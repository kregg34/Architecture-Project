package project;

import java.util.BitSet;

/*
 * Control class is "static" and is able to modify the registers
 */

public class Control 
{
	//Index range for different parts of the floating point number
	private static final int BIT_POSITION_SIGN     = 0;
	private static final int [] BIT_RANGE_EXPONENT = {11, 1};
	private static final int [] BIT_RANGE_MANTISSA = {63, 12};
	
	private static BitSet exponent_bias = new BitSet(10);
	
	public Control()
	{
		//Sets the bias to 1023 in binary
		exponent_bias.set(0, 9);
	}
	
	public static BitSet getBias()
	{
		return exponent_bias;
	}
	
	public static BitSet extractSign(Register register)
	{
		BitSet signBit = new BitSet();
		
		boolean bit = register.getBits().get(BIT_POSITION_SIGN);
		signBit.set(63, bit);
		
		System.out.println(signBit.length());
		
		return signBit;
	}
	
	public static BitSet extractExponent(Register register) 
	{
		BitSet exponentBits = new BitSet();
		
		for(int i = BIT_RANGE_EXPONENT[1]; i <= BIT_RANGE_EXPONENT[0]; i++) 
		{
			exponentBits.set(i - BIT_RANGE_EXPONENT[1] + 53, register.getBits().get(i));
		}
		
		return exponentBits;
	}
	
	public static BitSet extractMantissa(Register register) 
	{
		BitSet mantissaBits = new BitSet();
		
		for(int i = BIT_RANGE_MANTISSA[1]; i <= BIT_RANGE_MANTISSA[0]; i++) 
		{
			mantissaBits.set(i - BIT_RANGE_MANTISSA[1] + 12, register.getBits().get(i));
		}

		return mantissaBits;
	}
}
