package project;

public class Driver 
{
	public static void main(String [] args)
	{
		int n = 89765129;
		System.out.println("Test 1: Should be 9257*9697");
		System.out.println(TrialDivision.doDivision(n).toString());
		System.out.println(FermatFactorization.FermatFactor(n).toString());
		System.out.println();
		
		//Fermat's method won't work here since 150 is not the product of two primes
		//(It is the product of 4)
		int n2 = 150;
		System.out.println("Test 2: Should be 2*3*5*5");
		System.out.println(TrialDivision.doDivision(n2).toString());
		System.out.println(FermatFactorization.FermatFactor(n2).toString());
		System.out.println();
		
		int n3 = 232058627;
		System.out.println("Test 3: Should be 15107*15361");
		System.out.println(TrialDivision.doDivision(n3).toString());
		System.out.println(FermatFactorization.FermatFactor(n3).toString());
		System.out.println();
	}
}
