package first;

import java.math.BigInteger;
import java.util.Random;

public class MAXX {

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

    public static String top(){
        return "---------------------------------------------------------------------------------";
    }
    public static String side(){
        return "|";
    }

    public static void print2DBrett (Fraction[][] brett){

        for (int i = 0; i < brett.length; i++) {       //row
            System.out.println(top());
            for (int j = 0; j < brett[i].length; j++) {   //column
                brett[i][j] = randomNumber();
                System.out.printf(  side() + " " +  brett[i][j] + " ");
                if (j == brett[i].length - 1) System.out.print(side());
            }
            System.out.println();
            if (i == brett.length - 1) System.out.print(top());
        }
    }

    public static void main(String[] args) {
        Fraction[][] brett = new Fraction[8][8];
        print2DBrett(brett);
    }
}
