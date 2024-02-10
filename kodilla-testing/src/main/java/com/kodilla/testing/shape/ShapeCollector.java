package com.kodilla.testing.shape;

import java.util.List;
import java.util.ArrayList;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        while (shapes.contains(shape)) {
           shapes.remove(shape);
        }
    }

    public Shape getShape(int shapeIndex) {
        if (shapeIndex >= 0 && shapeIndex < shapes.size()) {
            return shapes.get(shapeIndex);
        }
        return null;
    }

    public String showShapes() {
        String s = "[";
        if (!shapes.isEmpty()) {
            s = s + shapes.get(0).getShapeName();
            for (int i = 1; i < shapes.size(); i++) {
                s = s + ", " + shapes.get(i).getShapeName();
            }
        }
        s = s + "]";
        return s;
    }
}
