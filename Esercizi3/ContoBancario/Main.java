import java.util.*;

public class Main 
{

    public static void main (String[] args)
    {

        ContoBancario primo = new ContoBancario();

        primo.deposita(1500.00);
        System.out.println(primo.getTitolare() + " ha appena effettuato un deposito sul conto "+ primo.getId() +", nuovo saldo disponibile: " + primo.getSaldo());
        System.out.print("\n");
        primo.preleva(600);
        primo.preleva(250.40);
        primo.preleva(100000);
        System.out.println(primo.getTitolare() + " ha appena effettuato un prelievo sul conto "+ primo.getId() +", nuovo saldo disponibile: " + primo.getSaldo());
        System.out.print("\n");    
    }

}