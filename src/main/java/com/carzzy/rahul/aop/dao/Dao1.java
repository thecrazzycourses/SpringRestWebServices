package com.carzzy.rahul.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class Dao1 {

    public String retrieveSomething() {
        return "Dao 1";
    }
}
