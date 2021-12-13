package first;

/**
 *Der Benutzer wird aufgefordert, den Namen einer der (in der Klasse Math 
 *vorhandenen) mathematischen Funktionen sin, cos, exp, log, 
 *sqrt, tan oder aber square , cube , quad und tower (für die 
 *Berechnung von Potenzen x^x^x) einzugeben. 
 *Wurde eine Funktion eingegeben, sollen Zahlwerte für Beginn, Schrittweite, 
 *und Ende erfragt und eingelesen und anschließend die Funktion geplottet 
 *(ausgegeben) werden.
 *Danach kann gleich wieder die nächste Funktion geplottet werden (Fortsetzung 
 *also bei Schritt 1). Nur wenn statt des Funktionsnamens stop eingegeben 
 *wurde, soll das Programm enden.

 * @author Dennis Deifel, Denis Maric, Dominik Agres, Chris Kiriakou
 * @version 1, 06.12.2021
 */

public class MathPlotter {
	
	
	static String funktion;
	static double b;
	static double i;
	static double e;
	static double a;

	public static void plot(D2Method meth) {
		for(; b<=e; b += i) {
				a = b;
				MyIO.writeln(b + "--> " +meth.compute(a));
		}
	}
	public static void main(String[] args) throws Exception {
		
		//Anfang der While schleife
		while(true) {
			
			//Einlesen der beliebigen Funktion
			funktion = MyIO.promtAndRead("Wählen Sie eine dieser Funktionen aus: sin, cos, exp, log, sqrt, tan, square, "
					+ "cube, quad oder tower ('stop' eingeben um das Programm zu beenden): ");
			
			//wenn stop eingegeben ist, hört das Programm auf
			if(funktion.equals("stop")) {
				System.out.println("Sie haben das Programm beendet. Auf Wiedersehen :)");
				break;
			}
			
			//Einlesen von beginn, schrittweite, ende
			b = MyIO.readDouble("Wert Beginn: ");
			i = MyIO.readDouble("Wert Schrittweite: ");
			e = MyIO.readDouble("Wert Ende: ");
			
			//switch cases
			switch(funktion) {
			case "sin" : plot(new D2Method(){
				public double compute(double a) {
					return Math.sin(a);	
				}
			});	break;
			case "cos" : plot(new D2Method(){
				public double compute(double a) {
					return Math.cos(a);						
				}
			}); break;
			case "exp" : plot(new D2Method(){
				public double compute(double a) {
					return Math.exp(a);						
				}
			}); break;
			case "log" : plot(new D2Method(){
				public double compute(double a) {
					return Math.log(a);						
				}
			}); break;
			case "sqrt" : plot(new D2Method(){
				public double compute(double a) {
					return Math.sqrt(a);						
				}
			}); break;
			case "tan" : plot(new D2Method(){
				public double compute(double a) {
					return Math.tan(a);						
				}
			}); break;
			case "square" : plot(new D2Method(){
				public double compute(double a) {
					return a*a;						
				}
			}); break;
			case "cube" : plot(new D2Method(){
				public double compute(double a) {
					return a*a*a;						
				}
			}); break;
			case "quad" : plot(new D2Method(){
				public double compute(double a) {
					return a*a*a*a;						
				}
			}); break;
			case "tower" : plot(new D2Method(){
				public double compute(double a) {
					return Math.pow(a, Math.pow(a, a));						
				}
			}); break;
			
			//ungültige Eingabe, nochmal fragen
			default: System.out.println("Diese Funktion existiert nicht: " + funktion);
			}	  
		}	
	}
}

