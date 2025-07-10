/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samue
 */
interface BookstoreSpecification 
{
    /**
     * By using the productID and amount given, it will update the stock by adding the amount to the existing quantity. 
     * @param productID
     * @param amount
     * @return the quantity of product now available
     */
    public int restockProduct(int productID, int amount);
    /**
     * calculate and returns the amount for the current inventory of products in stock
     * @return total value of store based on stock
     */
    public double inventoryValue();
}
