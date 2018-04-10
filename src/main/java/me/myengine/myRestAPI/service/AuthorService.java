package me.myengine.myRestAPI.service;

import me.myengine.myRestAPI.dao.AuthorRepository;
import me.myengine.myRestAPI.exception.custom.NotFoundException;
import me.myengine.myRestAPI.model.Author;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  public List<Author> index() throws Exception {
    List<Author> authors = this.authorRepository.findAll();
    if (authors.isEmpty()) {
      throw new Exception("No authors found");
    }

    return this.authorRepository.findAll();
  }

  public Author show(long id) throws Exception {
    Author author = this.authorRepository.findOne(id);
    if (author == null) {
      throw new Exception("Author with id " + id + " not found");
    }

    return author;
  }

  public Author create(Author author) {
    return this.authorRepository.save(author);
  }

  public Author edit(Author author) {
    return this.authorRepository.save(author);
  }

  public void destroy(long id) throws NotFoundException {
    if (this.authorRepository.findOne(id) == null) {
      throw new NotFoundException("Author with id " + id + " not found.");
    }
    this.authorRepository.delete(id);
  }

  public Author update(Author author, long id) throws NotFoundException {
    Author dbAuthor = this.authorRepository.findOne(id);
    if (dbAuthor == null) {
      throw new NotFoundException("Author with id " + id + " not found.");
    }

    BeanUtils.copyProperties(author, dbAuthor, AuthorService.getNullPropertyNamesToIgnore(author));
    return this.edit(dbAuthor);
  }

  public static String[] getNullPropertyNamesToIgnore(Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    PropertyDescriptor[] propertyDescriptors = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<>();
    for (PropertyDescriptor propertyDescriptor: propertyDescriptors) {
      // check if value of this property os null then add it to the collection
      Object srcValue = src.getPropertyValue(propertyDescriptor.getName());
      if (srcValue == null) {
        emptyNames.add(propertyDescriptor.getName());
      }
    }

    String[] result = new String[emptyNames.size()];

    return emptyNames.toArray(result);
  }



}
