package com.example.demo.route.producersParse;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParseProducersRoute extends RouteBuilder {

    private ProducerAggregationStrategy producerAggregationStrategy;

    @Value("${route.parse.producers}")
    private String routeParseProducers;

    public ParseProducersRoute(ProducerAggregationStrategy producerAggregationStrategy) {
        this.producerAggregationStrategy = producerAggregationStrategy;
    }

    @Override
    public void configure() throws Exception {
        from("direct:addProducer")
                .pollEnrich(routeParseProducers, producerAggregationStrategy)
                .to("direct:exportGames");
    }
}