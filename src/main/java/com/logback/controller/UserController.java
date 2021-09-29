package com.logback.controller;


import com.logback.model.User;
import com.logback.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class UserController {
    static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseBody
    public User getEmployee() {

        log.trace("Trace Logs");
        log.error("Error Logs");
        log.warn("Warn Logs");
        log.debug("Debug Logs");
        log.info("Info Logs");

        /*
        switch (logLevel) {
            case "TRACE":
                log.trace("Get User Called");
                break;
            case "DEBUG":
                log.debug("Get User Called");
                break;
            case "ERROR":
                log.error("Get User Called");
                break;
            case "WARN":
                log.warn("Get User Called");
                break;
            default:
                log.info("Get User Called");
        }*/
        return userService.getUser();
    }
}
