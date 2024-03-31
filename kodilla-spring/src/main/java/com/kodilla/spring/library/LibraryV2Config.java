package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryV2Config {
    @Bean
    public LibraryV2 libraryV2() {
        return new LibraryV2(libraryV2DbController());
    }

    @Bean
    public LibraryV2DbController libraryV2DbController() {
        return new LibraryV2DbController();
    }
}
