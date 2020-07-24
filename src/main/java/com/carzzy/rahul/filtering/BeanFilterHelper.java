package com.carzzy.rahul.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

@Component
public class BeanFilterHelper {

    public MappingJacksonValue filter(String feild1, String feild2, String beanClass, SomeBean bean) {

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(feild1, feild2);
        FilterProvider filters = new SimpleFilterProvider().addFilter(beanClass, filter);
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);

        return mapping;
    }
}
