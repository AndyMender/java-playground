package codecademy.intermediate_course;

public class Bus<T extends SchoolPerson> {
    private T passenger;

    public Bus(T passenger) {
        this.passenger = passenger;
    }

    public void setPassenger(T passenger) {
        this.passenger = passenger;
    }

    public T getPassenger() {
        return this.passenger;
    }

    public void printPassenger() {
        System.out.println(passenger.toString());
    } 
}
