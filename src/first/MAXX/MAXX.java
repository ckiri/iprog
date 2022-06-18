package first.MAXX;

/**
 * MAXX Spiel
 * @author Dennis Deifel, Dennis Maric, Chris Kiriakou, Yunus Turan, Dominik Agres
 * @version 1, 12.01.2022
 **/

public class MAXX {

    public static String top(){
        return "+---------+---------+---------+---------+---------+---------+---------+---------+";
    }   //Obere / untere begrenzung
    public static String side(){
        return "|";
    }       //Seitliche begrenzung

    public static int counter(Object x){                //Methode zum Zählen
        String literal = x.toString();
        return literal.length();
    }

    public static String sorter(Object brett) {     //checkt, ob alle zahlen Länge-parameter erfüllen
        if (counter(brett) == 7) {
            return side() + " " + brett + " ";
        } else if (counter(brett) == 6) {
            return side() + "  " + brett + " ";
        } else if (counter(brett) == 5) {
            return side() + "  " + brett + "  ";
        } else if (brett == "W" || brett == "S"){
            return side() + "    " + brett + "    ";
        } else if (counter(brett) == 4 || counter(brett) == 3 || counter(brett) == 2 || counter(brett) == 1){
            return side() + "         ";
        } else {
            return side() + "         ";
        }
    }

    public static void create2DBrett (Fraction[][] brett){      //Dies muss nur einmal ausgeführt werden, hier wird der Board erstellt
        for (int i = 0; i < brett.length; i++) {                //row
            for (int j = 0; j < brett[i].length; j++) {         //column
                brett[i][j] = RNG.randomNumber();
                do{
                    brett[i][j] = RNG.randomNumber();
                } while(sorter(brett[i][j]).equals(side() + "         "));   //Checkt, ob ganze oder einstellige Brüche vorkommen
            }
        }
    }

    public static void print2DBrett (Object[][] brett){     //Dieser Program gibt den ganzen brett aus so wie er ist
        for(int i = 0; i < brett.length; i++){
            System.out.println(top());
            for(int j = 0; j < brett[i].length; j++){
                System.out.printf("%10s", sorter(brett[i][j]));
                if (j == brett[i].length - 1) System.out.print(side());
            }
            System.out.println();
            if (i == brett.length - 1) System.out.print(top());
        }
        System.out.println();
    }

    public static void convert2DBrett(Object[][] brett, Fraction[][] punkteBrett){      //konvertiert den Fraction Array in Object für die Interaktion
        for(int i = 0; i < punkteBrett.length; i++){
            for(int j = 0; j < punkteBrett[i].length; j++ ){                            //manual Array copy, geht anders nicht
                brett[i][j] = punkteBrett[i][j];
            }
        }
    }

    public static boolean check2DBrettValidity(Fraction[][] punktebrett){
        Fraction sum = new Fraction(0, 1);
        Fraction min = new Fraction(84,1);
        Fraction max = new Fraction(100, 1);
        for(int i = 0; i < punktebrett.length; i++){
            for(int j = 0; j < punktebrett[i].length; j++){
                sum = sum.add(punktebrett[i][j]);
            }
        }
        if (sum.compareTo(min)<1 || sum.compareTo(max) > 0){
            return false;
        } else {
            return true;
        }
    }

    public static void checkPoints(Fraction a, Fraction b){         //Checkt die Points und printed sie
        String totalPoints = "Weiss hat:   " + a + " Punkte! \nSchwarz hat: " + b + " Punkte!";
        System.out.println(totalPoints);
    }
    public static Fraction addPoints(Fraction a, Fraction b){       //addition fertig, Fraction verwirrt mich
        Fraction result;
        result = a.add(b);
        return result;
    }

