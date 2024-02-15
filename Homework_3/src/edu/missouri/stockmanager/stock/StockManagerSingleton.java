package edu.missouri.stockmanager.stock;

import edu.missouri.stockmanager.media.*;

import java.util.ArrayList;

public class StockManagerSingleton
{
	@SuppressWarnings("unused")
	private static StockManagerSingleton instance;
	
	@SuppressWarnings("unused")
	private final String inventoryFilePath;
	
	@SuppressWarnings("unused")
	private ArrayList<MediaProduct> products;
	
	public StockManagerSingleton() 
	{
		this.inventoryFilePath = "inventory.csv";
	}
	
	public StockManagerSingleton(String filePath) 
	{
		this.inventoryFilePath = filePath;
	}
	
	public boolean initializeStock()
	{
		//TODO
		return false;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		//TODO
		return false;
	}
	
	public boolean addItem(MediaProduct product)
	{
		//TODO
		return false;
	}
	
	public boolean removeItem(MediaProduct product)
	{
		//TODO
		return false;
	}
	
	public boolean saveStock()
	{
		//TODO
		return false;
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList)
	{
		//TODO
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice)
	{
		//TODO
		return new ArrayList<MediaProduct>();
	}
	
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList)
	{
		//TODO
		return new ArrayList<VinylRecordProduct>();
	}
	
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList)
	{
		//TODO
		return new ArrayList<CDRecordProduct>();
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList)
	{
		//TODO
		return new ArrayList<TapeRecordProduct>();
	}
}
