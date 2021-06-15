package domain;


public class Bookmark {

  private String email;
  private long postingId;

  public Bookmark(String email, long postingId) {
    this.email = email;
    this.postingId = postingId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getPostingId() {
    return postingId;
  }

  public void setPostingId(long postingId) {
    this.postingId = postingId;
  }

}
