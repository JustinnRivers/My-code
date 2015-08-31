/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Represents Books in inventory
 * @author Justinn Rivers
 * @author Dennis Sager
 */
public class Books extends CommonData  {
    private int isbn;
    private String name;
/**
 * Init book from parameters
 * @param t_isbn
 * @param t_name
 * @param sku
 * @param quanity
 * @param price
 * @param title 
 */    
Books(int t_isbn, String t_name,int sku,int quanity,float price,String title)
{
    super(sku,quanity,price,title);
    isbn = t_isbn;
    name = t_name;
}

/**
 * Display book type
 * Override DisplayItemType method in CommonData.java
 */
@Override
void DisplayItemType()
{   
   String book = "book";
   System.out.println("Category: " + book);
}

/**
 * Display isbn of book and author
 * Override DisplayItemAttr method in CommonData.java
 */
@Override
void DisplayItemAttr()
{
  System.out.println("Item is a Book,has isbn " +isbn);
  System.out.println("with author "+name);
}

/**
 * Process a sale with the user input of quanity to sell and cost for sell
 * @param quanity_sold
 * @param cost
 * Overrides Process method in CommonData.java
 */
@Override
public void Process(int quanity_sold,float cost)
{
   float shipping_cost = 3.99f;
   float total_price;
   float total_sc,total_c,profit;
     
   
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
