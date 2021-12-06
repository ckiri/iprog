package first;

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
		
		while(true) {
			funktion = MyIO.promtAndRead("Wählen Sie eine dieser Funktionen aus: sin, cos, exp, log, sqrt, tan, square, "
					+ "cube, quad oder tower ('stop' eingeben um das Programm zu beenden): ");
			
			if(funktion.equals("stop")) {
				System.out.println("Sie haben das Programm beendet. Auf Wiedersehen :)");
				break;
			}
			b = MyIO.readDouble("Wert Beginn: ");
			i = MyIO.readDouble("Wert Schrittweite: ");
			e = MyIO.readDouble("Wert Ende: ");
			
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
					return Math.cos(Math.toRadians(a));						
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
			default: System.out.println("Diese Funktion existiert nicht: " + funktion);
			}	  
		}	
	}
}

