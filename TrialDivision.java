import java.util.*;
public class TrialDivision {

	int input = 52;
	int pid = 2;
	List<Integer> factors = new ArrayList<Integer>();
	Object[] factorsArr;
	
    Object[] doDivision(){
	do {
		if(input%pid == 0) {
			factors.add(pid);
			input = input/pid;
		}
		else {
			pid = pid+1;
		}
	}while(input >= pid*pid);
	factorsArr = factors.toArray();
	return factorsArr;
	}
}
