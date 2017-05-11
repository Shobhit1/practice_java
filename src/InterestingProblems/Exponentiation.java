package InterestingProblems;


public class Exponentiation 
{
	public long exponent(int number, int power, int mod){
		if(power > 1){
			long s = exponent(number, power/2,mod);
			if (!(power % 2 ==0)){
				return (long)((s*s)*number) % mod;
			}
			else{
				return (long)(s*s) % mod;
			}
		}
		else if (power == 1){
			return (long) (number % mod);
		}
		else{
			return -1;
		}
	}
	
	/**
	 * Functions for fibonacci series generation
	 */

	
	public static void main(String[] args){
		System.out.println(new Exponentiation().exponent(3,11,8));
	}
}
