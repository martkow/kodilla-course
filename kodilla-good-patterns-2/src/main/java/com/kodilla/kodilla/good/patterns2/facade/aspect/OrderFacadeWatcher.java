package com.kodilla.kodilla.good.patterns2.facade.aspect;

import com.kodilla.kodilla.good.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // @Aspect tells Spring that this class contains advice (additional behavior you want to apply at certain join points).
@Component // Component Annotation: @Component registers the aspect as a Spring bean.
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before(
            "execution(* com.kodilla.kodilla.good.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)"
    )
    public void logEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info("Logging event. Class: {}. Args: {}, {}", object.getClass().getName(), order, userId);
    }
}
