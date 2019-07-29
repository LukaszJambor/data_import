package com.example.demo.routes.gameParser;

import com.example.demo.parser.GameParser;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ParseGamesProcessor implements Processor {

    private GameParser gameParser;

    public ParseGamesProcessor(GameParser gameParser) {
        this.gameParser = gameParser;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        GenericFile genericFile = (GenericFile) exchange.getIn().getBody();
        File file = (File) genericFile.getBody();
        gameParser.parse(file);
    }
}
