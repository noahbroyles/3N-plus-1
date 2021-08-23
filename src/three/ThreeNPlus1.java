package three;

import java.math.BigInteger;

public abstract class ThreeNPlus1 {
	
	public static final BigInteger zero = BigInteger.ZERO;
	public static final BigInteger one = BigInteger.ONE;
	public static final BigInteger two = BigInteger.TWO;
	public static final BigInteger three = new BigInteger("3");
	
	public static BigInteger calc3n(BigInteger n) {
		if (n.mod(two) == zero) {
			n = n.divide(two);
		} else {
			n = (n.multiply(three)).add(one);
		}
		return n;
	}

}
