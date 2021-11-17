package first;

/**
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 15.11.2021
 */

public class Matrix 
{
    private double[][] matrize;
    private int zeile, spalte;

    public Matrix (int m, int n)
    {
        matrize = new double[m][n];   //zeile x spalte
        zeile = m;
        spalte = n;
    }

    public void setMatrix()   //Matrize nach Beispiel Aufgabe 4
    {
        this.setValue(0, 1, 1);
        this.setValue(1, 2, 1);
        this.setValue(2, 3, 1);
        this.setValue(3, 4, 1);
        this.setValue(4, 5, 1);
        this.setValue(5, 0, 1); this.setValue(5, 3, 1); this.setValue(5, 5, 1);
    }

    public String toString() 
    {
        String s = "";
        for(int i = 0; i < this.zeile; i++)
        {
            s += "[" + this.matrize[i][0];
            for(int j = 1; j < this.spalte; j++)
            {
                s += ", " + this.matrize[i][j];
            }
            s += " ] \n";
        }
        return s;
    }

    public void setValue (int i, int j, double x)
    {
        this.matrize[i][j] = x;
        //return this;
    }

    public double getValue (int i, int j)
    {
        return this.matrize[i][j];
    }

    public Matrix add(Matrix other)
    {
        Matrix x = new Matrix(this.zeile, this.spalte);
        if (this.zeile == other.zeile && this.spalte == other.spalte)
        {
            for (int i = 0; i < zeile; i++)
            {
                for (int j = 0; j < spalte; j++)
                {
                    x.setValue(i, j, this.getValue(i, j) + other.getValue(i, j));
                }
            }
        }
        return x;
    }

    public Matrix multiply(Matrix other) 
    {
        Matrix x = new Matrix(this.zeile, other.spalte);
        if (this.spalte == other.zeile)
        {
            for (int i = 0; i < x.zeile; i++)
            {
                for (int j = 0; j < x.spalte; j++)
                {
                    for (int k = 0; k < this.spalte; k++)
                    {
                        x.matrize[i][j] += this.matrize[i][k] * other.matrize[k][j];
                    }
                }
            }
        }
        return x;
    }
   
    public static void main(String[] args) 
    {
        int m = 6;
        int n = 6;
        Matrix matrix1 = new Matrix(m, n);
        matrix1.setMatrix();

        Matrix ergebnis = new Matrix(m, n);
        ergebnis.setMatrix();

        for(int i = 1; i <= 20; i++)
        {
            ergebnis = ergebnis.multiply(matrix1);
            System.out.println( ergebnis.toString() );
        }
    }
}