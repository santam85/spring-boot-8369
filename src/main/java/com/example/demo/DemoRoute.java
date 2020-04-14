package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class DemoRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .skipBindingOnErrorCode(false)
                .bindingMode(RestBindingMode.json);


        rest().get("/").route().setBody(constant("hello"));
    }
}
