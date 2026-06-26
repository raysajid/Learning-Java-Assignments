/*

Author: Rayyan Sajid
Date:25/06/2026

Assignment 5: Inheritance & Polymorphism

Objective: Learn code reusability (Inheritance) and method overriding/overloading (Polymorphism). [1, 2, 3]

Scenario: A Vehicle Fleet System

Create a base class named Vehicle.
Define a protected variable speed and a public method startEngine().
Create a subclass named Car that extends Vehicle.
Add a unique property like numberOfDoors.
Use method overriding by providing a specific implementation of startEngine() in the Car class.
Create another subclass named Motorcycle.
In your Main class, utilize method overloading by creating a drive() method that takes different parameters (e.g., drive(int speed) and drive(int speed, String weather)). [1, 2, 3, 4]
Create a Vehicle reference variable pointing to a Car object and invoke startEngine() to observe dynamic method dispatch at runtime. [1]
 */


class Vehicle2{
    protected int speed;
    Vehicle2(int s){
        this.speed = s;
    }

    //Parent startEngine()
    public void startEngine(){
        System.out.println("Generic engine start");
    }
}

class Car2 extends Vehicle2{
    private int numDoorsCar;
    Car2 (int s, int nDC){
        super(s);
        if (nDC < 1) {
            System.out.println("Error: Not enough doors!");
            return;
        }else{
            this.numDoorsCar = nDC;
        }
    }

    //Getter
    public int getNumDoorsCar(){
        return numDoorsCar;
    }

    //Setter
    public void setNumDoorsCar(int nNDC){
        if (nNDC < 1){
            System.out.println("Error: Not enough doors!");
            return;
        }else{
            this.numDoorsCar = nNDC;
        }
    }

    //Override parent startEngine()
    public void startEngine(){
        System.out.println("Your car has started!");
    }
}

class Motorcycle1 extends Vehicle2{
    private int numDoorMotorcycle;
    Motorcycle1(int s, int nDM){
        super(s);
        if (nDM > 0){
            System.out.println("Error: A motorcycle has no doors!");
            return;
        }else{
            this.numDoorMotorcycle = nDM;
        }
    }

    //Getter
    public int getNumDoorMotorcycle(){
        return numDoorMotorcycle;
    }

    //Setter
    public void setNumDoorMotorcycle(int nNDM){
        if (nNDM > 0){
            System.out.println("Error: A motorcycle has no doors!");
            return;
        }else{
            this.numDoorMotorcycle = nNDM;
        }
    }

    //Override parent startEngine()
    public void startEngine(){
        System.out.println("Your motorcycle has started!");
    }

}


public class VehicleFleetSystem {

    // Overloaded drive() — Requirement 4
    public static void drive(int speed) {
        System.out.println("Driving at " + speed + " km/h.");
    }

    public static void drive(int speed, String weather) {
        System.out.println("Driving at " + speed + " km/h in " + weather + " weather.");
    }

    public static void main(String[] args) {

        Vehicle2 myVehicle = new Car2(100, 4);
        myVehicle.startEngine();

        Vehicle2[] fleet = {
                new Car2(120, 4),
                new Motorcycle1(80, 0),
                new Car2(90, 2)
        };

        for (Vehicle2 v : fleet) {
            v.startEngine(); // Each calls its own version at runtime
        }

        drive(60);
        drive(40, "rainy");
    }
}
