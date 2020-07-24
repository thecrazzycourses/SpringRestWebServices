package com.carzzy.rahul.properties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/properties")
public class PropertiesApi {

    private Properties properties;

    public PropertiesApi(Properties properties) {
        this.properties = properties;
    }

    @GetMapping
    public Map getProperties() {
        Map map = new HashMap<>();
        map.put("Rest APi Enabled", properties.isEnabled());
        map.put("Rest APi URI", properties.getUrl());
        map.put("Rest APi Port", properties.getPort());
        return map;
    }
}
