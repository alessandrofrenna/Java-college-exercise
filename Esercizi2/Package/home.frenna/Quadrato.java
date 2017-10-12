package geometria.figurepiane;

public class Quadrato
{
    private double lato;

    public Quadrato(double lato)
    {
        this.lato = lato;
    }

    public double calculateArea()
    {
        return Math.pow(this.lato,2);
    }

    public void duplicaLato()
    {
        this.lato *= 2;
    }

    public double getLato()
    {
        return this.lato;
    }

}