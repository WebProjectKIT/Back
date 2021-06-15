package domain;


import java.sql.Timestamp;

public class Comments {

  private long commentId;
  private String email;
  private long postingId;
  private java.sql.Timestamp creationDate;
  private String contents;

  public Comments(long commentId, String email, long postingId, Timestamp creationDate, String contents) {
    this.commentId = commentId;
    this.email = email;
    this.postingId = postingId;
    this.creationDate = creationDate;
    this.contents = contents;
  }

  public long getCommentId() {
    return commentId;
  }

  public void setCommentId(long commentId) {
    this.commentId = commentId;
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


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

}
