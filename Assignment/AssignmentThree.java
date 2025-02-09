
//This program does not violate any of the SOLID principle
//1) SRP
//2) OCP
//3) LSP
//4) ISP
//5) DIP

import java.util.Scanner;

public class AssignmentThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	
        System.out.print("How much do you want to pay : ");
        int n = sc.nextInt();		//Asking the amount to be paid

        User u = new User(n);  
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        for (int i = 0; i < 3; i++) {
            System.out.println("Choose your transaction method : \n1) Credit Card \n2) PayPal \n3) Google Pay");
            System.out.print("-> ");
	    int input = sc.nextInt();		//Choosing the method to pay the amount
            
            PaymentMethod paymentMethod = paymentProcessor.getPaymentMethod(input); 	//Taking one of the method as input
            
            if (paymentMethod != null) {
                paymentMethod.processPayment(u);  	//Calling the method which is taken as input
            } else {
                System.out.println("Sorry. This method is currently unavailable in our system. Try again...");
            }
        }
    }
}

class User {		//Creating a diff class to maintain the vars (Follows SRP)
    int money;

    User(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}

interface PaymentMethod {	//Interface is designed properly thus follows ISP principle
    void processPayment(User u);
}

class PaymentProcessor {	//Everytime the input will be taken from this class
    public PaymentMethod getPaymentMethod(int choice) {
        switch (choice) {
            case 1:
                return new CreditCard();
            case 2:
                return new PayPal();
            case 3:
                return new GPay();
            default:
                return null;
        }
    }
}

abstract class AbstractPaymentMethod implements PaymentMethod { 	//Uses PaymentMethod (Follows OCP & LSP)
    public void processPayment(User u) {
        try {
            Thread.sleep(3000); // Delay for 3 seconds (3000 milliseconds)(Additional)
        } catch (InterruptedException e) {
            e.printStackTrace(); // This statement is to handle the exception (Additional)
        }
        System.out.println("♦ You have successfully deposited " + u.getMoney() + " ♦");
	System.out.println();
    }
}

//ALL THE CLASSES BELOW FOLLOW THE 'DIP' PRINCIPLE

class CreditCard extends AbstractPaymentMethod {	//Can use the abstract class which implements the interface
    @Override
    public void processPayment(User u) {
        System.out.println("Your transaction through Credit Card is under process...");
        super.processPayment(u);
    }
}

class PayPal extends AbstractPaymentMethod {	 //Can use the abstract class which implements the interface
    @Override
    public void processPayment(User u) {
        System.out.println("Your transaction through PayPal is under process...");
        super.processPayment(u);
    }
}

class GPay extends AbstractPaymentMethod {	 //Can use the abstract class which implements the interface
    @Override
    public void processPayment(User u) {
        System.out.println("Your transaction through GPay is under process...");
        super.processPayment(u);
    }
}
