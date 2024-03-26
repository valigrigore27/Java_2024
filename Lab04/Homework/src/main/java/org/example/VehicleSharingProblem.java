package org.example;

import java.util.*;

import static java.lang.Math.abs;

public class VehicleSharingProblem {
    private List<Driver> drivers;
    private List<Passenger> passengers;


    public VehicleSharingProblem(List<Person> people) {
        this.drivers = new ArrayList<>();
        this.passengers = new ArrayList<>();

         drivers = people.stream()
                .filter(person -> person.getAge() >= 25)
                .map(Driver::new)
                .toList();

         passengers = people.stream()
                .filter(person -> person.getAge() < 25)
                .map(Passenger::new)
                .toList();
    }
    public List<Person> sortedDriversByDistance(){
        List<Person> sortedDrivers = new ArrayList<>(getDrivers());
        sortedDrivers.sort(Comparator.comparingInt(person -> ((Driver) person).getDestination().getDistance()).reversed());
        return sortedDrivers;
    }
    public List<Person> sortedPassengersByDistance(){
        List<Person> sortedPassengers = new ArrayList<>(getPassengers());
        sortedPassengers.sort(Comparator.comparingInt(person -> ((Passenger) person).getDestination().getDistance()).reversed());
        return sortedPassengers;
}
    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void matchDriversWithPassengers() {
        for (Person driver : sortedDriversByDistance()) {
            if (driver.isFree()) {
                for (Person passenger : sortedPassengersByDistance()) {
                    if (passenger.isFree() && driver.getDestination().getDistance() >= passenger.getDestination().getDistance()) {
                        System.out.println("Driver: " + driver.getName() + " matched with Passenger: " + passenger.getName());
                        driver.setFree(false);
                        passenger.setFree(false);
                        break;
                    }
                }
            }
        }
    }

}
