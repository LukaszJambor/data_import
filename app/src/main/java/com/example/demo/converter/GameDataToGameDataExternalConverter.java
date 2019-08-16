package com.example.demo.converter;

import com.example2.demo.data.GameData;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GameDataToGameDataExternalConverter {

    @Mapping(source = "price.price", target = "price")
    @Mapping(source = "price.currency", target = "currency")
    @Mapping(expression = "java(gameData.getProducerDataList().get(0).getName())", target = "producerName")
    GameData toDto(com.example.demo.data.GameData gameData);
}