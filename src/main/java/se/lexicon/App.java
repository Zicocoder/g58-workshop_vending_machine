package se.lexicon;

import se.lexicon.model.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Product soda = new Soda(23, "Coca Cola");
        Product chips = new Chips(30, "Potato");
        Product chocolate= new Chocolate(15, "Mars");

        Product[] Products = new Product[]{soda, chips, chocolate};


        VendingMachineImpl vendingMachine = new VendingMachineImpl(Products);

        System.out.println(Arrays.toString(vendingMachine.getProducts()));

        System.out.println(vendingMachine.getDescription(0));

        vendingMachine.addCurrency(Currency.FIVE);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TWO);
        vendingMachine.addCurrency(Currency.TWO);

        System.out.println(vendingMachine.getBalance());

        try {
            Product requested = vendingMachine.request(1);
            System.out.println("You bought: " + requested.getProductName());

        }catch (RuntimeException e) {
            System.out.println("Too expensive");
        }

        try {
            vendingMachine.request(2);
        }catch (RuntimeException e) {
            System.out.println("Too expensive");
        }
        System.out.println(vendingMachine.getBalance());

        vendingMachine.endSession();


    }
}
