import java.util.*;

public class Biblioteca {

    public ArrayList<Documento> biblioteca = new ArrayList<Documento>();

    public String firstMenu() {
        return (
            "Fai la tua scelta: \n" +
            "1. Inserisci documento;\n" +
            "2. Modifica documento;\n" +
            "3. Elimina documento;\n" +
            "4. Cerca documento;\n" +
            "5. Mostra biblioteca;\n" +
            "6. Esci."
        );
    }

    public String secondMenu() {
        return (
            "Fai la tua scelta: \n" +
            "1. Inserisci libro;\n" +
            "2. Inserisci dizionario;\n" +
            "3. Inserisci quotidiano;\n" +
            "4. Inserisci cd;\n" +
            "5. Esci."
        );
    }

    public void firstSwitch(int selected) {
        switch(selected) {
            case 1: this.insertDoc(); break;
            case 2: this.editDoc(); break;
            case 3: this.deleteDoc(); break;
            case 4: 
                int risultato = this.searchElement(); 
                if(risultato != -1) {
                    System.out.println(this.getDocument(risultato));
                } else {
                    System.out.println("Non ho trovato nulla, riprova");
                }
            break;
            case 5: this.showLibrary(); break;
        }
    }

    public void secondSwitch(int selected) {
        switch(selected) {
            case 1: this.insertBook(); break;
            case 2: this.insertDict(); break;
            case 3: this.insertNewsP(); break;
            case 4: this.insertCD(); break;
        }
    }

    public void insertDoc() {
        int choice = 0;
        do {
            System.out.println(this.secondMenu());
            Scanner input = new Scanner(System.in);
            choice = Integer.parseInt(input.nextLine());
            this.secondSwitch(choice);
        } while(choice != 5);
    }

    /**
     * Costruttore!
     */
    public Biblioteca() {
        int choice = 0;
        do {
            System.out.println(this.firstMenu());
            Scanner input = new Scanner(System.in);
            choice = Integer.parseInt(input.nextLine());
            this.firstSwitch(choice);
        } while(choice != 6);
    }

    /** 
     * Metodi per l'inserimento dei vari documenti!
     */

    public void insertBook() {
        Scanner bookS = new Scanner(System.in);
        System.out.print("Inserisci Titolo: ");
        Libro l = new Libro(bookS.nextLine());
        System.out.print("Inserisci casa editrice: ");
        l.setEditor(bookS.nextLine());

        System.out.print("Quanti sono gli autori? ");
        int num = Integer.parseInt(bookS.nextLine());
        Person[] authors = new Person[num];

        for(int i = 0; i < num; i++) {
            System.out.printf("Autore %d\n", i + 1);
            System.out.print("Nome: ");
            String nome = bookS.nextLine();
            System.out.print("Cognome: ");
            String cognome = bookS.nextLine();
            authors[i] = new Person(nome, cognome);
        }

        l.setAuthors(authors);

        if(isDuplicate(l)) {
            System.out.println("Trovato duplicato, non sarà inserito!");
        } else {
            this.biblioteca.add(l);
        }
    }

    public void insertDict() {
        Scanner dictS = new Scanner(System.in);
        System.out.print("Inserisci Titolo: ");
        Dizionario d = new Dizionario(dictS.nextLine());
        System.out.print("Inserisci lingua: ");
        d.setLanguage(dictS.nextLine());
        System.out.print("Inserisci casa editrice: ");
        d.setEditor(dictS.nextLine());

        System.out.print("Quanti sono gli autori? ");
        int num = Integer.parseInt(dictS.nextLine());
        Person[] authors = new Person[num];

        for(int i = 0; i < num; i++) {
            System.out.printf("Autore %d\n", i + 1);
            System.out.print("Nome: ");
            String nome = dictS.nextLine();
            System.out.print("Cognome: ");
            String cognome = dictS.nextLine();
            authors[i] = new Person(nome, cognome);
        }

        d.setAuthors(authors);

        if(isDuplicate(d)) {
            System.out.println("Trovato duplicato, non sarà inserito!");
        } else {
            this.biblioteca.add(d);
        }
    }

    public void insertNewsP() {
        Scanner newsS = new Scanner(System.in);
        System.out.print("Inserisci Titolo: ");
        String titolo = newsS.nextLine();
        System.out.print("Inserisci Editore: ");
        String editore = newsS.nextLine();
        System.out.print("Inserisci data publicazione: ");
        String data = newsS.nextLine();
        Quotidiano q = new Quotidiano(titolo, editore, data);
        
        if(isDuplicate(q)){
            System.out.println("Trovato duplicato, non sarà inserito!");
        } else {
            this.biblioteca.add(q);
        }
        
    }

    public void insertCD() {
        Scanner cdS = new Scanner(System.in);
        System.out.print("Inserisci Titolo: ");
        String titolo = cdS.nextLine();
        System.out.print("Inserisci Artista: ");
        String artista = cdS.nextLine();
        System.out.print("Inserisci anno publicazione: ");
        Cd c = new Cd(titolo, artista, Integer.parseInt(cdS.nextLine()));
        System.out.print("Inserisci numero tracce: ");
        c.setTrackNumber(Integer.parseInt(cdS.nextLine()));
        System.out.print("Inserisci casa discografica: ");
        c.setLabel(cdS.nextLine());

        if(isDuplicate(c)){
            System.out.println("Trovato duplicato, non sarà inserito!");
        } else {
            this.biblioteca.add(c);
        }
    }

    /**
     * Metodi per la manipolazione
     */

