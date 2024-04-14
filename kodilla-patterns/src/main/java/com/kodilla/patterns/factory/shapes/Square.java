package com.kodilla.patterns.factory.shapes;

public final class Square implements Shape {
    private final String name;
    private final double side;

    public Square(final String name, final double side) {
        this.name = name;
        this.side = side;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2.0);
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
