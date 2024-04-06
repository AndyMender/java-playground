package baeldung.code_samples;

import java.lang.Thread;

public class EnumDemo {
    private PizzaStatus pizzaStatus = PizzaStatus.EATEN;   
    private long timeNow;
    private int pizzaOrderTime = 10 * 1000;

    public EnumDemo() {
        this.timeNow = System.currentTimeMillis();
    }

    public enum PizzaStatus {
        ORDERED,
        READY,
        EATEN;
    }      

    public PizzaStatus getStatus() {
        return pizzaStatus;
    }

    public void setStatus(PizzaStatus status) {
        this.pizzaStatus = status;
    }

    public boolean checkPizzaOrder() {
        long currTime = System.currentTimeMillis();

        if (getStatus() != PizzaStatus.ORDERED) {
            System.out.println("No pizza order in progress.");
            return false;
        }

        if ((currTime - timeNow) < pizzaOrderTime) {
            System.out.println("Pizza order still in progress. Please wait!");
            return false;
        }

        System.out.println("Pizza order complete!");

        setStatus(PizzaStatus.READY);
        return true;
    }

    public boolean eatPizza() {
        // NOTE: Direct comparisons against the 'enum' are fine, because there is only 1 instance of it
        if (getStatus() != PizzaStatus.READY) {
            System.out.println("No pizza ready yet!");
            return false;
        }

        setStatus(PizzaStatus.EATEN);
        System.out.println("Ate all of the pizza!");
        return true;
    }

    public boolean orderPizza() {
        boolean ordered = false;
        switch (getStatus())  {
            case PizzaStatus.ORDERED:
                System.out.println("A pizza was already ordered. Not ordering again!");
                ordered = true;
                break;

            case PizzaStatus.READY:
                System.out.println("A pizza is already here. Check your doorstep ;).");
                ordered = false;
                break;

            case PizzaStatus.EATEN:
                System.out.println("No pizzas left :(. Ordering a new one right away!");
                setStatus(PizzaStatus.ORDERED);
                ordered = true;
                break;
            default:
                System.out.println("Hmmm... looks like the pizza is lost somewhere. Status unclear. Can't order :(.");
                ordered = false;
        }
        return ordered;
    }

    public static void main(String[] args) throws InterruptedException {
        EnumDemo pizza = new EnumDemo();       
        boolean ready = false;

        if(!pizza.eatPizza()) {
            pizza.orderPizza();
        }
        while (!ready) {
            ready = pizza.checkPizzaOrder();
            Thread.sleep(2000);
        }
        pizza.eatPizza();

    }
}
