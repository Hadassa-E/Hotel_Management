/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverproject;

import Classes.Hotel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Hadassa
 */
//מחלקה שמייצגת את השרת
public class Server {

    public static Hotel hotel=new Hotel();//מקור הנתונים

    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(1000);//הקמת נקודת קצה של שרת
            //port 1000//שיאזין דרך  
        } catch (IOException ex) {
            //במקרה שתהיה שגיאה
            //לדוגמה כי הפורט תפוס
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void runServer() throws UnknownHostException {
          System.out.println("Server is running...");
        //הדפסת הכתובת והיציאה הלוגית
        System.out.println("IP Address:" + InetAddress.getLocalHost().getHostAddress());
        System.out.println("Port:" + serverSocket.getLocalPort());
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();//socket //מאזינה לבקשות התחברות וברגע שנוצר
                //שמנסה להתחבר לכתובת והיציאה המתאימה הפונקציה מחזירה אובייקט
                //עם פרטי הלקוח //Socket 
                System.out.println("New Connection from ip:" + clientSocket.getInetAddress().getHostAddress() + " ");
                ServerThread thread=new ServerThread(clientSocket);
                thread.start();//התחלת תהליכון חדש שיטפל בלקוח החדש
                //כך שהשרת עצמו ממשיך להאזין ללקוח הבא
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }

}
