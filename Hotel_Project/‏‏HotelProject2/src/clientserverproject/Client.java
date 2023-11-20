/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverproject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hadassa
 */
public class Client {

    private Socket socket;//שמאפשר להתחבר לנקודת קצה אחרת ברשת //JAVA //אובייקט של 
    //TCP\IP //בתצורת 

    private ObjectOutputStream writer;
    private ObjectInputStream reader;
    
    public Client() {
        try {
            //יצירת אובייקט שמתחבר לשרת עם הכתובת והיציאה המתאימה
            socket = new Socket("localhost", 1000);
             writer = new ObjectOutputStream(socket.getOutputStream());
            //אובייקט לצורך קריאת נתונים מהשרת
             reader = new ObjectInputStream(socket.getInputStream());
         
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Object sendMessage(Request r) {
        
        try {
            writer.writeObject(r);
            writer.flush();
            Object responseFromServer=reader.readObject();
            return responseFromServer;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;//null //אם הייתה שגיאה יוחזר
    }

}
