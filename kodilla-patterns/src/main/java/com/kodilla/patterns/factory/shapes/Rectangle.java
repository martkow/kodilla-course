package com.kodilla.patterns.factory.shapes;

public final class Rectangle implements Shape {
    private final String name;
    private final double length;
    private final double width;

    public Rectangle(final String name, final double length, final double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
