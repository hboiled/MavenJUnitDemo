package hb;

/**
 * Hello world!
 *
 */
public class MathUtils 
{
    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public double squareNumber(double x) {
        return x * x;
    }

    public double calcCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calcHypotenuse(double base, double perp) {
        return Math.sqrt(squareNumber(base) + squareNumber(perp));
    }

    public int divide(int x, int y) {
        return x / y;
    }
}