    public static void main(String[] args) {                 //Main Spiel
        //Board erstellen
        Fraction[][] punkteBrett = new Fraction[8][8];
        do{
            create2DBrett(punkteBrett);
        } while(!check2DBrettValidity(punkteBrett));          //Hier wird das Board checkt, ob genug punkte darauf sind
        Object[][] brett = new Object[8][8];
        convert2DBrett(brett, punkteBrett);                   //erstellt einen Object Board für das spiel mit identischen werten von der Fraction Board

        Fraction zero = new Fraction(0, 1);             //Null-Fraction
        //Spieler erstellen
        Player weiss = new Player(true, "W", 2, 2, 0, 1);
        Player schwarz = new Player(false, "S", 5, 5, 0 ,1);
        //Spieler Position Zuweisen
        brett[2][2] = weiss.icon;
        brett[5][5] = schwarz.icon;
        punkteBrett[2][2] = zero;
        punkteBrett[5][5] = zero;

        //Erster Print, subject to Change
        print2DBrett(brett);
        checkPoints(weiss.points, schwarz.points);
        System.out.println("Wähle eine dieser Zahlen um deinen Charakter zu bewegen: ");
        System.out.println("| 1 = SW | 3 = SO | 7 = NW | 9 = NO |");
        System.out.println("Schwarz darf 4 nutzen um nach Links zu gehen, Weiss darf 6 nutzen um nach Rechts zu gehen!");
        System.out.println("Dieses Spiel ist am einfachsten mit einer Numpad zu spielen.");
        System.out.println("Nach jeder Bewegung sammelst du die Punktezahl von dem Feld.");
        System.out.println("Der Spieler der zur erst 42 Punkte erreicht hat, Gewinnt!");
        System.out.println("Drücke 5 um das Spiel zu beenden!");

        //ein paar parameter für das Spiel
        int eingabe;
        boolean zweiteChanceWeiss = false;
        boolean zweiteChanceSchwarz = false;

        //Addition der Punkte halter-Variable
        Fraction gewinnerPunkte = new Fraction(42, 1);
        Fraction add;  //Holder variable für addition

        //Hier werden die einzelnen eingaben geprüft und ausgewertet
        main:
        do{

            boolean def = true;
            switchWeiss:
            while(def || !zweiteChanceSchwarz){
                zweiteChanceSchwarz = false;
                System.out.println("Wähle eine der 5 vorgegebenen himmelsrichtungen um dich zu bewegen.");
                eingabe = MyIO.readInt("Weiss, Dein Move: ");
            switch (eingabe){
                case 7:
                    brett[weiss.positionX][weiss.positionY] = 0;
                    if(weiss.positionX-1 == -1 || weiss.positionY-1==-1 || (weiss.positionX-1 == schwarz.positionX && weiss.positionY-1== schwarz.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceWeiss = true;
                        break;
                    }
                    weiss.positionX--; weiss.positionY--;
                    brett[weiss.positionX][weiss.positionY] = weiss.icon;

                    add = punkteBrett[weiss.positionX][weiss.positionY];
                    weiss.points = addPoints(weiss.points, add);                 //Add
                    punkteBrett[weiss.positionX][weiss.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchWeiss;
                case 9:
                    brett[weiss.positionX][weiss.positionY] = 0;
                    if(weiss.positionX-1 == -1 || weiss.positionY+1==8 || (weiss.positionX-1 == schwarz.positionX && weiss.positionY+1== schwarz.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceWeiss = true;
                        break;
                    }
                    weiss.positionX--; weiss.positionY++;
                    brett[weiss.positionX][weiss.positionY] = weiss.icon;

                    add = punkteBrett[weiss.positionX][weiss.positionY];
                    weiss.points = addPoints(weiss.points, add);                 //Add
                    punkteBrett[weiss.positionX][weiss.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchWeiss;
                case 3:
                    brett[weiss.positionX][weiss.positionY] = 0;
                    if(weiss.positionX+1 == 8 || weiss.positionY+1==8 || (weiss.positionX+1 == schwarz.positionX && weiss.positionY+1== schwarz.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceWeiss = true;
                        break;
                    }
                    weiss.positionX++; weiss.positionY++;
                    brett[weiss.positionX][weiss.positionY] = weiss.icon;

                    add = punkteBrett[weiss.positionX][weiss.positionY];
                    weiss.points = addPoints(weiss.points, add);                 //Add
                    punkteBrett[weiss.positionX][weiss.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchWeiss;
                case 1:
                    brett[weiss.positionX][weiss.positionY] = 0;
                    if(weiss.positionX+1 == 8 || weiss.positionY-1==-1 || (weiss.positionX+1 == schwarz.positionX && weiss.positionY-1== schwarz.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceWeiss = true;
                        break;
                    }
                    weiss.positionX++; weiss.positionY--;
                    brett[weiss.positionX][weiss.positionY] = weiss.icon;

                    add = punkteBrett[weiss.positionX][weiss.positionY];
                    weiss.points = addPoints(weiss.points, add);                 //Add
                    punkteBrett[weiss.positionX][weiss.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchWeiss;
                case 6:
                    brett[weiss.positionX][weiss.positionY] = 0;
                    if(weiss.positionY+1 == 8 || (weiss.positionX == schwarz.positionX && weiss.positionY+1 == schwarz.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceWeiss = true;
                        break;
                    }
                    weiss.positionY++;
                    brett[weiss.positionX][weiss.positionY] = weiss.icon;
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

                    add = punkteBrett[weiss.positionX][weiss.positionY];
                    weiss.points = addPoints(weiss.points, add);                 //Add
                    punkteBrett[weiss.positionX][weiss.positionY] = zero;

                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchWeiss;
                case 5:
                    System.out.println("Spiel zu ende!");
                    break main;
                default:
                    System.out.println("Falsche eingabe!");
            }
            }

            if(weiss.points.compareTo(gewinnerPunkte)>=0){
                System.out.println("Weiss, du hast gewonnen!");
                break;
            } else if (schwarz.points.compareTo(gewinnerPunkte)>=0){
                System.out.println("Schwarz, du hast gewonnen!");
                break;
            }

            boolean def2 = true;
            switchSchwarz:
            while(def2||!zweiteChanceWeiss){
                zweiteChanceWeiss = false;
                System.out.println("Wähle eine der 5 vorgegebenen himmelsrichtungen um dich zu bewegen.");
                eingabe = MyIO.readInt("Schwarz, Dein Move: ");
            switch (eingabe){
                case 7:
                    brett[schwarz.positionX][schwarz.positionY] = 0;
                    if(schwarz.positionX-1 == -1 || schwarz.positionY-1==-1 || (schwarz.positionX-1 == weiss.positionX && schwarz.positionY-1 == weiss.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceSchwarz = true;
                        break;
                    }
                    schwarz.positionX--; schwarz.positionY--;
                    brett[schwarz.positionX][schwarz.positionY] = schwarz.icon;

                    add = punkteBrett[schwarz.positionX][schwarz.positionY];
                    schwarz.points = addPoints(schwarz.points, add);                 //Add
                    punkteBrett[schwarz.positionX][schwarz.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchSchwarz;
                case 9:
                    brett[schwarz.positionX][schwarz.positionY] = 0;
                    if(schwarz.positionX-1 == -1 || schwarz.positionY+1==8 || (schwarz.positionX-1 == weiss.positionX && schwarz.positionY+1 == weiss.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceSchwarz = true;
                        break;
                    }
                    schwarz.positionX--; schwarz.positionY++;
                    brett[schwarz.positionX][schwarz.positionY] = schwarz.icon;

                    add = punkteBrett[schwarz.positionX][schwarz.positionY];
                    schwarz.points = addPoints(schwarz.points, add);                 //Add
                    punkteBrett[schwarz.positionX][schwarz.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchSchwarz;
                case 3:
                    brett[schwarz.positionX][schwarz.positionY] = 0;
                    if(schwarz.positionX+1 == 8 || schwarz.positionY+1==8 || (schwarz.positionX+1 == weiss.positionX && schwarz.positionY+1 == weiss.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceSchwarz = true;
                        break;
                    }
                    schwarz.positionX++; schwarz.positionY++;
                    brett[schwarz.positionX][schwarz.positionY] = schwarz.icon;

                    add = punkteBrett[schwarz.positionX][schwarz.positionY];
                    schwarz.points = addPoints(schwarz.points, add);                 //Add
                    punkteBrett[schwarz.positionX][schwarz.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchSchwarz;
                case 1:
                    brett[schwarz.positionX][schwarz.positionY] = 0;
                    if(schwarz.positionX+1 == 8 || schwarz.positionY-1==-1 || (schwarz.positionX+1 == weiss.positionX && schwarz.positionY-1 == weiss.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceSchwarz = true;
                        break;
                    }
                    schwarz.positionX++; schwarz.positionY--;
                    brett[schwarz.positionX][schwarz.positionY] = schwarz.icon;

                    add = punkteBrett[schwarz.positionX][schwarz.positionY];
                    schwarz.points = addPoints(schwarz.points, add);                 //Add
                    punkteBrett[schwarz.positionX][schwarz.positionY] = zero;

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchSchwarz;
                case 4:
                    brett[schwarz.positionX][schwarz.positionY] = 0;
                    if(schwarz.positionY-1==-1 || (schwarz.positionX == weiss.positionX && schwarz.positionY-1 == weiss.positionY)) {
                        System.out.println("Außer grenzen! Nochmal!");
                        zweiteChanceSchwarz = true;
                        break;
                    }
                    schwarz.positionY--;
                    brett[schwarz.positionX][schwarz.positionY] = schwarz.icon;
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

                    add = punkteBrett[schwarz.positionX][schwarz.positionY];
                    schwarz.points = addPoints(schwarz.points, add);                 //Add
                    punkteBrett[schwarz.positionX][schwarz.positionY] = zero;

                    print2DBrett(brett);
                    checkPoints(weiss.points, schwarz.points);
                    break switchSchwarz;
                case 5:
                    System.out.println("Spiel zu ende!");
                    break main;
                default:
                    System.out.println("Falsche eingabe: ");
            }
            }

            if(weiss.points.compareTo(gewinnerPunkte)>=0){
                System.out.println("Weiss, du hast gewonnen!");
                break;
            } else if (schwarz.points.compareTo(gewinnerPunkte)>=0){
                System.out.println("Schwarz, du hast gewonnen!");
                break;
            }

        }while(weiss.points.compareTo(gewinnerPunkte) < 1 || schwarz.points.compareTo(gewinnerPunkte) < 1);
        System.out.println("Danke fürs spielen!");
    }

}