package first;

/**
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 11.10.2021
 */

public class MyMath {
    public static String catAll(int... x) {
        String s = x.length == 0 ? "[" : "[" + x[0];
        for (int i = 1; i < x.length; i++) { s += "," + x[i]; }
        return s + "]";
    }
    public static int addAll(int... y) {
        int a = 0;
        for (int i:y) { a += i;}
        return a;
    }
    public static double multiplyAll(int... z) {
        double m = 1;
        for (int i:z) { m *= i;}
        return m;
    }
    public static void main (String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        System.out.println("Die Summe von "+catAll(array)+" ergibt "+addAll(array)+ "");
        System.out.println("Das Produkt von "+catAll(array)+" ergibt "+multiplyAll(array)+ "");
        System.out.println("Die Aufruf-Argumente sind: "+catAll(array));
    }
}