package com.bp3.springseed.conf;

import com.bp3.springseed.filter.FilterOne;
import com.bp3.springseed.filter.FilterTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author dparish
 */
@Configuration
public class AppConfig {

    @Bean
    Filter filterOne() {
        return new FilterOne();
    }

    @Bean
    Filter filterTwo() {
        return new FilterTwo();
    }
}
