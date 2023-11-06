package Assesment;

public class OfficialRecipient extends Recipient{

    //official recipient has designation
    private String designation;

    public OfficialRecipient(String name, String emailAddress, String designation) {
        super(name, emailAddress);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
