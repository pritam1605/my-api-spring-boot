package me.myengine.myRestAPI.exception.custom;

public class NotFoundException extends Exception {

  public NotFoundException() {
  }

  public NotFoundException(String message) {
    super(message);
  }

}
