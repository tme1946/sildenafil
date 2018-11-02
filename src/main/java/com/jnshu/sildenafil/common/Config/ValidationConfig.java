package com.jnshu.sildenafil.common.Config;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * validation的配置类,指定messageSource的文件位置
 * TODO
 * @author feifei 2018-11-1
 */
@Configuration
public class ValidationConfig  {

    @Bean
    public Validator getValidator() {
        Validator validator = Validation.byDefaultProvider().
                configure().
                messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("ErrorMessages"))).
                buildValidatorFactory().getValidator();
        return validator;
    }

}
