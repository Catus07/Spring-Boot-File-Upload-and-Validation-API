package com.dev.validatiom.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoSpecialCharsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoSpecialChar {
    String message() default "firstname must not contain special characters like <,/,>,@,#";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
