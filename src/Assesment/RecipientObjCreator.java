package Assesment;

public class RecipientObjCreator {
    public static void createObjects(String information){
        String[] inputLine = information.split(" ");
        String[] recipientDetails = inputLine[1].split(",");
        String type = inputLine[0];
        Recipient recipient;

        if (type.equals("Official:")) {
            Recipient recipient1 = new OfficialRecipient(recipientDetails[0], recipientDetails[1], recipientDetails[2]);
        } else if (type.equals("Office_friend:")) {
            recipient =new OfficialCloseFriend(recipientDetails[0], recipientDetails[1], recipientDetails[2], recipientDetails[3]);
            ((OfficialCloseFriend) recipient).insertOCFRecord();
        } else if (type.equals("Personal:")) {
           recipient =  new Personal(recipientDetails[0], recipientDetails[1], recipientDetails[2], recipientDetails[3]);
           ((Personal) recipient).insertPRecord();
        }
        return;
    }
}
