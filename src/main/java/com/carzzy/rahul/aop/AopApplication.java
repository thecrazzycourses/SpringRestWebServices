package com.carzzy.rahul.aop;

import com.carzzy.rahul.aop.business.Business1;
import com.carzzy.rahul.aop.business.Business2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AopApplication implements CommandLineRunner {

    private Business1 business1;
    private Business2 business2;

    public AopApplication(Business1 business1, Business2 business2) {
        this.business1 = business1;
        this.business2 = business2;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("************ AOP ************");
        log.info(business1.calculateSomething());
        log.info(business2.calculateSomething());
        log.info("************ AOP ************");
    }
}
