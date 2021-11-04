package first;

import java.math.BigInteger;

public class TryMyIO {
	  public static void main (String[] arg) {

	    String line = MyIO.promptAndRead("Gib mir ein Wort: ");
	    MyIO.writeln("Es wurde \"" + line + "\" engegeben.");

	    BigInteger i = MyIO.readBigInteger("Gib mir eine zahl: ");
	    MyIO.writeln("Es wurde \"" + i + "\" eingeben.");
	  }
	}