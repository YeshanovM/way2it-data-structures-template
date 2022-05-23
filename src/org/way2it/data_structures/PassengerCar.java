package org.way2it.data_structures;

public class PassengerCar extends Car {

    public PassengerCar() {
    }

    public PassengerCar(int wheelsCount, int load, int wight) {
        super(wheelsCount, load, wight);
    }

    @Override
    public void ride() {
        System.out.println("PassengerCar");
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "wheelsCount=" + wheelsCount +
                ", load=" + load +
                ", weight=" + weight +
                '}';
    }
}
