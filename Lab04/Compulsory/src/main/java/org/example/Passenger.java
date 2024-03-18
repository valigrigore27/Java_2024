package org.example;

public class Passenger extends Person{

public Passenger(Person person) {
    super(person.getName(), person.getAge(), person.getDestination());
}
}
