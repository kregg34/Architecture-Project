package project;

import java.util.*;
public class TrialDivision
{

	private static long pid;
	private static List<Integer> factors = new ArrayList<Integer>();
	
    public static List<Integer> doDivision(long input)
    {
    	pid = 2;
    	factors.clear();
    	
		do 
		{
			if(input % pid == 0) 
			{
				factors.add((int)pid);
				input = input/pid;
			}
			else
			{
				pid++;
			}
		}while(input > 1);
		
		return factors;
	}
}
