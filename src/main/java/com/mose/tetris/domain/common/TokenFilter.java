package com.mose.tetris.domain.common;

import com.mose.tetris.domain.common.utils.JwtTokenManagement;
import lombok.RequiredArgsConstructor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
@RequiredArgsConstructor
public class TokenFilter implements Filter {
    private final JwtTokenManagement mJwtTokenManagement;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();


        chain.doFilter(req, res);
    }
}
