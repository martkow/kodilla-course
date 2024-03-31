package com.kodilla.spring.intro.shape;

public class Drawer {
    final Shape shape;

    /**
     * --------------- Dependency Injection (DI) by the constructor (or Inversion of Control) ---------------
     * <p>
     * The class does not manage its dependencies itself (the creation of objects on which it depends, here Shape), but they are provided to the class by an external class, here by the constructor.
     * Thanks to DI, it is possible to practically implement one of the pillars of object-oriented programming - class isolation.
     */
    public Drawer(Shape shape) {
        this.shape = shape;
    }

    public String doDrawing() {
        return shape.draw();
    }
}
