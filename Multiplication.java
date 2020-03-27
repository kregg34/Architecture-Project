package project;

public class Multiplication 
{
	private Register muliplicand = new Register();
	private Register muliplier = new Register();
	private Register product = new Register();
	
	double candD = Driver.num1;
	double lierD = Driver.num2;
	
	float candS = Driver.num1;
	float lierS = Driver.num2;
	
	double productD = candD*lierD;
	
	float productS = candS*lierS;
	
}
