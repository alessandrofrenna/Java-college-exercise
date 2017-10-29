public class Studente extends Persona{

    protected String universita;
    protected String matricola;

    public Studente() {}

    public Studente(String nome, String cognome, int eta) {
        super(nome, cognome, eta);
        this.universita = "Unipa";
        this.matricola = "0000000";
    }

    public Studente(String nome, String cognome)
    {
        this(nome, cognome, 0);
    }

    public Studente(String nome, String cognome, int eta, String uni, String matricola) {
        this(nome, cognome, eta);
        this.universita = uni;
        this.matricola = matricola;
    }

    public Studente(String nome, String cognome, String uni, String matricola) {
        this(nome, cognome);
        this.universita = uni;
        this.matricola = matricola;
    }

    public final String getUniversita() {
        return this.universita;
    }

    public final String getMatricola() {
        return this.matricola;
    }

    @Override
    public void presentati() {
        System.out.println(
            "My name is " + this.getNome() + " " + this.getCognome() +
            " and I'm studying at " + this.getUniversita() + ". My student id is: " + this.getMatricola() + "!"
        );
    }

    @Override
    public String toString() {
        String output = this.getNome() + "\n" + 
            this.getCognome() + "\n" +
            this.getUniversita() + "\n" +
            this.getMatricola();

        return output;
    }
}