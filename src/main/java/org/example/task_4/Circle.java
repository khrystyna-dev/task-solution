package org.example.task_4;

class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String print() {
        return "Shape: circle, area: " + String.format("%.1f", getArea())
                + ", radius: " + radius;
    }
}