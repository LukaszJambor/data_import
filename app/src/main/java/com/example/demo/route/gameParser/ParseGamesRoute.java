package com.example.demo.route.gameParser;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ParseGamesRoute extends RouteBuilder {

    private ParseGamesProcessor parseGamesProcessor;

    public ParseGamesRoute(ParseGamesProcessor parseGamesProcessor) {
        this.parseGamesProcessor = parseGamesProcessor;
    }

    @Override
    public void configure() throws Exception {
        from("direct:parse")
                .process(parseGamesProcessor)
                .to("direct:addProducer")
                .end();
    }
}
