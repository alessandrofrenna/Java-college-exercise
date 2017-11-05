class Libro extends Documento implements Comparable<Documento> {
    /**
     * Attributi principali di Libro:
     * @param title titolo
     * @param authors autori
     * @param editor casa editrice
     * @param type tipo
     */
    protected Person[] authors;
    protected String editor;
    
    public Libro(String title) {
        this.setTitle(title);
    }

    /**
     * Setters;
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(Person[] authors) {
        this.authors = authors;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    /**
     * Getters
     */
    public String getInfo() {
        this.type = this.getClass().toString();
        return this.type.replace("class ", "");
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthors() {
        String output = "";
        for(Person author : this.authors) {
            output += author.toString() + ", ";
        }
        return output.substring(0, output.lastIndexOf(", "));
    }

    public String getEditor() {
        return this.editor;
    }

    public Person[] getAuthorsArray() {
        return this.authors;
    }

    /**
     * To String method!;
     */
    public String toString() {
        String output = 
            "Id: " + this.getId() + "\n" +
            "Tipo: " + this.getInfo() + "\n" +
            "Titolo: " + this.getTitle() + "\n" +
            "Autore/i: " + this.getAuthors() + "\n" +
            "Casa Editrice: " + this.getEditor() + "\n"; 
        return output;
    }

    public boolean equals(Libro doc) {
        if(
            this.getTitle().equals(doc.getTitle()) && 
            this.getAuthors().equals(doc.getAuthors()) &&
            this.getEditor().equals(doc.getEditor())
        ) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Documento doc){
        if(doc instanceof Libro) {
            Person currentAuthor = this.getAuthorsArray()[0];
            Libro  libro = (Libro) doc;
            Person toBeComparedWith = libro.getAuthorsArray()[0];
            return currentAuthor.getLastName().compareTo(toBeComparedWith.getLastName());
        }
        return -1;
    }
}