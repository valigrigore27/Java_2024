package org.example;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import static org.example.Person.generatePeople;

public class Main {
    public static void main(String[] args) {
        int n = 20;
        List<Person> people = generatePeople(n);

        List<Driver> drivers = people.stream()
                .filter(person -> person.getAge() >= 25)
                .map(Driver::new)
                .toList();

        List<Passenger> passengers = people.stream()
                .filter(person -> person.getAge() < 25)
                .map(Passenger::new)
                .toList();

        LinkedList<Person> sortedDrivers = new LinkedList<>(drivers);
        sortedDrivers.sort(Comparator.comparingInt(Person::getAge));

        TreeSet<Person> sortedPassengers = new TreeSet<>(Comparator.comparing(Person::getName));
        sortedPassengers.addAll(passengers);

        System.out.println("Sorted Drivers:");
        sortedDrivers.forEach(System.out::println);

        System.out.println("\nSorted Passengers:");
        sortedPassengers.forEach(System.out::println);

    }
}