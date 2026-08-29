/**
 * Shape Areas — demonstrates concrete classes for different shapes.
 * Each shape class computes and prints its own area.
 */
class Triangle {

    /** Computes and prints the area of a triangle: (1/2) * base * height */
    public void area(int base, int height) {
        System.out.println("Area of triangle: " + (0.5 * base * height));
    }
}

class Circle {

    /** Computes and prints the area of a circle: π * r² (using π ≈ 3.14) */
    public void area(int radius) {
        System.out.println("Area of circle: " + (3.14 * radius * radius));
    }
}

public class ShapeAreas {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        int base = 6, height = 3, radius = 2;

        triangle.area(base, height);
        circle.area(radius);
    }
}
