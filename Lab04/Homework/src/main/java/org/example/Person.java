package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {
    private Destination destination;
    private String name;
    private Integer age;
    private boolean free;

    public Person(Integer age, Destination destination) {
        this.destination = destination;
        Faker faker = new Faker();
        this.name = faker.name().fullName();
        this.age = age;
        this.free = true;
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

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = false;
    }

    public static List<Person> generatePeople(int numPeople) {
        List<Person> people = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numPeople; i++) {
            int age = random.nextInt(55) + 5;
            int distance = random.nextInt(900) + 100;
            boolean hasLicense = random.nextBoolean();
            Destination destination = new Destination(distance);
            people.add(new Person(age, destination));
        }
        return people;
    }

    @Override
    public String toString() {
        return "Person{" +
                "destination=" + destination +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", free=" + free +
                '}';
    }
}
