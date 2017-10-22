import java.util.Scanner;
import java.util.ArrayList;

public class Libro
{
    private ArrayList<Autore> autori = new ArrayList<Autore>();
    private static int progressivo = 1;
    private String id;
    private String titolo;
    private double prezzo;
    private String casaEditrice;

    public Libro()
    {
        
        int numAutori = 0;
        this.setID();
        
        //Start the input scanner!
        Scanner input = new Scanner(System.in);

        //Set titolo
        System.out.print("Titolo: ");
        this.setTitolo(input.nextLine());
        
        //Determina quanti autori ha il libro
        do {
            System.out.print("Quanti autori ha il libro?  ");
        } while((numAutori = input.nextInt()) == 0); //Continua a immettere il valore se non è un numero > 0

        //Una volta inserito il numero di autori, crea gli autori
        this.setAutori(numAutori);
    
        //Set prezzo del libro
        System.out.print("Prezzo: ");
        this.setPrezzo(input.nextDouble());

       
        input.nextLine();
        //Set casa editrice
        System.out.print("Casa editrice: ");
        this.setCasaEditrice(input.nextLine());
    }

    public String getID()
    {
        return this.id;
    }

    public void setID()
    {
        this.id = String.valueOf(this.progressivo);
        this.progressivo += 1;
    }

    public String getTitolo()
    {
        return this.titolo;   
    }

    public void setTitolo(String titolo)
    {
        this.titolo = titolo;
    }

    public double getPrezzo()
    {
        return this.prezzo;   
    }

    public void setPrezzo(double prezzo)
    {
        this.prezzo = prezzo;   
    }

    public String getCasaEditrice()
    {
        return this.casaEditrice;
    }

    public void setCasaEditrice(String edito)
    {
        this.casaEditrice = edito;
    }

    public void setAutori(int numero)
    {
        if(numero > 0) {
            Scanner input = new Scanner(System.in);
            System.out.print("Inserisci nome autore: ");
            String nome = input.nextLine();
            System.out.print("Inserisci cognome autore: ");
            String cognome = input.nextLine();
            System.out.flush();
            autori.add(new Autore(nome, cognome));
            setAutori(numero - 1);
        }
    }

    public String getAutoriToString()
    {
        String output = "";

        for(Autore auth : autori)
        {
            output+=auth.toString()+", "; 
        }

        return output.substring(0, output.lastIndexOf(","));
    }

    public String toString()
    {
        String output = "";

        output += 
            "Id libro: " + this.getID() + ".\n" +
            "Il libro ha titolo: " + this.getTitolo() + ".\n" + 
            "E' stato scritto da: " + this.getAutoriToString() + ".\n" +
            "E' edito da: " + this.getCasaEditrice() + ".\n" + 
            "Costa: Euro " + this.getPrezzo() + " .\n";

        return output;

    }

}