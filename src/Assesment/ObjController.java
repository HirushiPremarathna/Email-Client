package Assesment;

import java.io.*;
import java.util.ArrayList;

public class ObjController {

    public static ArrayList< EmailSender> sentMailsList = new
            ArrayList< EmailSender>(); //To store sent emails
    static ArrayList< EmailSender> loadMailList; //To deserialize objects.
    public static void serialization( EmailSender email) {
        sentMailsList.add(email);//Add email objects to serialize.
// Serialization
        try {
// Writing serialized object to file
            FileOutputStream fileStream = new FileOutputStream("AllEmails.ser");
//make a FileOutputStream
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
//make a objectOutputStream
            os.writeObject(sentMailsList); //write the object
            os.flush();
            fileStream.close(); //close the FileOutputStream
            os.close(); //close the ObjectOutputStream
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList< EmailSender> deSerialization() {
// Deserialization
        try {
            FileInputStream fileStream = new FileInputStream("AllEmails.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
//Method to deserialize object
            loadMailList = (ArrayList< EmailSender>) os.readObject();
            os.close();
            fileStream.close();
            return loadMailList; //return the deserialized list.
        } catch (IOException ex) {
            System.out.println("IOException occured");
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException occured");
            return null;
        }
    }


    public  static void displaySentMails(String date){
        int count = 0;
        ArrayList< EmailSender> sentMailList = deSerialization();
        for ( EmailSender se : sentMailList) {
            if ((date.trim()).contentEquals(se.date)) {
                count += 1;
                System.out.println("Subject :" + se.getSubject()+" , Recipient :"
                        +se.getToAddress());
            }
        }
        if (count == 0) {
            System.out.println("No email sent on that day");
        }

    }
}
