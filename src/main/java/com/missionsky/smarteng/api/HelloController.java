package com.missionsky.smarteng.api;

import com.missionsky.smarteng.model.User;
import com.missionsky.smarteng.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/")
    public String index() {
        logger.info("test log");
        return helloService.getGreeting();
    }

    @RequestMapping(value = "/hello/{userId}", method = RequestMethod.GET)
    public String say(@PathVariable String userId) {
        return  helloService.getGreeting() + helloService.getUserName(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam String userId) {
        return  helloService.getUser(userId);
    }
}
