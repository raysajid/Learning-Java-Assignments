/*

Author: Rayyan Sajid
Date: 24/06/2026

Assignment 3: Employee Payroll System (Practical Application)

Goal: Apply OOP principles to a simplified real-world scenario by calculating different payment strategies using polymorphism.

Instructions

Create a base class named Employee.
Add fields: String name and int id.
Create a constructor to set these fields.
Create a method calculateSalary() that returns 0.0.
Create a subclass named FullTimeEmployee.
Add a field: double monthlySalary.
Create a constructor matching the fields.
Override calculateSalary() to return the flat monthlySalary.
Create a subclass named PartTimeEmployee.
Add fields: double hourlyRate and int hoursWorked.
Create a constructor matching the fields.
Override calculateSalary() to return hourlyRate * hoursWorked.
In your main method:
Create an ArrayList<Employee> to manage your workforce.
Add two FullTimeEmployee objects and two PartTimeEmployee objects to the list.
Loop through the list to print out each employee's name, ID, and calculated salary using the common calculateSalary() method format.
 */
import java.util.ArrayList;

class Employee {
    String name;
    int id;

    Employee(String n, int i) {
        this.name = n;
        this.id = i;
    }

    double calculateSalary() {
        return 0.0;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}
class FullTimeEmployee extends Employee{
    double monthlySalary;
    FullTimeEmployee(String n, int i, double mS){
        super(n, i);
        this.monthlySalary = mS;
        System.out.println(n + "'s ID is " + i + ", has a monthly salary of $" + monthlySalary );
    }

    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    double hourlyRate;
    int hoursWorked;
    PartTimeEmployee(String n, int i, double hR, int hW){
        super(n, i);
        this.hourlyRate = hR;
        this.hoursWorked = hW;
        System.out.println(n + "'s ID is " + i + ", has an hourly rate of $" + hourlyRate + " and works " + hoursWorked + " hours per day");
    }

    double calculateSalary() {
        //return super.calculateSalary();
        return hourlyRate * hoursWorked;

    }
}

public class EmployeePayrollStatement {
    public static void main (String[] args) {
        FullTimeEmployee john = new FullTimeEmployee("John", 101, 2000);
        PartTimeEmployee sally = new PartTimeEmployee("Sally", 201, 25.00, 4);
        ArrayList<Employee>myEmployees = new ArrayList<Employee>();
            myEmployees.add(john);
            myEmployees.add(sally);
            for (Employee print : myEmployees) {
                System.out.println(print);
            }
        }
        /*
        //Could also use this instead of array list

        Employee[] employees = {
                new FullTimeEmployee("John", 101, 15000),
                new PartTimeEmployee("Sally", 201, 25.00, 4)
        };

        for (Employee item : employees) {
            if (item.getClass().getName() == "FullTimeEmployee"){
            // Instead of .getClass().getName()
            //I could also use instanceof as this would compare classes


            }
            System.out.println(item.getClass());
            System.out.println(item.name);
        }*/
}
