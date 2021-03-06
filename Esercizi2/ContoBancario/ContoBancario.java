/**
    @author Alessandro Frenna
    @version 1.0
 */

public class ContoBancario
{
    static int incremental = 0;
    private String id;
    private String titolare;
    private double saldo;
    static final double maxPrelievo = 500;
    static final double maxTransfer = 2500;

    /**
        Costruttore di default.
        Esso permette di istanziare il nuovo conto bancario, 
        nel caso in cui il correntista sia nuovo lo setta a 0.
        @param nome nome del titolare del conto
     */
    public ContoBancario(String nome)
    {
        this.titolare = nome;
        this.saldo = 0;
        this.incremental += 1;
        this.id = String.valueOf(this.incremental);
    }

    /**
        Costruttore di secondario.
        Esso permette di istanziare il nuovo conto bancario, 
        nel caso in cui il correntista sia già presente ed abbia un saldo.
        @param nome nome del titolare del conto
        @param saldoIniziale quanti soldi ha in banca
     */
    public ContoBancario(String nome, double saldoIniziale)
    {
        this(nome);
        this.saldo = saldoIniziale;
    }

    /**
        Permette di depositare una nuova quantità
        di soldi sul conto corrente bancario
        @param soldi la quantita' da depositare
     */
    public void deposita(double soldi)
    {
        if(soldi <= 0){
            System.out.println("Transazione rifiutata, non posso depositare somme negative o nulle\n");
            return;
        }

        this.saldo += soldi;
        return;
    }

    /**
        Permette di prelevare i soldi dal conto a patto che:
            - I soldi ci siano, se non ci sono mostra un errore;
            - Non si stia cercando di prelevare più del massimo consentito
        @param soldi la quantita' da prelevare
        @return boolean 
     */
    public boolean preleva(double soldi)
    {
        if(this.saldo == 0){
            System.out.println("Transazione rifiutata, il conto è vuoto!\n");
            return false;
        } 
        
        if(this.saldo < soldi) {
            System.out.println("Transazione rifiutata, credito insufficente\n");
            return false;
        }

        if(soldi > maxPrelievo) {
            System.out.println("Transazione rifiutata, limite massimo superato, riesegui l'operazione\n");
            return false;
        }

        this.saldo -= soldi;
        return true;
    }

    /**
        Permette di trasferire una somma di denaro da un conto corrente ad un altro
        @param importo importo da trasferire
        @param conto istanza del conto corrente su cui trasferire l'importo
        @return boolean
     */
    public boolean trasferisci(double importo, ContoBancario conto)
    {
        if(importo > maxTransfer) {
            System.out.println("Transazione rifiutata, non puoi superare l'importo limite, riprova\n");
            return false;
        }

        if(preleva(importo)) {
            conto.deposita(importo);
            return true;
        } 

        System.out.println("Transazione chiusa, impossibile trasferire denaro\n");
        return false;
    }

    /**
        Restituisce l'id del correntista.
        @return id id del titolare
     */
    public String getId()
    {
        return this.id;
    }

    /**
        Restituisce il nome del correntista
        @return titolare dettagli sul titolare
     */
    public String getTitolare()
    {
        return this.titolare;
    }

    /**
        Restituisce il saldo corrente.
        @return saldo saldo attuale del correntista
     */
    public double getSaldo()
    {
        return this.saldo;
    }

}