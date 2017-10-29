public class Impiegato extends Persona{
    
    protected String societa;
    protected double salario;
    protected Persona datoreLavoro;

    public Impiegato() {}

    public Impiegato(String nome, String cognome, String societa) {
        super(nome, cognome);
        this.societa = societa;
        this.datoreLavoro = new Persona("no", "one");
    }

    public final void setDatoreLavoro(Persona capo) {
        this.datoreLavoro = capo;
    }

    public final void setSalario(double money) {
        this.salario = money;
    }

    public final String getSocieta() {
        return this.societa;
    }

    public final String getDatoreLavoro() {
        return (String)(this.datoreLavoro.getNome() + " " + this.datoreLavoro.getCognome());
    }

    public final double getSalario() {
        return this.salario;
    }

    @Override
    public void presentati() {
        System.out.println(
            "My name is " + this.getNome() + " " + this.getCognome() +
            " and I'm working at " + this.getSocieta() + ". My boss is: " + this.getDatoreLavoro() + "!"
        );
    }

    @Override
    public String toString() {
        String output = this.getNome() + "\n" + 
            this.getCognome() + "\n" +
            this.getSocieta() + "\n" +
            this.getDatoreLavoro() + "\n" +
            this.getSalario();

        return output;
    }
}