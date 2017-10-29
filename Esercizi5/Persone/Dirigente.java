public class Dirigente extends Impiegato{
    
    protected String dipartimento;

    public Dirigente() {}

    public Dirigente(String nome, String cognome, String societa) {
        super(nome, cognome, societa);
    }

    public final void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public final String getDipartimento() {
        return this.dipartimento;
    }

    @Override
    public void presentati() {
        System.out.println(
            "My name is " + this.getNome() + " " + this.getCognome() +
            " and I'm working at " + this.getSocieta() + ". I'm the manager of the " + this.getDipartimento() 
            + " department. My boss is: " + this.getDatoreLavoro() + "!"
        );
    }

    @Override
    public String toString() {
        String output = this.getNome() + "\n" + 
            this.getCognome() + "\n" +
            this.getSocieta() + "\n" +
            this.getDatoreLavoro() + "\n" +
            this.getDipartimento() + "\n" +
            this.getSalario();

        return output;
    }
}