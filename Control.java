package project;

/*
 * Control class is "static" and is able to modify the registers
 */

public class Control 
{
	//Index range for different parts of the floating point number
	private static final int BIT_POSITION_SIGN     = 0;
	private static final int [] BIT_RANGE_EXPONENT = {11, 1};
	private static final int [] BIT_RANGE_MANTISSA = {63, 12};
	
	private static String exponent_bias = "1111111111";
	
	public static String getBias()
	{
		return exponent_bias;
	}
	
	public static String extractSign(Register register)
	{
		String signBit = "";
		
		signBit += register.getBits().charAt(BIT_POSITION_SIGN);
		
		return signBit;
	}
	
	public static String extractExponent(Register register) 
	{
		String exponentBits = "";
		
		for(int i = BIT_RANGE_EXPONENT[1]; i <= BIT_RANGE_EXPONENT[0]; i++) 
		{
			exponentBits += register.getBits().charAt(i);
		}
		
		return exponentBits;
	}
	
	public static String extractMantissa(Register register) 
	{
		String mantissaBits = "";
		
		for(int i = BIT_RANGE_MANTISSA[1]; i <= BIT_RANGE_MANTISSA[0]; i++) 
		{
			mantissaBits += register.getBits().charAt(i);
		}

		return mantissaBits;
	}
}
