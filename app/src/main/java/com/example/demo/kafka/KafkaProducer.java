package com.example.demo.kafka;

import com.example2.demo.data.GameData;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaProducer implements Processor {

    private KafkaTemplate<String, com.example2.demo.data.GameData> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, GameData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        List<GameData> gameDataList = (List<GameData>) exchange.getIn().getBody();
        gameDataList.forEach(gameData -> kafkaTemplate.send("export-games", gameData));
    }
}