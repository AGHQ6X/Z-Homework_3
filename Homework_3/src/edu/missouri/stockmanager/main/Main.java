package edu.missouri.stockmanager.main;

import edu.missouri.stockmanager.stock.StockManagerSingleton;

public class Main
{
	//Main method to test program with
	public static void main(String[] args)
	{
		//Create a stock manager object
		StockManagerSingleton sms = new StockManagerSingleton("inventoryCopy.csv");
		
		//Initialize stock from file
		sms.initializeStock();
		
		//Print list of stock
		sms.printListOfMediaProduct();
		
		//Save stock to file
		sms.saveStock();
	}
}
