package first;

/**
 * @author Denis Maric, Dennis Deifel, Dominik Agres, Chris Kirakou
 * @version 1, 18.10.2021
 */

public class Hund 
{
	private String gebell;	//Instanzvariable

	public Hund()	//Ein Konstruktor der Klasse Hund
	{			
		gebell = "wau";
	}

	public Hund(String gebell)	//Ein Konstruktor mit Parameter String gebell der Klasse Hund
	{	 
		this.gebell = gebell;	//Instanzvariable
	}

	public void setzeBellen(String gebell)	//Eine Methode setzeBellen der Klasse Hund
	{	
		this.gebell = gebell;				//Instanzvariable
	}

	public void bellen() 					//Eine Methode bellen der Klasse Hund
	{					
		String bellen;						//lokale Variable String bellen der Methode bellen
		bellen = gebell.concat(gebell);		
		System.out.println(bellen);
	}

	public void bellen(String bellen)	//Eine Methode bellen mit Parameter String bellen der Klasse Hund
	{		
		System.out.println(bellen);
	}

	public static void main (String[] args)	//Die main Methode der Klasse Hund
	{	
		Hund h1 = new Hund();
		Hund h2 = new Hund("wuff");		//"wuff" String-Argument des Konstruktors public Hund(String gebell)
		h1.bellen();						//Ausgabe der Methode bellen "wauwau"
		h2.bellen();						//Ausgabe der Methode bellen "wuffwuff"
		h1.setzeBellen("kleff");		//"kleff" String-Argument des Konstruktors public Hund(String gebell)
		h1.bellen();						//Ausgabe der Methode bellen "kleffkleff"
		h2.bellen();						//Ausgabe der Methode bellen "wuffwuff"
		h1.bellen("wau");				//"wau" String-Argument des Konstruktors public Hund(String gebell) //Ausgabe der Methode bellen "wau"
	}
}