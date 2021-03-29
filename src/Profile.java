import java.util.Scanner;

public class Profile {
    static Scanner in = new Scanner(System.in);
    public static void profile(){
        System.out.println("Please enter a username : ");
        String  userName = in.next();
        for (int i = 0; i < Twitter.getUsers().size(); i++) {
            if (Twitter.getUsers().get(i).getUserName().equals(userName.trim())) {
                System.out.println(userName.trim());
                for (Tweet tweet : Twitter.getUsers().get(i).tweets){
                    System.out.println(tweet);
                }
            }
        }
        System.out.println(userName.trim() + " not found!!!");
    }
}
