package matrix;

import java.util.Scanner;

public class Matrix {


	public static void welcome() {
		System.out.println("Welcome to my matrix calculator!");	
		System.out.println("What would you like to do?");
		System.out.println("1- Matrix Sum");
		System.out.println("2- Matrix Subtraction");
		System.out.println("3- Matrix Multiplication");
	}
	
	
	
	public static void printmatrix(int [][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	
	public static int[][] returnmatrix() {
		Scanner scanner = new Scanner(System.in);
		
		int rows;
		int columns;
		
		do {
			rows = scanner.nextInt();
		if(rows <=0) {
			System.out.println("The number of rows cannot be less than or equal to zero :'(");
		}
		
		}while(rows <=0);
		
		System.out.println("Enter the number of columns for your matrix :D");
		do {
			columns = scanner.nextInt();
		if(columns <=0) {
			System.out.println("The number of rows cannot be less than or equal to zero :'(");
		}
		
		}while(columns <=0);
		
		
		int[][] matrix = new int [rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.println("Row " + (i+1)+ " Column "+ (j+1));
				matrix[i][j]= scanner.nextInt();
			}
		}
		
		
		return matrix;
		
	}
	
	
	
	public static void sum() {
		
		System.out.println("Remembering that to perform a sum between matrices,");
		System.out.println(",they need to have the same size ;-)");
		
		
		
		System.out.println("Enter how many rows do you want for your matrix :D");
		int [][]matrixA = returnmatrix();
		
		System.out.println("Enter the number of rows for your other matrix :D");
		
		int [][]matrixB;
		
		do {
		matrixB = returnmatrix();
			if(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
				System.out.println("Type it again. The matrices are not the same size :(");	
				System.out.println("Enter the number of rows for your other matrix :D");
			}
		
		}while(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length);
		
		
		int [][]result = new int[matrixA.length][matrixA[0].length];
		
		
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA[i].length; j++) {
				
				result[i][j] = matrixA[i][j] + matrixB[i][j];
				
				
			}
		}
		
		System.out.println("The sum of the two matrices is: ");
		printmatrix(result);
		
		
	}
	
	public static void subtraction() {
		
		System.out.println("Remembering that to perform a subtraction between matrices,");
		System.out.println("they need to have the same size ;-)");
		
		
		
		System.out.println("Enter the number of rows for your matrix :D");
		int [][]matrixA = returnmatrix();
		
		System.out.println("Enter the number of rows for your other matrix :D");
		
		int [][]matrixB;
		
		do {
		matrixB = returnmatrix();
			if(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
				System.out.println("Type it again. The matrices are not the same size :( ");	
				System.out.println("Enter the number of rows for your other matrix :D\r\n"
						+ "");
			}
		
		}while(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length);
		
		
		int [][]result = new int[matrixA.length][matrixA[0].length];
		
		
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA[i].length; j++) {
				
				result[i][j] = (matrixA[i][j] - matrixB[i][j]);
				
				
			}
		}
		
		System.out.println("The subtraction of the two matrices is: ");
		printmatrix(result);
		
	}
	
	public static void multiplication() {
		
		System.out.println("Remembering that to perform matrix multiplication,");
		System.out.println("the number of columns of the first matrix must be");
		System.out.println("equal to the number of rows in the second");
		
		System.out.println("Enter the number of rows for your first matrix");
		int[][] matrixA = returnmatrix();
		
		int[][] matrixB;
		
		
		do {
		System.out.println("Enter the number of rows for the second matrix");
			matrixB = returnmatrix();	
			
			if(matrixA[0].length != matrixB.length) {
				System.out.println("The number of rows of the second matrix");
				System.out.println("must be equal to the number of columns in the first");
			}
		
		}while(matrixA[0].length != matrixB.length);
		
		int [][]result = new int [matrixA.length][matrixB[0].length];
		int summation;
		
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixB[0].length; j++) {
				summation = 0;
					for (int k = 0; k < result.length; k++) {
						summation += matrixA[i][k] * matrixB[k][j];
					}
				result[i][j]= summation;	
			
			}
		}
		
		System.out.println("Your matrix is:");
		printmatrix(result);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		welcome();
		int option;
		
		do{
		option = scanner.nextInt();	
			
		if(option != 1 && option != 2 && option !=3) {
			
			System.out.println("Please enter one of the valiable options.");
			
		}	
		}while( option != 1 && option != 2 && option !=3);
		
		if(option==1) {
			sum();
		}else if(option==2){
			subtraction();
		}else {
			multiplication();
		}
			
		scanner.close();
	}

}
