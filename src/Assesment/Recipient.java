package Assesment;

public abstract class Recipient {
    //recipient has a name and email address
    private String name;
    private String emailAddress;
    //count the number of recipients as no Of Recipients
    static int noOfRecipients = 0;


    //the no of recipients updates whenever creating the recipients object
    public Recipient(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        noOfRecipients++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public static int getNoOfRecipients() {
        return noOfRecipients;
    }
}
