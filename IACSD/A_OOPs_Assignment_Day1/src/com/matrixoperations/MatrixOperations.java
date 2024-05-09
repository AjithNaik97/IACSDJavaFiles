package com.matrixoperations;

public class MatrixOperations {

	private int [][]arr1;
	private int [][]arr2;
	private int [][]summat;
	private int [][]submat;
	private int [][]mulmat;
	private int [][]tmat;
	private int r1,c1,r2,c2;
	
	public MatrixOperations()
	{
		r1=0;
		r2=0;
		c1=0;
		c2=0;
	}
	
	public MatrixOperations(int [][]arr1,int r1,int c1,int [][]arr2,int r2,int c2)
	{
		this.arr1=arr1;
		this.r1=r1;
		this.c1=c1;
		this.arr2=arr2;
		this.r2=r2;
		this.c2=c2;
	}
	
	//Addition of two matrices
	
	public void addMatrix()
	{
		summat=new int[r1][c1];
		if(r1==r2&&c1==c2)
		{
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c1;j++)
				{
					summat[i][j]=arr1[i][j]+arr2[i][j];
				}
			}
			
			System.out.println("\nSum of two Matrices 1 and 2: ");
			
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c1;j++)
				{
					System.out.print(summat[i][j]+" ");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("\nMatrix addition not possible!");
		}
	}
	
	//Subtraction of two Matrices
	
	public void subMatrix()
	{
		submat=new int[r1][c1];
		if(r1==r2&&c1==c2)
		{
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c1;j++)
				{
					submat[i][j]=arr1[i][j]-arr2[i][j];
				}
			}
			
			System.out.println("\nSubtraction of two Matrices 1 and 2: ");
			
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c1;j++)
				{
					System.out.print(submat[i][j]+" ");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("\nMatrix subtraction not possible!");
		}
	}

	//Multiplication of two Matrices

	public void mulMatrix()
	{
		if(r1==c2)
		{
			mulmat=new int[r1][c2];
			System.out.println("\nMultiplication of two Matrices 1 and 2:");
			
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c2;j++)
				{
					mulmat[i][j]=0;
					
					for(int k=0;k<r2;k++)
					{
						mulmat[i][j]+=arr1[i][k]*arr2[k][j];
					}
					System.out.print(mulmat[i][j]+" ");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("\nMatrix multiplication not possible!");
		}
			
	}
	
	//Transpose of a Matrix
	
	public void transMatrix(int arr[][],int r,int c)
	{
		tmat=new int[c][r];
		System.out.println("\nTranspose of the Matrix 1: ");
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<r;j++)
			{
				tmat[i][j]=arr[j][i];
				System.out.print(tmat[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	//Scalar Multiplication
	
	public void smulmat(int arr[][],int r,int c,int s)
	{
		System.out.println("\nScalar multiplication of Matrix 1 with "+s+" is:");
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(s*arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//Symmetric Matrix
	
	public void checkSymmetric(int arr[][],int r,int c)
	{
		if(r==c)
		{
			boolean status=false;
			tmat=new int[c][r];
			for(int i=0;i<c;i++)
			{
				for(int j=0;j<r;j++)
				{
					tmat[i][j]=arr[j][i];
				}
			}
			for(int i=0;i<c;i++)
			{
				for(int j=0;j<r;j++)
				{
					if(tmat[i][j]==arr[i][j])
					{
						status=true;
					}
					else
					{
						status=false;
						break;
					}
				}
			}
			if(status)
			{
				System.out.println("\n Matrix 1 is a Symmetric Matrix.");
			}
			else
			{
				System.out.println("\nMatrix 1 is not a symmetric Matrix!");
			}
		}
		else
		{
			System.out.println("\nMatrix 1 is not a symmetric Matrix!");
		}
	}
}





