package com.fruitbasket;

import java.util.Scanner;

public class FruitUtility {
	
	public static void displayAllFruit(Fruit[] f,int i){
		for(int j=0;j<i;j++)
		{
			System.out.println(f[j].name);
		}
	}
	
	public static void displayBasket(Fruit[] f, int i) {
		for (int j = 0; j < i; j++) {
			System.out.println(f[j].taste());
			
			System.out.println(f[j]);
			/*
			 * if(f[j].fresh) { System.out.println("Fresh Fruit!"); } else {
			 * System.out.println("Stale Fruit!"); }
			 */
			System.out.println();
		}
	}
	
	public static void displaySF(Fruit[] f,int ind)
	{
		if (f[ind] instanceof Apple) {
			((Apple) f[ind]).jam();
		}
		if (f[ind] instanceof Orange) {
			((Orange) f[ind]).juice();
		}
		if (f[ind] instanceof Mango) {
			((Mango) f[ind]).pulp();
		}
	}
	
	public static void markSourStale(Fruit[] f,int ind)
	{
		for(int j=0;j<ind;j++)
		{
			/*
			 * if(f[j] instanceof Orange) f[j].fresh=false;
			 */
			String str="sour";
			if(f[j].taste().equalsIgnoreCase(str))
			{
				f[j].fresh=false;
			}
		}
	}
}