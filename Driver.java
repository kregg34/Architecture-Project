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
		
		String value1 = toIEEE754Format(num1);
		System.out.println(value1);
		
		
		//Test register and control class
		Register r1 = new Register();
		r1.setBits(value1);
		
		System.out.println("Sign: " + Control.extractSign(r1));
		System.out.println("Exponent: " + Control.extractExponent(r1));
		System.out.println("Mantissa: " + Control.extractMantissa(r1));
		
		/*
		 * Now we will manually divide and multiply FP numbers
		 * using the procedure used in the textbook
		 */
		

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
