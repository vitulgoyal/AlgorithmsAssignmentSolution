package com.gl.beans;


public class Stock implements Comparable<Stock> {
	
	private Double stockPrice;
	private Boolean isSharePriceRise;
	
	public Stock(Double stockPrice,Boolean isSharePriceRise) {
		this.stockPrice =  stockPrice;
		this.isSharePriceRise = isSharePriceRise;
	}
	
	public Double getStockPrice() {
		return stockPrice;
	}
	
	public Boolean getIsSharePriceRise() {
		return isSharePriceRise;
	}

	@Override
	public int compareTo(Stock other) {
		// TODO Auto-generated method stub
		
		return this.stockPrice == other.stockPrice ? 0 : this.stockPrice > other.stockPrice ? 1 : -1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " " + stockPrice;
	}

}
