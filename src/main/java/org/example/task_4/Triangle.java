package org.example.task_4;

class Triangle implements Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String print() {
        return "Shape: triangle, area: " + String.format("%.1f", getArea())
                + ", base: " + base
                + ", height: " + height;
    }
}
