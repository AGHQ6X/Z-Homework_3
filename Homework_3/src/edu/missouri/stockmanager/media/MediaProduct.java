package edu.missouri.stockmanager.media;

public class MediaProduct
{
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	public MediaProduct(String title, double price, int year, Genre genre)
	{
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}
	
	public String toString()
	{
		return this.title + " (" + this.year + ") " + this.genre.toString() + " $" + this.price;
	}
}
