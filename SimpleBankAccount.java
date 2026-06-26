/*

Author: Rayyan Sajid
Date: 24/06/2026

Assignment 4: Encapsulation & Access Modifiers

Objective: Learn data hiding and controlled access using private, public, constructors, and getters/setters. [1, 2, 3]

Scenario: A Simple Bank Account

Create a BankAccount class with the following private variables: accountNumber, accountHolderName, and balance.
Provide a constructor to initialize the account details. Ensure that the initial balance cannot be negative (set it to 0 if an invalid value is passed).
Create public getter and setter methods to access and modify the data. In your setter for balance, add a simple rule: you cannot set a negative balance.
Create a main method, instantiate a bank account, and try accessing the private variables directly to observe the compiler errors. Then, use the getter/setter methods to update the balance safely. [1, 2]

 */

class BankAccount {
    private int accNum;
    private String accName;
    private double accBal;

    BankAccount(int num, String name, double bal) {
        this.accNum = num;
        this.accName = name;
        if (bal < 0) {
            System.out.println("Error");
            this.accBal = 0.0;
        } else {
            this.accBal = bal;
        }
    }

    //Getter Methods (I don't know of these will work)
    public int getAccNum() {
        return accNum;
    }
    public String getAccName() {
        return accName;
    }
    public double getAccBal() {
        return accBal;
    }

    //Setter Methods (I don't know of these will work)
    public void setAccNum(int num) {
        this.accNum = num;
    }

    public void setAccName(String name) {
        this.accName = name;
    }

    public void setAccBal(double bal) {
        if (bal < 0) {
            System.out.println("Error");
        }else{
            this.accBal = bal;
        }

    }

    //Functionality for deposit, got some help on this
    public void deposit(double money){
        if (money <= 0){
            System.out.println("Deposit must be positive!");
            return;
        }else{
            accBal = accBal + money;
        }
    }
    //Functionality for withdrawal, got some help on this
    public void withdraw(double money){
        if (money <= 0 ){
            System.out.println("Withdrawal must be positive!");
            return;
        }else if (money > accBal){
            System.out.println("Withdrawal is greater than balance");
            return;
        }else{
            accBal = accBal - money;
        }
    }


}

public class SimpleBankAccount {
    public static void main (String[] args){
        BankAccount myAcc = new BankAccount(102938, "Rayyan Sajid", 1056.76);

        System.out.println(myAcc.getAccNum());
        System.out.println(myAcc.getAccName());
        System.out.println(myAcc.getAccBal());
        myAcc.setAccBal(100.0);
        System.out.println(myAcc.getAccBal());
    }
}
