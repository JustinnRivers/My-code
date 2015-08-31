/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Represents movie in inventory
 * @author Justinn Rivers
 * @author Dennis Sager
 */
public class Movie extends CommonData {
private int upc;

/**
 * Create movie with the given parameters 
 * @param temp_upc
 * @param temp_sku
 * @param temp_quanity
 * @param temp_price
 * @param temp_title 
 */
Movie(int temp_upc,int temp_sku,int temp_quanity,float temp_price,String temp_title)
{
    super(temp_sku,temp_quanity,temp_price,temp_title);
    upc = temp_upc;
}


/**
 * Display movie type
 * Override DisplayItemType method in CommonData.java
 */
@Override
void DisplayItemType()
{
    String movie = "Movie"; 
    System.out.println("Category: " + movie);
}

/**
 * Display upc of movie
 * Override DisplayItemAttr method in CommonData.java
 */
@Override 
void DisplayItemAttr()
{
    System.out.println();
    System.out.println("Your item is a Movie and carries upc code: " + upc);
}

/**
 * Process a sale with the user input of quanity to sell and cost for sell
 * @param quanity_sold
 * @param cost 
 * Overrides Process method in CommonData.java
 */
@Override
 void Process(int quanity_sold,float cost)
{
   float shipping_cost = 2.98f;
   float total_price;
   float total_sc,total_c,profit;
   
   
   
   //Total Price
   total_price  = GetPrice() *  quanity_sold;
   //Total Shipping Credit
   total_sc = quanity_sold * shipping_cost;
   //Total Comission
   total_c = total_price * .12f;
   //Get Profit
   profit = total_price + total_sc -(total_c + cost);
   
   //Print Output
   System.out.println("Total Price:         $" + total_price);
   System.out.println("Total Shipping Credit:      $" + total_sc);
   System.out.println("Total Commission:       $"+ total_c);
   System.out.println("Total Profit:       $" + profit);
}

    
}
