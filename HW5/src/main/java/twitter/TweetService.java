package twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {

    private static int ids = 0;


    private List<Tweet> tweets = new ArrayList<Tweet>();

    public List<Tweet> getAll() {
        return tweets;
    }

    public boolean remove(long id){
        Tweet tweet = getById(id);
        return tweets.remove(tweet);
    }

    public boolean add(String message) {
        Tweet tweet = new Tweet();
        tweet.setMessage(message);
        tweet.setCreatedAt(new Date());
        tweet.setId(++ids);
        ArrayList<String> comments = new ArrayList<String>();
        tweet.setCommentsMessage(comments);
        return tweets.add(tweet);
    }

    public boolean addComment(long id, String message) {
        Tweet tweet = getById(id);
        return getById(id).getCommentsMessage().add(message);
    }

    public Tweet getById(long id) {
        for (Tweet tweet : tweets) {
            if (tweet.getId() == id) {
                return tweet;
            }
        }
        return null;
    }

}
