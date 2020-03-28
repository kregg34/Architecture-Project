package project;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class FermatFactorization
{
	public static List<BigInteger> FermatFactor(BigInteger input)
	{
		List<BigDecimal> factor = new ArrayList<BigDecimal>();
		List<BigInteger> factor2 = new ArrayList<BigInteger>();
		
		for(BigInteger k = new BigInteger("1"); k.compareTo(input.sqrt()) == -1 ; k = k.add(BigInteger.ONE)) 
		{
			BigInteger l = input.add(square(k)); //n+k^2 = l^2
			
			if(isSquare(l)) 
			{
				factor.add(new BigDecimal(l).sqrt(new MathContext(0)).subtract(new BigDecimal(k)));
				factor.add(new BigDecimal(l).sqrt(new MathContext(0)).add(new BigDecimal(k)));
				break;
			}
		}
		
		
		for(BigDecimal b: factor) {
			factor2.add(b.toBigInteger());
		}
		return factor2;
	}
	
	private static BigInteger square(BigInteger x)
	{
		BigInteger sq = new BigInteger("0");
		
		sq = sq.add(x);
		sq = sq.multiply(sq);
		
		return sq;
	}
	
	private static boolean isSquare(BigInteger input) 
	{
		BigDecimal sqr = new BigDecimal(input).sqrt(new MathContext(100));
		sqr = sqr.subtract(sqr.setScale(0, RoundingMode.UP));
		
		return (sqr == BigDecimal.ZERO);
	}
}
