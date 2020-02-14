package com.example.demo.route.gameExport;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExportGamesRoute extends RouteBuilder {

    private ConvertGamesProcessor convertGamesProcessor;

    public ExportGamesRoute(ConvertGamesProcessor convertGamesProcessor) {
        this.convertGamesProcessor = convertGamesProcessor;
    }

    @Override
    public void configure() throws Exception {
        from("direct:exportGames")
                .process(convertGamesProcessor)
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .to("http://main-app:9080/api/import/games");
    }
}