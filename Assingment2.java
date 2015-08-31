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
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Inventory List; //Init Object List Here
        
        int choices;
        int sku,quan;
        float price;
        String title;
        char cate_type;   
        
        //Start of input Serialize 
        try
        {
            FileInputStream fis = new FileInputStream ("InventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
    
            List = (Inventory)ois.readObject();
               
            fis.close();
            //ois.close();
        }
        catch(FileNotFoundException e) {
            List = new Inventory();
            System.out.println("Cannot find database.");
        }
        catch(IOException e) { 
            List = new Inventory();
            System.out.println("Problem with file input");}
        catch(ClassNotFoundException e) {
            List = new Inventory();
            System.out.println("Class not found on input from file");}
        
        //Display menu of Inventory
        do
        {
        
        System.out.println("Please pick between choices 1 - 6");
        System.out.println("1. Add a item to the inventory");
        System.out.println("2. Remove a item from the inventory");
        System.out.println("3. Display the information for item");
        System.out.println("4. Display the inventory in a table");
        System.out.println("5. Make a sell ");
        System.out.println("6. Quit");
        Scanner scan = new Scanner(System.in); //Get the input value from user for menu 
        choices = scan.nextInt();
        
        //Add Movie
        if(choices == 1)
        {
            
            System.out.print("Please add SKU of item  ");
            sku = scan.nextInt();          
            System.out.print("Please add quanity of item ");
            quan = scan.nextInt();
            System.out.print("Please add price of item $");
            price = scan.nextFloat();
            System.out.print("Please add title for item ");
            scan.nextLine();
            title = scan.nextLine();
            System.out.println("Indicate what item this:(M),(B),or (T)");
            cate_type = scan.next().charAt(0);
            if(cate_type == 'M' || cate_type ==  'm')
            {
                
                System.out.println("Please enter UPC number for movie entry");
                int user_upc = scan.nextInt();
                if(List.SkuCheck(sku) &&  
                   List.QuanityCheck(quan) && 
                   List.PriceCheck(price))
                {
                    //Create Object for Movie
                    List.AddItem(user_upc,sku,quan,price,title);
                    System.out.println("Movie was added to Inventory");
                }             
            }
            if(cate_type == 'B' || cate_type == 'b')
            {
                System.out.println("Enter the author of this book.");
                scan.nextLine();
                String user_author = scan.nextLine();
                System.out.println("Enter the ISBN number for the book");
                int user_isbn = scan.nextInt();
                if(List.SkuCheck(sku) && 
                   List.QuanityCheck(quan) && 
                   List.PriceCheck(price))
                {
                  //Create Object for Book  
                  List.AddItem(user_isbn,user_author,sku,quan,price,title);
                  System.out.println("Book was added to Inventory");  
                }
                
            }
            if(cate_type == 'T' || cate_type == 't')
            {
                System.out.println("Please enter the weight of this toy.");
                float user_weight = scan.nextFloat();
                if(List.SkuCheck(sku) &&  
                   List.QuanityCheck(quan) && 
                   List.PriceCheck(price))
                {
                   //Create Object for Toy
                   List.AddItem(user_weight,sku,quan,price,title);
                   System.out.println("Toy was  added to Inventory");
                }
            }
        }
        if(choices == 2) //Remove Movie
        {
            System.out.println("Select which item you want to delete by SKU");
            //Display List for user to see Inventory
            List.DisplayInventory();
            sku = scan.nextInt();
            List.RemoveItem(sku);
        }
        if(choices == 3) //Display Item
        {
            System.out.println("Select which item you want to view by SKU");
            sku = scan.nextInt();
            List.DisplayIt(sku);
            System.out.println();
        }
        if(choices == 4) //Display Inventory
        {
            List.DisplayInventory();
        }
        if(choices == 5)//Sell a Product
        {
            System.out.println("Enter the SKU of item you want to purchase.");
            sku = scan.nextInt();
            System.out.println("Please enter shipping quanity of purchase.");
            quan = scan.nextInt();
            System.out.print("Please enter shipping cost for sale. $");
            price = scan.nextFloat();
            List.Sale(sku,quan,price);
        }
        if(choices == 6)//Quit
        {
            //Serialize Output to InventoryFile
            try
            {
             FileOutputStream fos = new FileOutputStream("InventoryFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
       
             oos.writeObject(List);
             
            System.out.println("Your output file has been updated.");
             //oos.close();
             fos.close();
            }
            catch(IOException e){
                System.out.println("Problem with file output");}
        }    
            
        
        }while(choices != 6);
    }
    }
   
