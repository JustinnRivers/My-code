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
public class Assignment1  {

    /**
     * @param args the command line arguments
     * Main function driver class 
     * @return The Program is finished and output of InventoryFile to view
     */
    public static void  main(String[] args) {
        Inventory List = new Inventory(); //Init Object List Here
        int choices;
        int user_sku,user_quan;
        float user_price;
        String user_title;
 
        //Start of input Serialize 
        try
        {
            FileInputStream fis = new FileInputStream ("InventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
    
            List = (Inventory)ois.readObject();
               
            fis.close();
            ois.close();
        }
        catch(FileNotFoundException e) { System.out.println("Cannot find database.");}
        catch(IOException e) { }
        catch(ClassNotFoundException e) {System.out.println("Class not found on input from file");}
        
        
        //Display menu of Inventory
        do
        {
        
        System.out.println("Please pick between choices 1 - 5");
        System.out.println("1. Add a movie to the inventory");
        System.out.println("2. Remove a movie from the inventory");
        System.out.println("3. Display the information for a movie");
        System.out.println("4. Display the inventory in a table");
        System.out.println("5. Quit ");
        Scanner scan = new Scanner(System.in); //Get the input value from user for menu 
        choices = scan.nextInt();
        
        if(choices == 1) //Add Movie
        {
            System.out.print("Please add SKU of item");
            user_sku = scan.nextInt();          
            System.out.print("Please add quanity of item");
            user_quan = scan.nextInt();
            System.out.print("Please add price of item $");
            user_price = scan.nextFloat();
            System.out.print("Please add title of movie");
            scan.nextLine();
            user_title = scan.nextLine();
            
            //Check to see if any inputs are invalid then create item in Inventory
            if(List.SkuCheck(user_sku) &&  List.QuanityCheck(user_quan) && List.PriceCheck(user_price))
            {
               System.out.println("Your movie was successfully added to Inventory");
               System.out.println();
               List.AddMovie(user_sku, choices, user_price, user_title);    
            }
        }
        if(choices == 2) //Remove Movie
        {
            System.out.println("Please select which Movie you want to delete by SKU");
            //Display List for user to see Inventory
            List.DisplayInventory();
            user_sku = scan.nextInt();
            List.RemoveMovie(user_sku);
        }
        if(choices == 3) //Display Movie
        {
            System.out.println("Please select which Movie you want to view by SKU");
            user_sku = scan.nextInt();
            List.DisplayMovie(user_sku);
        }
        if(choices == 4) //Display Inventory
        {
            List.DisplayInventory();
        }
        if(choices == 5)//Quit
        {
            //Serialize Output to InventoryFile
            try
            {
             FileOutputStream fos = new FileOutputStream("InventoryFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
       
             oos.writeObject(List);
       
             oos.close();
             fos.close();
            }
            catch(IOException e) {System.out.println("Problem with file output");}
              
        }
        
        }while(choices != 5);
    }
    
}
