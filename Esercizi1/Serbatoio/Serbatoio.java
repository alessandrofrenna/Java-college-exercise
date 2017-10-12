/**
 * Classe serbatoio che permette di istanziare un nuovo
 * serbatoio, rifornirlo e consumare carburante.
 * @author Alessandro Frenna
 * @version 1.0
 */

public class Serbatoio
{
    private double livello;

    private final int capacita = 65;

    /**
     * Costruttore di default:
     * inizializza a 10 litri il serbatoio istanziato
     */
    public Serbatoio ()
    {
        rifornisci(10.0);
    }

    /**
     * Costruttore secondario, permette di istanziare la 
     * classe con un valore arbitrario da immettere nel serbatoio
     *
     * @param livelloIniziale livello del rifornimento iniziale
     */
    public Serbatoio (double livelloIniziale)
    {
        rifornisci(livelloIniziale);
    }

    /**
     * Permette di fare il rifornimento del serbatoio incrementando
     * il numero di litri di carburante al suo interno.
     * @param litri litri da aggiungere
     */
    public void rifornisci(double litri)
    {
        this.livello += litri;
        if( controllaSePossoRifornire(getLivello()) ) {
            System.out.println("Serbatoio pieno, rifornimento terminato!\n");
            this.livello = this.capacita;
            return;
        } 
        
        System.out.println("Rifornimento terminato, ho inserito: "+ litri +" litri!\n");
        return;
    }

    /**
     * Permette di consumare il carburante del serbatoio decrementandone
     * il contenuto al suo interno
     * @param litri litri da consumare
     */
    public void consuma(double litri)
    {
        if(this.livello >= litri) {
            this.livello -= litri;
            System.out.printf("Ho consumato: %.2f litri!\n", this.livello);    
            return;
        }

        System.out.println("Non posso rimuovere più litri di quelli presenti nel serbatoio!\n");
        return;
    }

    /**
     * Restituisce il livello di carburante presente nel serbatoio
     * @return livello 
     */
    public double getLivello()
    {
        return this.livello;
    }

    /**
     * Restituisce in output la capacità massima settata per il serbatoio
     * @return capacità
     */
    public int getCapacita()
    {
        return this.capacita;
    }

    /**
     * Metodo di controllo, permette di stabilire se il contenuto del serbatoio
     * supera la capacità massima consentita.
     * @param litri litri su cui operare il confronto
     * @return boolean
     */
    private boolean controllaSePossoRifornire(double litri)
    {
        return this.capacita < litri;
    }

}