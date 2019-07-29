package com.example.demo.routes.fileImport;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileImportRoute extends RouteBuilder {

    private FileNameProcessor fileNameProcessor;

    public FileImportRoute(FileNameProcessor fileNameProcessor) {
        this.fileNameProcessor = fileNameProcessor;
    }

    @Override
    public void configure() throws Exception {
        from("file:/D:/backup/workspace/hot_folder/?delete=true")
                .process(fileNameProcessor)
                .to("file:/D:/backup/workspace/data_import/app/src/main/resources/hot_folder_internal")
                .to("direct:parse")
                .end();
    }
}