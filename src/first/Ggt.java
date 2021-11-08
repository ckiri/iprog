/**
 * Ggt
 * @author DMaric, DDeifel, DAgres, CKirakou
 * @version 1, 18.10.21
 * */


package first;

public class Ggt {

    public static void main(String[] args) {
        int x1 = MyIO.readInt("Nummer 1: ");
        int y1 = MyIO.readInt("Nummer 2: ");
        int i1 = 0;

        System.out.println(ggT(x1, y1, i1));

    }

    public static int ggT (int x, int y, int i){
        i = x % y;
        x = y;
        y = i;
        return y == 0 ? x :
                ggT(x, y, i);
        }

}
