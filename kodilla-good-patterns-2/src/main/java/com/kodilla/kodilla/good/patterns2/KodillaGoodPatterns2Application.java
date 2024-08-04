package com.kodilla.kodilla.good.patterns2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot starts scanning for beans and components from the package where the main application class, annotated with @SpringBootApplication, is located. It scans all subpackages from that point downward in the package hierarchy.
 */
@SpringBootApplication
public class KodillaGoodPatterns2Application {

    public static void main(String[] args) {
        SpringApplication.run(KodillaGoodPatterns2Application.class, args);
    }

}
