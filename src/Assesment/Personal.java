package Assesment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Personal  extends Recipient  implements IWisher{
    //personal recipient has a nickname and birth of date.
    private String nickName;
    private String birthOfDate;

    /*//birthday greeting for personal recipients
    static final String personalBirthdayWish = "hugs and love on your birthday. Hirushi";
*/


    public Personal(String name, String nickName, String emailAddress, String birthOfDate) {
        super(name, emailAddress);
        this.nickName = nickName;
        this.birthOfDate = birthOfDate;
    }

    //add personal objects to the list
    public void insertPRecord() {
        personalRecipientList.add(this);
    }

    //to get the list of birthdays who has today
    public static void birthTodayPR(String birthOfDate){
        int count = 0;
        for (Personal personal:personalRecipientList
             ) {
            if (personal.birthOfDate.subSequence(5,10).equals(birthOfDate.subSequence(5,10))){
                System.out.println(personal.getName());
                count++;
            }
        }
        if (count==0){
            System.out.println("No birthdays today for personal recipients.");
        }
    }



    //sending the birthday wish
    public static void  personalWishSend(){
        for (Personal personal:personalRecipientList) {

            //to know the current date
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String today = simpleDateFormat.format(new Date());

            if (today.subSequence(5,10).equals(personal.getBirthOfDate().subSequence(5,10))){
                EmailSender email = new EmailSender(personal.getEmailAddress(), "Birthday wish", "hugs and love on your birthday. Hirushi");

                email.sendMails();
                ObjController objController=new ObjController();
                objController.serialization(email);
            }
        }
    }



    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getBirthOfDate() {
        return birthOfDate;
    }
    public void setBirthOfDate(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

}

