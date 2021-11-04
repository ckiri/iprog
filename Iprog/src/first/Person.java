package first;

import java.util.*;
/**
 * 
 * @author Chris
 *
 */
public class Person {
	// Personenobjekte
    protected String vorname, name, beruf, geburtsort, groesse;
    protected int geburtsjahr;
    protected float hoehe;
    
    public void compareWith(Person persVorgegeben, Person persInteraktiv) {
    	if(persVorgegeben.hoehe < 1.49)
    	{
    		groesse = "klein";
    	}
    	else if(hoehe <= 1.82)
    		{
    			groesse = "mittelgroß";
    		}
    	else
    	{
    		groesse = "groß";
    	}
    }
    
    @Override
    public String toString() {
    	String oneLine;
    	int jahr = new GregorianCalendar().get(Calendar.YEAR);
    	int alter = jahr - geburtsjahr;
    	String groesse;
    	if(hoehe < 1.49)
    	{
    		groesse = "klein";
    	}
    	else if(hoehe <= 1.82)
    		{
    			groesse = "mittelgroß";
    		}
    	else
    	{
    		groesse = "groß";
    	}
    	oneLine = "Die Person heißt " + this.vorname + " " + this.name + ", arbeitet als " + this.beruf
    			+ " & wurde im Jahr " + this.geburtsjahr + " in " + this.geburtsort + " geboren, ist demnach " + alter + " alt"
    			+ " und ist " + this.hoehe + "m " + groesse;
    	return oneLine;
    }
	// interaktiver Konstruktor
    public Person(){
    	this.vorname = MyIO.promptAndRead("Vorname: ");
    	this.name = MyIO.promptAndRead("Name: ");
    	this.beruf = MyIO.promptAndRead("Beruf: ");
    	this.geburtsjahr = MyIO.readInt("Geburtsjahr: ");
    	this.geburtsort = MyIO.promptAndRead("Geburtsort: ");
    	this.hoehe = MyIO.readFloat("Körpergröße: ");
    }
    // vorgegebener Konstruktor
    public Person(String vorname, String name, String beruf, int geburtsjahr, String geburtsort, float hoehe) {
    	this.vorname = vorname;
    	this.name = name;
    	this.beruf = beruf;
    	this.geburtsjahr = geburtsjahr;
    	this.geburtsort = geburtsort;
    	this.hoehe = hoehe;
    }
    
    // main Methode mit vorgegebener und interaktiver Person
    public static void main(String[] args) {
    	Person p1 = new Person("Joseph", "Robinette Biden", "Präsident der Vereinigten Staaten", 1942, "Scranton, Pensylvania U.S", 1.83f);
    	Person p2 = new Person();
    	System.out.println(p1+"\n"+p2);
    }
}
