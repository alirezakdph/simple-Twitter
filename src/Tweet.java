import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Tweet {
    private String tweet;
    private int userNum;
    public int like = 0;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyDDDhhmmss");
    long ID =Long.parseLong(now.format(format) + String.valueOf(userNum));
    long toSort = Long.parseLong(now.format(format));
    List<Integer> likes = new ArrayList<>();

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public long getID() {
        return ID;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setToSort(long toSort) {
        this.toSort = toSort;
    }

    public void setLikes(List<Integer> likes) {
        this.likes.addAll(likes);
    }

    public String displayWithUserName() {
        return Twitter.getUsers().get(userNum).getUserName() + '\n' +
               "Tweet ID : " + ID + "                   like = " + like + '\n' +
               tweet + "\n\n" +
               "----------------------------------------------------------------------------------------------------\n"
                ;
    }

    @Override
    public String toString() {
        return "Tweet ID : " + ID + "                   like = " + like + '\n' +
               tweet + "\n\n" +
               "----------------------------------------------------------------------------------------------------\n"
               ;
    }

    public void equals(Tweet tweet) {
        tweet.setTweet(this.tweet);
        tweet.setUserNum(this.userNum);
        tweet.setID(this.ID);
        tweet.setLike(this.like);
        tweet.setToSort(this.toSort);
        tweet.setLikes(this.likes);
    }
}
