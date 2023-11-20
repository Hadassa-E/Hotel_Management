package Classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class Room implements Comparable<Room>, Serializable {

    private int numRoom;//מספר חדר
    private int numBeds;//מספר מיטות בחדר
    private TypeRoom typeRoom;//סוג חדר
    private boolean isOccupied;//האם החדר תפוס?
    private int numAdjacentRoom;//מספר חדר צמוד
    private HashSet<LocalDate> datesTaken;//תאריכים תפוסים
    private Semaphore semaphore;
    public Room(int numRoom, int numBeds, TypeRoom typeRoom, boolean isOccupied, int numAdjacentRoom) {
        this.numRoom = numRoom;
        this.numBeds = numBeds;
        this.typeRoom = typeRoom;
        this.isOccupied = isOccupied;
        this.numAdjacentRoom = numAdjacentRoom;
        this.datesTaken = new HashSet<LocalDate>();
        this.semaphore=new Semaphore(1);
    }

    /**
     * @return the numRoom
     */
    public int getNumRoom() {
        return numRoom;
    }

    /**
     * @param numRoom the numRoom to set
     */
    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    /**
     * @return the numBeds
     */
    public int getNumBeds() {
        return numBeds;
    }

    /**
     * @param numBeds the numBeds to set
     */
    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
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
     * @return the isOccupied
     */
    public boolean isIsOccupied() {
        return isOccupied;
    }

    /**
     * @param isOccupied the isOccupied to set
     */
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * @return the numAdjacentRoom
     */
    public int getNumAdjacentRoom() {
        return numAdjacentRoom;
    }

    /**
     * @param numAdjacentRoom the numAdjacentRoom to set
     */
    public void setNumAdjacentRoom(int numAdjacentRoom) {
        this.numAdjacentRoom = numAdjacentRoom;
    }

    /**
     * @return the datesTaken
     */
    public HashSet<LocalDate> getDatesTaken() {
        return datesTaken;
    }

    /**
     * @param datesTaken the datesTaken to set
     */
    public void setDatesTaken(HashSet<LocalDate> datesTaken) {
        this.datesTaken = datesTaken;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    @Override
    public String toString() {
        return "Room{" + "numRoom=" + numRoom + ", numBeds=" + numBeds+ ", typeRoom=" + typeRoom + ", isOccupied=" + isOccupied + ", numAdjacentRoom=" + numAdjacentRoom + ", datesTaken=" + datesTaken + '}';
    }

    //פונקציה הבודקת האם כל התאריכים לחדר זה פנויים
    public boolean IsAvailable(LocalDate from, LocalDate until) {
        LocalDate j;
        for (j = from; j.isBefore(until) && !this.getDatesTaken().contains(j); j = j.plusDays(1));//מעבר על תאריכי השהייה האם כולם פנויים
        if (j.equals(until) && !this.getDatesTaken().contains(j)) {
            return true;
        }
        return false;
    }

    //hashsetפונקציית עדכון ל
    public void UpdateHashset(LocalDate from, LocalDate until) {
        for (LocalDate j = from; j.isBefore(until); j = j.plusDays(1)) {
            this.datesTaken.add(j);
        }
    }

    @Override
    public int compareTo(Room o) {
        return this.getNumBeds() - o.getNumBeds();
    }
}
