import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tweet {
    private String tweet;
    private int userNum;
    public int like = 0;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyDDDhhmmss");
    long ID =Long.parseLong(now.format(format) + String.valueOf(userNum));
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

    @Override
    public String toString() {
        return Twitter.getUsers().get(userNum).getUserName() + '\n' +
                "Tweet ID : '" + ID + "                   like= " + like + "\n\n" +
                tweet +
                "----------------------------------------------------------------------------------------------------"
                ;
    }
}
