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
	
	public MediaProduct(MediaProduct copy)
	{
		this.title = copy.title;
		this.price = copy.price;
		this.year = copy.year;
		this.genre = copy.genre;
	}
	
	@Override
	public String toString()
	{
		return this.title + " (" + this.year + ") " + this.genre.toString() + " $" + this.price;
	}
	
	public String toCsv()
	{
		return "Product," + this.title + "," + this.price + "," + this.year + "," + this.genre.toString();
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public Genre getGenre()
	{
		return genre;
	}

	public void setGenre(Genre genre)
	{
		this.genre = genre;
	}
}
