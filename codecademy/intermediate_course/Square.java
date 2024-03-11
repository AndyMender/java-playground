package codecademy.intermediate_course;

// Generics accept only reference types, but thanks to autoboxing/unboxing, primitives can be handled as well
public class Square implements Polygon<Double> {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public Double getLength() {
        return this.length;
    }

    public Double getArea() {
        return this.getLength() * this.getLength();
    }

    // NOTE: Double -> double auto-unboxing works as intended
    public Double getCircumference() {
        return 4 * this.getLength();
    }

    public String toString() {
        return String.format(
            "length: %.2f, area: %.2f, circumference: %.2f",
            this.getLength(),
            this.getArea(),
            this.getCircumference()
        );
    }

    public static void main(String[] args) {
        Square square = new Square(4.5);
        System.out.println(square);
    }
}
