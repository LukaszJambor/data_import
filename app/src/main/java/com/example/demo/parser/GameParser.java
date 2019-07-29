package com.example.demo.parser;

import com.example.demo.data.GameData;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class GameParser {

    public List<GameData> parse(File file) {
        BeanListProcessor<GameData> rowProcessor = new BeanListProcessor<>(GameData.class);
        CsvParser parser = new CsvParser(createSettings(rowProcessor));
        parser.parse(file);
        return rowProcessor.getBeans();
    }

    private CsvParserSettings createSettings(BeanListProcessor<GameData> rowProcessor) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setDelimiter(";");
        settings.getFormat().setLineSeparator("\n");
        settings.setProcessor(rowProcessor);
        return settings;
    }
}
