package com.kodilla.kodilla.good.patterns2.aop.calculator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * How can we now make the Watcher class an aspect?<br><br>
 * In other words, how to make its method be called when specific events occur, defined cross-sectionally throughout the application?
 * First, we need to mark the Watcher class with the @Aspect annotation.
 * Then we need to mark the logEvent() method with one of the annotations defining the event in the application.
 * Marking the logEvent() method with one of the below annotations will cause it to become the so-called "advice", i.e. code executed in response to an event.
 * @@Before – The event occurs every time before the method is called. Requires specifying an argument that defines for which methods and which classes the event should be handled. Here, we define what is called a pointcut. Pointcuts are defined using AspectJ pointcut expressions. The basic structure of a pointcut expression is as follows:<br>
 * <pre>{@code
 *  <expression>([<method_scope>] <return_type> <qualified_class_name>.<method>(<parameters>))
 *  }
 *  </pre>
 * where:
 *  <ul>
 *  <li>{@code <expression>} – the type of event. We will use an event that specifies the execution of a method, which is written using the keyword execution,</li>
 *  <li>{@code <method_scope>} – the visibility modifier of the method. If we specify, for example, public, the event will be triggered when public methods are executed; this modifier can be omitted,</li>
 *  <li>{@code <return_type>} – the return type of the method for which events should be generated,</li>
 *  <li>{@code <qualified_class_name>} – the name of the class, including the package, for which the event should be generated,</li>
 *  <li>{@code <method>} – the name of the method for which events should be generated,</li>
 *  <li>{@code <parameters>} – the parameter types that the method accepts. We can use .. (two dots) to indicate that the event should be generated for any number of arguments of any type.</li>
 *  </ul>
 *  Example 1:<br>
 *  {@code execution(* *(..))}
 *  The event will be triggered for every method of every class.<br>
 *
 *  Example 2:<br>
 *  {@code execution(public * com.kodilla.myClass.myMethod(java.lang.String))}
 *  The event will be triggered for every public method named myMethod in the class myClass (regardless of the return type), accepting one argument of type String.<br>
 *
 *  Example 3:<br>
 *  {@code execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))}
 *  The event will be triggered for the factorial() method of the Calculator class.<br>
 * @@AfterReturning – The event occurs after the method returns a value and it has completed without an error.
 * @@AfterThrowing – An event occurring after the method throws an exception.
 * @@After – Always occurs after the method has completed execution, regardless of whether the execution was successful or threw an exception.
 * @@Around – A special event "surrounding" the method call.<br><br>
 *
 * Apart from {@code execution(...)} expression indicating the pointcut (which specifies the methods for which events are created for the aspect), it is possible to provide further expressions and combine them with the {@code &&} operator.
 * Use {@code args(...)} to pass the arguments used to call the method on which the aspect is attached to the specified variable (which is an argument of the aspect method).
 * Use {@code target(...)} to pass the object on which the method was called to the aspect.
 */
@Aspect // @Aspect tells Spring that this class contains advice (additional behavior you want to apply at certain join points).
@Component // Component Annotation: @Component registers the aspect as a Spring bean.
public class CalculatorWatcher {
    private static Logger LOGGER = LoggerFactory.getLogger(CalculatorWatcher.class);

    @Before(
            "execution(* com.kodilla.kodilla.good.patterns2.aop.calculator.Calculator.factorial(..))" +
            "&& args(number) && target(object)"
    )
    public void logEvent(int number, Object object) {
        LOGGER.info("Logging an event. Class: {}. Args: {}.", object.getClass().getName(), number);
    }

    @Around("execution(* com.kodilla.kodilla.good.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed(); // The proceedingJoinPoint argument represents a "handle" to the captured method. This object has a proceed() method that causes the captured method to run. The result of its call should be returned using return.
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed {} [ms]", end - begin);
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}


