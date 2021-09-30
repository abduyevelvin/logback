package com.logback.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class IgnoreLoggerFilter extends TurboFilter {
    private String loggerName;

    @Override
    public FilterReply decide(Marker marker, Logger logger,
                              Level level, String format, Object[] params, Throwable t) {
        if (loggerName == null) {
            return FilterReply.NEUTRAL;
        } else if (loggerName.equals(logger.getName())) {
            return FilterReply.DENY;
        } else
            return FilterReply.NEUTRAL;
    }

    public void setLoggerName(String loggerName) {
        System.out.println(loggerName);
        this.loggerName = loggerName;
    }
}
