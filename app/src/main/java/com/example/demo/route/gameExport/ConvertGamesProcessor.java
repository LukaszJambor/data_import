package com.example.demo.route.gameExport;

import com.example.demo.converter.GameDataToGameDataExternalConverter;
import com.example.demo.data.GameData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertGamesProcessor implements Processor {

    GameDataToGameDataExternalConverter gameDataToGameDataExternalConverter;

    public ConvertGamesProcessor(GameDataToGameDataExternalConverter gameDataToGameDataExternalConverter) {
        this.gameDataToGameDataExternalConverter = gameDataToGameDataExternalConverter;
    }

    @Override
    public void process(Exchange exchange) {
        List<GameData> gameDataList = (List<GameData>) exchange.getIn().getBody();
        List<com.example2.demo.data.GameData> collect = gameDataList.stream()
                .map(gameData -> gameDataToGameDataExternalConverter.toDto(gameData))
                .collect(Collectors.toList());
        exchange.getIn().setBody(collect);
    }
}