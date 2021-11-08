package first;

import java.util.*;

/**
 * Die es Ihnen erlaubt, Personen-Objekte zu erzeugen. Für Personen-Objekte gibt es zwei verschiedene Konstruktoren. 
 * Beim ersten werden alle Attribute einer Person als Parameter übergeben, 
 * beim zweiten werden sie im Konstruktor interaktiv bestimmt (die Parameterliste ist also leer). 
 * Eine Person hat Vorname, Name, Beruf (Strings) und ein Geburtsjahr (int). Weiterhin soll es eine Methode toString() geben, 
 * welche als ReturnWert alle relevanten Informationen über eine Person als einen String herausgibt. 
 * Entwerfen, implementieren und testen Sie die Klasse in der mainMethode. 
 * (Erzeugen Sie also mehrere Personen-Objekte (auf verschiedene Art) und geben Sie anschließend deren Daten auf den Bildschirm aus.)
 * 
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 2, 25.10.2021
 */

public class Person 
{
    private String vorname, name, beruf, geburtsort, größenbereich;
    private int geburtsjahr, alter;
    private float körpergröße;

    public Person(String vorname, String n, String b, String gbo, int gb, float gr)
    {
        this.vorname = vorname;
        this.name = n;
        this.beruf = b;
        this.geburtsort = gbo;
        this.geburtsjahr = gb;
        this.körpergröße = gr;

        this.alter = this.getAlter();
        this.größenbereich = this.getGrößenbereich();
    }
    
    public Person()
    {
        System.out.println();
        System.out.println("Beschreibe eine Person:");
        this.vorname = MyIO.promtAndRead("Vorname: ");
        this.name = MyIO.promtAndRead("Name: ");
        this.beruf = MyIO.promtAndRead("Beruf: ");
        this.geburtsort = MyIO.promtAndRead("Geburtsort: ");
        this.geburtsjahr = MyIO.readInt("Geburtsjahr: ");
        this.körpergröße = MyIO.readFloat("Körpergröße in Meter: ");

        this.alter = this.getAlter();        
        this.größenbereich = this.getGrößenbereich();
    }

    @Override   //toString Methode von Anfang an vorhanden, wird überschrieben für logischere Ausgabe
    public String toString()
    {
        return this.name + " " + this.vorname + ", arbeitet als " + this.beruf 
            + ", ist " + this.körpergröße + "m " + this.größenbereich + " und wurde im Jahr " + this.geburtsjahr 
                + " in " + this.geburtsort + " geboren, damit ist er/ sie " + this.alter + " Jahre alt.";
    }

    public int getAlter()
    {
        return new GregorianCalendar().get(Calendar.YEAR) - this.geburtsjahr;
    }

    public String getGrößenbereich()
    {
        if(körpergröße < 1.49f)
        {
            return "klein";
        }
        else
        {
            if(körpergröße > 1.82f)
            {
                return "groß";
            }
            else
            {
                return "mittel groß";
            }
        }
    }

    public void compareWith(Person x)
    {
        System.out.println();

        if( this.körpergröße < x.körpergröße )
        {
            System.out.println(x.name + " " + x.vorname + " ist " + (x.körpergröße - this.körpergröße) + "m größer als " 
                + this.name + " " + this.vorname + ".");
        }
        else if( this.körpergröße == x.körpergröße )
            {
                System.out.println(this.name + " " + this.vorname + " und " + x.name + " " + x.vorname 
                    + " sind mit " + this.körpergröße + "m gleich groß.");
            }
            else
            {
                System.out.println(this.name + " " + this.vorname + " ist " + (this.körpergröße - x.körpergröße) + "m größer als " 
                    + x.name + " " + x.vorname + ".");
            }
    

        if( this.alter < x.alter )
        {
            System.out.println(x.name + " " + x.vorname + " ist " + (x.alter - this.alter) + " Jahre älter als " 
                + this.name + " " + this.vorname + ".");
        }
        else if( this.alter == x.alter )
            {
                System.out.println(this.name + " " + this.vorname + " und " + x.name + " " + x.vorname 
                    + " sind mit " + this.alter + " Jahren gleich alt.");
            }
            else
            {
                System.out.println(this.name + " " + this.vorname + " ist " + (this.alter - x.alter) + " Jahre älter als " 
                    + x.name + " " + x.vorname + ".");
            }
    }
    
    public static void main (String[] args)
    {
        Person person1 = new Person("Biden", "Joseph", "Präsident der Vereinigten Staaten", "Pennsylvania", 1942, 1.8f);
        Person person2 = new Person("Mustermann", "Max", "Kaufmann", "Heilbronn", 1975, 2.1f);
        Person person3 = new Person("Musterfrau", "Erika", "Softwareentwicklerin", "Berlin", 1987, 1.6f);
        Person person4 = new Person(); 

        Person p[] = {person1, person2, person3, person4};

        int j = 1;
        for(Person i : p)
        {
            System.out.println();
            System.out.println("Person " + j++);
            System.out.println(i.toString());
        }

        person4.compareWith(person1);
        person2.compareWith(person3);
    }
}