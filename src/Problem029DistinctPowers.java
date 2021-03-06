import java.math.BigInteger;
import java.util.ArrayList;

// How many distinct terms are in the sequence generated by a^b for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?

public class Problem029DistinctPowers {
	
	private int getAnswer(){
		
		int aMin = 2;
		int aMax = 100;
		int bMin = 2;
		int bMax = 100;
		BigInteger term;
		ArrayList<BigInteger> terms = new ArrayList<BigInteger>();
		
		for (int a=aMin; a<=aMax; a++){
			for (int b=bMin; b<=bMax; b++){
				term = (getTerm(BigInteger.valueOf(a*a),a,b-1));
				if(!terms.contains(term)){
					terms.add(term);
				}
			}
		}
		
		return terms.size();
	}

	private BigInteger getTerm(BigInteger aSquared, int a, int b) {
				
		if(b > 1){
			aSquared = getTerm(aSquared.multiply(BigInteger.valueOf(a)), a, b-1);
		}
	    return aSquared;
		
	}

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println("Answer: " + (new Problem029DistinctPowers().getAnswer()));
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");

	}

}
