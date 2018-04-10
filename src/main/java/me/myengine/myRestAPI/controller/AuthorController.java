package me.myengine.myRestAPI.controller;

import me.myengine.myRestAPI.apiResponse.ResponseMessage;
import me.myengine.myRestAPI.apiResponse.SuccessMessage;
import me.myengine.myRestAPI.exception.custom.NotFoundException;
import me.myengine.myRestAPI.model.Author;
import me.myengine.myRestAPI.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = { "https://myengine.me", "http://localhost:4200"})
@RequestMapping(value = "/authors")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public ResponseEntity<ResponseMessage> getAuthor(@PathVariable long id) throws Exception {
    return new ResponseEntity<ResponseMessage>(new SuccessMessage(1000, this.authorService.show(id), "Author with id " + id + " successfully retrieved"), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage> createAuthor(@Valid @RequestBody Author author) {
    return new ResponseEntity<ResponseMessage>(new SuccessMessage(1002, this.authorService.create(author), "Author successfully created"), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseMessage> getAllAuthors() throws Exception {
    return new ResponseEntity<ResponseMessage>(new SuccessMessage(1001, this.authorService.index(), "Authors successfully retrieved"), HttpStatus.OK);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseMessage> editAuthor(@RequestBody Author author, @PathVariable long id) {
    author.setId(id);
    return new ResponseEntity<ResponseMessage>(new SuccessMessage(1003, this.authorService.edit(author), "Author with id " + id + " successfully updated"), HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<ResponseMessage> deleteAuthor(@PathVariable long id) throws NotFoundException {
    this.authorService.destroy(id);
    return new ResponseEntity<ResponseMessage>(new SuccessMessage(1004, null, "Author with id " + id + " successfully deleted"), HttpStatus.OK);
  }


  @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseMessage> partiallyUpdateAuthor(@RequestBody Author partialAuthor, @PathVariable("id") long id) throws NotFoundException {
    partialAuthor.setId(id);
    return new ResponseEntity<ResponseMessage>(new SuccessMessage(1005, this.authorService.update(partialAuthor, id), "Author with id " + id + " updated"), HttpStatus.OK);
  }
}
