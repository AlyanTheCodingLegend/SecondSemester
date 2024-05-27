class CircleWithException {
    private double radius;
    private static int numberOfObjects = 0;

    public CircleWithException() {
        this(1.0);
    }

    public CircleWithException(double newRadius) {
        setRadius(newRadius);
        numberOfObjects++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        if (newRadius <= 0) {
            throw new IllegalArgumentException("Radius must be a positive number.");
        }
        radius = newRadius;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double findArea() {
        return radius * radius * 3.14159;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            CircleWithException c1 = new CircleWithException(5);
            System.out.println("Number of objects created: " +
                    CircleWithException.getNumberOfObjects());
            System.out.println("Area of c1: " + c1.findArea());

            // Trying to create a circle with negative radius
            CircleWithException c2 = new CircleWithException(-2); // This should throw an exception
            System.out.println("Area of c2: " + c2.findArea());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
