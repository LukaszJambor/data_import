package com.example.demo.route.gameExport;

import com.example.demo.kafka.KafkaProducer;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExportGamesRoute extends RouteBuilder {

    private ConvertGamesProcessor convertGamesProcessor;
    private KafkaProducer kafkaProducer;

    public ExportGamesRoute(ConvertGamesProcessor convertGamesProcessor, KafkaProducer kafkaProducer) {
        this.convertGamesProcessor = convertGamesProcessor;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void configure() throws Exception {
        from("direct:exportGames")
                .process(convertGamesProcessor)
                .process(kafkaProducer);
    }
}