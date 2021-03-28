import java.util.Locale;
import java.util.Scanner;

public class Login {
    static Scanner in = new Scanner(System.in);
    protected static boolean isLogin;
    protected static String userName;
    protected static int userNum;
    private static String password;

    public static void login() {
        isLogin = false;
        System.out.println("Enter a user name :");
        userName = in.next();
        userNum = searchForUser(userName);
        System.out.println("Enter your password :");
        password = in.next();
        checkPass(password);
    }

    private static int searchForUser(String userName){
        int userNum = -1;
        for (int i = 0; i < Twitter.getUsers().size(); i++) {
            if (Twitter.getUsers().get(i).getUserName().equals(userName.trim())){
                userNum = Twitter.getUsers().get(i).getUserNum();
                break;
            }
        }
        if (userNum == -1) {
            System.out.println(userName + " not found !!! \nEnter a user name :");
            userName = in.next();
            userNum = searchForUser(userName);
        }
        return userNum;
    }

    private static void checkPass(String password){
        if (Twitter.getUsers().get(userNum).passIsCorrect(password)) {
            System.out.println("Login successfully");
            isLogin = true;
        }
        else {
            System.out.println("The password is incorrect.Please try again \n" +
                               "(Enter \"cancel\" to cancel the login)");
            password = in.next();
            if (!password.toLowerCase().equals("cancel")) {
                checkPass(password);
            }
            else {
                userName = null;
                userNum = -1;
                return;
            }
        }
    }

    public static boolean isLogin() {
        return isLogin;
    }

}
