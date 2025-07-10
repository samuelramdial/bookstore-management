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
public class Bookstore implements BookstoreSpecification
{
    private final ArrayList<Product> menu;
    private final ArrayList<Customer> customers;
    private static int nextMemberID = 1;
    private static int nextItemID = 1;
    private BasicMember addBasicMember;
    private PremiumMember addPremiumMember;
    
    /**
     * A public constructor that generates the products and customers. 
     * @param filename
     */
    public Bookstore(String filename)
    {
          menu = new ArrayList();
          try {
                Scanner fileScan = new Scanner(new File(filename));
                String header = fileScan.nextLine();
                
                while (fileScan.hasNext())
                {
                    String line = fileScan.nextLine();
                    String[] lineSplit = line.split(",");
                    
                    int productID = Integer.parseInt(lineSplit[0]);
                    String title = lineSplit[2];
                    String author = lineSplit[3];
                    int stock = Integer.parseInt(lineSplit[4]);
                    double price = Double.parseDouble(lineSplit[5]);
                    
                    if(line.contains("book"))
                    {
                        menu.add(new Book(productID , title , author , stock , price));
                    }
                    else if(line.contains("cd"))
                    {
                        menu.add(new CD(productID, title, author , stock , price));
                    }
                    else
                    {
                        menu.add(new DVD(productID, title, author, stock, price));
                    }   
                }   
          }
          catch (FileNotFoundException fne)
          {
              System.out.println("Caught FileNotFoundException for ProductInventory.csv. Try again making sure the final name and path are correct.");
          }
          Collections.sort(menu);
        
          for(int index = 0; index < menu.size(); index++)
          {
            menu.get(index).setId(getNextItemID());
            incrementNextItemNum();
          }
        
        
        customers = new ArrayList();
        BasicMember member1 = new BasicMember(getNextMemberNum(),"Samuel",0);
        incrementNextMemberNum();
        BasicMember member2 = new BasicMember(getNextMemberNum(),"Anthony",0);
        incrementNextMemberNum();
        PremiumMember member3 = new PremiumMember(getNextMemberNum(),"Angelica",0,false);
        incrementNextMemberNum();
        PremiumMember member4 = new PremiumMember(getNextMemberNum(),"Dominic",0,false);
        
        customers.add(member1);
        customers.add(member2);
        customers.add(member3);
        customers.add(member4);
    }
    /**
     * A public method that gets the next member ID. 
     * @return the integer of the next member ID. 
     */
    public static int getNextMemberNum()
    {
        return nextMemberID;
    }
    /**
     * A private method that increments the member ID by one. 
     */
    private static void incrementNextMemberNum()
    {
        nextMemberID = nextMemberID + 1;
    }
    /**
     * A public method that gets the next ID of the product. 
     * @return the integer of the next product ID. 
     */
    public int getNextItemID()
    {
        return nextItemID;
    }
    /**  
     * A private method that increments the product ID by one. 
     */
    private static void incrementNextItemNum()
    {
        nextItemID = nextItemID + 1;
    }
    /** 
     * A public method that utilizes the parameters to add a customer based on their decisions
     * @param _name Initializes the name of the customer
     * @param _choice Determines whether the customer will become a premium member or basic member
     */
    public void addCustomer(String _name, char _choice)
    {
        if(_choice == 'B' || _choice == 'b')
        {
            incrementNextMemberNum();
            addBasicMember = new BasicMember(getNextMemberNum(),_name,0);
            customers.add(addBasicMember);
            
          
        }
        else if(_choice == 'P' || _choice == 'p')
        {
            incrementNextMemberNum();
            addPremiumMember = new PremiumMember(getNextMemberNum(),_name,0,false);
            System.out.println("A membership fee will be applied to your first purchase as a premium member. \n");
            customers.add(addPremiumMember);
           
        }
        else
        {
            System.out.println("\np or b was not entered, this operation could not be completed. Please try again.");
        }
    }
    /**
     * A public method used to get access to the list of Customers. 
     * @return an ArrayList of customers
     */
    public ArrayList<Customer> getCustomers()
    {
        return customers;
    }
    /**
     * A public method used to print out the list of Customers utilizing the object's toString.
     * @return A string of the list of customers. 
     */
    public String getCustomersString()
    {
        String text = "";
        for (Customer aCustomer: customers)
        {
            text += aCustomer + "\n";
        }
        return text; 
    }
    /**
     * A public method used to print out the list of Products utilizing the object's toString. 
     * @return A string of the list of products. 
     */
    public String getProductsString()
    {
        String text = "";
        for (Product aProduct: menu)
        {
            text += aProduct + "\n";
        }
        return text; 
    }
    /**
     * A public method used to gain access to the list of Products
     * @return An ArrayList of customers
     */
    public ArrayList<Product> getProducts()
    {
        return menu; 
    }
    /**
     * A public method that utilizes the parameter in order to determine what the membership fee status is of an individual. 
     * @param _id used to determine the member that will be checked
     */
    public void checkMembershipFee(int _id)
    {
           
            if (customers.get(_id-1) instanceof PremiumMember && ((PremiumMember)customers.get(_id-1)).areDuesPaid()== false)
            {
                    System.out.println("Your membership fee has not been paid. This will be charged with your first purchase.");
                    System.out.println("Number of Purchases: " + customers.get(_id-1).getNumberOfPurchases());
            }
            else if (customers.get(_id - 1) instanceof BasicMember)
            {
                    System.out.println("You currently have a basic membership. The membership fee does not apply to you.");
                    System.out.println("Number of Purchases: " + customers.get(_id-1).getNumberOfPurchases());
            }
            else
            {
                System.out.println("Your membership fee has  been paid.");
                System.out.println("Number of Purchases: " + customers.get(_id-1).getNumberOfPurchases());
            }
        }
    /**
     * A public method that relies on the Product's class compareTo method to determine which product price is greater.
     * @param _result an integer returned from the Product's compareTo method, based on the integer the system will print out different situations. 
     */
    public void comparison(int _result)
    {
        if(_result == 1)
        {
            System.out.println("The price of the first item is greater.");
        }
        else if (_result == -1)
        {
            System.out.println("The price of the second item is greater.");
        }
        else
        {
            System.out.println("The price of these items are equal.");
        }
    }
    @Override
    public double inventoryValue()
    {
        double total = 0.0; 
        for(Product aProduct: menu)
        {
            total += (aProduct.getPrice() * aProduct.getStock());
        }
        return total; 
    }
    @Override
    public int restockProduct(int productID, int amount)
    {
        int newAmount = amount + menu.get(productID-1).getStock();
        menu.get(productID - 1).setStock(newAmount);
        return newAmount; 
    }
    /**
     * A public method that utilizes the parameters in order to select the items the user has purchased and print out their receipt based on their membership status. 
     * @param purchases an arrayList of products that the user has selected to purchase
     * @param _memberID the memberID of the user purchasing items, used to set their number of purchases and determine if they're a basic or premium member
     */
    public void Purchase(ArrayList<Product> purchases, int _memberID)
    {
        double merchandise = 0; 
        double total = 0;
        String receipt = "";
        Customer aCustomer = customers.get(_memberID-1);
        int counter = 0; 
        
        for (Product aProduct: purchases)
        {
            merchandise += aProduct.getPrice();
            counter += 1;
        }
        aCustomer.setNumberOfPurchases(counter);
        if(aCustomer instanceof PremiumMember)
        {
           if(((PremiumMember)aCustomer).areDuesPaid() == false)
           {
               double membershipFee = 5.00;
               total += membershipFee + merchandise;
               ((PremiumMember)aCustomer).setDuesPaid(true);
               aCustomer.setNumberOfPurchases(counter);
               
               receipt = receipt 
               +                "-------------"
               + "\n" +         "Your total is updated to reflect your membership fee."
               + "\n" +         "Monthly Membership Fee: " + "$" + String.format("%.2f",membershipFee)
               + "\n" +         "Merchandise Total: " + "\t$" + String.format("%.2f", merchandise)
               + "\n" +         "Total: " + "\t\t\t" + "$" + String.format("%.2f", total);
           }
           else
           {
               aCustomer.setNumberOfPurchases(counter);
               total += merchandise;
               receipt = receipt
               +                "--------------"
               + "\n" +         "Total: " + "\t\t\t" + "$" + String.format("%.2f",total);
           }
        }
        if(aCustomer instanceof BasicMember)
        {
            aCustomer.setNumberOfPurchases(counter);
            total += merchandise;
            
            receipt = receipt
            +                   "--------------"
            + "\n" +            "Total: " + "\t\t\t" + "$" + String.format("%.2f",total); 
            
        }
        System.out.println(receipt);
    }
    /**
     * A public method used to generate an end of day report of the bookstore. 
     * @param filename the filename of the generated text file
     * @param products the products that were purchased that day
     * @param _counter the number of transactions of that day
     */
    public void endReport(String filename, ArrayList<Product> products, int _counter)
    {
        try {
            FileOutputStream fs = new FileOutputStream(filename);
            PrintWriter outFS = new PrintWriter(fs);
            
            outFS.println("Products Purchased Today: ");
            if (products.isEmpty())
            {
                outFS.println("No items were purchased today.");
            }
            else
            {
                 for(Product aProduct: products)
                 {
                    outFS.println(aProduct.getTitle());
                 }
            }
            outFS.println("\nNumber of Transactions Today: ");
            if (_counter == 0)
            {
                outFS.println("No transactions were made today.");
            }
            else
            {
                outFS.println(_counter);
            }
            outFS.println("\nMembers Registered Today: ");
            if(customers.size() <= 4 )
            {
                outFS.println("No new members were registered today.");
            }
            else
            {
                for (Customer aCustomer: customers)
                {
                    if (aCustomer.getID() >= 5)
                    {
                        outFS.println(aCustomer.getName());
                    }
                }
            }
            outFS.println("\nTotal Sales and Revenue Today: ");
            double total = 0;
            if(products.isEmpty())
            {
                outFS.println("No sales were made today.");
            }
            else
            {
                for (Product aProduct: products)
                {
                    total += aProduct.getPrice();
                    
                }
                outFS.println(String.format("$%.2f",total));
            }
            outFS.close();
            fs.close();
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Caught FileNotFoundException for endreport.txt. Try again making sure the file name and path are correct.");
        }
        catch(IOException io)
        {
            System.out.print("Caught IOException when closing output stream. Try again.");
        }
    }
    /**
     * A public method that generates a new inventory that reflects the changes that were made throughout the day. 
     * @param filename the filename of the generated output file
     */
    public void inventoryDay2(String filename)
    {
        try {
            FileOutputStream fs = new FileOutputStream(filename);
            PrintWriter outFS = new PrintWriter(fs);
            
            String header = "productID" + "," + "type" + "," + "author/artist" + "," + "numInStock" + "," + "price";
            outFS.println(header);
            
            for(Product aProduct: menu)
            {
                if (aProduct instanceof Book)
                {
                    outFS.println(aProduct.getId() + "," + "book" + "," + aProduct.getTitle() + "," + aProduct.getAuthor() + "," + aProduct.getStock() + "," + aProduct.getPrice());
                }
                if (aProduct instanceof CD)
                {
                    outFS.println(aProduct.getId() + "," + "cd" + "," + aProduct.getTitle() + "," + aProduct.getAuthor() + "," + aProduct.getStock() + "," + aProduct.getPrice()); 
                }
                if (aProduct instanceof DVD)
                {
                    outFS.println(aProduct.getId() + "," + "dvd" + "," + aProduct.getTitle() + "," + aProduct.getAuthor() + "," + aProduct.getStock() + "," + aProduct.getPrice());
                }
            }
            
            outFS.close();
            fs.close();
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Caught FileNotFoundException for BookInventoryDay2.csv Try again making sure the file name and path are correct.");
        }
        catch(IOException io)
        {
            System.out.println("Caught IO exception when closing output stream. Try again");
        }
        
    }
} 
 
