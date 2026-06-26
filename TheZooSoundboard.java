/*
Author: Rayyan Sajid
Date: 23/06/2026

Assignment 1: The Zoo Soundboard (Basic)

Goal: Learn how to create a basic parent class, extend it to child classes, and use method overriding.

Instructions

Create a superclass named Animal.
Add a private string field name.
Create a constructor to initialize the name.
Create a method named makeSound() that prints "Some generic animal sound".
Create a subclass named Dog that extends Animal.
Use the super keyword in its constructor to pass the name up to the parent.
Override the makeSound() method to print "Woof! Woof!".
Create a subclass named Cat that extends Animal.
Use super in the constructor.
Override the makeSound() method to print "Meow!".
Create a Main class with a main method.
Create an array of type Animal[] containing one Dog and one Cat.
Loop through the array and call makeSound() on each object to watch runtime polymorphism in action.

 */
class Animal {
    private String name;
    public Animal(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void makeSound(){
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void makeSound(){
        System.out.println("Woof Woof");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void makeSound(){
        System.out.println("Meow");
    }
}

public class TheZooSoundboard{
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog ("Dog"),
                new Cat ("Cat")
        };
        for (Animal animal:animals){
            System.out.print(animal.getName() + " says: ");
            animal.makeSound();

        }
    }
}
