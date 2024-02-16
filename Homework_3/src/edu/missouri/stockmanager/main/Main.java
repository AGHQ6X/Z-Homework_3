package edu.missouri.stockmanager.main;

import edu.missouri.stockmanager.media.*;
import edu.missouri.stockmanager.stock.StockManagerSingleton;

import java.util.ArrayList;

public class Main
{
	//Main method to test program with
	public static void main(String[] args)
	{
		//Create a stock manager object
		StockManagerSingleton sms = StockManagerSingleton.getSingleton();
		
		//Initialize stock from file
		sms.initializeStock();
		
		//Print list of items below $25
		ArrayList<MediaProduct> al = sms.getMediaProductBelowPrice(25);
		
		ArrayList<VinylRecordProduct> vr = sms.getVinylRecordList(al);
		ArrayList<MediaProduct> vm = new ArrayList<MediaProduct>(vr.size());
		vr.forEach(element -> vm.add((MediaProduct) element));
		
		ArrayList<CDRecordProduct> cr = sms.getCDRecordsList(al);
		ArrayList<MediaProduct> cm = new ArrayList<MediaProduct>(cr.size());
		cr.forEach(element -> cm.add((MediaProduct) element));
		
		ArrayList<TapeRecordProduct> tr = sms.getTapeRecordList(al);
		ArrayList<MediaProduct> tm = new ArrayList<MediaProduct>(tr.size());
		tr.forEach(element -> tm.add((MediaProduct) element));
		
		sms.printListOfMediaProduct(vm);
		sms.printListOfMediaProduct(cm);
		sms.printListOfMediaProduct(tm);
	}
}
