package com.example.demo.route.ParseProducers;

import com.example.demo.converter.ProducerToGameConverter;
import com.example.demo.data.GameData;
import com.example.demo.data.ProducerData;
import com.example.demo.parser.ProducerParser;
import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class ProducerAggregationStrategy implements AggregationStrategy {

    private ProducerParser producerParser;
    private ProducerToGameConverter producerToGameConverter;

    public ProducerAggregationStrategy(ProducerParser producerParser, ProducerToGameConverter producerToGameConverter) {
        this.producerParser = producerParser;
        this.producerToGameConverter = producerToGameConverter;
    }

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        GenericFile genericFile = (GenericFile) newExchange.getIn().getBody();
        File file = (File) genericFile.getBody();
        List<ProducerData> producerDataList = producerParser.parse(file);
        List<GameData> gameDataList = (List<GameData>) oldExchange.getProperty("gameData", producerDataList);
        producerToGameConverter.convert(gameDataList, producerDataList);
        newExchange.setProperty("enrichedgGmeData", gameDataList);
        return newExchange;
    }
}