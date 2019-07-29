package com.example.demo.data;

import com.univocity.parsers.annotations.EnumOptions;
import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.Setter;

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
    private String name;

    @Parsed(index = 1)
    private String type;

    @Parsed(index = 2)
    @EnumOptions(customElement = "type")
    private DistributionPath distributionPath;

    @Parsed(index = 3)
    private int quantity;

    @Nested
    private Price price;
}
