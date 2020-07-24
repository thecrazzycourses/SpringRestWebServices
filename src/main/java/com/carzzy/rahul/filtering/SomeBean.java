package com.carzzy.rahul.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;
    private String field2;
    private String field3;

}
