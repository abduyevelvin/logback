package com.logback.service;

import com.logback.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    static final Logger log = LoggerFactory.getLogger(UserService.class);

    public User getUser() {
        log.info("Get User in side UserService");
        User employee = new User("User", 30);
        log.debug("Retrieving User");
        return employee;
    }
}
