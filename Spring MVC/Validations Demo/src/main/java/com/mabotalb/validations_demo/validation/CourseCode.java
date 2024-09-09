package com.mabotalb.validations_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // Define the default course code value
    public String value() default "LUV";

    // Define the default error message for invalid course code
    public String message() default "Invalid course code. must start with LUV";

    // Define the groups for this validation
    public Class<?>[] groups() default {};

    // Define the payload for this validation
    public Class<? extends Payload>[] payload() default {};


}
