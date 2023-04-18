package com.interview.carprocurement.data;


import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Needed to convert the value from String in format in application.yml
 * to the Pojo in BigDecimal
 * application.yml -> amount: 12000.00
 * Pojo TransactionRecord.java -> private BigDecimal amount;
 */
@Component
@ConfigurationPropertiesBinding
public class BigDecimalConverter implements Converter<String, BigDecimal> {
    @Override
    public BigDecimal convert(String source) {
        if (source == null) {
            return null;
        }
        return new BigDecimal(source);
    }
}
