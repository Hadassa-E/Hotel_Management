/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Hadassa
 *
 */
public class Hotel implements Serializable {

    private List<Room> rooms;
    private Vector<TotalOrder> orders;

    public Hotel() {
        this.rooms = new ArrayList<Room>();
        rooms.add(new Room(1, 5, TypeRoom.STANDART_ROOM, true, 2));
        rooms.add(new Room(2, 5, TypeRoom.STANDART_ROOM, true, 1));
        rooms.add(new Room(3, 4, TypeRoom.STANDART_ROOM, false, -1));
        rooms.add(new Room(4, 6, TypeRoom.STANDART_ROOM, false, -1));
        rooms.add(new Room(5, 7, TypeRoom.STANDART_ROOM, false, -1)); 
        
        rooms.add(new Room(6, 5, TypeRoom.ACCESSIBLE_ROOM, true, 7));
        rooms.add(new Room(7, 5, TypeRoom.ACCESSIBLE_ROOM, true, 6));
        rooms.add(new Room(8, 4, TypeRoom.ACCESSIBLE_ROOM, false, -1));
        rooms.add(new Room(9, 6, TypeRoom.ACCESSIBLE_ROOM, false, -1));
        rooms.add(new Room(10, 7, TypeRoom.ACCESSIBLE_ROOM, false, -1));
        
        rooms.add(new Room(11, 5, TypeRoom.DELUX_ROOM, true, 12));
        rooms.add(new Room(12, 5, TypeRoom.DELUX_ROOM, true, 11));
        rooms.add(new Room(13, 4, TypeRoom.DELUX_ROOM, false, -1));
        rooms.add(new Room(14, 6, TypeRoom.DELUX_ROOM, false, -1));
        rooms.add(new Room(15, 7, TypeRoom.DELUX_ROOM, false, -1));
        
        rooms.add(new Room(16, 5, TypeRoom.SUITE_ROOM, true, 17));
        rooms.add(new Room(17, 5, TypeRoom.SUITE_ROOM, true, 16));
        rooms.add(new Room(18, 4, TypeRoom.SUITE_ROOM, false, -1));
        rooms.add(new Room(19, 6, TypeRoom.SUITE_ROOM, false, -1));
        rooms.add(new Room(20, 7, TypeRoom.SUITE_ROOM, false, -1)); 
        
        this.orders = new Vector<>();
    }

