package com.example.demo.routes.fileImport;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FileNameProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String originalFileName = exchange.getIn().getHeader(
                Exchange.FILE_NAME, String.class);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String changedFileName = dtf.format(localDateTime) + originalFileName;
        exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
    }
}
