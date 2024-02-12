package edu.missouri.stockmanager.media;

public class VinylRecordProduct extends MediaProduct
{
	public VinylRecordProduct(String title, double price, int year, Genre genre)
	{
		super(title, price, year, genre);
	}
	
	public VinylRecordProduct(VinylRecordProduct copy)
	{
		super(copy.title, copy.price, copy.year, copy.genre);
	}
	
	public String toString()
	{
		return "Vinyl: " + super.toString();
	}
}
