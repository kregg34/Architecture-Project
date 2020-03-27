package project;

import java.util.ArrayList;
import java.util.Random;

public class Driver 
{
	public static void main(String [] args) 
	{
		ArrayList <Double> doubleValues = new ArrayList<Double>();
		ArrayList <Float> floatValues = new ArrayList<Float>();
		
		final int NUM_VALUES = 20000000;
		
		final double MIN_DOUBLE = -100000.0;
		final double MAX_DOUBLE =  100000.0;
		
		Random random = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < NUM_VALUES; i++) 
		{
			double randomValue = MIN_DOUBLE + (MAX_DOUBLE - MIN_DOUBLE) * random.nextDouble();
			doubleValues.add(randomValue);
			floatValues.add((float) randomValue);
		}
		
		double resultDouble;
		float resultFloat;
		
		//multiplying double values
		ArrayList<Double> multDoubVals = new ArrayList<Double>();
		
		for(int j = 0; j < 50; j++) 
		{
			long startTime = System.nanoTime();
			
			for(int i = 0; i < NUM_VALUES - 1; i++) 
			{
				resultDouble = doubleValues.get(i) * doubleValues.get(i+1);
			}
			long endTime = System.nanoTime();
			
			double time = (endTime - startTime)/1000000000.0;
			multDoubVals.add(time);
			System.out.println("Time to multiply double values: " + time + " seconds");
		}
		
		
		
		//dividing double values
		ArrayList<Double> divDoubVals = new ArrayList<Double>();
		
		for(int j = 0; j < 50; j++) 
		{
			long startTime = System.nanoTime();
			
			for(int i = 0; i < NUM_VALUES - 1; i++) 
			{
				resultDouble = doubleValues.get(i) / doubleValues.get(i+1);
			}
			long endTime = System.nanoTime();
			
			double time = (endTime - startTime)/1000000000.0;
			divDoubVals.add(time);
			System.out.println("Time to divide double values: " + time + " seconds");
		}
		
		
		
		//multiplying double values
		ArrayList<Double> multFloatVals = new ArrayList<Double>();
		
		for(int j = 0; j < 50; j++) 
		{
			long startTime = System.nanoTime();
			
			for(int i = 0; i < NUM_VALUES - 1; i++) 
			{
				resultDouble = floatValues.get(i) * floatValues.get(i+1);
			}
			long endTime = System.nanoTime();
			
			double time = (endTime - startTime)/1000000000.0;
			multFloatVals.add(time);
			System.out.println("Time to multiply float values: " + time + " seconds");
		}
		
		
		
		//multiplying double values
		ArrayList<Double> divFloatVals = new ArrayList<Double>();
		
		for(int j = 0; j < 50; j++) 
		{
			long startTime = System.nanoTime();
			
			for(int i = 0; i < NUM_VALUES - 1; i++) 
			{
				resultDouble = floatValues.get(i) / floatValues.get(i+1);
			}
			long endTime = System.nanoTime();
			
			double time = (endTime - startTime)/1000000000.0;
			divFloatVals.add(time);
			System.out.println("Time to divide float values: " + time + " seconds");
		}

		System.out.println("\n\nAverage time for mult. doubles: " + getAverage(multDoubVals));
		System.out.println("Average time for div. doubles: " + getAverage(multDoubVals));
		System.out.println("Average time for mult. floats: " + getAverage(multDoubVals));
		System.out.println("Average time for div. floats: " + getAverage(multDoubVals));
	}
	
	private static double getAverage(ArrayList<Double> values)
	{
		double avgVal = 0;
		
		for(int i = 0; i < values.size(); i++)
		{
			avgVal += values.get(i);
		}
		
		return avgVal / values.size();
	}
}
