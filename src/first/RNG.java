package first;

import java.math.BigInteger;
import java.util.Random;

public class RNG {
    public static Fraction randomNumber(){
        BigInteger randomNumber0;
        BigInteger randomNumber1;

        BigInteger upperLimit = BigInteger.valueOf(999);

        do {
            randomNumber0 = new BigInteger(upperLimit.bitLength(), new Random() );
        } while (randomNumber0.compareTo(upperLimit) >= 0 && randomNumber0.equals(0));
        do {
            randomNumber1 = new BigInteger(upperLimit.bitLength(), new Random() );
        } while (randomNumber1.compareTo(upperLimit) >= 0);

        Fraction a = new Fraction(randomNumber0, randomNumber1);

        if (a.isInteger() ){
            a = randomNumber();
            return a;
        } else return a;

    }
}
