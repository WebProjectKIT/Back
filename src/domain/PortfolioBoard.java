package domain;


import java.sql.Timestamp;

public class PortfolioBoard {

  private long postingId;
  private String email;
  private long portfolioId;
  private String title;
  private String contents;
  private java.sql.Timestamp creationDate;
  private long view;

  public PortfolioBoard(long postingId, String email, long portfolioId, String title, String contents, Timestamp creationDate, long view) {
    this.postingId = postingId;
    this.email = email;
    this.portfolioId = portfolioId;
    this.title = title;
    this.contents = contents;
    this.creationDate = creationDate;
    this.view = view;
  }

  public long getPostingId() {
    return postingId;
  }

  public void setPostingId(long postingId) {
    this.postingId = postingId;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getPortfolioId() {
    return portfolioId;
  }

  public void setPortfolioId(long portfolioId) {
    this.portfolioId = portfolioId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public long getView() {
    return view;
  }

  public void setView(long view) {
    this.view = view;
  }

}
