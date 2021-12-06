package first;

public class MathPlotter {
	
	
		static String funktion = MyIO.promtAndRead("Wählen Sie eine dieser Funktionen aus: sin, cos, exp, log, sqrt, tan, square, cube, quad oder tower: ");

	
	static double b = MyIO.readDouble("Wert Beginn: ");
	static double i = MyIO.readDouble("Wert Schrittweite: ");
	static double e = MyIO.readDouble("Wert Ende: ");
	static double a;

	public static void plot(D2Method meth) {
		for(; b<=e; b += i) {
				a = b;
				MyIO.writeln(b + "-> " +meth.compute(a));
			
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		
		while(true) {
			if(funktion.equals("sin")) {
				plot(new D2Method(){
								public double compute(double a) {
									return Math.sin(Math.toRadians(a));						
					}
				});
			}
			else if(funktion.equals("cos")) {
				plot(new D2Method(){
								public double compute(double a) {
									return Math.cos(Math.toRadians(a));						
					}
				});
			}
			else if(funktion.equals("exp")) {
				plot(new D2Method(){
								public double compute(double a) {
									return Math.exp(a);						
					}
				});
			}
			else if(funktion.equals("log")) {
				plot(new D2Method(){
								public double compute(double a) {
									return Math.log10(a);						
					}
				});
			}
			else if(funktion.equals("sqrt")) {
				plot(new D2Method(){
								public double compute(double a) {
									return Math.sqrt(a);						
					}
				});
			}
			else if(funktion.equals("tan")) {
				plot(new D2Method(){
								public double compute(double a) {
									return Math.tan(a);						
					}
				});
			}
			else if(funktion.equals("square")) {
				plot(new D2Method(){
								public double compute(double a) {
									return a*a;						
					}
				});
			}
			else if(funktion.equals("cube")) {
				plot(new D2Method(){
								public double compute(double a) {
									return a*a*a;						
					}
				});
			}
			else if(funktion.equals("quad")) {
				plot(new D2Method(){
								public double compute(double a) {
									return a*a*a*a;						
					}
				});
			}
			else if(funktion.equals("tower")) {
				plot(new D2Method(){
								public double compute(double a) {
									double s = a;
									double x = s*(a*a);
									return x*x;
								
					}
				});
			}
		}
	}	
}