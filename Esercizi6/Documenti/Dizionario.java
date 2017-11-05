class Dizionario extends Libro implements Comparable<Documento>{
    protected String language;
    
    public Dizionario(String title) {
        super(title);
    }

    /**
     * Setters;
     */
    public void setLanguage(String lang) {
        this.language = lang;
    }

    /**
     * Getters
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * To String method!;
     */
    public String toString() {
        String output = 
            "Id: " + this.getId() + "\n" +
            "Tipo: " + this.getInfo() + "\n" +
            "Titolo: " + this.getTitle() + "\n" +
            "Lingua: " + this.getLanguage() + "\n" +
            "Autore/i: " + this.getAuthors() + "\n" +
            "Casa Editrice: " + this.getEditor() + "\n"; 
        return output;
    }

    public boolean equals(Dizionario doc) {
        if(
            this.getTitle().equals(doc.getTitle()) && 
            this.getAuthors().equals(doc.getAuthors()) &&
            this.getEditor().equals(doc.getEditor()) &&
            this.getLanguage().equals(doc.getLanguage())
        ) {
            return true;
        }
        return false;
    }

}