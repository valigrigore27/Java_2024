package org.example;

public class Passenger extends Person{

public Passenger(Person person) {
    super(person.getAge(), person.getDestination());
}
}
