package com.example.demo.data;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by USER on 01.06.2019.
 */

@Setter
@Getter
public class Price {

    @Parsed(index = 5)
    private BigDecimal price;

    @Parsed(index = 6)
    private Currency currency;
}
