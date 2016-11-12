package twitter;

import java.util.Date;
import java.util.List;

public class Tweet {

    private long id;

    private String message;
    private List<String> commentsMessage;

    private Date createdAt;

    public String getMessage() {
        return message;
    }

    public void setCommentsMessage(List<String> commentsMessage) {
        this.commentsMessage = commentsMessage;
    }

    public List<String> getCommentsMessage() {
        return commentsMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