    public Hotel(List<Room> rooms, Vector<TotalOrder> orders) {
        this.rooms = rooms;
        this.orders = orders;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Vector<TotalOrder> getOrders() {
        return orders;
    }

    public void setOrders(Vector<TotalOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Hotel{" + "rooms=" + rooms + ", orders=" + orders + '}';
    }

    //פונקציית הזמנה
    public boolean AddTotalOrder(TotalOrder allOrder) {
        List<List<Room>> roomsOrder = CheckOrder(allOrder, false);
        if (roomsOrder != null) {
            for (List<Room> listRoom : roomsOrder) {
                for (Room room : listRoom) {
                    //מציאת החדר
                    Room r = this.rooms.stream().filter(x -> x.getNumRoom() == room.getNumRoom()).findAny().get();
                    //עדכון התאריכים התפוסים
                    r.UpdateHashset(allOrder.getFromDate(), allOrder.getUntilDate());
                    //שחרור נעילת החדר
                    r.getSemaphore().release();
                }
            }
            this.orders.add(allOrder);
            return true;
        }
        return false;
    }

    //פונקציית בדיקת הזמנה
    public List<List<Room>> CheckOrder(TotalOrder allOrders, boolean forCheck) {
        List<List<Room>> roomsForAllGroups = new ArrayList<List<Room>>();
        List<Room> vacantRooms = new ArrayList<Room>();//חדרים פנויים בתאריכים הללו
        for (Room vacantRoom : this.rooms) {
            if (vacantRoom.IsAvailable(allOrders.getFromDate(), allOrders.getUntilDate())) {
                if (!forCheck) {//נעילת חדרים שהם בהזמנה ולא בבדיקת תאריכים אפשריים
                    try {
                        vacantRoom.getSemaphore().acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                vacantRooms.add(vacantRoom);
            }
        }
        Collections.sort(vacantRooms);//מיון לפי כמות המיטות בחדר
        for (GroupOrder oneOrder : allOrders.getOrder()) {
            List<Room> matchRooms = new ArrayList<Room>();//חדרים מתאימים לפי הדרישות
            List<Room> roomsToOneOrder = new ArrayList<Room>();
            matchRooms = vacantRooms.stream().filter(x -> x.getTypeRoom() == oneOrder.getTypeRoom()).collect(Collectors.toList());
            List<Room> theRooms = new ArrayList<Room>();
            if (oneOrder.isConnectingDoor()) {//עבור דלת מקושרת
                roomsToOneOrder = matchRooms.stream().filter(x -> x.getNumAdjacentRoom() != -1).collect(Collectors.toList());
                int index = 0;
                while (index < roomsToOneOrder.size() && theRooms.isEmpty()) {
                    Room r1 = roomsToOneOrder.get(index);
                    Room r2 = roomsToOneOrder.stream().filter(x -> x.getNumAdjacentRoom() == r1.getNumRoom()).findAny().get();
                    index++;
                    //כאשר כמות המיטות בשני החדרים מספיקה
                    if (r2 != null && r1.getNumBeds() + r2.getNumBeds() >= oneOrder.getNumAdultsBeds() + oneOrder.getNumChildrenBeds()) {
                        theRooms.add(r1);
                        theRooms.add(r2);
                        vacantRooms.remove(r1);
                        vacantRooms.remove(r2);

                    }
                }
                if (theRooms.size() == 2) {//חדרים2  אם שובצו
                    roomsForAllGroups.add(theRooms);
                } 
                else {
                    if (!forCheck) {//שחרור נעילה
                        for (Room theRoom : theRooms) {
                            theRoom.getSemaphore().release();
                        }
                    }
                }
            }
            if (!oneOrder.isConnectingDoor() || theRooms.size() != 2)
            {
                //כמות מיטות שלא שובצו
                int countBeds = oneOrder.getNumAdultsBeds() + oneOrder.getNumChildrenBeds();
                for (int i = matchRooms.size() - 1; i >= 0 && countBeds != 0; i--) {
                    int j;
                    //חיפוש חדר עם מספר מיטות מדויק לכמות שנשארה
                    for (j = 0; j <= i && countBeds > matchRooms.get(j).getNumBeds(); j++);
                    //אם אין חדר שמכיל את כולם אז שיבוץ החדר הגדול ביותר
                    if (j > i) {
                        theRooms.add(matchRooms.get(i));
                        countBeds -= matchRooms.get(i).getNumBeds();
                        vacantRooms.remove(matchRooms.get(i));

                    } else {//אם יש חדר שמכיל את כל המיטות שלא שובצו
                        theRooms.add(matchRooms.get(j));
                        vacantRooms.remove(matchRooms.get(j));
                        countBeds = 0;

                    }
                }
                //אם לא הצליח שיבוץ כל המיטות ונעלנו את הסמפור
                if (countBeds != 0 && !forCheck) {
                    //שחרור הסמפור
                    for (List<Room> rooms : roomsForAllGroups) {
                        for (Room room : rooms) {
                            room.getSemaphore().release();
                        }
                    }
                    for (Room room : vacantRooms) {
                        room.getSemaphore().release();
                    }
                    for (Room theRoom : theRooms) {
                        theRoom.getSemaphore().release();
                    }
                }
                if(countBeds!=0)
                    return null;
            }
            roomsForAllGroups.add(theRooms);
        }
        if (!forCheck) {
            for (Room room : vacantRooms) {//שחרור החדרים שלא השתמשו בהם.
                room.getSemaphore().release();
            }
        }
        if (roomsForAllGroups.size() == 0) {
            return null;
        }
        for (List<Room> inner : roomsForAllGroups) {
            if (inner.size() == 0) {
                return null;
            }
        }
        return roomsForAllGroups;
    }

    
    //פונקציה המקבלת הזמנה עם תאריך התחלתי לבדיקה
    // תאריכים אפשריים לביצוע ההזמנה 10הפונקציה מחזירה 
    public List<LocalDate> CheckDates(TotalOrder allOrder) {
        List<LocalDate> dates = new ArrayList<>();
        for (LocalDate d = allOrder.getFromDate(); dates.size() < 10; d = d.plusDays(1)) {
            allOrder.setFromDate(d);
            allOrder.setUntilDate(d.plusDays(allOrder.getNumDays()));
            if (CheckOrder(allOrder, true) != null) {
                dates.add(d);
            }
        }
        return dates;
    }

}
