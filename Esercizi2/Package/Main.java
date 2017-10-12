import java.util.*;
import geometria.figurepiane.*;
import geometria.figuresolide.*;

public class Main 
{

    public static void main (String[] args)
    {
        System.out.print("Inserisci valore del raggio: ");
        Scanner input = new Scanner(System.in);
        System.out.println("L'area del cerchio e': " + Cerchio.calculateArea(input.nextDouble())+"\n");

        System.out.print("\n\nInserisci valore del lato: ");
        input = new Scanner(System.in);
        Quadrato q = new Quadrato(input.nextDouble());

        System.out.println("L'area del quadrato e': " + q.calculateArea()+"\n");
        q.duplicaLato();
        System.out.println("Ho duplicato il lato del quadrato, esso adesso e': " + q.getLato()+"\n");
        
        System.out.println("La nuova area del quadrato e': " + q.calculateArea()+"\n");

        System.out.print("\n\nInserisci valore del lato del cubo: ");
        input = new Scanner(System.in);
        Cubo c = new Cubo(input.nextDouble());

        System.out.println("L'area del cubo e': " + c.calculateArea()+"\n");
    }


}