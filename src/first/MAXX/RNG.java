package first.MAXX;

import java.math.BigInteger;
import java.util.Random;

/**
 * RNG: Generiert eine random Fraction für das MAXX Spiel
 * @author Dennis Deifel, Dennis Maric, Chris Kiriakou, Yunus Turan, Dominik Agres
 * @version 1, 12.01.2022
 **/

public class RNG {

    public static Fraction randomNumber() {
        int MAX = 999;                      //MAX wert (1000-1 = 999)
        int MIN = 10;                       //MIN wert (10)
        BigInteger random1;                 //zähler
        BigInteger random2;                 //nenner
        boolean kurzbar;                    //ist die Zahl Kurzbar boolean

        //Zähler Zuweisung:
        long y = (long) new Random().nextInt((MAX - MIN + 1)) + MIN;        //Random zahl generiert
        random1 = BigInteger.valueOf(y);                                    //Hier wird die Zahl zugewiesen

        //Nenner Zuweisung:
        do {
            long x = (long) new Random().nextInt((MAX - MIN + 1)) + MIN;    //Random zahl generiert
            random2 = BigInteger.valueOf(x);                                //Hier wird die Zahl zugewiesen

            kurzbar = false;                                                // es ist nicht kurzbar. Eig. Irrelevant

            int i = 100;                                                    //checkt, ob die zahl durch einer dieser teilbar ist
            do{
                BigInteger iBig =  BigInteger.valueOf(i);
                BigInteger nennerMod = random1.mod(iBig);
                BigInteger zaehlerMod = random2.mod(iBig);                  //Falschrum bennant
                i--;
                if ((nennerMod.equals(0) && zaehlerMod.equals(0)) || nennerMod.equals(zaehlerMod)) {
                    kurzbar = true;                                         //falls einer dieser Kriterien erfüllt sind, dann ist die Zahl kurzbar
                    break;
                }                                                           //sonst passiert nichts
            } while (i != 1);                                               //für alle 100
        } while (kurzbar);

        return new Fraction(random1, random2);  //Erstellung einer Frachtion die returned wird
    }

}

