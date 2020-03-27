import java.util.*;
public class TrialDivision {

	long pid = 2;
	List<Long> factors = new ArrayList<Long>();
	Object[] factorsArr;
	
    public Object[] doDivision(long input){
	do {
		if(input%pid == 0) {
			factors.add(pid);
			input = input/pid;
		}
		else {
			pid = pid++;
		}
	}while(input >= pid*pid);
	factorsArr = factors.toArray();
	return factorsArr;
	}
}
