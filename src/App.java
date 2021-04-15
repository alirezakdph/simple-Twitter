import java.util.Scanner;

import static java.lang.System.exit;

public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to my Twitter :)");
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Enter command : ");
            String command = in.nextLine();
            command = command.toLowerCase();
            switch (command.trim()){
                case "quit":
                    exit(0);
                    break;
                case "sign up":
                    if (!Login.isLogin()) {
                        SignUp.addUser();
                        break;
                    }
                case "login":
                    if (!Login.isLogin()) {
                        Login.login();
                        break;
                    }
                case "logout":
                    if (Login.isLogin()){
                        Logout.logout();
                        break;
                    }
                case "follow":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).follow();
                        break;
                    }
                case "unfollow":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).unfollow();
                        break;
                    }
                case "followers":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).printFollowers();
                        break;
                    }
                case "following":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).printFollowing();
                        break;
                    }
                case "like":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).like();
                        break;
                    }
                case "tweet":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).tweet();
                        break;
                    }
                case "my profile":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).myProfile();
                        break;
                    }
                case "profile":
                    if (Login.isLogin()){
                        Profile.profile();
                        break;
                    }
                case "timeline":
                    if (Login.isLogin()){
                        Twitter.getUsers().get(Login.userNum).timeLine();
                        break;
                    }
                default:
                    System.out.println("Invalid command !!!");
            }
        }
    }
}
