class Cd extends Documento implements Comparable<Documento> {
    protected String artist;
    protected int tracks;
    protected String label;
    
    protected int year;

    public Cd (String title, String artist, int year) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setYear(year);
    }

    /**
     * Setters
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrackNumber(int num) {
        this.tracks = num;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getters
     */
    public String getArtist() {
        return this.artist;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLabel() {
        return this.label;
    }

    public int getTrackNumber() {
        return this.tracks;
    }

    public int getYear() {
        return this.year;
    }

    public String getInfo() {
        this.type = this.getClass().toString();
        return this.type.replace("class ", "");
    }

    /**
     * To string method
     */
    public String toString() {
        String output = 
            "Id: " + this.getId() + "\n" +
            "Tipo: " + this.getInfo() + "\n" +
            "Titolo: " + this.getTitle() + "\n" +
            "Autore/i: " + this.getArtist() + "\n" +
            "Anno d'uscita: " + this.getYear() + "\n" +
            "Numero brani: " + this.getTrackNumber() + "\n" +
            "Casa Discografica: " + this.getLabel() + "\n"; 
        return output;
    }

    public int compareTo(Documento doc) {
        if(doc instanceof Cd) {
            Cd cast = (Cd) doc;
            return this.getTitle().compareTo(cast.getTitle());
        } 
        return 0;
    }

    public boolean equals(Cd doc) {
        if(
            this.getTitle().equals(doc.getTitle()) && 
            this.getArtist().equals(doc.getArtist()) &&
            this.getLabel().equals(doc.getLabel()) &&
            this.getYear() == doc.getYear() &&
            this.getTrackNumber() == doc.getTrackNumber()
        ) {
            return true;
        }
        return false;
    }
}