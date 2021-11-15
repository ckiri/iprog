package first;

/**
 * das einen Aufzählungstyp (enum) mit dem gleichen Namen kennt für (Januar, Februar, …, Dezember). 
 * Jeder Monat hat eine Nummer, (1, …, 12) deren Wert mit getNumber() abgefragt werden kann. 
 * Das Programm soll nacheinander zwei Listen ausgeben und dazu jeweils über alle Monate iterieren. 
 * Die erste Liste besteht aus den Monaten, in denen der Buchstabe „n“ vorkommt und deren Nummer ungerade ist, 
 * die zweite Liste enthält die Monate, in denen ein „r“ vorkommt und deren Nummer gerade ist.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 015.11.2021
 */

enum Monat 
{
    Januar (1), Februar (2), Maerz (3), April (4), 
    Mai (5), Juni (6), Juli (7), August (8), 
    September (9), Oktober (10), November (11), Dezember (12);

    private final int i;

    Monat (int i)  { this.i = i; }

    public int getNumber()  {return this.i; }

    public static void main(String[] args) 
    {
        System.out.println("Liste 1 („n“ und ungerade):");
        for( Monat m : Monat.values())
        {
            if( m.toString().toLowerCase().contains("n") && m.i%2 != 0)
            {
                System.out.println(m.toString() + " (" + m.i + ")");
            }
        }    
        System.out.println();
        System.out.println("Liste 2 („r“ und gerade):");
        for( Monat m : Monat.values())
        {
            if( m.toString().toLowerCase().contains("r") && m.i%2 == 0)
            {
                System.out.println(m.toString() + " (" + m.getNumber() + ")");
            }
        }   
    }
}