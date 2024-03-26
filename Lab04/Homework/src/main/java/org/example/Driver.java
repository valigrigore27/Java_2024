package org.example;

public class Driver extends Person{

public Driver(Person person) {
    super(person.getAge(), person.getDestination());
}
}
