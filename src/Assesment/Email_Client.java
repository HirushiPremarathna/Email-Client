package Assesment;


// your index number
//200479D

//import libraries

import java.util.Scanner;

public class Email_Client {

    public static void main(String[] args) {

        FileRead.reader();  // to read the client list file and make objects

        //Send birthday Wishes
        Personal.personalWishSend();
        OfficialCloseFriend.OfficialFriendWishSend();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");



        int option = scanner.nextInt();



        switch(option){
            case 1:
                System.out.println("\tOfficial: <name>,<email>,<designation>" + "\t\t\t\t\t\t\t\t\teg:Official: nimal,nimal@gmail.com,ceo\n"
                    + "\tOffice_friend: <Name>,<Email address>,<Designation>,<BirthOfdate>" + "\t\teg:Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12\n"
                    + "\tPersonal: <Name>,<nick-name>,<Email Address>,<BirthOfdate>" + "\t\t\t\teg:Personal: sunil,suna,sunil@gmail.com,2000/10/10");

                // input format - Official: nimal,nimal@gmail.com,ceo
                Scanner s1 = new Scanner(System.in);
                String record1 = s1.nextLine();

                // Use a single input to get all the details of a recipient
                FileHandler.writeFile(record1);
                // code to add a new recipient
                // store details in clientList.txt file
                // Hint: use methods for reading and writing files
                break;
            case 2:
                System.out.println("\t<Email Address>,<Subject>,<Content>");

                scanner.nextLine();
                String s2 = scanner.nextLine();

                String[]  s =  s2.split(",");
                String emailAddress = s[0];
                String subject = s[1];
                String content = s[2];

                EmailSender email = new EmailSender(emailAddress, subject, content);

                email.sendMails();
                ObjController.serialization(email);

                System.out.println("Done.");
                // input format - email, subject, content
                // code to send an email
                break;
            case 3:
                System.out.println("Input the date in the following format.");
                System.out.println("\tyyyy/MM/dd (ex: 2018/09/17)");

                // input format - yyyy/MM/dd (ex: 2018/09/17)
                scanner.nextLine();
                String s3 = scanner.nextLine();

                DisplayRecipients.display(s3);

                // code to print recipients who have birthdays on the given date
                break;
            case 4:
                System.out.println("Input the date in the following format.");
                System.out.println("\tyyyy/MM/dd (ex: 2018/09/17)");
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                scanner.nextLine();
                String s4 = scanner.nextLine();
               ObjController objController1 = new ObjController();
               objController1.displaySentMails(s4);




                // code to print the details of all the emails sent on the input date
                break;
            case 5:
                System.out.println(Recipient.getNoOfRecipients());
                // code to print the number of recipient objects in the application
                break;

        }

        // start email client
        // code to create objects for each recipient in clientList.txt
        // use necessary variables, methods and classes

    }
}

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)