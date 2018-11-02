package com.jnshu.sildenafil.util;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
public class ValidationUtils {
    /**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class)
            .configure().failFast(true).buildValidatorFactory().getValidator();
    /**
     * 〈注解验证参数〉
     * @param
     * @see
     * @since
     */
    public static <T> void validate(T obj,Class<?>... groups) throws ServiceExcetpion {
        //校验的结果集，groups为校验组；
        //Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj,groups);

        if (constraintViolations.size() > 0) {
//            log.error("validation error;detail message is: {}",
//                    constraintViolations.iterator().next().getMessage());
//                for (ConstraintViolation<T> constraintViolation : constraintViolations) {
//
//                    System.out.println(constraintViolation);
//                }
            throw new ServiceExcetpion(
                    String.format("args validation error:%s",
                            constraintViolations.iterator().next().getMessage()));

        }
    }
}
