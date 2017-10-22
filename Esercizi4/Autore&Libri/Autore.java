import java.util.Scanner;

public class Autore
{
    private String nome;
    private String cognome;

    public Autore(String nome, String cognome)
    {        
        this.setNome(nome);        
        this.setCognome(cognome);        
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCognome()
    {
        return this.cognome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public String toString()
    {
        return this.getNome() + " " + this.getCognome();
    }

}