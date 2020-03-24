package project;

import java.util.BitSet;

/*
 * Control class is "static" and is able to modify the registers
 */

public class Control 
{
	//Index range for different parts of the floating point number
	private static final int BIT_POSITION_SIGN     = 63;
	private static final int [] BIT_RANGE_EXPONENT = {62, 52};
	private static final int [] BIT_RANGE_MANTISSA = {51,  0};
	
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
		BitSet signBit = new BitSet(1);
		
		signBit.set(0, register.getBits().get(BIT_POSITION_SIGN));
		
		return signBit;
	}
	
	public static BitSet extractExponent(Register register) 
	{
		BitSet exponentBits = new BitSet(11);
		
		for(int i = BIT_RANGE_EXPONENT[1]; i <= BIT_RANGE_EXPONENT[0]; i++) 
		{
			exponentBits.set(i, register.getBits().get(i));
		}
		
		return exponentBits;
	}
	
	public static BitSet extractMantissa(Register register) 
	{
		BitSet mantissaBits = new BitSet(52);
		
		for(int i = BIT_RANGE_MANTISSA[1]; i <= BIT_RANGE_MANTISSA[0]; i++) 
		{
			mantissaBits.set(i, register.getBits().get(i));
		}

		return mantissaBits;
	}
}
