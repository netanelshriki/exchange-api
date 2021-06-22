package com.net.demo33.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DecimalFormat;


@Configuration
public class DecimalConfig {

    @Bean
    public DecimalFormat decimalFormat(){
        return new DecimalFormat("0.00");
    }
}
