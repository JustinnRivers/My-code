/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author Justinn Rivers
 * @author Dennis Sager
 * 
 * Inventory Class handles the Inventory of all movies in the list.
 * Features include
 * -AddMovie
 * -RemoveMovie
 * -DisplayInventory
 * -DisplayMovie
 * -PriceCheck
 * -QuanityCheck
 * -SkuCheck
 */

public class Inventory implements Serializable{
//Keep track of Movies
private ArrayList<Movie> inventory ;


//Construct object of ArrayList
Inventory(){ inventory = new ArrayList<>(); }


/*
   Adds a Movie to the ArrayList and stores data into inventory object
   @parameter sku,quanity,price,title
   Takes parameters and creates Movie object for inventory.
*/
public void AddMovie(int sku,int quanity,float price,String title)
{
    //Create an object of the new movie in Inventory
    inventory.add(new Movie(sku,quanity,price,title));
}

/*
   @parameter sku
   Takes SKU parameter and searches list for Movie to remove. 
   @return true if Movie was removed false if otherwise
*/
public boolean RemoveMovie(int sku)
{
    for(int i = 0; i < inventory.size();++i)
    {
        //Look for a matching SKU number
        
        if(inventory.get(i).CompareSku(sku)) 
        {
            System.out.println("Your movie has successfuly been removed");
            inventory.remove(i);
            return true;
           
        }
    }
    System.out.println("No movie was removed from Inventory.Please Check SKU of Movie");  
    return false;
      
}

/*
Display Inventory of entire movie list 
*/
public void DisplayInventory()
{
    System.out.println("Your Movie List contains ");
    System.out.println("SKU:    Quanity:      Price:         Title:");
    for(int i = 0;i < inventory.size();++i)
    {
          inventory.get(i).DisplayMovie();
    }    
}
/*
@param int sku
Display Movie of one Movie item given sku
@return void
*/
public void DisplayMovie(int sku)
{
    System.out.print("Here is your movie and details");
    for(int i = 0;i < inventory.size();i++)
    {
        
        if(inventory.get(i).CompareSku(sku))
        {
          inventory.get(i).DisplayMovie();
        }
    }
}

/*
@param float price
Check Price to see if user price is less than zero.
@return true if price is valid and false otherwise
*/
 public boolean PriceCheck(float price) 
   {
       //Check to see if SKU number is unique 
       if(price < 0.0  ) 
       {
           System.out.println("Item was not added,the price can not be less than zero.");
           return false;
       }
       return true;
   }

 /*
 @param int quanity
 Check quanity to see if user quanity is less than zero.
 @return true if quanity is valid and false otherwise.
 */
public boolean QuanityCheck(int quanity)
   {
      if(quanity < 0)
      {
          System.out.println("Item was not added,quanity can not be less than zero.");
          return false;
      }
      return true;
   }
 
/*
@param int sku
Check user input sku to see if sku input is unique.
@return true if sku is not unique and return false otherwise.
*/
public boolean SkuCheck(int sku)
   {
       //Check to see if sku is unique, traverse whole list
           for(int i = 0;i < inventory.size();++i)
           {
           if(inventory.get(i).CompareSku(sku))
           {
               System.out.println("Item was not added, SKU is not unique.");
               return false;
           }
           }
           return true;
   }

}

