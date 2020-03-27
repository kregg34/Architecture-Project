package project;

/*
 * Used to control what tests are performed.
 * Also will be used for bench marks?
 */

public class Driver 
{
	public static void main(String [] args) 
	{
		//some test numbers for debugging
		double num1 = -11465665464567.753232;
		double num2 = 14028385.123591;											//a random number (multiplier/dividend)
		
		String value1 = toIEEE754Format(num1);
		String value2= toIEEE754Format(num2);
		System.out.println(value1);
		System.out.println(value2);
		
		
		//Test register and control class
		Register r1 = new Register();
		r1.setBits(value1);
		Register r2 = new Register();											
		r2.setBits(value2);														//setbits
		
		
		
		System.out.println("Sign: " + Control.extractSign(r1));					
		System.out.println("Exponent: " + Control.extractExponent(r1));
		System.out.println("Mantissa: " + Control.extractMantissa(r1));
		
		System.out.println("Sign: " + Control.extractSign(r2));					
		System.out.println("Exponent: " + Control.extractEzxponent(r2));
		System.out.println("Mantissa: " + Control.extractMantissa(r2));
		
		
		/*
		 * Now we will manually divide and multiply FP numbers
		 * using the procedure used in the textbook
		 */
		
		System.out.println("Single Point Multiplication: "+toIEEE754Format(Multiplication.productS));
		System.out.println("Double Point Multiplication: "+toIEEE754Format(Multiplication.productD));
		

	}
	
	private static String toIEEE754Format(double value) 
	{
		String ieee754Str = "";
		
		//If a number is positive, the sign bit is 0, this is left out
		//of the conversion... so have to add it on manually.
		if(value > 0)
		{
			ieee754Str += "0";
		}
		
		ieee754Str += Long.toBinaryString(Double.doubleToRawLongBits(value));
		
		return ieee754Str;
	}
}
