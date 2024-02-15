package edu.missouri.stockmanager.media;

public class VinylRecordProduct extends MediaProduct
{
	public VinylRecordProduct(String title, double price, int year, Genre genre)
	{
		super(title, price, year, genre);
	}
	
	public VinylRecordProduct(MediaProduct copy)
	{
		super(copy);
	}
	
	public VinylRecordProduct(VinylRecordProduct copy)
	{
		super(copy.title, copy.price, copy.year, copy.genre);
	}
	
	@Override
	public String toString()
	{
		return "Vinyl: " + super.toString();
	}
	
	@Override
	public String toCsv()
	{
		return "Vinyl," + this.title + "," + this.price + "," + this.year + "," + this.genre.toString();
	}
}
