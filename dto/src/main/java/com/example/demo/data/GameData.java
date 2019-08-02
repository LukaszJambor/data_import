package com.example.demo.data;

import com.univocity.parsers.annotations.EnumOptions;
import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameData {

    enum DistributionPath {
        CD("CD"),
        KEY("KEY");

        public final String type;

        DistributionPath(String type) {
            this.type = type;
        }
    }

    @Parsed(index = 0)
    private long id;

    @Parsed(index = 1)
    private String name;

    @Parsed(index = 2)
    private String type;

    @Parsed(index = 3)
    @EnumOptions(customElement = "type")
    private DistributionPath distributionPath;

    @Parsed(index = 4)
    private int quantity;

    @Nested
    private Price price;

    private List<ProducerData> producerData;
}
