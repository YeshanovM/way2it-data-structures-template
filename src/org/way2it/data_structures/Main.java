package org.way2it.data_structures;

public class Main {

    public static void main(String[] args) {
        Car car = new PassengerCar(4, 600, 1500);
        String carString = car.toString();
        System.out.println(carString);
    }
}
