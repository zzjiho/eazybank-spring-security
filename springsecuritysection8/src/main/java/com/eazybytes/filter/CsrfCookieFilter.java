package com.eazybytes.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CsrfCookieFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { //csrf토큰을 헤더에 설정해주는 필터
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName()); //csrf토큰을 가져옴
        if (null != csrfToken.getHeaderName()) { //csrf토큰이 존재하면
            response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken()); //헤더에 csrf토큰을 설정
        }
        filterChain.doFilter(request, response); //다음 필터로 넘김
    }
}
