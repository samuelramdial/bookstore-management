/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samue
 */
public abstract class Customer 
{
    private String name; 
    private int id; 
    private int numberOfPurchases = 0;
    
    Customer(int _id, String _name, int _numberofPurchases)
    {
        id = _id;
        name = _name;
    }
    public String getName()
    {
        return name; 
    }
    public void setName(String _name)
    {
        name = _name;
    }
    public int getNumberOfPurchases()
    {
        return numberOfPurchases;
    }
    public void setNumberOfPurchases(int _number)
    {
        numberOfPurchases = _number;
    }
    public int getID()
    {
        return id; 
    }
    public void setID(int _id)
    {
        id = _id;
    }
} //end class
