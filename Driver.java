package project;

import java.math.BigInteger;

public class Driver 
{
	public static void main(String [] args)
	{
		
		BigInteger n2 = new BigInteger("91");
		
		double startTime = System.currentTimeMillis();
		System.out.println(TrialDivision.doDivision(n2).toString());
		double endTime = System.currentTimeMillis();
		System.out.println("Time: " + ((endTime-startTime) / 1000.0) + " seconds");
		
		startTime = System.currentTimeMillis();
		System.out.println(FermatFactorization.FermatFactor(n2).toString());
		endTime = System.currentTimeMillis();
		System.out.println("Time: " + ((endTime-startTime) / 1000.0) + " seconds");
		System.out.println();

	}
}
