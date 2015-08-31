/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Justinn Rivers
 * @author Dennis Sager
 * 
 * Movie class handles data of individual movie item
 */
import java.io.*;

public class Movie implements Serializable {

    //Private data fields in Movie Class
    private int sku;
    private int quanity;
    private float price;
    private String title;
 
/*
Constructor default for Movie Class  with user input with sku,quanity,price,title
*/
Movie(int in_sku,int in_quanity,float in_price,String in_title)
{
    sku = in_sku;
    quanity = in_quanity;
    price = in_price;
    title = in_title;
}
/*
Check to see if Sku is unique 
@return : True if sku is unique and false if otherwise
*/
public boolean CompareSku(int Sku)
{
   if(Sku == sku) return true;
   return false;
}

/*
Display Movie and attritubes 
*/
public void DisplayMovie()
{
    System.out.format("%4d%7d           $%5.2f        %20s",sku,quanity,price,title);
    System.out.println();  
}

}
