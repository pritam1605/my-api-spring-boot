package me.myengine.myRestAPI.validators;

import me.myengine.myRestAPI.validators.annotation.BeginsWith;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<BeginsWith, String> {
  @Override
  public void initialize(BeginsWith beginsWith) {
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return (s.startsWith("Admin"));
  }
}
