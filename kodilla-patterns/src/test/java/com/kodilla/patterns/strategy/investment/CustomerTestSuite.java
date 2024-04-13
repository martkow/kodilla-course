package com.kodilla.patterns.strategy.investment;

import com.kodilla.patterns.strategy.investment.BalancedPredictor;
import com.kodilla.patterns.strategy.investment.CorporateCustomer;
import com.kodilla.patterns.strategy.investment.IndividualCustomer;
import com.kodilla.patterns.strategy.investment.IndividualYoungCustomer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Customer class")
public class CustomerTestSuite {
    @DisplayName("Test case for predict method for corporate customer")
    @Test
    void testCaseForPredictMethodForCorporateCustomer() {
        // Given
        CorporateCustomer corporateCustomer = new CorporateCustomer("Corporate customer");
        // When
        String result = corporateCustomer.predict();
        // Then
        Assertions.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ" ,result);
    }

    @DisplayName("Test case for predict method for individual customer")
    @Test
    void testCaseForPredictMethodForIndividualCustomer() {
        // Given
        IndividualCustomer individualCustomer = new IndividualCustomer("Individual customer");
        // When
        String result = individualCustomer.predict();
        // Then
        Assertions.assertEquals("[Conservative predictor] Buy debentures of XYZ" ,result);
    }

    @DisplayName("Test case for predict method for individual young customer")
    @Test
    void testCaseForPredictMethodForIndividualYoungCustomer() {
        // Given
        IndividualYoungCustomer individualYoungCustomer = new IndividualYoungCustomer("Individual young customer");
        // When
        String result = individualYoungCustomer.predict();
        // Then
        Assertions.assertEquals("[Aggressive predictor] Buy stock of XYZ" ,result);
    }

    @DisplayName("Test case for setBuyingStrategy method for individual young customer")
    @Test
    void testCaseForSetBuyingMethodForIndividualYoungCustomer() {
        // Given
        IndividualYoungCustomer individualYoungCustomer = new IndividualYoungCustomer("Individual young customer");
        // When
        individualYoungCustomer.setBuyingStrategy(new BalancedPredictor());
        String result = individualYoungCustomer.predict();
        // Then
        Assertions.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ" ,result);
    }
}
