package me.myengine.biDirectionalMapping;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "book_bidirectional")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id"
)
//http://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private int edition;
  private int pageCount;

//  @JsonBackReference   // it won't appear in the output when Book object is printed out
//  @JsonIgnore     // It will ignore the field al together in the output
  private Author author;

  public Book() {
  }

  public Book(String title, int edition, int pageCount) {
    this.title = title;
    this.edition = edition;
    this.pageCount = pageCount;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getEdition() {
    return edition;
  }

  public void setEdition(int edition) {
    this.edition = edition;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", edition=" + edition +
      ", pageCount=" + pageCount +
      ", author=" + author +
      '}';
  }
}
