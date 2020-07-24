package com.carzzy.rahul.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("rest.api")
@Getter
@Setter
public class Properties {

    private boolean enabled;
    private String url;
    private int port;

}
