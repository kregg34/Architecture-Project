package project;

import java.util.BitSet;

/*
 * Represents a floating point register.
 */

public class Register 
{
	//registers are 64 bit
	private final int SIZE = 64;
	
	//The value stored in the register
	private BitSet bits = new BitSet(SIZE);
	
	public BitSet getBits() 
	{
		return bits;
	}
	
	public void setBits(BitSet bits)
	{
		this.bits = bits;
	}
}
