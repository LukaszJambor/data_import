package com.example.demo.route.ParseProducers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ParseProducersRoute extends RouteBuilder {

    private ProducerAggregationStrategy producerAggregationStrategy;

    public ParseProducersRoute(ProducerAggregationStrategy producerAggregationStrategy) {
        this.producerAggregationStrategy = producerAggregationStrategy;
    }

    @Override
    public void configure() throws Exception {
        from("direct:addProducer")
                .pollEnrich("file:/D:/backup/workspace/data_import/app/src/main/resources/hot_folder/?delete=true&include=producers.txt", producerAggregationStrategy)
                .end();
    }
}