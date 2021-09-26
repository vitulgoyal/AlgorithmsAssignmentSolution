package com.gl.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.gl.beans.Stock;

public class StockServices {


	private Stock[] stocksArray;
	private Stock[] ascendingStocks;
	private Stock[] descendingStocks;

	Scanner sc = new Scanner(System.in);
	int choice;

	public void getUserInputs() {

		System.out.println("Enter the number of companies: \n");
		Integer noOfComp = sc.nextInt();
		stocksArray = new Stock[noOfComp];

		for(int i = 0; i<noOfComp; i++) {
			System.out.println("Enter current stock price of the company " + (i + 1) + "\n");
			Double stockPrice = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday? \n");
			Boolean isStockPriceRise = sc.nextBoolean();
			Stock stock = new Stock(stockPrice, isStockPriceRise);
			stocksArray[i] = stock;
		}
		displayOperations();
	}

	public void displayOperations() {

		do {

			System.out.println("Enter the operation that you want to perform.");
			System.out.println("1. Display the companies stock prices in ascending order.");
			System.out.println("2. Display the companies stock prices in descending order.");
			System.out.println("3. Display the total no of companies for which stock prices rose today.");
			System.out.println("4. Display the total no of companies for which stock prices declined today.");
			System.out.println("5. Search a specific stock price.");
			System.out.println("6. press 0 to exit.");

			choice = sc.nextInt();

			switch (choice) {

			case 0:
				System.out.println("Exited successfully");
				break;

			case 1: {
				displayStocks(true);
			}
			break;

			case 2: {
				displayStocks(false);
			}
			break;

			case 3: {
				displayRoseStockes();
			}
			break;

			case 4: {
				displayDeclinedStockes();
			}
			break;

			case 5: {
				searchStock();
			}
			break;

			default:
				System.out.println("Invalid choice. Enter a valid no.\n");
				break;
			}

		} while (choice != 0);

	}

	private void displayStocks(Boolean isAscending) {
		if (isAscending) {
			if (ascendingStocks == null) {
				ascendingStocks = new Stock[stocksArray.length];
				Arrays.sort(stocksArray);
				ascendingStocks = stocksArray;
				System.out.println(Arrays.toString(ascendingStocks));
			} else {
				System.out.println(Arrays.toString(ascendingStocks));
			}
		} else {
			if (descendingStocks == null) {
				descendingStocks = new Stock[stocksArray.length];
				Arrays.sort(stocksArray,Collections.reverseOrder());
				descendingStocks = stocksArray;
				System.out.println(Arrays.toString(descendingStocks));
			} else {
				System.out.println(Arrays.toString(descendingStocks));
			}
		}
	}

	private void displayRoseStockes() {
		Integer length = Arrays.stream(stocksArray).filter(x -> x.getIsSharePriceRise()).toArray().length;
		System.out.println("Total no of companies whose stock price rose today: " + length);
	}

	private void displayDeclinedStockes() {
		Integer length = Arrays.stream(stocksArray).filter(x -> !x.getIsSharePriceRise()).toArray().length;
		System.out.println("Total no of companies whose stock price declined today: " + length);
	}

	private void searchStock() {
		System.out.println("Enter the key value");
		Double stockPrice = sc.nextDouble();
		boolean isExists = false;
        for (Stock element : stocksArray) {
            if (element.getStockPrice().equals(stockPrice)) {
            	isExists = true;
                break;
            }
        }
		if (isExists) {
			System.out.println("Stock of value " +  stockPrice + " is present");
		} else {
			System.out.println("Stock of value " +  stockPrice + " is not present");
		}
	}

}
