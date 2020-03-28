package project;

import java.util.*;

public class FermatFactorization
{
	public static List<Long> FermatFactor(long input)
	{
		List<Long> factor = new ArrayList<Long>();
		
		for(int k = 1; k < Math.sqrt(input); k++) 
		{
			long l = (long) (input + Math.pow(k, 2));
			if(isSquare(l)) 
			{
				factor.add((long) Math.sqrt(l) - k);
				factor.add((long) Math.sqrt(l) + k);
				break;
			}
		}
		
		return factor;
	}
	
	private static boolean isSquare(double input) 
	{
		long sqr = (long) Math.sqrt(input);
		if(sqr*sqr == input || (sqr+1)*(sqr+1)==input)
			return true;
		return false;
	}
}
