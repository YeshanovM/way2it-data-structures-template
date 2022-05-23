package org.way2it.data_structures;

public class Car {
    int wheelsCount;
    int load;
    int weight;

    public Car() {
    }

    public Car(int wheelsCount, int load, int weight) {
        this.wheelsCount = wheelsCount;
        this.load = load;
        this.weight = weight;
    }

    public void ride() {
        System.out.println("Base car");
    }

    public void ride(String model) {
        System.out.println("Base car: " + model);
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheelsCount=" + wheelsCount +
                ", load=" + load +
                ", wight=" + weight +
                '}';
    }
}
