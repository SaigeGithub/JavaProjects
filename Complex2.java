/*
Instance methods are usually called by object, the data in instance
method that each object created is stored in different area of the 
memory,  different from main or other Object. So if the static
method want to use the data in instance method, it must use the 
object as a reference.
Static method is valid for the whole class, and the data stored in 
them is shared among all the objects.
*/


// NAME: Complex2.java
// PURPOSE:  create and manipulate Complex Number objects
// AUTHOR:  Saige Liu V00812068
// DATE: 2014/1/19
// CREDITS: none - Maybe the instructions from the teacher

public class Complex2 {
	private int real;
	private int imaginary;

	//Default Constructor
	public Complex2 () {
		this.real = 0;
		this.imaginary = 0;
	}

	//Constructor for a new complex number, with:
	//  input- real component = r
	//  input- imaginary component = i 
	public Complex2 (int r, int i) {
		this.real = r;
		this.imaginary = i;
	}

	//Constructor for a new complex number, with:
	//  input- real component = r
	//  input- imaginary component = 0
	public Complex2 (int r) {
		this.real = r;
		this.imaginary = 0;
	}
	
	//The upper three methods are all the constructor for a new object,but the parameters are different.
	
	//Accessor for the real component attribute 
	//output:real
	public int getReal() {
		return this.real;
	}
	
	//Mutator for the real component attribute
	//input:real
	public void setReal(int real) {
		this.real = real;
	}

	//Accessor for the imaginary component attribute
	//output:imaginary
	public int getImaginary() {
		return this.imaginary;
	}

	//Mutator for the imaginary component attribute
	//input:imaginary
	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	
	//return a complex number whose value is the sum of  the two object
	//input: Complex2 other
	//output: new Complex2
	public Complex2 add(Complex2 other) {
		return new Complex2(real+ other.real,imaginary +other.imaginary);
	}

	//return a complex number whose value is the difference between the two object
	//input: Complex2 other
	//output: new Complex2
	public Complex2 subtract(Complex2 other) {
		return new Complex2 (real -other.real,imaginary-other.imaginary);
	}

	//return a complex number whose value is the product of the two object
	//input: Complex2 other
	//output: new Complex2
	public Complex2 multiply(Complex2 other) {
		return new Complex2(real*other.real-imaginary*other.imaginary, imaginary*other.real+real*other.imaginary);
	}

	//return a complex number whose value is the quotient of the two object
	//input: Complex2 other
	//output: new Complex2
	public Complex2 divide(Complex2 other) {
		return new Complex2((real*other.real+imaginary*other.imaginary)/(other.real*other.real+other.imaginary*other.imaginary), (imaginary*other.real-real*other.imaginary)/(other.real*other.real+other.imaginary*other.imaginary));
	}
	//the upper four methods is used to input two complex number
	//object and do some calculation and then output them.
	
	//toString method is used to print out the object in this class
	// if the imaginary number is 0, it will not show it,
	//if it is less than 0, the number will be reversed.
	//if it is bigger than 0, it will be just like what it should be.
	public String toString() {
		String result = "";
		if(imaginary>0){
			result += real + " + " + imaginary + "i";
			}
		else if(imaginary==0){
			result +=real ;
			}
		else if(imaginary<0){
			result +=real + " - " + -imaginary + "i";
			}
		return result;
	}

	//the main method here is like a Tester to test whether the 
	//upper methods are wrote correctly by print them out in the screen.
	public static void main(String [] args) {

		System.out.println("Complex Number Tester Output:");

		// Test the new constructor for Real (only) numbers
		Complex2 aReal = new Complex2(423);
		System.out.print("Real Constructor Test: Should Output 423 : ");
		System.out.println(aReal.toString());

		// Instantiate some more complex numbers
		Complex2 oneValue = new Complex2(-3,4);
		Complex2 anotherValue = new Complex2(2,-1);

		// Test add:  oneValue + anotherValue
		System.out.print("Add Tester: Should Output -1 + 3i : ");
		System.out.println(oneValue.add(anotherValue));

		// Test subtract:  oneValue - anotherValue
		System.out.print("Subtract Tester: Should Output -5 + 5i : ");
		System.out.println(oneValue.subtract(anotherValue));

		// Test multiply:  oneValue * anotherValue
		System.out.print("Multiply Tester: Should Output -2 + 11i : ");
		System.out.println(oneValue.multiply(anotherValue));

		// Test divide:  oneValue / anotherValue
		System.out.print("Divide Tester: Should Output -2 + 1i : ");
		System.out.println(oneValue.divide(anotherValue));

	}
}
