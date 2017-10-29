public class Persona {

    protected String nome;
    protected String cognome;
    protected int eta;

    public Persona() {}

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = 0;
    }

    public Persona(String nome, String cognome, int eta){
        this(nome, cognome);
        this.eta = eta;
    }

    public final String getNome() {
        return this.nome;
    }

    public final String getCognome() {
        return this.cognome;
    }

    public final int getEta() {
        return this.eta;
    }

    public void presentati( ){
        int eta = this.getEta();
        System.out.println(
            "My name is " + this.getNome() + " " + this.getCognome() +
            ((this.getEta() != 0) ? " and I'm " + eta + " years old!" : "!")
        );
    }

    public String toString() {
        String output = this.getNome() + "\n" + 
            this.getCognome();
        return (this.getEta() != 0 ? output + this.getEta() : output);
    }
}