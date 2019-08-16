package com.example.demo.data;

import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameData {

    public GameData() {
        this.producerDataList = new ArrayList<>();
    }

    @Parsed(index = 0)
    private Long id;

    @Parsed(index = 1)
    private String name;

    @Parsed(index = 2)
    private String type;

    @Parsed(index = 3)
    private DistributionPath distributionPath;

    @Parsed(index = 4)
    private int quantity;

    @Nested
    private Price price;

    private List<ProducerData> producerDataList;

    public void addProducer(ProducerData producerData){
        producerDataList.add(producerData);
    }
}
