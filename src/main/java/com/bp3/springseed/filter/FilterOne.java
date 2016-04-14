package com.bp3.springseed.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author dparish
 */
@Order(2)
public class FilterOne implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(FilterOne.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("in init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("in filter one");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
