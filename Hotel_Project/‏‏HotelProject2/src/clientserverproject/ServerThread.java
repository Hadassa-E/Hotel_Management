/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverproject;

import Classes.TotalOrder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hadassa
 */
//מחלקה שבה תוגדר תקשורת של השרת עם לקוח מסוים
public class ServerThread extends Thread {

    private Socket clientSocket;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            //באופן זה קריאת הנתונים היא מהלקוח החדש שהתחבר
            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream()); 
            ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
            System.out.println("new connection from:"+clientSocket.getInetAddress().getCanonicalHostName());
            Request reqFromClient = (Request) reader.readObject();//קורא את הנתון שהלקוח שלח
            while (reqFromClient.getType() != TypeOfRequest.StopConnection)//כל עוד נשלחה בקשה ששונה מבקשת סיום התקשרות
            {
                switch (reqFromClient.getType()) {
                    case AddOrder:
                        boolean b = Server.hotel.AddTotalOrder((TotalOrder) reqFromClient.getDataOfRequest());
                        writer.writeObject(b);// שליחה ללקוח שההוספה בוצעה בהצלחה או בכישלון
                        writer.flush();
                        break;
                    case CheckDates:
                        List<LocalDate> list = Server.hotel.CheckDates((TotalOrder) reqFromClient.getDataOfRequest());
                        List<LocalDate> copy = new ArrayList<>();
                        list.forEach(x -> copy.add(x));
                        writer.writeObject(copy);
                        writer.flush();
                        break;
                }
                reqFromClient = (Request) reader.readObject();
            }
            System.out.println("client signed out...");
        } 
        catch (IOException ex) {
            
        } 
        catch (ClassNotFoundException ex) {
            
        }
    }

}
