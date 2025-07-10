/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samue
 */
public class BasicMember extends Customer 
{

    public BasicMember(int _id,String _name, int _number)
    {
        super(_id, _name, _number);
    }
 
    @Override
    public String toString()
    {
        return super.getID() + ". " +super.getName() + " || Membership Type: Basic";
    }
}//end class
