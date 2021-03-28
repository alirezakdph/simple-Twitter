import java.util.ArrayList;
import java.util.List;

public class Twitter {
    private static List<User> users = new ArrayList<>();

    public static void setUser(User users) {
        Twitter.users.add(users);
    }

    public static List<User> getUsers() {
        return users;
    }
}
