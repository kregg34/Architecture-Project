import java.util.*;

public class FermatFactorization {

	
	public Object[] FermatFactor(long input) {
		long num1 = (long) Math.ceil(Math.sqrt(input));
		long num2 = num1 * num1 - input;
		while(isSquare(num2))
		{
			num1++;
			num2 = num1*num1-input;
		}
		long root1 = num1 - (long)Math.sqrt(num2);
		long root2 = input / root1;
		
		List<Long> factor = new ArrayList<Long>();
		factor.add(root1);
		factor.add(root2);
		
		return factor.toArray();
	}
	public boolean isSquare(long input) {
		long sqr = (long) Math.sqrt(input);
		if(sqr*sqr == input || (sqr+1)*(sqr+1)==input)
			return true;
		return false;
	}
}
