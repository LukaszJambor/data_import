package com.example.demo.converter;

import com.example.demo.data.GameData;
import com.example.demo.data.ProducerData;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProducerToGameConverter {

    public void convert(List<GameData> gameDataList, List<ProducerData> producerDataList) {
        gameDataList.stream()
                .forEach(gameData -> addProducer(gameData, producerDataList));
    }

    private void addProducer(GameData gameData, List<ProducerData> producerDataList) {
        producerDataList.stream()
                .filter(producerData -> producerData.getId() == gameData.getId())
                .findAny()
                .ifPresent(producerData -> {
                    if (CollectionUtils.isEmpty(gameData.getProducerData())) {
                        gameData.setProducerData(new ArrayList<>());
                    }
                    List<ProducerData> producerDataInternal = gameData.getProducerData();
                    producerDataInternal.add(producerData);
                });
    }
}
