package com.kodilla.good.patterns.challenges.solid.product.order.ntf;

import com.kodilla.good.patterns.challenges.solid.product.order.user.User;

public class EmailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Sending confirmation email to " + user.getUserEmail());
    }
}
