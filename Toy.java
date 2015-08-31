/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Represents Toy in the inventory 
 * @author Justinn Rivers
 * @author Dennis Sager 
 */
public class Toy extends CommonData  {
private float weight;

/**
 * Init object of Toy with parameters given
 * @param t_weight
 * @param sku
 * @param quanity
 * @param price
 * @param title 
 */
Toy(float t_weight,int sku,int quanity,float price,String title)
{
    super(sku,quanity,price,title);
    weight = t_weight;
    
}

/**
 * Display Toy Text output 
 * Override DisplayItemType method in CommonData.java
 */
@Override 
 void DisplayItemType()
{
  String Toy = "Toy";  
  System.out.println("Category: " + Toy);
}
 
/**
 * Display weight of Toy
 * Override DisplayItemAttr method in CommonData.java
 */
 @Override
void DisplayItemAttr()
{
    System.out.println();
    System.out.format("Item is a Toy and carries a weight of %5.2f",weight);
} 
 

/**
 * Process sell for a toy in the inventory with the given parameters
 * @param quanity_sold
 * @param cost 
 * Override Process method in CommonData.java*
 */
@Override
public void Process(int quanity_sold,float cost)
{
   float shipping_cost = 4.49f;
   float total_price;
   float total_sc,total_c,profit;
   
   //Convert oz to pounds
   int lb = (int)weight / 16;
   if(weight % 16 >= 8) lb++;  
   
   //Total Price
   total_price  = GetPrice() *  quanity_sold;
   //Total Shipping Credit
   total_sc = quanity_sold * shipping_cost;
   //Total Comission
   total_c = total_price * .15f;
   //Get Profit
   profit = total_price + total_sc -(total_c + cost);
   
   //Print Output
   System.out.println("Total Price:         $" + total_price);
   System.out.println("Total Shipping Credit:      $" + total_sc);
   System.out.println("Total Commission:       $"+ total_c);
   System.out.println("Total Profit:       $" + profit);
}
    
}
