package me.myengine.myRestAPI.validators.annotation;

import me.myengine.myRestAPI.validators.StringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringValidator.class)
public @interface BeginsWith {

  String message() default "";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}
