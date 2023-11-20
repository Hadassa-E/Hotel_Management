/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hadassa
 */

public class TotalOrder implements Serializable,Cloneable{
    //static int maxInRoom=5;
    private List<GroupOrder> order;
    private String ordererName;
    private String ordererPhone;
    private LocalDate fromDate;
    private LocalDate untilDate;
    
    private int numDays;

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }
    

    
    
    
    public TotalOrder(ArrayList<GroupOrder> order, String ordererName, String ordererPhone, LocalDate fromDate, LocalDate untilDate) {
        this.order = order;
        this.ordererName = ordererName;
        this.ordererPhone = ordererPhone;
        this.fromDate = fromDate;
        this.untilDate = untilDate;
    }
    
    
    public TotalOrder(ArrayList<GroupOrder> order, String ordererName, String ordererPhone, LocalDate fromDate, int numDays) {
        this.order = order;
        this.ordererName = ordererName;
        this.ordererPhone = ordererPhone;
        this.fromDate = fromDate;
        this.numDays=numDays;
    }

    /**
     * @return the order
     */
    public List<GroupOrder> getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(List<GroupOrder> order) {
        this.order = order;
    }

    /**
     * @return the ordererName
     */
    public String getOrdererName() {
        return ordererName;
    }

    /**
     * @param ordererName the ordererName to set
     */
    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    /**
     * @return the ordererPhone
     */
    public String getOrdererPhone() {
        return ordererPhone;
    }

    /**
     * @param ordererPhone the ordererPhone to set
     */
    public void setOrdererPhone(String ordererPhone) {
        this.ordererPhone = ordererPhone;
    }

    /**
     * @return the fromDate
     */
    public LocalDate getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the untilDate
     */
    public LocalDate getUntilDate() {
        return untilDate;
    }

    /**
     * @param untilDate the untilDate to set
     */
    public void setUntilDate(LocalDate untilDate) {
        this.untilDate = untilDate;
    }

    @Override
    public String toString() {
        return "TotalOrder{" + "order=" + order + ", ordererName=" + ordererName + ", ordererPhone=" + ordererPhone + ", fromDate=" + fromDate + ", untilDate=" + untilDate + '}';
    }
    
    @Override
    public Object clone()
    {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TotalOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

