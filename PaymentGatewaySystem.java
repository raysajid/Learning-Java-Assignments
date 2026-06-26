/*

Author: Rayyan Sajid
Date: 26/06/2026

Assignment 6: Abstraction

Objective: Hide complex implementation details and define standard contracts using abstract classes and interfaces. [1, 2, 3]

Scenario: Payment Gateway System

Create an abstract class named PaymentMethod that contains:
A non-abstract method processReceipt() that prints a general payment receipt.
An abstract method initiatePayment(double amount). [1]
Create an interface named Refundable with a method issueRefund(double amount).
Create two concrete classes, CreditCard and PayPal, both extending PaymentMethod and implementing Refundable.
Write the specific logic for initiatePayment and issueRefund inside both classes. [1]
In your main method, create instances of both CreditCard and PayPal. Call their respective methods to see abstraction in action—you only need to know what the methods do, not how they are implemented under the hood. [1, 2]
 */

abstract class PayMethod{
    public void processReceipt(){
        System.out.println("General receipt");
    }
    public abstract void initiatePayment(double amt);
}

interface Refundable {
    public void issueRefund(double amt);
}

class CreditCard extends PayMethod implements Refundable{
    private double creditCardBalance;
    private boolean itemReturned = false;
    private boolean refundIssued = false;
    CreditCard(double amt){
        if (amt < 0){
            throw new IllegalArgumentException("Error: Initial balance must be positive!");
        }
        this.creditCardBalance = amt;

    }

    //Getter
    public double getCreditCardBalance(){
        return creditCardBalance;
    }

    public boolean getItemReturned(){
        return itemReturned;
    }

    public void returnItem(){
        if (itemReturned){
            System.out.println("Item has already been returned");
        }else{
            this.itemReturned = true;
            System.out.println("Item return processed");
        }
    }

    public void initiatePayment(double amt){
        if (amt < 0){
            System.out.println("Error: Amount must be positive!");
            return;
        }else if(amt > creditCardBalance){
            System.out.println("Insufficient funds!");
            return;
        }else{
            creditCardBalance = creditCardBalance - amt;
            System.out.println("Item purchase successful!");
        }
    }

    public void issueRefund(double amt){
        if (!itemReturned) {
            System.out.println("Error: Item has not been returned yet!");
            return;
        }else if (refundIssued) {
            System.out.println("Item has already been refunded!");
            return;
        }else{
            creditCardBalance = creditCardBalance + amt;
            refundIssued = true;
            System.out.println("Refund has been issued");
        }
    }

}

class PayPal extends PayMethod implements Refundable {
    private double payPalBalance;
    private String accountEmail;
    private boolean itemReturned = false;
    private boolean refundIssued = false;

    PayPal(String email, double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Error: Initial balance must be positive!");
        }
        this.accountEmail = email;
        this.payPalBalance = amt;
    }

    public double getPayPalBalance() {
        return payPalBalance;
    }

    public void returnItem() {
        if (itemReturned) {
            System.out.println("Item has already been returned.");
        } else {
            this.itemReturned = true;
            System.out.println("Item return registered.");
        }
    }

    public void initiatePayment(double amt) {
        if (amt < 0) {
            System.out.println("Error: Amount must be positive!");
            return;
        } else if (amt > payPalBalance) {
            System.out.println("Insufficient PayPal funds!");
            return;
        } else {
            payPalBalance -= amt;
            System.out.println("PayPal payment of $" + amt + " sent via account: " + accountEmail + ". Remaining balance: $" + payPalBalance);
        }
    }

    public void issueRefund(double amt) {
        if (!itemReturned) {
            System.out.println("Error: Item has not been returned yet!");
            return;
        }
        if (refundIssued) {
            System.out.println("Error: Refund has already been issued for this item!");
            return;
        }
        payPalBalance += amt;
        refundIssued = true;
        System.out.println("PayPal refund of $" + amt + " sent instantly to " + accountEmail + ". New balance: $" + payPalBalance);
    }
}

public class PaymentGatewaySystem {
    public static void main(String[] args){

        System.out.println("|Credit Card|");
        PayMethod myCard = new CreditCard(15430.20);
        myCard.processReceipt();
        myCard.initiatePayment(200.00);
        myCard.initiatePayment(20000.00);   // insufficient funds
        ((CreditCard) myCard).returnItem();
        ((CreditCard) myCard).issueRefund(200.00);
        ((CreditCard) myCard).issueRefund(200.00);  // duplicate refund attempt
        System.out.println("Final balance: $" + ((CreditCard) myCard).getCreditCardBalance());

        System.out.println();

        System.out.println("|PayPal|");
        PayMethod myPayPal = new PayPal("rayyan@email.com", 850.20);
        myPayPal.processReceipt();
        myPayPal.initiatePayment(150.00);
        myPayPal.initiatePayment(1000.00);  // insufficient funds
        ((PayPal) myPayPal).returnItem();
        ((PayPal) myPayPal).issueRefund(150.00);
        ((PayPal) myPayPal).issueRefund(150.00);    // duplicate refund attempt
        System.out.println("Final balance: $" + ((PayPal) myPayPal).getPayPalBalance());
    }

}

