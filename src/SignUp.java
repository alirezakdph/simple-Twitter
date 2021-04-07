import java.util.Scanner;

public class SignUp{

    public static void addUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your user name :");
        String userName = in.next();
        userName = checkUserName(userName);
        System.out.println("Please enter your Password \n" +
                "(Use 8 characters or more, a combination of letters,numbers and symbols) :");
        String password = in.next();
        password = checkStrongPass(password);
        System.out.println("Please confirm your Password : ");
        String confirmPassword = in.next();
        password = samePass(password, confirmPassword);
        User newUser = new User(userName, password);
        newUser.setUserNum(Twitter.getUsers().size());
        Twitter.setUser(newUser);
        System.out.println("Your account was created successfully.");

    }

    private static String checkUserName(String userName){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < Twitter.getUsers().size(); i++) {
            if (Twitter.getUsers().get(i).getUserName().equals(userName.trim())){
                System.out.println("That username is taken. Try another.");
                userName = in.next();
                userName = checkUserName(userName);
                return userName;
            }
        }
        return userName;
    }

    private static String checkStrongPass(String password) {
        Scanner in = new Scanner(System.in);
        if (password.length() < 8) {
            System.out.println("Use 8 characters or more for your password !!! :");
            password = in.next();
            password = checkStrongPass(password);
        }
        boolean alpha = false, digit = false, special = false;
        String allLower = "abcdefghijklmnopqrstuvwxyz";
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digit = true;
            } else if (allLower.indexOf(Character.toLowerCase(c)) != -1) {
                alpha = true;
            } else {
                special = true;
            }
        }
        if (alpha && digit && special) {
            return password;
        } else {
            System.out.println("Your password must be a combination of letters, numbers and symbols !!! :");
            password = in.next();
            password = checkStrongPass(password);
        }
        return password;
    }
    private static String samePass(String password, String confirmPassword) {
        Scanner in = new Scanner(System.in);
        if (!password.equals(confirmPassword)){
            System.out.println("Those passwords didn’t match. Try again.");
            System.out.println("Please enter your Password \n" +
                    "(Use 8 characters or more, a combination of letters,numbers and symbols) :");
            password = in.next();
            password = checkStrongPass(password);
            System.out.println("Please confirm your Password : ");
            confirmPassword = in.next();
            password = samePass(password, confirmPassword);
            return password;
        }
        return password;
    }
}

