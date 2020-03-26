package project;

import java.util.BitSet;

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
		
		BitSet set = toBitSet(value1);
		printBitSet(set);
		
		//Test register and control class
		Register r1 = new Register();
		r1.setBits(set);
		
		BitSet sign = Control.extractSign(r1);
		BitSet exp = Control.extractExponent(r1);
		BitSet mantissa = Control.extractMantissa(r1);
		
		System.out.println("\nExtracting the sign, exp, mantissa...");
		printBitSet(sign);
		printBitSet(exp);
		printBitSet(mantissa);
		
		/*
		 * Now we will manually divide and multiply FP numbers
		 * using the procedure used in the textbook
		 */
		

	}
	
	private static void printBitSet(BitSet bitset) 
	{
		for(int i = 0; i < bitset.size(); i++)
		{
			if(bitset.get(i)) {
				System.out.print("1");
			}else {
				System.out.print("0");
			}
		}
		System.out.println();
	}
	
	private static BitSet toBitSet(String ieee754FormatNum) 
	{
		BitSet ieee754BitSet = new BitSet(64);
		
		for(int i = 0; i < ieee754FormatNum.length(); i++)
		{
			if(ieee754FormatNum.charAt(i) == '0') {
				ieee754BitSet.set(i, false);
			}else {
				ieee754BitSet.set(i, true);
			}
		}
		
		return ieee754BitSet;
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
