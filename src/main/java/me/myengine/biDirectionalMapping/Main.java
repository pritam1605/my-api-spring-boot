package me.myengine.biDirectionalMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    Author author = new Author("Dan", "Brown");
    Book book1 = new Book("The Da Vinci Code", 1, 600);
    Book book2 = new Book("The Lost Symbol", 1, 600);
    Book book3 = new Book("Digital Fortress", 1, 600);

    book1.setAuthor(author);
    book2.setAuthor(author);
    book3.setAuthor(author);

    author.setBooksWritten(Arrays.asList(book1, book2, book3));

//    Converting object to JSON
    String authorJSON = new ObjectMapper().writeValueAsString(author);
    String book1JSON = new ObjectMapper().writeValueAsString(book1);
    String book2JSON = new ObjectMapper().writeValueAsString(book2);
    String book3JSON = new ObjectMapper().writeValueAsString(book3);

    System.out.println(authorJSON);
    System.out.println(book1JSON);
    System.out.println(book2JSON);
    System.out.println(book3JSON);

//    Converting JSON to Object
//    Author danBrown = new ObjectMapper().readerFor(Author.class).readValue(authorJSON);
//    Book daVinciCode = new ObjectMapper().readerFor(Book.class).readValue(book1JSON);
//    Book lostSymbol = new ObjectMapper().readerFor(Book.class).readValue(book2JSON);
//    Book digitalFortress = new ObjectMapper().readerFor(Book.class).readValue(book3JSON);


  }
}
