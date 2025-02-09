import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    static Scanner in = new Scanner(System.in);
    private String userName;
    private String password;
    private int userNum;
    List<Tweet> tweets = new ArrayList<>();
    List<Integer> followers = new ArrayList<>();
    List<Integer> following = new ArrayList<>();
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweet(String tweetText) {
        Tweet tweet = new Tweet();
        tweet.setTweet(tweetText);
        tweets.add(tweet);
        tweet.setUserNum(userNum);
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public boolean passIsCorrect(String enteredPass){
        if (enteredPass.equals(this.password)) {
            return true;
        }
        return false;
    }

    public void follow() {
        System.out.println("Enter the username you want to follow : ");
        String target = in.next();
        if (target.equals("cancel")) return;
        while (target.equals(userName)){
            System.out.println("You can not follow yourself!!! \nEnter the username you want to follow : ");
            if (target.equals("cancel")) return;
            target = in.next();
        }
        for (int i = 0; i < Twitter.getUsers().size(); i++) {
            if (Twitter.getUsers().get(i).getUserName().equals(target.trim())) {
                System.out.println(target + " successfully followed.");
                this.following.add(Twitter.getUsers().get(i).getUserNum());
                Twitter.getUsers().get(i).followers.add(userNum);
                return;
            }
        }
        System.out.println(target + " not found!!!");
    }
    public void unfollow() {
        System.out.println("Enter the username you want to unfollow :");
        String target = in.next();
        if (target.equals("cancel")) return;
        while (target.equals(userName)){
            System.out.println("You can not unfollow yourself!!! \nEnter the username you want to unfollow : ");
            target = in.next();
            if (target.equals("cancel")) return;
        }
        for (int i = 0; i < Twitter.getUsers().size(); i++) {
            if (Twitter.getUsers().get(i).getUserName().equals(target.trim())) {
                System.out.println(target + " successfully unfollowed.");
                this.following.remove(new Integer(Twitter.getUsers().get(i).userNum));
                Twitter.getUsers().get(i).followers.remove(new Integer(this.userNum));
                return;
            }
        }
        System.out.println("You have not followed " + target + " yet !!!");
    }

    public void printFollowers(){
        System.out.println("** Followers **");
        for (int i = 0; i < followers.size(); i++) {
            System.out.println(Twitter.getUsers().get(followers.get(i)));
        }
    }

    public void printFollowing(){
        System.out.println("** Following **");
        for (int i = 0; i < following.size(); i++) {
            System.out.println(Twitter.getUsers().get(following.get(i)));
        }
    }

    public void tweet(){
        System.out.println("Please enter the text of the tweet.(Less than 140 letters)");
        String tweetText = in.nextLine();
        if (tweetText.equals("cancel")) return;
        setTweet(tweetText);
        System.out.println("Tweeted successfully");
    }

    public void like(){
        System.out.println("Please enter the tweet ID you want to like.");
        String ID = in.next();
        if (ID.equals("cancel")) return;
        while (ID.length() < 12){
            System.out.println("Wrong ID !!!");
            System.out.println("Please enter the tweet ID you want to like.");
            ID = in.next();
            if (ID.equals("cancel")) return;
        }
        int tweeterNum = 0;
        try {
            tweeterNum = Integer.parseInt(ID.substring(11));
        } catch (Exception ex){}
        for (int i = 0; i < Twitter.getUsers().get(tweeterNum).getTweets().size(); i++) {
            if (Twitter.getUsers().get(tweeterNum).getTweets().get(i).getID() == Long.parseLong(ID)){
                for (int j : Twitter.getUsers().get(tweeterNum).getTweets().get(i).likes) {
                    if (j == userNum) {
                        return;
                    }
                }
                Twitter.getUsers().get(tweeterNum).getTweets().get(i).like ++;
                Twitter.getUsers().get(tweeterNum).getTweets().get(i).likes.add(userNum);
                System.out.println("Tweet liked successfully");
                return;
            }
        }
        System.out.println("Tweet(" + ID + ") not found!!!");
    }

    public void myProfile(){
        System.out.println(userName);
        for (Tweet tweet : tweets){
            System.out.println(tweet);
        }
    }

    public void timeLine() {
        List<Tweet> allTweets = new ArrayList<>();
        allTweets.addAll(tweets);
        for (int i = 0; i < following.size(); i++) {
            for (int j = 0; j < Twitter.getUsers().size(); j++) {
                if (following.get(i) == Twitter.getUsers().get(j).getUserNum()) {
                    allTweets.addAll(Twitter.getUsers().get(j).getTweets());
                }
            }
        }
        Tweet[] allTweetsArr = new Tweet[allTweets.size()];
        for (int i = 0; i < allTweets.size(); i++) {
            allTweetsArr[i] = new Tweet();
        }
        for (int i = 0; i < allTweetsArr.length; i++) {
            allTweetsArr[i] = allTweets.get(i);
        }
        Tweet temp = new Tweet();
        for (int i = 0; i < allTweetsArr.length; i++) {
            for (int j = i + 1; j < allTweetsArr.length; j++) {
                if (allTweetsArr[i].toSort < allTweetsArr[j].toSort){
                    temp = allTweetsArr[i];
                    allTweetsArr[i] = allTweetsArr[j];
                    allTweetsArr[j] = temp;
                }
            }
        }
        for (Tweet tweet : allTweetsArr){
            System.out.println(tweet.displayWithUserName());
        }
    }

    @Override
    public String toString() {
        return userName;
    }
}
//    Tweet temp = new Tweet();
//        for (int i = 0; i < allTweetsArr.length; i++) {
//        for (int j = i + 1; j < allTweetsArr.length; j++) {
//        if (allTweetsArr[i].toSort < allTweetsArr[j].toSort){
//        temp.equals(allTweetsArr[i]);
//        allTweetsArr[i].equals(allTweetsArr[j]);
//        allTweetsArr[j].equals(temp);
//        }
//        }
//        }