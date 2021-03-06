/*Suppose a class VegetableBill keeps track of a list of vegetable being purchased at a market:
Method/Constructor Description
public VegetableBill(Employee clerk) constructs a VegetableBill object for the given clerk
public void add(Item i) adds i to this bill's total
public double getTotal() returns the cost of these items
public void printReceipt() prints a list of items
VegetableBill objects interact with Item objects. An Item has the following public methods:

Method/Constructor Description
public double getPrice() returns the price for this item
public double getDiscount() returns the discount for this item

For example, Onion item might cost 1.35 with a discount of 0.25 for preferred customers, meaning that preferred customers get it for 1.10.
(Some items will have no discount, 0.0.) Currently the above classes do not consider discounts. Every item in a bill is charged full price, and item discounts
are ignored.

Define a class DiscountBill that extends VegetableBill to compute discounts for preferred customers. The constructor for DiscountBill accepts a parameter for whether the customer should get the discount.
Your class should adjust the amount reported by getTotal for preferred customers. For example, if the total would have been $80 but a preferred customer is getting $20 in discounts, then getTotal should report the total as $60 for that customer. You should also keep track of how many items a customer is getting a non-zero discount for and the overall discount, both as a total amount and as a percentage of the original bill. Include the extra methods below that allow a client to ask about the discount:

Method/Constructor Description
public DiscountBill(Employee clerk, boolean preferred) constructs bill for given clerk
public int getDiscountCount() returns the number of items that were discounted, if any
public double getDiscountAmount() returns the total discount for this list of items, if any
public double getDiscountPercent() returns the percent of the total discount as a percent of what the total would have been otherwise
If the customer is not a preferred customer the DiscountBill behaves at all times as if there is a total discount of 0.0 and no items have been discounted.
*/

import java.util.*;
class VegetableBill
{   private Employee clerk;
    List<Item> bill;
    private double total;
    private double Discount;    // In percentage
    
    public VegetableBill(Employee clerk)
    {
        this.clerk = clerk;
        bill = new ArrayList();
        total = 0.0;
        Discount = 0.0;
    }
    public void add(Item i)
    {
        bill.add(i);
        total = total + i.getPrice();
        Discount =Discount + i.getDiscount();       
    }
    public double getTotal()
    {
    return total;
    }
    public void printReceipt()
    {
      for (int i = 0; i < bill.size(); i++) 
      {
            System.out.println("Price = " +bill.get(i).getPrice());
            System.out.println("Discount = " +bill.get(i).getDiscount()+" %");
            System.out.println("Total Price = " +getTotal()+"\n");
            
       }
    }
       public Employee getClerk()            // return type Employee class
       {
        return clerk;
    }
}
class Item
{
    private String name;
    private double price;
    private double discount;
   
    public Item(String name, double price, double discount) 
    {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
public double getPrice()
{
    return price;
}
public double getDiscount() 
{
    return discount;
}
}	

class Employee 
{
	private String name;
	public Employee(String name) 
	{
			this.name = name;
	}
		
	public String getName() 
	{
			return name;
	}	
    
}
	
class DiscountBill extends VegetableBill
{
    private int myDiscountCount;
    private double myDiscountAmount;
    private double myPrice;
    private double myDiscountPercent;
    private boolean preferred;
public DiscountBill(Employee clerk, boolean preferred)
{
    super(clerk);
    this.preferred = preferred;
    
}
    @Override
public void add(Item myBill)
    {
        myPrice += myBill.getPrice();
        if (preferred)
        myDiscountAmount += myBill.getDiscount();
    
        if (myDiscountAmount > 0 && preferred)
        myDiscountCount += 1;
    }

    @Override
    public double getTotal()
    {
        if (preferred)
        return myPrice - myDiscountAmount;
        else
        return myPrice;
    }

public int getDiscountCount()
{
    return myDiscountCount;
}
public double getDiscountAmount()
{
     return myDiscountAmount;
}
public double getDiscountPercent()
{
    myDiscountPercent=myDiscountAmount;
    return myDiscountPercent;

}
}


public class Main
{
	public static void main(String[] args) 
	{
	
Employee E =new Employee("Mohd Tauhid");
Item I1= new Item("Tomato",70.50,10.0);
Item I2= new Item("Onion",80.0,20.0);
Item I3= new Item("Potato",30.00,0.0);
Item I4= new Item("Ginger",20.00,15.0);
Item I5= new Item("Pumpkin",25.50,18.0);
VegetableBill V=new VegetableBill(E);
V.add(I1);
V.add(I2);
V.add(I3);
V.add(I4);
V.add(I5);
V.getTotal();
V.printReceipt();


DiscountBill D=new DiscountBill(E,true); 
D.add(I1);
D.add(I2);
D.add(I3);
D.add(I4);
D.add(I5);

System.out.println(D.getTotal());
System.out.println(D.getDiscountCount());
System.out.println(D.getDiscountAmount());
System.out.println(D.getDiscountPercent());
	}
}

