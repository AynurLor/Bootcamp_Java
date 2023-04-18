package classes;

public class Car {
    private Integer fuelCapacity;
    private Integer expense;
    private String model;

    public Car() {
    }

    public Car(Integer fuelCapacity, Integer expense, String model) {
        this.fuelCapacity = fuelCapacity;
        this.expense = expense;
        this.model = model;
    }

    public int refuel() {
        System.out.println(this.fuelCapacity);
        return this.fuelCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", fuelCapacity=" + fuelCapacity +
                ", model='" + model + '\'' +
                '}';
    }
}
