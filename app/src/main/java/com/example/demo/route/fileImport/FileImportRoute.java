package com.example.demo.route.fileImport;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileImportRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/D:/backup/workspace/data_import/app/src/main/resources/hot_folder/?delete=true&include=games.txt")
                .to("direct:parse")
                .end();
    }
}