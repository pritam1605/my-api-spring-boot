package me.myengine.biDirectionalMapping;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author_bidirectional")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id"
)
//http://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String firstName;
  private String lastName;

//  @JsonManagedReference
//  @JsonIgnore     // It will ignore the field al together in the output
  private List<Book> booksWritten;

  public Author() {
  }

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<Book> getBooksWritten() {
    return booksWritten;
  }

  public void setBooksWritten(List<Book> booksWritten) {
    this.booksWritten = booksWritten;
  }

  @Override
  public String toString() {
    return "Author{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", booksWritten=" + booksWritten +
      '}';
  }
}
