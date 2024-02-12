package edu.missouri.stockmanager.media;

public class TapeRecordProduct extends MediaProduct
{
	public TapeRecordProduct(String title, double price, int year, Genre genre)
	{
		super(title, price, year, genre);
	}
	
	public TapeRecordProduct(TapeRecordProduct copy)
	{
		super(copy.title, copy.price, copy.year, copy.genre);
	}
	
	public String toString()
	{
		return "Tape: " + super.toString();
	}
}
