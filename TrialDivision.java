package project;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TrialDivision
{

	private static BigInteger pid;
	private static List<BigInteger> factors = new ArrayList<BigInteger>();
	
    public static List<BigInteger> doDivision(BigInteger input)
    {
    	pid = new BigInteger("2");
    	factors.clear();
    	
		do 
		{
			if(input.mod(pid) == BigInteger.ZERO) 
			{
				factors.add(pid);
				input = input.divide(pid);
			}
			else
			{
				pid = pid.add(BigInteger.ONE);
			}
		}while(input.compareTo(BigInteger.ONE) == 1);
		
		return factors;
	}
}
