package com.logback.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggerUtils {

    public static void createLoggerFor() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder ple = new PatternLayoutEncoder();

        ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
        ple.setContext(lc);
        ple.start();
        ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender<>();
        consoleAppender.setEncoder(ple);
        consoleAppender.setContext(lc);
        consoleAppender.start();

        //String loggerName = MDC.get("package-level") != null ? MDC.get("package-level") : "com.logback.controller";
        //String level = MDC.get("log-level") != null ? MDC.get("log-level") : "INFO";
        Logger logger = (Logger) LoggerFactory.getLogger(MDC.get("package-level"));
        System.out.println(MDC.get("package-level"));
        logger.setLevel(Level.toLevel(MDC.get("log-level")));
        System.out.println(MDC.get("log-level"));
        logger.addAppender(consoleAppender);
        logger.setAdditive(false); /* set to true if root should log too */

        Logger root = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);
    }

}
