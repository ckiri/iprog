package first;

/**
 * Person.java
 * @author DMaric, DDeifel, CKirakou, DAgres
 * @version 1, 25.10.21
 **/

import java.math.BigInteger;

public class Kgv {
	
	private static BigInteger ggT(BigInteger x, BigInteger y) {
		return y.equals(BigInteger.ZERO) ? x : ggT (y, x.mod(y));
	}
	private static BigInteger rdD(BigInteger x, BigInteger y) {    //rdd = rest der Divison
		return x.mod(y);
	}
	
	private static BigInteger kgV(BigInteger x, BigInteger y) {
		return (x.multiply(y)).divide(ggT(x,y));
	}

	public static void main(String[] args) {

        BigInteger x = MyIO.readBigInteger("Geben Sie ein X-Wert ein: ");
		BigInteger y = MyIO.readBigInteger("Geben Sie ein Y-Wert Zahl ein: ");

		System.out.println("Das kleinste gemeinsame Vielfache von x und y beträgt " + kgV(x, y));
		System.out.println("Der Rest bei der Divison x durch y ist " + rdD(x,y));
	}
}