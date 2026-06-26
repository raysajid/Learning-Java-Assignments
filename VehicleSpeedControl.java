/*
Author: Rayyan Sajid
Date: 23/06/2026

Assignment 2: Vehicle Speed Control (Intermediate)

Goal: Practice adding unique fields to subclasses and mixing inherited behavior with overridden methods.

Instructions

Create a parent class named Vehicle.
Add fields: String brand and int speed.
Create a constructor to set these fields.
Create a method speedUp() that adds 10 to speed and prints the brand's new speed.
Create a subclass named Bicycle.
Add a unique field: boolean hasBell.
Create a constructor that initializes all three properties using super().
Override speedUp() because a bicycle accelerates slower. Only add 2 to speed when called.
Create a subclass named Car.
Add a unique field: int fuelLevel.
Create a constructor that initializes all three properties.
Override speedUp(). Add 20 to speed and decrease fuelLevel by 5.
In your main method:
Instatiate a Bicycle and a Car using a Vehicle reference type (e.g., Vehicle myCar = new Car(...);).
Call speedUp() on both to prove they act differently based on their actual object type.
 */

class Vehicle1{
    String brand;
    int speed;
    Vehicle1 (String b, int s){
        this.brand = b;
        this.speed = s;
    }

    void speedUp(String str) {
        speed = speed + 10;
        System.out.println(brand + "'s new speed: " + speed + " km/h" + str);
    }
}

class Bicycle extends Vehicle1{
    boolean hasBell;
    Bicycle(String b, int s, boolean hB){
        super(b, s);
        this.hasBell = hB;
    }
    void speedUp() {
        speed = speed + 2;
        System.out.println(brand + "'s new speed: " + speed + " km/h");
    }
}

class Car1 extends Vehicle1{
    int fuelLevel;
    Car1(String b, int i, int f){
        super(b, i);
        this.fuelLevel = f;
    }
    void speedUp() {
        speed = speed + 20;
        fuelLevel = fuelLevel - 5;
        System.out.println(brand + "'s new speed: " + speed + " km/h  |  Fuel remaining: " + fuelLevel + "L");
    }
}

public class VehicleSpeedControl {
    public static void main (String[] args){
        Bicycle myBicycle = new Bicycle("Trek", 10, true);
        Car1 myCar = new Car1("BYD", 200, 60);
        Vehicle1 myVehicle = new Vehicle1("Toyota", 100);
        myBicycle.speedUp();
        myCar.speedUp("Hello");
        myVehicle.speedUp("bye");
    }
}