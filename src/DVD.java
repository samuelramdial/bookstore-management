/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samue
 */
public class DVD extends Product
{ 
    
    public DVD(int _id, String _title, String _author, int _stock, double _price)
    {
        super(_id, _title, _author, _stock, _price);
    }
    @Override
    public String toString()
    {
        return "Product ID: " + super.getId() + " || " + "Type: " + "DVD" + " || " + "Author/Artist: " + super.getAuthor() + " || " + "Stock: " + super.getStock() + " || " + "Price: " + String.format("%.2f", super.getPrice());
    }
}
