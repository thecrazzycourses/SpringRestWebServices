package com.carzzy.rahul.aop.business;

import com.carzzy.rahul.aop.dao.Dao2;
import org.springframework.stereotype.Component;

@Component
public class Business2 {

    private Dao2 dao2;

    public Business2(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String calculateSomething() {
        return dao2.retrieveSomething();
    }
}
