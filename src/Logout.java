public class Logout extends Login{
    public static void logout() {
        System.out.println("Logout successfully");
        isLogin = false;
        userName = null;
        userNum = -1;
    }
}
