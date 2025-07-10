/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samue
 */
import java.util.*;
import java.io.*;
public class BookstoreDriver 
{
    public static void main (String [] args) throws FileNotFoundException, IOException
    {
        Scanner scnr = new Scanner(System.in);
        Bookstore aBookstore = new Bookstore("ProductInventory.csv");
        ArrayList<Product> selection = new ArrayList();
        ArrayList<Product> endReport = new ArrayList();
        ArrayList<Customer> customerList = new ArrayList();
        
        int counter = 0; //used to calculate the number of transactions, one transaction per purchase. (Ex: doesn't matter how many products you purchase in one instance, it's considered one transaction)
        
        boolean exitConditions = false; // boolean used to verify whether the user is ready to exit the menu
        boolean validInput; //boolean used to very whether the user has entered an appropriate menu choice
        boolean userQuit; //boolean used to verify whether the user has finished purchasing their items

        while(exitConditions == false)
        {
            System.out.println("\n" + "Welcome to Sam's Bookstore!");
            System.out.println("Select from one of the following options: ");
            System.out.println("\t 1. Complete a purchase");
            System.out.println("\t 2. Register a member");
            System.out.println("\t 3. Check membership fee status");
            System.out.println("\t 4. Compare products based on price");
            System.out.println("\t 5. Display inventory total");
            System.out.println("\t 6. Restock an item");
            System.out.println("\t 7. Exit");
            try{
                int choice = scnr.nextInt();
                validInput = false; 
                userQuit = false; 
                
                while (validInput == false)
                {
                    scnr.nextLine();
                    if (choice == 1)// Allows the user to make a purchase
                    {
                        validInput = true; 
                        selection.clear();
                        while (userQuit == false)
                        {
                            System.out.println(aBookstore.getProductsString());
                            System.out.print("Please enter the ID of the product you would like to purchase: ");
                            int purchase = scnr.nextInt();
                            if (aBookstore.getProducts().get(purchase-1).getStock() == 0)
                            {
                                System.out.println("Sorry, there are no more available copies. Please select a different item.");
                            }
                            else
                            {
                                selection.add(aBookstore.getProducts().get(purchase-1));
                                aBookstore.getProducts().get(purchase-1).setStock(aBookstore.getProducts().get(purchase - 1).getStock()-1);
                                endReport.add(aBookstore.getProducts().get(purchase-1));
                            }
                            System.out.print("Would you like to purchase another item (enter y/n): ");
                            char userChoice = scnr.next().charAt(0);
                            if (userChoice == 'n' || userChoice == 'N')
                            {
                                userQuit = true; 
                                System.out.println(aBookstore.getCustomersString());
                                System.out.print("Please enter the ID of your membership: ");
                                int memberID = scnr.nextInt();
                                aBookstore.Purchase(selection, memberID);
                                counter +=1;
                            }
                        }
                    }
                    else if (choice == 2) // Allows the user to register a member, and choose whether to be premium or basic 
                    {
                        validInput = true; 
                        System.out.print("What is your name?: ");
                        String name = scnr.nextLine();
                        System.out.print("What membership type would you like? (Enter p for premium or b for basic) : ");
                        char memberChoice = scnr.next().charAt(0);
                        aBookstore.addCustomer(name, memberChoice);
                        System.out.println(aBookstore.getCustomersString());
                    }
                    else if (choice == 3) //Allows the user to check their membership fee status, also lets them see the number of puchases they've made 
                    {
                        validInput = true; 
                        System.out.println(aBookstore.getCustomersString());
                        System.out.print("Please enter the ID number of your membership: ");
                        int id = scnr.nextInt();
                        aBookstore.checkMembershipFee(id);
                    }
                    else if (choice == 4) //Allows the user to compare products based on price, and let them know which item is greater in price. 
                    {
                        validInput = true; 
                        System.out.println(aBookstore.getProductsString());
                        System.out.print("Please enter the Id number of the product of your choice: ");
                        int firstProduct = scnr.nextInt();
                        System.out.print("Please enter the ID number of the product you wish to compare with: ");
                        int secondProduct = scnr.nextInt();
                        System.out.println("");
                        aBookstore.comparison(aBookstore.getProducts().get(firstProduct-1).compareTo(aBookstore.getProducts().get(secondProduct-1)));
                    }
                    else if (choice == 5) // Calculates the current value of the store based on the amount of items in stock 
                    {
                        validInput = true; 
                        System.out.println("\nThe current total of the store's inventory is: " + String.format("%.2f", aBookstore.inventoryValue()));
                    }
                    else if (choice == 6) // Allows the user to restock an item based on the amount they choose. 
                    {
                        validInput = true; 
                        System.out.println(aBookstore.getProductsString());
                        System.out.print("Please enter the ID number of the product you wish to restock: ");
                        int restockID = scnr.nextInt();
                        System.out.print("How many copies would you like to restock? ");
                        int amount = scnr.nextInt();
                        System.out.println("Quantity in stock: " + aBookstore.restockProduct(restockID,amount));
                        System.out.println("\n" + aBookstore.getProductsString());
                    }
                    else if (choice == 7) //exit, sets all conditions to true in order to exit the while loop
                    {
                        exitConditions = true; 
                        validInput = true; 
                        System.out.println("Thank you for shopping with us! Have a good day.");
                    
                        aBookstore.endReport("endReport.txt",endReport,counter);
                        aBookstore.inventoryDay2("BookInventoryDay2.csv");
                    
                    }
                    else
                    {
                        System.out.print("Sorry, but you need to enter 1, 2, 3, 4, 5, 6 or 7: ");
                        System.out.println("\n" + "Welcome to Sam's Bookstore!");
                        System.out.println("Select from one of the following options: ");
                        System.out.println("\t 1. Complete a purchase");
                        System.out.println("\t 2. Register a member");
                        System.out.println("\t 3. Check membership fee status");
                        System.out.println("\t 4. Compare products based on price");
                        System.out.println("\t 5. Display inventory total");
                        System.out.println("\t 6. Restock an item");
                        System.out.println("\t 7. Exit");
                        choice = scnr.nextInt();
                    
                    }
                }
                }
                catch(InputMismatchException excpt)
                {
                    System.out.println("Invalid type entered. Please try again!");
                    scnr.nextLine();
                }
                catch(Exception excpt)
                {
                    System.out.println(excpt.getMessage());
                    System.out.println("An error has occured. Please try again.");
                }
            }
    }//end main
    
}//end class
