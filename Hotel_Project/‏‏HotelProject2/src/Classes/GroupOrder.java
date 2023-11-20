/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Hadassa
 */
public class GroupOrder implements Serializable{

    public GroupOrder() {
    }
    
    
    private int numAdultsBeds;
    private int numChildrenBeds;
    private TypeRoom typeRoom;
    private boolean connectingDoor;
    private ArrayList<Integer> rooms;


    public GroupOrder(int numAdultsBeds, int numChildrenBeds, TypeRoom typeRoom, boolean connectingDoor) {
        this.numAdultsBeds = numAdultsBeds;
        this.numChildrenBeds = numChildrenBeds;
        this.typeRoom = typeRoom;
        this.connectingDoor = connectingDoor;
        this.rooms=new ArrayList<Integer>();
    }

    /**
     * @return the numAdultsBeds
     */
    public int getNumAdultsBeds() {
        return numAdultsBeds;
    }

    /**
     * @param numAdultsBeds the numAdultsBeds to set
     */
    public void setNumAdultsBeds(int numAdultsBeds) {
        this.numAdultsBeds = numAdultsBeds;
    }

    /**
     * @return the numChildrenBeds
     */
    public int getNumChildrenBeds() {
        return numChildrenBeds;
    }

    /**
     * @param numChildrenBeds the numChildrenBeds to set
     */
    public void setNumChildrenBeds(int numChildrenBeds) {
        this.numChildrenBeds = numChildrenBeds;
    }

    /**
     * @return the typeRoom
     */
    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    /**
     * @param typeRoom the typeRoom to set
     */
    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    /**
     * @return the connectingDoor
     */
    public boolean isConnectingDoor() {
        return connectingDoor;
    }

    /**
     * @param connectingDoor the connectingDoor to set
     */
    public void setConnectingDoor(boolean connectingDoor) {
        this.connectingDoor = connectingDoor;
    }
    //עדכון החדרים השמורים לקבוצה בהזמנה
     public void AddRoomOrder(int num){
        this.rooms.add(num);
    }
      
    @Override
    public String toString() {
        return "GroupInvitation{" + "numAdultsBeds=" + numAdultsBeds + ", numChildrenBeds=" + numChildrenBeds + ", typeRoom=" + typeRoom + ", connectingDoor=" + connectingDoor + '}';
    }
}
