package project;

import java.math.BigInteger;

public class Driver 
{
	public static void main(String [] args)
	{
		BigInteger n1 = new BigInteger("89765129");
		System.out.println("Test 1: Should be 9257*9697");
		System.out.println(TrialDivision.doDivision(n1).toString());
		System.out.println(FermatFactorization.FermatFactor(n1).toString());
		System.out.println();
		
		BigInteger n2 = new BigInteger("150");
		System.out.println("Test 2: Should be 2*3*5*5");
		System.out.println(TrialDivision.doDivision(n2).toString());
		System.out.println(FermatFactorization.FermatFactor(n2).toString());
		System.out.println();
		
		BigInteger n3 = new BigInteger("232058627");
		System.out.println("Test 3: Should be 15107*15361");
		System.out.println(TrialDivision.doDivision(n3).toString());
		System.out.println(FermatFactorization.FermatFactor(n3).toString());
		System.out.println();
		

		BigInteger n4 = new BigInteger("1000000000000000");
		System.out.println("Test 4: Some large number");
		System.out.println(TrialDivision.doDivision(n4).toString());
		System.out.println(FermatFactorization.FermatFactor(n4).toString());
		System.out.println();
	}
}
