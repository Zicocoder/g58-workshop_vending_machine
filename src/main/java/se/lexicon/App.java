package se.lexicon;

import se.lexicon.model.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Product soda = new Soda(23, "Coca Cola");
        Product chips = new Chips(30, "Potato Chips");
        Product chocolate = new Chocolate(15, "Mars");

        Product[] products = {soda, chips, chocolate};


        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Vending Machine!");

        boolean running = true;
        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Show products");
            System.out.println("2. Insert money");
            System.out.println("3. Buy product");
            System.out.println("4. Show balance");
            System.out.println("5. End session");
            System.out.print("Choose an option");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\nAvailable products");
                    for (String desc : vendingMachine.getProducts()) {
                        System.out.println(desc);
                    }
                    break;

                case "2":
                    System.out.println("Insert money (1, 2, 5, 10, 20, 50, 100, 200, 500, 1000");
                    int amount = Integer.parseInt(scanner.nextLine());
                    boolean valid = false;
                    for (Currency c : Currency.values()) {
                        if (c.getValue() == amount) {
                            vendingMachine.addCurrency(c);
                            valid = true;
                            break;
                        }
                    }

                case "3": // 🟢 buy product
                    System.out.println("Enter product ID to buy:");
                    int id = Integer.parseInt(scanner.nextLine());
                    try {
                        Product bought = vendingMachine.request(id);
                        System.out.println("You bought: " + bought.getProductName());
                        System.out.println(bought.use());
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "4": // 🟢 show balance
                    System.out.println("Current balance: " + vendingMachine.getBalance() + " kr");
                    break;

                case "5": // 🟢 end session
                    int change = vendingMachine.endSession();
                    System.out.println("Session ended. Returning " + change + " kr in change.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        System.out.println("Goodbye!");
    }

}
