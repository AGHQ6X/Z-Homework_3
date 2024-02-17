package Homework_3.src.edu.missouri.stockmanager.stock;
import Homework_3.src.edu.missouri.stockmanager.media.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



public class StockManagerSingleton
{
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
	
	public ArrayList<MediaProduct> getProducts() {
		return this.products;
	}
	
	public boolean initializeStock()
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath))){
			products = new ArrayList<>();
			
			//Read the .csv file
			String line;
			
			boolean firstLine = true;
			
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (firstLine) {
					//skip first line here
					firstLine = false;
					continue;
				}
				if (parts.length == 5) {
					String type = parts[0].trim();
					String title = parts[1].trim();
					double price = Double.parseDouble(parts[2].trim());
					int year = Integer.parseInt(parts[3].trim());
					Genre genre = Genre.valueOf(parts[4].trim());
					//create appropriate product object depending upon 
					MediaProduct product;
					switch(type) {
					case "CD":
						product = new CDRecordProduct(title, price, year, genre);
						break;
					case "Tape":
						product = new TapeRecordProduct (title, price, year, genre);
						break;
					case "Vinyl":
						product = new VinylRecordProduct (title, price, year, genre);
						break;
					default:
						product = new MediaProduct (title, price, year, genre);
						break;
						
					}
					
					//add whatever kind of product to the array list
					products.add(product);
				}
			}
			return true;
		}catch (IOException | IllegalArgumentException e){
			e.printStackTrace();
			return false;
			 
		}
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		if(products != null) {
			for(MediaProduct existingProduct : products) {
				if (existingProduct.equals(product)) {
					existingProduct.setPrice(newPrice);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean addItem(MediaProduct product)
	{
		if (products != null && !products.contains(product)) {
			products.add(product);
		System.out.println("Successfully added product!");
		return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeItem(MediaProduct productToRemove)
	{
		if(products != null) {
			for (Iterator<MediaProduct> iterator = products.iterator(); iterator.hasNext();) {
				MediaProduct currentProduct = iterator.next();
				if(currentProduct.getTitle().equals(productToRemove.getTitle())) {
					iterator.remove();
					return true;
				}
			}
		}
			
		return false;
	}
	
	public boolean saveStock()
	{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryFilePath))){
			if (products != null) {
				for(MediaProduct product : products) {
					writer.write(product.toString());
					writer.newLine();
				}
			}
			System.out.println("Successfully Saved!");
			return true;

			
		}catch(IOException e){
			System.out.println("Save failed.");
			e.printStackTrace();
			return false;
		}
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList, Class<? extends MediaProduct> productType)
	{
		if(productList != null) {
			for(MediaProduct product :productList) {
				if( productType.isInstance(product)) {
					System.out.println("Title: " + product.getTitle() + ", Price: " + product.getPrice()
									+ ", Year: " + product.getYear() + ", Genre: " + product.getGenre());
				}
			}
		}
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice)
	{
		ArrayList<MediaProduct> belowPriceProducts = new ArrayList<>();
		if(products != null) {
			for(MediaProduct product : products) {
				if(product.getPrice() <maxPrice) {
					belowPriceProducts.add(product);
				}
			}
		}
		return new ArrayList<MediaProduct>();
	}
	
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList)
	{
		ArrayList<VinylRecordProduct> vinylRecords = new ArrayList<>();
		if (productList != null) {
			for (MediaProduct product: productList) {
				if(product instanceof VinylRecordProduct) {
					vinylRecords.add((VinylRecordProduct) product);
				}
			}
		}
			
		
		return new ArrayList<VinylRecordProduct>();
	}
	
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList)
	{
		ArrayList<CDRecordProduct> CDRecords = new ArrayList<>();
		if (productList != null) {
			for (MediaProduct product: productList) {
				if(product instanceof CDRecordProduct) {
					CDRecords.add((CDRecordProduct) product);
				}
			}
		}
			
		
		return new ArrayList<CDRecordProduct>();
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList)
	{
		ArrayList<TapeRecordProduct> tapeRecords = new ArrayList<>();
		if (productList != null) {
			for (MediaProduct product: productList) {
				if(product instanceof TapeRecordProduct) {
					tapeRecords.add((TapeRecordProduct) product);
				}
			}
		}
			
		
		return new ArrayList<TapeRecordProduct>();
	}
}
//test
