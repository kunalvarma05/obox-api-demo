package com.logicboxes.marvel.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class AuthFilter extends OncePerRequestFilter
{

    private static final String API_KEY_HEADER = "Authorization";
    private static final String API_KEY = "1234";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException
    {

        String key = request.getHeader(API_KEY_HEADER);

        if (key.isEmpty() || !key.equals(API_KEY))
        {
            throw new ServletException("Invalid API KEY");
        }

        filterChain.doFilter(request, response);
    }

}