package com.logback.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.MDC;

public class ClassNameFilter extends AbstractMatcherFilter<ILoggingEvent> {

    String loggerName;

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }

        if (event.getLoggerName().equals(loggerName)) {
            System.out.println(loggerName);
            return onMatch;
        } else {
            return onMismatch;
        }
    }

    public void setClassName(String className) {
        System.out.println("class " +className);
        this.loggerName = className;
    }

    private void setLoggerName() {
        if (loggerName.equalsIgnoreCase("default")) {
            this.loggerName = MDC.get("package-level");
            System.out.println("burda " + loggerName);
        }
    }

    @Override
    public void start() {
        if (this.loggerName != null) {
            super.start();
        }
    }
}
