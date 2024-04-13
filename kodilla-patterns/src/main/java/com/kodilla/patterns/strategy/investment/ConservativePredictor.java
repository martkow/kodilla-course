package com.kodilla.patterns.strategy.investment;

import com.kodilla.patterns.strategy.investment.BuyPredictor;

public final class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}
