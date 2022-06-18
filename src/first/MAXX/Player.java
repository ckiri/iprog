package first.MAXX;

/**
 * Player: Spieler Klasse für MAXX Spiel
 * @author Dennis Deifel, Dennis Maric, Chris Kiriakou, Yunus Turan, Dominik Agres
 * @version 1, 12.01.2022
 **/

    //Bad practice, alles Public

public class Player {
    public Fraction points;
    public boolean myTurn;
    public String icon;
    public int positionX;
    public int positionY;

    public Player(boolean farbe, String i, int posX, int posY, long nu, long de){
        points = new Fraction(nu, de);  //Punkte als Fraction
        myTurn = farbe;                 //weiß = true, heisst weiß hat ersten turn
        icon = i;                       //icon, hier W oder S
        positionX = posX;               //X Coordinate
        positionY = posY;               //Y Coordinate
    }

}
