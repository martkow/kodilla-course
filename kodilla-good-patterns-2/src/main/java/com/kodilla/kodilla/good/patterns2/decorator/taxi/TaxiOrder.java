package com.kodilla.kodilla.good.patterns2.decorator.taxi;

import java.math.BigDecimal;

public interface TaxiOrder {
    BigDecimal getCost();
    String getDescription();
}
