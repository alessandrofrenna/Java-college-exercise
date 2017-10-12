import java.util.*;

public class Main 
{

    public static void main (String[] args)
    {
        System.out.print("Inserisci valore di litri iniziale nel serbatoio: ");
        Scanner input = new Scanner(System.in);
        Serbatoio tank = new Serbatoio(input.nextDouble());

        tank.rifornisci(15.45);
        System.out.println("Il serbatoio ha disponibili litri: " + tank.getLivello()+"\n");
        tank.consuma(20);
        System.out.println("Il serbatoio ha disponibili litri: " + tank.getLivello()+"\n");

    }

}