package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jonathan on 11/2/2016.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
