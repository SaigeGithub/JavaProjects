// NAME: ComplexExerciser.java
// PURPOSE:  using the Complex1 class to create different complex numbers and then print them out
// AUTHOR:  Saige Liu V00812068
// DATE:  2014/1/19
// CREDITS: none - Maybe the instructions from the teacher
import java.util.Scanner;
import java.io.*;

public class ComplexExerciser{

	public static void main(String args[]) throws FileNotFoundException{
		
		Complex1 one = new Complex1(2,4);
		System.out.println("First complex number:"+one);
		Complex1 two  = new Complex1(4,-5);
		System.out.println("Second complex number:"+two);
		Scanner inFile = new Scanner(new File("ComplexData.txt"));
		int size= inFile.nextInt();
		Complex1[] num = new Complex1[size];
		System.out.println("From File: ");
		for(int i =0; i< size; i++){
			num[i]= new Complex1();
			num[i].setReal(inFile.nextInt());
			num[i].setImaginary(inFile.nextInt());
			
			System.out.println(num[i]);
		}
		}










}