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
       
