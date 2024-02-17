package edu.missouri.stockmanager.main;
import edu.missouri.stockmanager.stock.StockManagerSingleton;
import edu.missouri.stockmanager.media.CDRecordProduct;
import edu.missouri.stockmanager.media.Genre;
import edu.missouri.stockmanager.media.MediaProduct;
//import edu.missouri.stockmanager.media.TapeRecordProduct;
//import edu.missouri.stockmanager.media.VinylRecordProduct;
//import java.util.ArrayList;
//test1
public class Main
{
	//Main method to test program with
	public static void main(String[] args)
	{
		//Instantiate Singleton Function
		StockManagerSingleton stockManager = new StockManagerSingleton();
		
		//check if the stock is initialized
		if (stockManager.initializeStock()) {
			System.out.println("Successfully Initialized!");
		}
		else {
			System.out.println("Failed to Initialize...");
		}
		//add a new CD
		CDRecordProduct CD = new CDRecordProduct("Melodrama", 10.00, 2017, Genre.ELECTRONIC); 
		stockManager.addItem(CD);
		
		//Update Existing item's price
		MediaProduct existingProduct = stockManager.getProducts().get(0);
		stockManager.updateItemPrice(existingProduct, 19.99);
		
		//remove an item
		String titleToRemove = "Rumours";
		//dummy instance for removal
		MediaProduct productToRemove = new MediaProduct(titleToRemove, 0.0, 0, Genre.ROCK);
		stockManager.removeItem(productToRemove);
		
		//show list of products of a type
		System.out.println("Current Products");
		stockManager.printListOfMediaProduct(stockManager.getProducts(), CDRecordProduct.class);
		
		//get list of products below a given price
		stockManager.getMediaProductBelowPrice(20);
		
		stockManager.getVinylRecordList(stockManager.getProducts());
		stockManager.getCDRecordsList(stockManager.getProducts());
		stockManager.getTapeRecordList(stockManager.getProducts());
		
		
		
		
	}
}