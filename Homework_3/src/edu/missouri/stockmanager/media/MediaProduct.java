package edu.missouri.stockmanager.media;

//import Homework_3.src.edu.missouri.stockmanager.media.Genre;

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
	
	//setters
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,",
				getClass(),
				getTitle(),
				getPrice(),
				getYear(),
				getGenre());
	}
	
	//getters
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	
	public int getYear(){
		return year;
	}
	public Genre getGenre() {
		return genre;
	}
}
//test