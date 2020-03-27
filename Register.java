/*
 * Represents a floating point register.
 */

public class Register 
{
	//registers are 64 bit
	private final int SIZE = 64;
	
	//The value stored in the register
	private String bits = "";
	
	public Register()
	{
		initBits();
	}
	
	private void initBits() 
	{
		for(int i = 0; i < SIZE; i++) 
		{
			bits += "0";
		}
	}

	public String getBits() 
	{
		return bits;
	}
	
	public void setBits(String bits)
	{
		this.bits = bits;
	}
}
