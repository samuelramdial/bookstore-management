/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samue
 */
public class PremiumMember extends Customer
{
    private boolean duesPaid;
    public PremiumMember(int _id, String _name,int _number, boolean _duesPaid)
    {
        super(_id, _name,_number);
        duesPaid = _duesPaid;
    }
    public void setDuesPaid(boolean _dues)
    {
        duesPaid = _dues;
    }
    public boolean areDuesPaid()
    {
        return duesPaid;
    }
    @Override
    public String toString()
    {
        return super.getID() + ". " + super.getName() + " || Membership Type: Premium";
    }
} //end class
