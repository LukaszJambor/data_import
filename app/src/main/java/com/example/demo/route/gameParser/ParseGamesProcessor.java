package com.example.demo.route.gameParser;

import com.example.demo.data.GameData;
import com.example.demo.parser.GameParser;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class ParseGamesProcessor implements Processor {

    private GameParser gameParser;

    public ParseGamesProcessor(GameParser gameParser) {
        this.gameParser = gameParser;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        GenericFile genericFile = exchange.getIn().getBody(GenericFile.class);
        File file = (File) genericFile.getBody();
        List<GameData> gameDataList = gameParser.parse(file);
        exchange.getIn().setBody(gameDataList);
//        exchange.setProperty("gameData", gameDataList);
    }
}
