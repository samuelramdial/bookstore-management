/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author samue
 */
import java.util.*;
public abstract class Product implements Comparable<Product>
{
    private int id;
    private String title;
    private String author;
    private double price; 
    private int stock; 
    
    public Product(int _id, String _title, String _author, int _stock, double _price)
    {
        id = _id;
        title = _title;
        author = _author;
        price = _price; 
        stock = _stock; 
    }
    public int getId()
    {
        return id; 
    }
    public void setId(int _id)
    {
        id = _id; 
    }
    public String getTitle()
    {
        return title; 
    }
    public void setTitle(String _title)
    {
        title = _title; 
    }
    public double getPrice()
    {
        return price; 
    }
    public void setPrice(double _price)
    {
        price = _price; 
    }
    public int getStock()
    {
        return stock; 
    }
    public void setStock(int _stock)
    {
        stock = _stock; 
    }
    public String getAuthor()
    {
        return author; 
    }
    public void setAuthor(String _author)
    {
        author = _author;
    }
    @Override
    public int compareTo(Product o) 
    {
       
        double otherPrice = o.getPrice();
        if(price > otherPrice)
        {
            return 1; 
        }
        else if (price < otherPrice)
        {
            return -1;
        }
        return 0; 
    }
} // end class
