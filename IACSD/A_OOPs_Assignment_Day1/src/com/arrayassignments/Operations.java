package com.arrayassignments;

public class Operations {

	private	int []arr;
	private int mx,min;
	private	int n;
	private double sum=0;
	public Operations(int []arr, int n)
	{
		this.arr=arr;
		this.n=n;
	}
	
	//Max Element Method
	public int maxEle()
	{
			mx=arr[0];
			for(int i=0;i<n;i++)
			{
				if(mx<arr[i])
				{
					mx=arr[i];
				}
			}
			return mx;
	}
	
	//Sum of all elements
	public double sumEle()
	{
		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];
		}
		return sum;
	}
	
	//Average of all elements in the array
	public double avgEle()
	{
		sum=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];
		}
		return sum/n;
		
	}
	
	//Sorting elements
	public void sortArray()
	{
		int temp;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}
