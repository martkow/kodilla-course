package com.kodilla.good.patterns.challenges.solid.ntf;

import com.kodilla.good.patterns.challenges.solid.ntf.InformationService;
import com.kodilla.good.patterns.challenges.solid.user.User;

public class EmailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Sending confirmation email to " + user.getUserEmail());
    }
}
