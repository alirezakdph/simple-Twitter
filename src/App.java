import java.util.Scanner;

import static java.lang.System.exit;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            String command = in.nextLine();
            command = command.toLowerCase();
            switch (command){
                case "quit":
                    exit(0);
                    break;
                case "sign up":
                    SignUp.addUser();
                    break;
                case "login":
                    Login.login();
                    break;
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
                case "b":
                    for (int i = 0; i < Twitter.getUsers().size(); i++) {
                        System.out.println(Twitter.getUsers().get(i));
                    }
                    break;
            }
        }
    }


}
