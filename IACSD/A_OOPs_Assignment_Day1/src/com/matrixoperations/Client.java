package com.matrixoperations;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int r1,c1,r2,c2,s;
		
		System.out.println("Enter row and column of Matrix 1:");
		Scanner in=new Scanner(System.in);
		r1=in.nextInt();
		c1=in.nextInt();
		
		int [][]arr1=new int[r1][c1];
		System.out.println("Enter the elements of the Matrix 1:");
		for(int i=0;i<r1;i++)
		{
			for(int j=0;j<c1;j++)
			{
				arr1[i][j]=in.nextInt();
			}
		}
		
		System.out.println("Enter row and column of Matrix 2:");
		r2=in.nextInt();
		c2=in.nextInt();
		
		int [][]arr2=new int[r2][c2];
		System.out.println("Enter the elements of the Matrix 2:");
		for(int i=0;i<r2;i++)
		{
			for(int j=0;j<c2;j++)
			{
				arr2[i][j]=in.nextInt();
			}
		}
		
		System.out.println("\nMatrix 1:");
		for(int i=0;i<r1;i++)
		{
			for(int j=0;j<c1;j++)
			{
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\nMatrix 2:");
		for(int i=0;i<r2;i++)
		{
			for(int j=0;j<c2;j++)
			{
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		MatrixOperations obj=new MatrixOperations(arr1,r1,c1,arr2,r2,c2);
		obj.addMatrix();
		obj.subMatrix();
		obj.mulMatrix();
		obj.transMatrix(arr1, r1, c1);
		
		System.out.print("\nEnter the number to be multiplied with Matrix 1: ");
		s=in.nextInt();
		obj.smulmat(arr1,r1,c1,s);
		obj.checkSymmetric(arr2, r2, c2);
		
	}

}
