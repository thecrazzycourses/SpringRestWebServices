package com.carzzy.rahul.versioning;

import com.carzzy.rahul.versioning.entity.Name;
import com.carzzy.rahul.versioning.entity.PersonV1;
import com.carzzy.rahul.versioning.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versions")
public class VersionApi {

    // Versioning Using URI : localhost:8080/api/versions/v1/person
    @GetMapping("/v1/person")
    public PersonV1 personV1() {
        return PersonV1.builder().name("Rahul Choudhary").build();
    }
    @GetMapping("/v2/person")
    public PersonV2 personV2() {
        Name name = Name.builder().firstName("Rahul").lastName("Choudhary").build();
        return PersonV2.builder().name(name).build();
    }


    // Versioning Using Params : localhost:8080/api/versions/person/param?version=1
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramsV1() {
        return PersonV1.builder().name("Rahul Choudhary").build();
    }
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramsV2() {
        Name name = Name.builder().firstName("Rahul").lastName("Choudhary").build();
        return PersonV2.builder().name(name).build();
    }


    // Versioning Using Header : localhost:8080/api/versions/person/header with Header Key = X-API-VERSION & Value = 1, cache issue
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return PersonV1.builder().name("Rahul Choudhary").build();
    }
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        Name name = Name.builder().firstName("Rahul").lastName("Choudhary").build();
        return PersonV2.builder().name(name).build();
    }

    // Versioning Using Produces : localhost:8080/api/versions/person/produces with Header Key = Accept & Value = application/vnd.company.app-v1+json, cache issue
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return PersonV1.builder().name("Rahul Choudhary").build();
    }
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        Name name = Name.builder().firstName("Rahul").lastName("Choudhary").build();
        return PersonV2.builder().name(name).build();
    }

}
