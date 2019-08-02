package com.example.demo.parser;

import com.example.demo.data.ProducerData;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class ProducerParser {

    public List<ProducerData> parse(File file) {
        BeanListProcessor<ProducerData> rowProcessor = new BeanListProcessor<>(ProducerData.class);
        CsvParser parser = new CsvParser(createSettings(rowProcessor));
        parser.parse(file);
        return rowProcessor.getBeans();
    }

    private CsvParserSettings createSettings(BeanListProcessor<ProducerData> rowProcessor) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setDelimiter(";");
        settings.getFormat().setLineSeparator("\n");
        settings.setProcessor(rowProcessor);
        return settings;
    }
}
