package org.example;

public class Driver extends Person{

public Driver(Person person) {
    super(person.getName(), person.getAge(), person.getDestination());
}
}
