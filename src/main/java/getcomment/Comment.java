package getcomment;

import java.util.List;

public class Comment {
    private String maxResults;
    private String total;
    private String startAt;
    private List<Comments> comments;

    public String getMaxResults() {
        return maxResults;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void setMaxResults(String maxResults) {
        this.maxResults = maxResults;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }
}
