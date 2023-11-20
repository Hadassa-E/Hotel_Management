/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverproject;

/**
 *
 * @author Hadassa
 */

//מכיל את סוגי הבקשות שנשלחות מהלקוח האפשריים בפרויקט
public enum TypeOfRequest {   
    AddOrder,//הזמנה
    CheckDates,//בדיקת תאריכים מתאימים
    StopConnection//התנתקות מהשרת
}
