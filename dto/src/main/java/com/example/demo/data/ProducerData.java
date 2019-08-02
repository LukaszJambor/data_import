package com.example.demo.data;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProducerData {

    @Parsed(index = 0)
    private long id;

    @Parsed(index = 1)
    private String name;
}