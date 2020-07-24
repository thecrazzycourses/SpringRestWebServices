package com.carzzy.rahul.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/somebeans")
public class SomeBeanApi {

    private BeanFilterHelper beanFilterHelper;

    public SomeBeanApi(BeanFilterHelper beanFilterHelper) {
        this.beanFilterHelper = beanFilterHelper;
    }

    @GetMapping("/filter1")
    public MappingJacksonValue retrieveField1AndField2() {

        SomeBean bean = new SomeBean();
        bean.setField1("value 1");
        bean.setField2("value 2");
        bean.setField3("value 3");

      /*  SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);*/

        return beanFilterHelper.filter("field1", "field2", "SomeBeanFilter", bean);
    }

    @GetMapping("/filter2")
    public MappingJacksonValue retrieveField2AndField3() {

        SomeBean bean = new SomeBean();
        bean.setField1("value 1");
        bean.setField2("value 2");
        bean.setField3("value 3");

        /*SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);*/

        return beanFilterHelper.filter("field2", "field3", "SomeBeanFilter", bean);
    }
}
