package com.carzzy.rahul.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homes")
public class HomeApi {

    @GetMapping
    public String getHomes() {
        return "Home Api is Up & Running";
    }
}
