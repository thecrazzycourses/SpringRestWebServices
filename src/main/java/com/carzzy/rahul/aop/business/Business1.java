package com.carzzy.rahul.aop.business;

import com.carzzy.rahul.aop.dao.Dao1;
import org.springframework.stereotype.Component;

@Component
public class Business1 {

    private Dao1 dao1;

    public Business1(Dao1 dao1) {
        this.dao1 = dao1;
    }

    public String calculateSomething() {
        return dao1.retrieveSomething();
    }
}
