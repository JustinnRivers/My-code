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

 */
public class Inventory implements Serializable {
private ArrayList<CommonData> inventory;

Inventory()
{
    inventory = new ArrayList<>();
}


/**
 * 
 * @param wei
 * @param sku
 * @param qua
 * @param pri
 * @param tit 
 */
public void AddItem(float wei,int sku,int qua,float pri,String tit)
{
    //Add Toy Object 
   inventory.add(new Toy(wei,sku,qua,pri,tit));
    
}

/**
 * 
 * @param isbn
 * @param nam
 * @param sku
 * @param qua
 * @param pri
 * @param tit 
 */
public void AddItem(int isbn,String nam,int sku,int qua,float pri,String tit)
{
   //Add Book object 
   inventory.add(new Books(isbn,nam,sku,qua,pri,tit));   
}
/**
 * 
 * @param upc
 * @param sku
 * @param qua
 * @param pri
 * @param tit 
 */
public void AddItem(int upc,int sku,int qua,float pri,String tit)
{
    //Add Movie object
    inventory.add(new Movie(upc,sku,qua,pri,tit));
}

/**
 * 
 * @param sku
 * @return 
 */
public boolean RemoveItem(int sku)
{
    for(int i = 0; i < inventory.size();++i)
    {
        //Look for a matching SKU number
        if(inventory.get(i).FlagSku(sku)) 
        {
           System.out.println("Your item has successfuly been removed");
           inventory.remove(i);
           return true;
           
        }
    }
    System.out.println("Item was not removed. Please Check sku of item");  
    return false;
      
}
/**
 * 
 * @param price
 * @return 
 */
public boolean PriceCheck(float price) 
   {
       //Check to see if SKU number is unique 
       if(price < 0.0  ) 
       {
           System.out.println("Item not added,price is less than zero.");
           return false;
       }
       return true;
   }
/**
 * 
 */
public void DisplayInventory()
{
    Collections.sort(inventory);
    System.out.println("Your Item List contains ");
     for(int i = 0;i < inventory.size();++i)
    {
          inventory.get(i).Display();
    }    
}

/**
 * 
 * @param sku 
 */
public boolean DisplayIt(int sku)
{
    
    for(int i = 0;i < inventory.size();i++)
    {
        
        if(inventory.get(i).FlagSku(sku))
        {
          System.out.println("Here is your Item and details");  
          inventory.get(i).DisplayItem();
          return true;
        }
    }
    System.out.println("The item was not found please check inventory");
    return false;
}

/**
 * 
 * @param user_sku
 * @param quanity_sold
 * @param cost
 * @return 
 */
public boolean Sale(int user_sku,int quanity_sold,float cost)
{
    for(int i = 0;i < inventory.size();i++)
    {
      if(inventory.get(i).FlagSku(user_sku) &&
         inventory.get(i).QuanCheck(quanity_sold))
     {
            inventory.get(i).Process(quanity_sold,cost);
            inventory.get(i).ModifyQuan(quanity_sold);
            return true;
      }
   }
   System.out.println("Your sale was not processed.");
   return false;
}
   
/**
 * 
 * @param quanity
 * @return 
 */
public boolean QuanityCheck(int quanity)
   {
      if(quanity < 0)
      {
          System.out.println("Item was not added,quanity is less than zero.");
          return false;
      }
      return true;
   }

/**
 * 
 * @param sku
 * @return 
 */
public boolean SkuCheck(int sku)
{
    //Check to see if sku is unique, traverse whole list
    for(int i = 0;i < inventory.size();++i)
    {
     if(inventory.get(i).FlagSku(sku))
     {
      System.out.println("Item was not added, SKU is not unique.");
      return false;
     }
   }
 return true;
}

}
