package fpoly.edu.assignment_java5.test;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.lookups.v1.PhoneNumber;

public class SMSTest {
    public static final String ACCOUNT_SID = "Your_Account_SID";
    public static final String AUTH_TOKEN = "Your_Auth_Token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String phoneNumber = "+84972495038"; // Replace with your phone number

        try {
            PhoneNumber number = PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(phoneNumber)).fetch();
            boolean isSmsCapable = true;

            if (isSmsCapable) {
                System.out.println("Phone number is SMS-enabled");
            } else {
                System.out.println("Phone number is not SMS-enabled");
            }
        } catch (ApiException e) {
            System.out.println("Error checking phone number capabilities: " + e.getMessage());
        }
    }
}
