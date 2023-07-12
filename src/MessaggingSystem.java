import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface MessagingService
{
    void sendMessage();
}
class SMSMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Phone number of Receiver : ");
        long number = scanner.nextLong();
        System.out.println();
        System.out.println("Enter content : ");
        String content = scanner.next();
        String regex = "^[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matched = pattern.matcher(Long.toString(number));
        if(matched.matches())
        {
            System.out.println("Send message to "+number);
            System.out.println("Message : "+content);
        }
        else
        {
            System.out.println("Invalid number!!! \n\t Please enter valid number!!!");
        }
        scanner.close();
        return ;
    }
}

class EmailMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ReceiverMail");
        String email = scanner.next();
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matched = pattern.matcher(email);
        if(matched.matches())
        {
            System.out.println("Enter Subject : ");
            String subject = scanner.next();
            System.out.println("Enter Content :");
            String content = scanner.next();
            System.out.println("Sent content to " +email);
            System.out.println("Subject of the Message : "+subject);
            System.out.println("Content of the Message : "+content);
        }
        else {
            System.out.println("Invalid Email!!! \n\t Please enter valid Email!!!");
        }
        scanner.close();
    }
}

class WhatsAppMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("if Receiver Already had whatsapp account enter 1 for yes or enter 0 no");
        int Account_checking = scanner.nextInt();
        System.out.println("Enter Phone number of Receiver");
        long number = scanner.nextLong();
        System.out.println("Enter content");
        String content = scanner.next();
        String patten = "^[6-9]\\d{9}$";
        Pattern regex = Pattern.compile(patten);
        Matcher matched = regex.matcher(Long.toString(number));
        if((matched.matches()) && (Account_checking!=0))
        {
            System.out.println("Send message to "+number);
            System.out.println("message : "+content);
        }
        else
        {
            System.out.println("Invalid number!!! \n\t Please enter valid number!!!");
        }
        scanner.close();
    }
}
public class MessaggingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MessagingService sms = new SMSMessagingService();
        MessagingService email = new EmailMessagingService();
        MessagingService whatsApp = new WhatsAppMessagingService();
        int option;
        do {

            System.out.println("Enter 1 to use SMS \n Enter 2 to use Email \n Enter 3 to use Whatsapp \n Enter 4 to Exit");
            System.out.print("Enter the value : ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    sms.sendMessage();
                    break;
                case 2:
                    email.sendMessage();
                    break;
                case 3:
                    whatsApp.sendMessage();
                    break;
                case 4:
                    break;
            }

        } while (option != 4);
        scan.close();

    }
}


/* {
}
*/