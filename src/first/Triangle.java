package first;
/**
 * Triangle.java
 * @author Dennis Deifel, Denis Maric, Chris Kiriakou, Dominik Agres
 * @version 1, 25.10.2021
 **/
public class Triangle {
    public static void main(String[] args) {

        System.out.println("Wir malen dreiecke... ");
        int n = MyIO.readInt("Bitte eine zahl eingeben:");          //n ist anzahl der rheien

        int i;                                      //zähler Variablen i und j
        int j;

        int space;                                  //leerzeichen Zähler
        space = 0;

        int sternAnzahl;
        sternAnzahl = 0;

        int zeilenAnzahl;
        zeilenAnzahl = n;



            while (0 != n) {
                i = 0;
                j = 0;
                while(space > j){
                    j++;
                    System.out.print(" ");
                }
                while (i < n) {
                    i++;
                    System.out.print("* ");
                    sternAnzahl++;
                }
                System.out.println();
                space++;
                n--;
            }

        MyIO.writeln(zeilenAnzahl + " Zeilen und " + sternAnzahl + " Sterne");      //Output

    }
}


