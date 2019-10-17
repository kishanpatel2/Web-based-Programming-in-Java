/*
Author: Kishan Patel
E-mail: kpp5282@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 2
Due date: 2/14/2019
File: main.java
Purpose: Java application that implements an online specialty pizzashop
Compiler/IDE: IntelliJ IDEA
Operating system: Macbook Pro
Reference(s): Java 8 API - Oracle Documentation
https://www.mkyong.com/java/java-display-double-in-2-decimal-points/
https://www.quora.com/How-do-I-truncate-float-up-to-two-decimal-points-in-Java
//https://stackoverflow.com/questions/12524243/how-do-i-make-java-register-a-string-input-with-spaces/12524285
//Page 63 of book
*/

//empty string means program has to ended.
package specialtyPizzaMenu;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static ArrayList<OrderItem> items = new ArrayList<OrderItem>();
    static Scanner scan = new Scanner(System.in);
    static float total;
    static int count = 0;

    public static void main(String[] args) {
        System.out.println("****************************************************************************************************");
        System.out.println("\nWelcome to Kishan's Pizza of Piscataway!");
        System.out.println("\n**************************************************************************************************");
        boolean tf = true;
        while (tf != false) {
            Display_Pizza_Menu();
            tf = takeOrder();
            if (tf == true) {
                count++;
            }
        }
        // System.exit(6);
        if(count > 0) {
            OrderSum();
            payment();
        }
        System.out.println("\nThank you for using Kishan's Pizza of Piscataway online ordering system. Visit again soon!\n");
        System.out.println("**************************************************************************************************");
    }

    public static void Display_Pizza_Menu() {
        System.out.println("\nSpeciality Pizza Menu");
        System.out.println("1) Meat Lovers");
        System.out.println("2) Vegetarian");
        System.out.println("3) Hawaiian");
        System.out.println("4) Mozzarella");
        System.out.println("5) BBQ Chicken");
        System.out.println("6) Exit Menu");
    }

    public static void OrderSum() {
        System.out.println("\n**************************************************************************************************\n");
        System.out.println("Order Summary: ");
        System.out.println("Type               " + "" + "Size      " + "" + "Quantity         " + "" + "Price");
        System.out.println("----------------------------------------------------------------------------------");
        for (int x = 0; x < items.size(); x++) {
            System.out.println(items.get(x));
        }
        System.out.printf("\nOrder Total: $" + "%.2f%n", total);
        System.out.print("\n");
        //System.out.println("\nOrder Total: $" +  total + "\n");
        System.out.println("**************************************************************************************************");
    }

    public static void calcPrice(int num, double price) {
        total += num * price;

        System.out.printf("\nYour current total is $ " + "%.2f%n", total);
        //System.out.format( "%.2f%n", total);
        System.out.println("\n**************************************************************************************************");
    }


    public static int getQuantity(int size, String type) {
        System.out.println("\n**************************************************************************************************");
        System.out.println("\nHow many " + size + " " + "inch pizzas would you like?");
        int num = scan.nextInt();
        while ((num >= 1) != true) {
            System.out.println("Please enter number greater than or equal to 1");
            num = scan.nextInt();
        }
        System.out.println("\n**************************************************************************************************");
        return num;

    }

    public static String getType(int input) {
        while ((input >= 1 && input <= 6) != true) {
            System.out.println("\n**************************************************************************************************\n");
            System.out.println("Invalid choice! Choose again 1-6.");
            input = scan.nextInt();
            System.out.println("\n**************************************************************************************************");
        }
        String type;
        if (input == 1)
            return type = "Meat Lover";
        else if (input == 2)
            return type = "Vegetarian";
        else if (input == 3)
            return type = "Hawaiian";
        else if (input == 4)
            return type = "Mozzarella";
        else if (input == 5)
            return type = "BBQ Chicken";
        return type = "";
//empty string means program has to ended.
    }

    public static double getPrice(int size) {
        if (size == 10)
            return 12.15;
        else if (size == 14)
            return 16.25;
        else if (size == 16)
            return 20.35;
        else if (size == 18)
            return 24.45;
        return 0;
    }

    public static int getSize(int input) {
        while ((input >= 1 && input <= 4) != true) {
            System.out.println("\n**************************************************************************************************\n");
            System.out.println("Invalid choice! Choose again 1-4.");
            input = scan.nextInt();
            System.out.println("\n**************************************************************************************************");
        }
        int size;
        if (input == 1)
            return size = 10;
            // System.out.println("Personal Pizza");
        else if (input == 2)
            return size = 14;
            //System.out.println("Medium Pizza");
        else if (input == 3)
            //System.out.println("Large Pizza");
            return size = 16;

        return size = 18;
    }

    public static boolean takeOrder() {
        System.out.println("Choose 1-6.");
        int input = scan.nextInt();
        String type = getType(input);
        if (type == "")
            return false;
        System.out.println("\n**************************************************************************************************");
        System.out.println("\nAvailable Sizes and Prices");
        System.out.println("1) 10\" Personal    - $12.15");
        System.out.println("2) 14\" Medium      - $16.25");
        System.out.println("3) 16\" Large       - $20.35");
        System.out.println("4) 18\" Extra Large - $24.45");
        System.out.println("Choose 1-4.");
        input = scan.nextInt();
        int size = getSize(input);
        double  price = getPrice(size);
        int num = getQuantity(size, type);
        calcPrice(num, price);
        OrderItem pizza = new OrderItem(type, size, num, price);
        items.add(pizza);
        return true;
    }

    public static void payment() {
        //if statement here to end output

        System.out.println("\nHow do you wish to pay for your order?");
        System.out.println("(Enter 1 for cash 2 for credit.)");
        int input = scan.nextInt();
        while (input < 1 || input > 2) {
            System.out.println("Enter valid choice 1 or 2");
            input = scan.nextInt();
        }
        if(input ==1) {
            System.out.println("\nCash payment summary: \n");
            System.out.printf("Payment amount: $ " + "%.2f%n",total);
            System.out.println("\n**************************************************************************************************");
        }else if(input == 2) {
            ccpayment();
        }

    }

    public static void ccpayment(){
        Scanner cardH = new Scanner(System.in);
        System.out.println("\nPlease enter the information requested.\n");
        System.out.println("Card holder name: ");
        String cardHolder = cardH.nextLine();
        // System.out.println("Card holder name: " + cardHolder);
        Scanner cardT = new Scanner(System.in);
        System.out.println("Credit Card Type(ex. Mastercard): ");
        String cardType = cardT.nextLine();
        //  System.out.println("Credit Card Type(ex. Mastercard): " + cardType);
        Scanner cardN = new Scanner(System.in);
        System.out.println("Credit Card Number(ex. 123456789123456: ");
        long cardNumber;
        cardNumber = cardN.nextLong();
        // System.out.println("Credit Card Number(ex. 123456789123456): " + cardNumber );
        Scanner expi = new Scanner(System.in);
        System.out.println("Expiration Date(ex. 10/2016): ");
        String expiration = expi.next();
        //System.out.println("Expiration Date(ex. 10/2016): " + expiration);
        System.out.println("\n**************************************************************************************************");
        System.out.println("Credit Card Payment Summary: \n");
        System.out.printf("Payment Amount: $ " + "%.2f%n",total );
        System.out.println("Customer Name: " + cardHolder);
        System.out.println("Card Type: " + cardType);
        System.out.println("Credit Card Number: " + "***********" + cardNumber % 10000);
        System.out.println("Expiration Date: " + expiration);
        System.out.println("\n**************************************************************************************************");
    }
}
