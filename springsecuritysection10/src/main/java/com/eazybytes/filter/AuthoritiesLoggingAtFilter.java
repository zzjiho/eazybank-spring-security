package com.eazybytes.filter;


import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 인증이 진행중이라는 것을 로깅하는 필터
 * 실제로 볼 일이 별로 없다.
 */
@Slf4j
public class AuthoritiesLoggingAtFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        log.info("Authentication is in progress");
        chain.doFilter(servletRequest, servletResponse);
    }
}
