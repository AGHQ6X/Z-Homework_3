package edu.missouri.stockmanager.stock;

import edu.missouri.stockmanager.media.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class StockManagerSingleton
{
	private final String inventoryFilePath;
	private ArrayList<MediaProduct> products;
	
	public StockManagerSingleton() 
	{
		//Set default filepath
		this.inventoryFilePath = "inventory.csv";
		
		//Create empty product list
		this.products = new ArrayList<MediaProduct>();
	}
	
	public StockManagerSingleton(String filePath) 
	{
		//Set custom filepath
		this.inventoryFilePath = filePath;
		
		//Create empty product list
		this.products = new ArrayList<MediaProduct>();
	}
	
	public boolean initializeStock()
	{
		//Create a reader object
		BufferedReader reader;
				
		//File opening
		try
		{
			//Initialize reader
			reader = new BufferedReader(new FileReader(this.inventoryFilePath));
			
			//Check if empty
			if (reader.readLine() == null)
			{
				//Print error
				System.out.println("File empty.");
				
				//Close the reader
				reader.close();
				
				//File was empty
				return false;
			}
			
			//Read first CSV line
			String line = reader.readLine();
			
			//Loop through lines
			while (line != null)
			{
				//Separate values by commas
				String[] values = line.split(",", 5);
				
				//Make sure we have enough values
				if (values.length == 5)
				{
					//Parse values
					String title = values[1];
					double price = Double.parseDouble(values[2]);
					int year = Integer.parseInt(values[3]);
					Genre genre = Genre.valueOf(values[4]);
					
					//Check which type of media it is
					if (values[0].equals("CD"))
					{
						this.products.add(new CDRecordProduct(title, price, year, genre));
					}
					else if (values[0].equals("Tape"))
					{
						this.products.add(new TapeRecordProduct(title, price, year, genre));
					}
					else if (values[0].equals("Vinyl"))
					{
						this.products.add(new VinylRecordProduct(title, price, year, genre));
					}
					else
					{
						this.products.add(new MediaProduct(title, price, year, genre));
					}
				}
				
				//Read next CSV line
				line = reader.readLine();
			}
			
			//Close reader
			reader.close();
		} 
		catch (IOException e)
		{
			//Print error
			System.out.println("File read error: " + e.toString());
			
			//File read failed
			return false;
		}
		
		//If it got here, it succeeded
		return true;
	}
	
	public boolean saveStock()
	{
		//Create a writer object
		BufferedWriter writer;
						
		//File opening
		try
		{
			//Initialize reader
			writer = new BufferedWriter(new FileWriter(this.inventoryFilePath, false));
					
			//Write opening line
			writer.write("Type,Title,Price,Year,Genre");
			writer.newLine();
			
			//Loop through lines
			for (MediaProduct product : this.products)
			{
				//Write the product CSV conversion string to file
				writer.write(product.toCsv());
				writer.newLine();
			}
				
			//Close reader
			writer.close();
		} 
		catch (IOException e)
		{
			//Print error
			System.out.println("File write error: " + e.toString());
				
			//File read failed
			return false;
		}
			
		//If it got here, it succeeded
		return true;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		//Get index of first occurrence
		int index = this.products.indexOf(product);
		
		//Check if product was found
		if (index >= 0)
		{
			//Change price
			this.products.get(index).setPrice(newPrice);
			
			//Product was found
			return true;
		}
		else
		{
			//Product was not found
			return false;
		}
	}
	
	public boolean addItem(MediaProduct product)
	{
		//Add the product to the product list
		return this.products.add(product);
	}
	
	public boolean removeItem(MediaProduct product)
	{
		//Remove the product from the product list
		return this.products.remove(product);
	}
	
	public void printListOfMediaProduct()
	{
		//Just call the other method on our product array
		this.printListOfMediaProduct(this.products);
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList)
	{
		//Print the top message
		System.out.println("List of media products:");
		
		//Loop through all products
		for (MediaProduct product : productList) 
		{
			System.out.println(" " + product.toString());
		}
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
