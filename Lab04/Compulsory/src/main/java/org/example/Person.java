package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {
    private Destination destination;
    private String name;
    private Integer age;
    public Person(String name, Integer age, Destination destination) {
        this.destination = destination;
        this.name = name;
        this.age = age;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public static List<Person> generatePeople(int numPeople) {
        List<Person> people = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numPeople; i++) {
            String name = "Person " + i;
            int age = random.nextInt(55) + 5;
            int distance = random.nextInt(900) + 100;
            boolean hasLicense = random.nextBoolean();
            Destination destination = new Destination(distance);
            people.add(new Person(name, age, destination));
        }
        return people;
    }

    @Override
    public String toString() {
        return "Person{" +
                "destination=" + destination +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
