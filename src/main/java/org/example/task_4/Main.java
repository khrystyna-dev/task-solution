package org.example.task_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double side = 3;
        double radius = 1;
        double base = 5;
        double height = 2;
        double width = 1;

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(side));
        shapes.add(new Rectangle(width, height));
        shapes.add(new Triangle(base, height));
        shapes.add(new Circle(radius));

        // Sort the shapes based on their areas in ascending order
        shapes.sort(Comparator.comparingDouble(Shape::getArea));

        // Print the sorted shapes
        for (Shape shape : shapes) {
            System.out.println(shape.print());
        }
    }
}
