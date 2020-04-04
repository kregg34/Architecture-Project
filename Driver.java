package project;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Driver 
{
	private static Random randomGenerator = new Random(System.currentTimeMillis());
	private static final int NUM_OF_TESTS = 10;
	
	private static final int MIN_PRIME_VAL = 2000000;
	private static final int MAX_PRIME_VAL = 4000000;
	
	
	public static void main(String [] args)
	{
		ArrayList<Double> timesTrial = new ArrayList<Double>();
		ArrayList<Double> timesFermat = new ArrayList<Double>();
		
		System.out.println("Finding primes and creating test cases...");
		ArrayList<Integer> primes = getPrimes();
		ArrayList<BigInteger> numsToFactor = createComposite(primes);
		
		System.out.println("\nTest beginning now... (Number of tests = " + NUM_OF_TESTS + ")");

		for(int i = 0; i < numsToFactor.size(); i++)
		{
			System.out.println("Currently factoring: " + numsToFactor.get(i));
			
			double startTime = System.currentTimeMillis();
			TrialDivision.doDivision(numsToFactor.get(i));
			double endTime = System.currentTimeMillis();
			timesTrial.add((endTime-startTime) / 1000);
			
			startTime = System.currentTimeMillis();
			FermatFactorization.FermatFactor(numsToFactor.get(i));
			endTime = System.currentTimeMillis();
			timesFermat.add((endTime-startTime) / 1000);
		}
		
		System.out.println("Test done!");
		
		System.out.println("\nData: (in seconds)");
		System.out.println("Trial\t\tFermat");
		for(int i = 0; i < timesTrial.size(); i++) 
		{
			System.out.print(timesTrial.get(i) + "\t\t" + timesFermat.get(i));
			if(timesTrial.get(i) > timesFermat.get(i)) {
				System.out.println("\t\tFermat Won!");
			}else {
				System.out.println("\t\tTrials Won!");
			}
		}
	}

	private static ArrayList<BigInteger> createComposite(ArrayList<Integer> primes) 
	{
		ArrayList<BigInteger> compNums = new ArrayList<BigInteger>();
		
		for(int i = 0; i < NUM_OF_TESTS; i++)
		{
			BigInteger prime1 = new BigInteger(randomSelect(primes) + "");
			BigInteger prime2 = new BigInteger(randomSelect(primes) + "");
			compNums.add(prime1.multiply(prime2));
		}
		
		return compNums;
	}

	//Fermat Primality Test
	private static ArrayList<Integer> getPrimes(){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> aRange = new ArrayList<Integer>();
		final int INITIAL_N = MIN_PRIME_VAL;
		final int T = 5;
		
		for(int i = 2; i < INITIAL_N - 1; i++)
		{
			aRange.add(i);
		}
		
		//get primes in a given range
		for(int n = INITIAL_N; n < MAX_PRIME_VAL; n++) 
		{
			boolean isLiklyPrime = true;
			for(int i = 0; i < T; i++) 
			{
				//randomly select a in range 2 to n-2
				int a = randomSelect(aRange);
				
				if(computeModExp(a, n-1, n) != 1)
				{
					isLiklyPrime = false;
				}
			}
			
			if(isLiklyPrime)
			{
				primes.add(n);
			}
			
			aRange.add(n - 1);
		}
		
		return primes;
	}
	
	//Select a random element
    private static int randomSelect(ArrayList<Integer> array)
    {
        return array.get(randomGenerator.nextInt(array.size()));
    }

    //Fast Modular Exponentiation
	private static int computeModExp(int a, int exp, int modBase)
	{
	    long x1 = 1;
	    long x2 = a;
	    while(exp > 0)
	    {
	    	if(exp%2 == 1)
	    	{
	    		x1= (x1*x2) % modBase;
	    	}
	    	
	    	x2 = (x2*x2) % modBase;
	    	exp /= 2;
	    }
	    
	    return (int) x1 % modBase;
	}
}