    public void editDoc() {
        Scanner scanner = new Scanner(System.in);

        int index = this.searchElement();

        if(index == -1) {    
            System.out.print("Elemento non trovato, vuoi inserirlo? ");
            String answ = scanner.nextLine();
            switch(answ.toLowerCase()){
                case "yes":
                case "si":
                    this.insertDoc();
                break;
                case "no": 
                break;
            }

        } else {
            System.out.println("Elemento prima della modifica: \n" + this.getDocument(index) + "\n");
            Documento doc = this.biblioteca.get(index);
            if(doc instanceof Libro) {
                Libro res = this.editBook(doc);
                if(doc instanceof Dizionario) {
                    Dizionario d = (Dizionario)res;
                    System.out.print("Inserirsci nuova lingua o lascia in bianco: ");
                    String lingua = scanner.nextLine();
                    if(!(lingua.equals(""))) {
                        d.setLanguage(lingua);
                    }
                    this.biblioteca.set(index, d);
                }
                this.biblioteca.set(index, res);
            } else if(doc instanceof Quotidiano) {
                this.biblioteca.set(index, this.editNewsPaper(doc));
            } else if(doc instanceof Cd) {
                this.biblioteca.set(index, this.editCD(doc));
            } else {
                System.out.println("No compatible type!");
            }

        }

        System.out.println("Nuovo elemento modificato: \n" + this.getDocument(index));
    }

    public void deleteDoc() {
        int risultato = this.searchElement();
        if(risultato != -1) {
            System.out.println("Sto eliminando : \n"+ this.biblioteca.get(risultato));
            this.biblioteca.remove(risultato);
        }
    }

    public int searchElement() {
        Scanner search = new Scanner(System.in);
        System.out.print("Inserirsci il titolo dell'elemento da cercare: ");
        String title = search.nextLine();
        Collections.sort(this.biblioteca, new DocTitleComp());


        for(int i = 0; i < this.biblioteca.size(); i++) {
            if(this.biblioteca.get(i).getTitle().equals(title)) {
                return i;
            }
        }

        return -1;
    }

    public void showLibrary() {
        Collections.sort(this.biblioteca); //, new DocTitleComp());
        System.out.println(this.biblioteca);
    }


    /**
     * Methods to edit by a single instance!
     */

    public Libro editBook(Documento doc) {
        Scanner scanner = new Scanner(System.in);

        Libro l = (Libro) doc;

        System.out.print("Inserisci nuovo titolo o lascia in bianco: ");
        
        String titolo = scanner.nextLine();
        if(!(titolo.equals(""))) {
            l.setTitle(titolo);
        }
        
        System.out.print("Inserisci nuova casa editrice o lascia in bianco: ");
        String casaEd = scanner.nextLine();
        if(!(casaEd.equals(""))) {
            l.setEditor(casaEd);
        }

        System.out.print("Vuoi modificare l'/gli autore/i? ");
        String answ = scanner.nextLine();
        switch(answ.toLowerCase()){
            case "yes":
            case "si":
                Person[] authors = l.getAuthorsArray();
                for(int i = 0; i < authors.length; i++) {
                    System.out.printf("Autore %d: \n", i+1);
                    System.out.print("Inserisci nuovo nome o lascia in bianco: ");
                    String nome = scanner.nextLine();
                    if(!(nome.equals(""))) {
                        authors[i].setName(nome);
                    }           
                    System.out.print("Inserisci nuovo cognome o lascia in bianco: ");
                    String cognome = scanner.nextLine();
                    if(!(cognome.equals(""))) {
                        authors[i].setLastName(cognome);
                    }
                }
                l.setAuthors(authors);
            break;
            case "no": 
            break;
        }

        return l;
    }

    public Quotidiano editNewsPaper(Documento doc) {
        Quotidiano n = (Quotidiano) doc;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci nuovo titolo o lascia vuoto: ");
        String titolo = scanner.nextLine();

        if(!(titolo.equals(""))) {
            n.setTitle(titolo);
        }

        System.out.print("Inserisci nuovo editore: ");
        String editore = scanner.nextLine();

        if(!(editore.equals(""))) {
            n.setEditor(editore);
        }

        return n;
    }

    public Cd editCD(Documento doc) {
        Cd c = (Cd) doc;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci nuovo titolo o lascia vuoto: ");
        String titolo = scanner.nextLine();

        if(!(titolo.equals(""))) {
            c.setTitle(titolo);
        }

        System.out.print("Inserisci nuovo artista o lascia vuoto: ");
        String artista = scanner.nextLine();

        if(!(artista.equals(""))) {
            c.setArtist(artista);
        }

        System.out.print("Inserisci nuova casa discografica o lascia vuoto: ");
        String casaDisco = scanner.nextLine();

        if(!(casaDisco.equals(""))) {
            c.setLabel(casaDisco);
        }

        System.out.print("Inserisci nuovo numero tracce o lascia vuoto: ");
        String tracce = scanner.nextLine();

        if(!(tracce.equals(""))) {
            c.setTrackNumber(Integer.parseInt(tracce));
        }

        System.out.print("Inserisci nuovo anno publicazione o lascia vuoto: ");
        String anno = scanner.nextLine();

        if(!(anno.equals(""))) {
            c.setYear(Integer.parseInt(anno));
        }

        return c;
    }

    /**
     * Get single document!
     */
    public Documento getDocument(int index) {
        return this.biblioteca.get(index);
    }

    /**
     * Binary search for finding duplicates
     */
    public boolean isDuplicate(Documento doc) {
        Collections.sort(this.biblioteca, new DocTitleComp());
        int index = Collections.binarySearch(this.biblioteca, doc, new DocTitleComp());
        if(index != -1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
    }
}

9c8373751dbdaf5354f30a9abaae5b491ca98d03