package Assesment;

import java.util.ArrayList;
import java.util.List;

public interface IWisher {
    //need to add personal recipients and official friend for two list to find the birthday and send mail
    //need to have a method for sending wish and add details


    //list for personal recipients
    public static List<Personal> personalRecipientList = new ArrayList<>();

    //list for official friends recipients
    public static List<OfficialCloseFriend> officialClosedFriendList = new ArrayList<>();
}
