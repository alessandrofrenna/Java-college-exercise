import java.util.*;

public class Main 
{

    public static void main (String[] args)
    {
        System.out.print("Inserisci il nome ed il cognome del titolare del conto: ");
        Scanner input = new Scanner(System.in);
        String titolare = input.nextLine();
        System.out.print("\n");
        System.out.print("Inserisci Saldo corrente del titolare: ");
        Double saldoCorrente = input.nextDouble();
        ContoBancario primo = new ContoBancario(titolare, saldoCorrente);
        System.out.print("\n");
        
        System.out.print("Inserisci il nome ed il cognome del titolare del conto: ");
        input = new Scanner(System.in);
        ContoBancario secondo = new ContoBancario(input.nextLine());
        System.out.print("\n");

        primo.deposita(1500.90);
        System.out.println(primo.getTitolare() + " ha appena effettuato un deposito sul conto "+ primo.getId() +", nuovo saldo disponibile: " + primo.getSaldo());
        System.out.print("\n");
        primo.preleva(600);
        primo.preleva(250.40);
        primo.preleva(100000);
        System.out.println(primo.getTitolare() + " ha appena effettuato un prelievo sul conto "+ primo.getId() +", nuovo saldo disponibile: " + primo.getSaldo());
        System.out.print("\n");

        if(primo.trasferisci(400.90, secondo)) {
            System.out.print(primo.getTitolare() + " ha appena effettuato un trasferimento dal conto "+ primo.getId());
            System.out.print("\nal conto "+ secondo.getId() +" appartenente a: "+ secondo.getTitolare()+"\n");
            System.out.println(primo.getTitolare() +" nuovo saldo disponibile: " + primo.getSaldo()+"\n");
            System.out.println(secondo.getTitolare() +" nuovo saldo disponibile: " + secondo.getSaldo());
            System.out.print("\n");
        };

    
    }

}