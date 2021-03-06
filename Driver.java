package project;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Driver 
{
	private static Random randomGenerator = new Random(123456789);
	private static final int NUM_OF_TESTS = 100;
	private static final int MIN_PRIME_VAL = 98000;
	private static final int MAX_PRIME_VAL = 100000;
	
	
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
			
			double startTime = System.nanoTime();
			TrialDivision.doDivision(numsToFactor.get(i));
			double endTime = System.nanoTime();
			timesTrial.add((endTime-startTime) / 1000000000);
			
			startTime = System.nanoTime();
			FermatFactorization.FermatFactor(numsToFactor.get(i));
			endTime = System.nanoTime();
			timesFermat.add((endTime-startTime) / 1000000000);
		}
		
		System.out.println("Test done!");
		
		System.out.println("\nData: (in seconds)");
		System.out.println("Trial\t\t\tFermat");
		for(int i = 0; i < timesTrial.size(); i++) 
		{
			System.out.print(timesTrial.get(i) + "\t\t" + timesFermat.get(i));
			if(timesTrial.get(i) > timesFermat.get(i)) {
				System.out.println("\tFermat Won!");
			}else {
				System.out.println("\tTrials Won!");
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
		final int INITIAL_N = MIN_PRIME_VAL;
		final int T = 5;
		
		//get primes in a given range
		for(int n = INITIAL_N; n < MAX_PRIME_VAL; n++) 
		{
			boolean isLiklyPrime = true;
			for(int i = 0; i < T; i++) 
			{
				//randomly select a in range 2 to n-2
				int a = ThreadLocalRandom.current().nextInt(2, n - 1);
				if(computeModExp(a, n-1, n) != 1)
				{
					isLiklyPrime = false;
				}
			}
			
			if(isLiklyPrime)
			{
				primes.add(n);
			}
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
