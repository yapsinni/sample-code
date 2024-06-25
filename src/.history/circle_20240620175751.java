// Abstract class Shape
abstract class Shape {
    // Abstract methods
    abstract void draw();        // Abstract method 1
    abstract void calculateArea(); // Abstract method 2

    // Concrete method
    void display() {
        System.out.println("Displaying shape.");
    }
}

// Abstract subclass (Child class)
abstract class TwoDimensionalShape extends Shape {
    // Only implementing one abstract method
    abstract void calculateArea(); // Remaining abstract method
}

// Concrete subclass extending TwoDimensionalShape
class Circle extends TwoDimensionalShape {
    // Implementing draw method
    void draw() {
        System.out.println("Drawing Circle.");
    }

    // Implementing calculateArea method
    void calculateArea() {
        System.out.println("Calculating area of Circle.");
    }
}

public class Circle {
    public static void main(String[] args) {
        // Creating an object of concrete subclass Circle
        Circle circle = new Circle();

        // Calling methods
        circle.draw();            // Outputs: Drawing Circle.
        circle.calculateArea();   // Outputs: Calculating area of Circle.
    }
}
