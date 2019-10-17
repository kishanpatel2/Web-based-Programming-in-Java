/*
Author: Kishan Patel
E-mail: kpp5282@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 2
Due date: 2/14/2019
File: OrderItem.java
Purpose: Java application that implements an online specialty pizzashop
Compiler/IDE: IntelliJ IDEA
Operating system: Macbook Pro
Reference(s): Java 8 API - Oracle Documentation
https://www.mkyong.com/java/java-display-double-in-2-decimal-points/
https://www.quora.com/How-do-I-truncate-float-up-to-two-decimal-points-in-Java
//https://stackoverflow.com/questions/12524243/how-do-i-make-java-register-a-string-input-with-spaces/12524285
*/
package specialtyPizzaMenu;

public class OrderItem {
    int quantity, size;
    double price;
    String type;

    public OrderItem() {
        quantity = 0;
        size = 0;
        price = 0;
        type = "";
    }

    public OrderItem(String type, int size, int qantity, double price) {
        this.type = type;
        this.size = size;
        this.quantity = qantity;
        this.price = price;
    }

    /** This method get the quantity from the user
     *
     */

    public int getQantity() {

        return quantity;
    }

    /** This method sets the quantity
     *
     * @param qantity The number of pizzas from the user
     */

    public void setQantity(
            int qantity) {
        this.quantity = qantity;
    }

    /** This method gets the size from user
     *
     */

    public int getSize() {

        return size;
    }

    /** This method sets the size from user
     *
     * @param size The size of pizza from the user
     */

    public void setSize(
            int size) {
        this.size = size;
    }

    /** This method gets the price from user
     *
     */
    public double getPrice() {

        return price;
    }

    /** This method sets the price from user
     *
     * @param price The price of pizza from user options
     */
    public void setPrice(double price) {

        this.price = price;
    }

    /** This method gets the type of pizza
     *
     */
    public String getType() {

        return type;
    }

    /** This method sets the type of pizza
     *
     * @param type The type of pizza from user
     */
    public void setType(String type) {

        this.type = type;
    }

    /** This method is the rows and columns at the end of program
     *
     */
    public String toString() {

        return type + "\t        " +  size + "\t\t\t" + quantity + "\t\t\t" + " $ " + price;
    }



}
