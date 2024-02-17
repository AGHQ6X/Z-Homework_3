package edu.missouri.stockmanager.media;

public class CDRecordProduct extends MediaProduct
{
	public CDRecordProduct(String title, double price, int year, Genre genre)
	{
		super(title, price, year, genre);
	}
	
	public CDRecordProduct(CDRecordProduct copy)
	{
		super(copy.title, copy.price, copy.year, copy.genre);
	}
}
//test