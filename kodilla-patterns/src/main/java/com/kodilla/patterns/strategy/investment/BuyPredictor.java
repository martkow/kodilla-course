package com.kodilla.patterns.strategy.investment;

public sealed interface BuyPredictor permits AggressivePredictor, BalancedPredictor, ConservativePredictor {
    String predictWhatToBuy();
}
