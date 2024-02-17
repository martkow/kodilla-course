package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String s, PoemDecorator poemDecorator) {
        System.out.println(poemDecorator.decorate(s));
    }
}
