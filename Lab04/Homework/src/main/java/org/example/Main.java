package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.Person.generatePeople;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        List<Person> people = generatePeople(n);

        VehicleSharingProblem vehicleSharingProblem = new VehicleSharingProblem(people);
        List<Person> sortedDriversByDistance = new ArrayList<>();
        sortedDriversByDistance = vehicleSharingProblem.sortedDriversByDistance();
        List<Person> sortedPassengersByDistance = new ArrayList<>();
        sortedPassengersByDistance = vehicleSharingProblem.sortedPassengersByDistance();

        System.out.println("Sorted Drivers:");
        sortedDriversByDistance.forEach(System.out::println);

        System.out.println("\nSorted Passengers:");
        sortedPassengersByDistance.forEach(System.out::println);

        System.out.println();
        vehicleSharingProblem.matchDriversWithPassengers();

        ////////////////////////////////////////////////////////////

        List<Destination> destinations = people.stream()
                .map(Person::getDestination)
                .toList();
        System.out.println();
        System.out.println("All the destinations:");
        for (Destination destination : destinations)
            System.out.println(destination);
        System.out.println();

        Map<Destination, List<String>> destinationMap = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getDestination,
                        Collectors.mapping(Person::getName, Collectors.toList())
                ));


        System.out.println("Map of destinations and people who want to go there:");
        destinationMap.forEach((destination, persons) -> {
            System.out.println("\n" + destination);
            persons.forEach(System.out::println);
        });
    }
}