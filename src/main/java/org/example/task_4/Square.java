package org.example.task_4;

class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String print() {
        return "Shape: square, area: " + String.format("%.1f", getArea())
                + ", side: " + side;
    }
}