package geometria.figuresolide;
import geometria.figurepiane.Quadrato;

public class Cubo
{
    private Quadrato q;
    
    public Cubo(double lato)
    {
        this.q = new Quadrato(lato);
    }

    public double calculateArea()
    {
        return Math.pow(this.q.getLato(), 2) * 6;
    }
}