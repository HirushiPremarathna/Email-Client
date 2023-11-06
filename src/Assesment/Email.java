package Assesment;



public class Email {

    private String toAddress;
    private String subject;
    private String content;
    private String date;


    public Email(String toAddress, String subject, String content, String date) {
        this.toAddress = toAddress;
        this.subject = subject;
        this.content = content;
        this.date = date;
    }


    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
