package com.outsourcemib.homepagemib.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.outsourcemib.homepagemib.ConstantsOfSystem;

public class SecurityFilter implements Filter {

    private FilterConfig filterConfig;
    private static final Logger logger = Logger.getLogger(SecurityFilter.class.getName());

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Object user = request.getSession().getAttribute(ConstantsOfSystem.USER_SESSION_KEY);
        String resource = request.getRequestURI().replaceAll(request.getContextPath(), "");
        
        logger.info("Security filter: "+ resource);
        
        if( ConstantsOfSystem.pages.contains(resource)){
        	logger.log(Level.INFO, "access granted: " + resource);
        }else if (user == null) {
            logger.log(Level.INFO, "access denied: " + resource);
            response.sendRedirect(ConstantsOfSystem.LOGIN_PAGE);
            return;
        }else{
        	logger.log(Level.INFO, "access granted: " + resource);
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    protected FilterConfig getFilterConfig() {
        return filterConfig;
    }
}

