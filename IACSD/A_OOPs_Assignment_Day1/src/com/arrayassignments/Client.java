package com.arrayassignments;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		
		int n;
		System.out.print("Enter the number of elements in array: ");
		n=in.nextInt();
		
		int []arr=new int[n];
		System.out.println("Enter the array elements: ");
		
		for(int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
		}
		
		System.out.print("\nArray elements are: ");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		Operations obj1=new Operations(arr,n);
		System.out.println("\n\nMax element: "+obj1.maxEle());
		System.out.println("Sum of all elements: "+obj1.sumEle());
		System.out.println("Average of elements: "+obj1.avgEle());
		
		obj1.sortArray();
		System.out.println("Sorted Array: ");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}
