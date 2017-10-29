public class Test{
    public static void main(String[] args) {
        Persona[] gente = new Persona[5];
        gente[0] = new Impiegato("Mario", "Rossi", "Poste Italiane");
        gente[1] = new Impiegato("Giuseppe", "Verdi", "Poste Italiane");
        gente[2] = new Persona("Carlo", "Gentile");
        gente[3] = new Dirigente("Paolo", "Carloni", "Poste Italiane");
        gente[4] = new Studente("Alessandro", "Frenna", "Unipa", "0652004");


        for(Persona persona : gente) {
            persona.presentati();
        }
    }
}