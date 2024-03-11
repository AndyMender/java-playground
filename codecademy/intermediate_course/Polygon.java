package codecademy.intermediate_course;

interface Polygon<T> {
    // NOTE: By default it's going to be marked as 'public static final'
    //       and can't be changed in implementing classes
    String polygonVersion = "0.0.1";

    // NOTE: This looks doable in theory, but numerical operations on generics require type checks, casting, etc.
    public T getArea();

    public T getCircumference();
}
