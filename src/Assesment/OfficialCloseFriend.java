package Assesment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OfficialCloseFriend extends Recipient implements IWisher{
    //official friend has birth of date and designation
    private String birthOfDate;
    private  String designation;

    /*
    //birthday greeting for official friend
    final String OCFBirthdayWish = "Wish you a Happy Birthday. Hirushi";
*/

    public OfficialCloseFriend(String name, String emailAddress, String designation, String birthOfDate) {
        super(name, emailAddress);
        this.designation = designation;
        this.birthOfDate = birthOfDate;
    }

    //add official friends objects to the list
    public void insertOCFRecord() {
        officialClosedFriendList.add(this);
    }

    //to get the list of birthdays who has today
    public static void birthTodayOCF(String birthOfDate){
        int count = 0;
        for (OfficialCloseFriend officialCloseFriend:officialClosedFriendList
        ) {
            if (officialCloseFriend.birthOfDate.subSequence(5,10).equals(birthOfDate.subSequence(5,10))){
                System.out.println(officialCloseFriend.getName());
                count++;
            }
        }
        if (count==0){
            System.out.println("No birthdays today for official friends.");
        }
    }



    //sending the birthday wish
    public static void  OfficialFriendWishSend(){
        for (OfficialCloseFriend officialCloseFriend:officialClosedFriendList) {

            //to know the current date
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String today = simpleDateFormat.format(new Date());

            if (today.subSequence(5,10).equals(officialCloseFriend.getBirthOfDate().subSequence(5,10))){
                EmailSender email = new EmailSender(officialCloseFriend.getEmailAddress(), "Birthday wish", "Wish you a Happy Birthday. Hirushi");

                email.sendMails();
                ObjController objController=new ObjController();
                objController.serialization(email);
            }
        }
    }


/*
    public String getOCFBirthdayWish() {
        return OCFBirthdayWish;
    }*/

    public String getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
