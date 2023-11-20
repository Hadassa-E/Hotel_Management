/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverproject;

import java.io.Serializable;

/**
 *
 * @author Hadassa
 */
//מחלקה שמייצגת בקשה שנשלחת מהלקוח לשרת
public class Request implements Serializable{
    private TypeOfRequest type;//מכיל את סוג הבקשה הרצויה
    private Serializable dataOfRequest;

    public Request(TypeOfRequest type, Serializable dataOfRequest) {
        this.type = type;
        this.dataOfRequest = dataOfRequest;
    }

    
    
    /**
     * @return the type
     */
    public TypeOfRequest getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeOfRequest type) {
        this.type = type;
    }

    /**
     * @return the dataOfRequest
     */
    public Serializable getDataOfRequest() {
        return dataOfRequest;
    }

    /**
     * @param dataOfRequest the dataOfRequest to set
     */
    public void setDataOfRequest(Serializable dataOfRequest) {
        this.dataOfRequest = dataOfRequest;
    }
    
    
}
