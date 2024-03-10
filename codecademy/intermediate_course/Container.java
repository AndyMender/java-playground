package codecademy.intermediate_course;

// NOTE: 'T' can be any REFERENCE type - primitive types need to be boxed
//       For instance, 'int' to 'Integer', 'char' to 'Character', etc.
public class Container<T> {
    private T data;

    public Container(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
