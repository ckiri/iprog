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
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 2, 06.12.2021
 */

public class Person implements Comparable<Person> , Cloneable , SimpleTreeNode
{
    protected String vorname, name, beruf, geburtsort, größenbereich;
    protected int geburtsjahr, alter;
    protected float körpergröße;
    protected boolean geschlecht;

    private SimpleTreeNode treenode = new DefaultTreeNode("");

    public Person(String n, String vorn, Boolean g, String b, String gbo, int gb, float gr)
    {
        this.vorname = vorn;
        this.name = n;
        this.geschlecht = g;
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

        int i = 0;
        do 
        { 
            String g = MyIO.promtAndRead("Geschlecht (m/w): ");
            switch (g) 
            {
                case "m":
                    this.geschlecht = true; i++;
                    break;
            
                case "w":
                    this.geschlecht = false; i++;
                    break;

                default:
                    System.out.println("Versuch es bitte noch einmal.");
                    break;
            }
        } while(i == 0);

        this.beruf = MyIO.promtAndRead("Beruf: ");
        this.geburtsort = MyIO.promtAndRead("Geburtsort: ");
        this.geburtsjahr = MyIO.readInt("Geburtsjahr: ");
        this.körpergröße = MyIO.readFloat("Körpergröße in Meter: ");

        this.alter = this.getAlter();        
        this.größenbereich = this.getGrößenbereich();
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

    @Override   //toString Methode von Anfang an vorhanden, wird überschrieben für logischere Ausgabe
    public String toString()
    {
        String gesch = this.geschlecht == true ? "er " : "sie ";

        return this.name + " " + this.vorname + ", arbeitet als " + this.beruf 
            + ", ist " + this.körpergröße + "m " + this.größenbereich + " und wurde im Jahr " + this.geburtsjahr 
                + " in " + this.geburtsort + " geboren, damit ist " + gesch + this.alter + " Jahre alt.";
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

    @Override
    public int compareTo(Person o) 
    {
        return (name + vorname).compareTo(o.name + o.vorname);
    }

    public static void bubbleSort(Person[] p) 
    {
        boolean sorted;
        do 
        {
            sorted = true;
            for (int i = 0; i < p.length-1; i++) 
            {
                if (p[i].compareTo(p[i+1]) > 0)
                {
                    Person tmp = p[i];
                    p[i] = p[i+1];
                    p[i+1] = tmp;
                    sorted = false;
                }
            }
        } while (!sorted);   
    }

    public void addChild (SimpleTreeNode child)
    {
        treenode.addChild (child);
    }
        
    public int getChildCnt()
    {
        return treenode.getChildCnt();
    }
        
    public SimpleTreeNode getChild (int pos)
    {
        return treenode.getChild (pos);
    }

    public static void print (Person n, String indent)
    {
        System.out.println (indent + n.vorname + " " + n.name);
        for (int i=0; i < n.getChildCnt(); i++)
        {
            print((Person) n.getChild(i), indent + " ");
        }
    }

   
    public Person clone()
    {
        Person x = new Person(name, vorname, geschlecht, beruf, geburtsort, geburtsjahr, körpergröße);

        for (int i = 0; i < getChildCnt(); i++) 
        {
            x.treenode.addChild( ((Person) this.getChild(i)).clone() );
        }
        return x;
    }

    public static void main (String[] args)
    {
        Person person1 = new Person("Biden", "Joseph", true, "Präsident der Vereinigten Staaten", "Pennsylvania", 1942, 1.8f);
        Person person2 = new Person("Mustermann", "Max", true, "Kaufmann", "Heilbronn", 1975, 2.1f);
        Person person3 = new Person("Mustermann", "Corinna", false, "Softwareentwicklerin", "Berlin", 1987, 1.6f);
        Person person4 = new Person("Schneider", "Thomas", true, "Fußballer", "München", 1979, 1.7f);
        Person person41 = new Person("Schneider", "Erika", false, "Köchin", "München", 1999, 1.6f);
        Person person411 = new Person("Schneider", "Dominik", true, "Schüler", "München", 2008, 1.5f);
        Person person42 = new Person("Schneider", "Denis", true, "Fußballer", "München", 2000, 1.75f);
        Person person421 = new Person("Schneider", "Vitali", true, "Rennfahrer", "München", 2008, 1.7f);
        Person person422 = new Person("Schneider", "Lukas", true, "Student", "München", 2007, 1.48f);
        Person person4221 = new Person("Schneider", "Arne", true, "Zusteller ", "München", 2009, 1.5f);
        Person person43 = new Person("Schneider", "Chris", true, "Mechaniker", "München", 1989, 1.8f);

        Person p[] = {person1, person2, person3, person4, person41, person411, person42, person421, person422, person4221, person43};

        bubbleSort(p);

        int j = 1;
        System.out.println("Sortierte Liste der Personen:");
        for(Person i : p)
        {
            System.out.println("Person " + j++);
            System.out.println(i.toString());
        }

        person4.addChild(person41);
        person4.addChild(person42);
        person4.addChild(person43);
        person41.addChild(person411);
        person42.addChild(person421);
        person42.addChild(person422);
        person422.addChild(person4221);


        System.out.println();
        System.out.println("Stammbaum von Thomas Schneider:");
        print(person4, "");

        Person person4_clone = person4.clone();
        System.out.println();
        System.out.println("Stammbaum des geklonten Thomas Schneider:");
        print(person4_clone, "");
    }
}