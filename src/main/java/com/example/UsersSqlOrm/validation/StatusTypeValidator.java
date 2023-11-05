package com.example.UsersSqlOrm.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StatusTypeValidator implements ConstraintValidator<ValidationRoleType,String> {
    @Override
    public boolean isValid(String statusType, ConstraintValidatorContext constraintValidatorContext) {

        List<String> statusTypes= Arrays.asList("ADMIN","USER","CLIENT");


        return statusTypes.contains(statusType);
    }
}
