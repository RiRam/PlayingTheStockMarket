import java.util.Scanner;
import java.util.ArrayList;

/*
 * Ri Ram
 * reddit.com/r/dailyprogrammer Challenge #249 Playing the Stock Market
 * https://redd.it/40h9pd
 * 1-27-2016
 */

public class PlayingTheStockMarket {
	
	static ArrayList<Double> arr = new ArrayList<Double>();
	
	public static void main(String[] args)
	{
		readInput();
		System.out.println("Best Trade: " + findBestTrade());
	}
	
	//reads in Double values, fills ArrayList for findBestTrade()
	public static void readInput()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a sequence of double values separated by a space: ");
		String in = input.nextLine();
		String temp = "";
		for(int i = 0; i < in.length(); i++)
		{
			if(in.charAt(i) != ' ')
				temp += in.charAt(i);
			else
			{
				arr.add(Double.parseDouble(temp));
				temp = "";
			}
		}
		input.close();
	}
	
	//finds best trade, returns a String (to be printed System.out)
	public static String findBestTrade()
	{
		double buy = 0, sell = 0;
		for (int i = 0; i < arr.size() - 2; i++) 
		{
	        for (int j = i + 2; j < arr.size(); j++) 
	        {
	            if (arr.get(j) - arr.get(i) > sell - buy)
	            {
	            	buy = arr.get(i);
	            	sell = arr.get(j);
	            }
	        }
		}
		
		return buy + " " + sell;
	}
}

/*
 * Test Input:
 * Enter a sequence of double values separated by a space: 
 * 19.35 19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98
 * Best Trade: 18.88 19.03
 * 
 * Challenge Input:
 * Enter a sequence of double values separated by a space: 
 * 9.20 8.03 10.02 8.08 8.14 8.10 8.31 8.28 8.35 8.34 8.39 8.45 8.38 8.38 8.32 8.36 8.28 8.28 8.38 8.48 8.49 8.54 8.73 8.72 8.76 8.74 8.87 8.82 8.81 8.82 8.85 8.85 8.86 8.63 8.70 8.68 8.72 8.77 8.69 8.65 8.70 8.98 8.98 8.87 8.71 9.17 9.34 9.28 8.98 9.02 9.16 9.15 9.07 9.14 9.13 9.10 9.16 9.06 9.10 9.15 9.11 8.72 8.86 8.83 8.70 8.69 8.73 8.73 8.67 8.70 8.69 8.81 8.82 8.83 8.91 8.80 8.97 8.86 8.81 8.87 8.82 8.78 8.82 8.77 8.54 8.32 8.33 8.32 8.51 8.53 8.52 8.41 8.55 8.31 8.38 8.34 8.34 8.19 8.17 8.16
 * Best Trade: 8.03 9.34
 */
