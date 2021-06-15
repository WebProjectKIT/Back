package domain;


import java.sql.Timestamp;

public class Portfolio {

  private long portfolioId;
  private String email;
  private String title;
  private String link;
  private String image;
  private java.sql.Timestamp creationDate;

  public Portfolio(long portfolioId, String email, String title, String link, String image, Timestamp creationDate) {
    this.portfolioId = portfolioId;
    this.email = email;
    this.title = title;
    this.link = link;
    this.image = image;
    this.creationDate = creationDate;
  }

  public long getPortfolioId() {
    return portfolioId;
  }

  public void setPortfolioId(long portfolioId) {
    this.portfolioId = portfolioId;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }

}
