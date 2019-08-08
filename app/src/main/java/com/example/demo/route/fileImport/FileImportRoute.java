package com.example.demo.route.fileImport;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileImportRoute extends RouteBuilder {

    @Value("${route.import.name}")
    private String routeImportName;

    @Override
    public void configure() throws Exception {
        from(routeImportName)
                .to("direct:parse")
                .end();
    }
}