// NOTE: This program will not compile until method stubs or methods are added!

// STUDENT:  Saige Liu V00812068
// DATE:  2014/2/28
// CREDITS: none 
// NAME: a3Tester
// PURPOSE:  Solve Mathematical functions, like x^n and e^x iteratively and then recursively
//     and then more efficiently using recursion.
// AUTHOR:  LillAnne Jackson
// DATE: Januayr 2014
// CREDITS: The ideas for the problems: from the Carrano and Prichard textbook

import java.util.*;
import java.io.*;

public class a3Tester {


	//just use a for loop to make the x multiply n times
	static double powerOne(double x,long n){
		double total=1;
		for(int i=0;i<n;i++){
			total=total*x;
		}
			
		return total;
	}
	
	//a normal recursive method call itself until n=0
	static double powerTwo(double x,long n){
		double total=0;
		if (n==0){
			total=1;
		}
		else{
			total=x*powerTwo(x,n-1);
		}
			
		return total;
	}

	//a different way to do recursion, but the same idea,following the assignment's lead.
	static double powerThree(double x,long n){
		double total=0;
		if( n>=0){
			if (n==0){
				total=1;
			}else if(n%2==0){
				total=powerThree(x,n/2)*powerThree(x,n/2);
			}else{
				total=x*powerThree(x,n/2)*powerThree(x,n/2);
			}
		}
			
		return total;
	}
	// fact is number multiply each other from 1 to x.
	static double factOne(double x){
		double total =1;
		for(int i=1;i<=x;i++){
			total = i*total;
		}
		return total;
	}
	//a recursive way to do face, call the number and multiply one by one
	static double factTwo(double x){
		double total=0;
		if(x==0){
			total=1;
		}else{
			total=x*factTwo(x-1);
		}	
		return total;
	}
	// e^n is the number power/fact add every time. 
	static double eOne(double x, long n){
		double total=1;
		if(n==0){
			total=1;
		}else{
			for(long k=n;k>0;k--){
				double fact =1;
				for(int i=1;i<=k;i++){
					fact = i*fact;
				}
				double power=1;
				for(int i=0;i<k;i++){
					power=power*x;
				}
				total=total+power/fact;
			}
		}
		return total;
	}
	// I use the two methods above to achieve it.
	static double eTwo(double x,long n){
		double total=1;
		if(n==0){
			total=1;
		}else{
			total=eTwo(x,n-1)+powerTwo(x,n)/factTwo(n);
		}
		return total;
	}
	// This is the hardest part, we need to use three parameters to achieve it, so I 
	//create a new method and put 1 in it ,to make the recursion done, because the recursion starts at 1 and end at x.
	static double eThree(double x,long n){
		if (n < 1) {
			return 0;
		} else {
			return calcu(x,1,n);
		}
	}
	public static double calcu(double x, double m, double n) {
		if (m>= n) {
			return 1 + x/m;
		} else {
			return 1 + x/m * calcu(x,m+1,n);
		}
	}

	public static boolean test(double result, Scanner testData) {
			return (Math.abs(result - testData.nextDouble()) < 0.00000000001);
	}

	public static void main (String [] args) throws FileNotFoundException{

		// File input
		Scanner in = new Scanner(new File("TestData.txt"));
		Scanner testIn = new Scanner(new File("TestResult.txt"));

		System.out.println(" M A T H   T E S T E R \n\n" );
		System.out.println(" Methods Written by: Saige Liu");
		System.out.println("   ID:  V00812068  February 2014");

		// First line of file is number of data points:
		int numPoints = in.nextInt();

	    for (int i=0; i < numPoints; i++ ) {

			//skip title line in file
			in.next();

			// Data for testing x^n methods
			double base = in.nextDouble();
			int exponent = in.nextInt();

			// x^n test calls
			System.out.println(" *********************************");
			System.out.println(" Iterative x^n with x= " + base + " and n= " + exponent + ": ");
			double data = powerOne(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive x^n (#1) with x= " + base + " and n= " + exponent + ": ");
			data = powerTwo(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive x^n (#2) with x= " + base + " and n= " + exponent + ": ");
			data = powerThree(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			// Data for testing n! methods
			//skip title line in file
			in.next();
			int n = in.nextInt();

			// x^n test calls

			System.out.println(" *********************************");
			System.out.println(" Iterative n! with n= " + n +  ": ");
			data = factOne((double)n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive n! with n= " + n + ": ");
			data = factTwo((double)n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			// Data for testing e^x methods
			//skip title line in file
			in.next();
			double x = in.nextDouble();
			n = in.nextInt();

			// x^n test calls

			System.out.println(" *********************************");
			System.out.println(" Iterative e^x with x= " + x + "("+ n + " terms): ");
			data = eOne(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive e^x (#1) with x= " + x + "("+ n + " terms): ");
			data = eTwo(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive e^x (#2) with x= " + x + "("+ n + " terms): ");
			data = eThree(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			//in.nextLine();
		}
	}


}


