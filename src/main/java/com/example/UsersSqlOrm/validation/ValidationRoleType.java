package com.example.UsersSqlOrm.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StatusTypeValidator.class)
public @interface ValidationRoleType {

    public String message() default "Invalid role: it should be either ADMIN OR USER OR CLIENT";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
