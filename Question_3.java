/*#Problem 3
Design a System for a shop keeper to keep his/her inventory managed. He have furniture at the beginning , but he may add more items to it. His furniture are wood chair, 
wood table, steel chair etc. Each furniture have one property called isChilldSafe.
if the shopkeeper wants to add new type of items, such as phone or may be something else he can add, In future , he might also wants to add two new properties, 
such as isFireSafe, isWaterSafe etc.

WoodenFurniture = "Sofa Set", "Dinning Table","Dinning Chair","Dressing Table","Almirah","Rocking Chair"
SteelFurniture = "Steel Chair","Steel Sofa","Steel Bed","Steel Almirah"
ElectronicFurniture =" phone set","Tablet Set"
MedicineFurniture = " "

*/

import java.util.*;
interface Items                                                                 //Haveing common properties
{

   public void getId();                           
   public void getName();
   public void getPrice();
   public void getQuantity();
   public void getTotalPrice();
}
interface Furniture
{  
   public static boolean flag=false;
   public boolean isChilldSafe();
   public default boolean isFireSafe()                                                    // Can be Override
   {
       return flag;
   }
   public default boolean isWaterSafe()                                                     // Can be Override
   {
       return flag;
   }
}

class  WoodenFurniture implements Items, Furniture                                     
{
    private String id , name;
    private int quantity;
    private boolean flag;
    private double price;
    WoodenFurniture(String id, String name, double price,int quantity,boolean flag)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.flag=flag;
    }
   public void getId()
   {
       System.out.println("Id of WoodenFurniture is = "+id);
   }
   public void getName()
   {
     System.out.println("Name of WoodenFurniture is = "+name);  
   }
   public void getPrice()
   {
    System.out.println("Price of "+name+" is = "+price);  
   }
   public void getQuantity()
   {
    System.out.println("Quantity of "+name+" is = "+quantity); 
   }
   public void getTotalPrice()
   {
    System.out.println("Total Cost of "+name+" is = "+quantity*price); 
   }
   public boolean isChilldSafe()
   {
       return flag;
   }
   
}
class SteelFurniture implements Items, Furniture
{
    private Furniture furniture;
    private String id , name;
    private boolean flag;
    private int quantity;
    private double price;
    SteelFurniture(String id, String name, double price,int quantity,boolean flag)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.furniture=furniture;
        this.quantity=quantity;
        this.flag=flag;
    }
   public void getId()
   {
       System.out.println("Id of SteelFurniture is = "+id);
   }
   public void getName()
   {
     System.out.println("Name of SteelFurniture is = "+name);  
   }
   public void getPrice()
   {
    System.out.println("Price of "+name+" is = "+price);  
   }
   public void getQuantity()
   {
    System.out.println("Quantity of "+name+" is = "+quantity); 
   }
   public void getTotalPrice()
   {
    System.out.println("Total Cost of "+name+" is = "+quantity*price); 
   }
   public boolean isChilldSafe()
   {
       return flag;
   }
}
public class Main
{
	public static void main(String[] args) 
	{
     WoodenFurniture F =new WoodenFurniture("A@123","Sofa Set" ,1110.50,5,true);
     F.getId();
     F.getName();
     F.getPrice();
     F.getQuantity();
     F.getTotalPrice();
     System.out.println("Is Child Safe = " +F.isChilldSafe());
    
    
     SteelFurniture S =new SteelFurniture("B@123","Steel Chair" ,2110.50,4,false);
     S.getId();
     S.getName();
     S.getPrice();
     S.getQuantity();
     S.getTotalPrice();
     System.out.println("Is Child Safe = " +S.isChilldSafe());
	}
}
