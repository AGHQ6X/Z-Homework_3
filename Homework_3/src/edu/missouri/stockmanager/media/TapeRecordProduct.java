package edu.missouri.stockmanager.media;

public class TapeRecordProduct extends MediaProduct
{
	public TapeRecordProduct(String title, double price, int year, Genre genre)
	{
		super(title, price, year, genre);
	}
	
	public TapeRecordProduct(MediaProduct copy)
	{
		super(copy);
	}
	
	public TapeRecordProduct(TapeRecordProduct copy)
	{
		super(copy.title, copy.price, copy.year, copy.genre);
	}
	
	@Override
	public String toString()
	{
		return "Tape: " + super.toString();
	}
	
	@Override
	public String toCsv()
	{
		return "Tape," + this.title + "," + this.price + "," + this.year + "," + this.genre.toString();
	}
}
