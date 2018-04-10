package me.myengine.myRestAPI.model;

import me.myengine.myRestAPI.validators.annotation.BeginsWith;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank(message = "firstname is required")
  @Size(min = 3, max = 15 , message = "firstname must be 3 to 15 characters long")
  @BeginsWith(message = "firstname must begin with Admin")
  private String firstName;

//  @NotBlank(message = "lastname is required")
//  @Size(min = 3, max = 15 , message = "lastname must be 3 to 15 characters long")
  private String lastName;

  public Author() {
  }

  public Author(long id, String firstName, String lastName) {
    this.id = id;
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

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
