package com.logback.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.qos.logback.classic.Logger;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TracingInterceptor implements HandlerInterceptor {

    private static final String LOG_LEVEL = "log-level";
    private static final String PACKAGE_LEVEL = "package-level";

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler){
        MDC.remove(LOG_LEVEL);
        MDC.remove(PACKAGE_LEVEL);
        MDC.put(LOG_LEVEL, getLogLevelFromRequest(request));
        MDC.put(PACKAGE_LEVEL, getPackageLevelFromRequest(request));
        return true;
    }

    private String getLogLevelFromRequest(HttpServletRequest request) {
        String incomingLogLevel = request.getHeader(LOG_LEVEL);
        return incomingLogLevel == null || incomingLogLevel.isEmpty() ? "INFO" : incomingLogLevel;
    }

    private String getPackageLevelFromRequest(HttpServletRequest request) {
        String incomingPackageLevel = request.getHeader(PACKAGE_LEVEL);
        return incomingPackageLevel == null || incomingPackageLevel.isEmpty() ? "com.logback.controller" : incomingPackageLevel;
    }
}

