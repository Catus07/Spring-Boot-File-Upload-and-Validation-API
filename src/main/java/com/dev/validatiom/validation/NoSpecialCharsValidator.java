package com.dev.validatiom.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoSpecialCharsValidator implements ConstraintValidator<NoSpecialChar,String> {

    public static final String DISALLOWED_REGEX=".*[<>@#\\\\$%&*].*";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null) return true;
        return !value.matches(DISALLOWED_REGEX);
    }
}
