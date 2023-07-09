package com.example.demo.config;

import com.example2.demo.data.GameData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;

public class KafkaSerializer implements Serializer<GameData> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public byte[] serialize(String s, GameData gameData) {
        return objectMapper.writeValueAsBytes(gameData);
    }
}
