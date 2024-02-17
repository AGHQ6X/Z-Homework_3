package edu.missouri.stockmanager.stock;

import edu.missouri.stockmanager.media.*;

import java.util.ArrayList;

public class StockManagerSingleton
{
	@SuppressWarnings("unused")
	private stat ic StockManagerSingleton instance;
	
	@SuppressWarnings("unused")
	private final String inventoryFilePath;
	
	@SuppressWarnings("unused")
	private ArrayList<MediaProduct> products;
	
	public StockManagerSingleton() 
	{ 
		this.inventoryFilePath = "inventory.csv";
		this.products = new ArrayList<>;
	}
	
	public StockManagerSingleton(String filePath) 
	{
		this.inventoryFilePath = filePath;
	}
	
	public boolean initializeStock()
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath))) {
			String line;
			while ((line = reader.readline()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 4) {
					String title = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    int year = Integer.parseInt(parts[2]);
                    Genre genre = Genre.valueOf(parts[3]);
                    MediaProduct product;	
                    
                    if (parts[3].equals("VINYL")) {
                        product = new VinylRecordProduct(title, price, year, genre);
                    } else if (parts[3].equals("CD")) {
                        product = new CDRecordProduct(title, price, year, genre);
                    } else if (parts[3].equals("TAPE")) {
                        product = new TapeRecordProduct(title, price, year, genre);
                    } else {
                        continue;
                    }
                    products.add(product);
                }
            }
            return true;
            
        } catch (IOException e) {
        		e.printStackTrace();
        		return false;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		for (MediaProduct p : products) {
            if (p.equals(product)) {
                p.setPrice(newPrice);
                return true;
		return false;
	}
	
	public boolean addItem(MediaProduct product)
	{
		return products.add(product);
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
