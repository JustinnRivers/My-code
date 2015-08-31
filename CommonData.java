/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 * Represents common details of items in inventory
 * @author Justinn Rivers
 * @author Dennis Sager
 */
abstract class CommonData implements Serializable,Comparable<CommonData>   {
  private int sku;
  private int quanity;
  private float price;
  private String title;
  

/**
 * Creates CommonData with given parameters
 * @param tsku
 * @param tquanity
 * @param tprice
 * @param ttitle 
 */
CommonData(int tsku,int tquanity,float tprice,String ttitle)
{
    sku =  tsku;
    quanity = tquanity;
    price = tprice;
    title = ttitle;
}

/**
 * Checks to see if user input a unique sku
 * @param user_sku
 * @return true if sku is not unique
 * @return false otherwise
 */
public boolean FlagSku(int user_sku)
{
    if(sku == user_sku) return true;
    return false;
}

/**
 * Check to see if quanity sold will result in a negative quanity in inventory
 * @param user_quanity
 * @return false if quanity is negative
 * @return true otherwise
 */
public boolean QuanCheck(int user_quanity)
{
   if((quanity - user_quanity) < 0) return false;
   return true;
}


/**
 * Get value of sku of inventory
 * @return sku
 */
public int GetSku(){return sku;}

/**
 * Get value of price in inventory
 * @return price
 */
public float GetPrice() {return price;}

/**
 * Display details of items in inventory
 */
public void Display()
{
 DisplayItemType();
 System.out.println("SKU: " + sku);
 System.out.println("Quanity: " + quanity);
 System.out.println("Price: " + price );
 System.out.println("Title: "+ title);
 System.out.println();
 
   
}

/**
 * Display detail of item and category in inventory
 */
public void DisplayItem()
{
    System.out.println("SKU: " + sku);
    System.out.println("Quanity: " + quanity);
    System.out.println("Price: " + price );
    System.out.println("Title: "+ title);
    
    DisplayItemAttr();
}

/**
 * Update quanity in inventory
 * @param temp_quan 
 */
public void ModifyQuan(int temp_quan)
{
    quanity = quanity - temp_quan; 
}


/**
 * Sort items in inventory by sku with given input
 * @param rhs
 * @return result of sku comparison 
 */
public int compareTo(CommonData rhs){  return this.sku - rhs.sku; }

/**
 * Handles process of sell for any item
 * @param x
 * @param y 
 */
abstract void Process(int x,float y);
/**
 * Handles Display of any item type in inventory
 */
 abstract void DisplayItemType();
 /**
  * Handles display of any item with specific item information 
  */
 abstract void DisplayItemAttr();


}

