package me.myengine.myRestAPI.apiResponse;

public class SuccessMessage extends ResponseMessage {

  public SuccessMessage(int code, Object object, String message) {
    super(code, object, message);
  }
}
