import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Quotidiano extends Documento implements Comparable<Documento> {
    protected String editor;
    protected Date date; 

    public Quotidiano(String title, String editor, String date) {
        this.setTitle(title);
        this.setEditor(editor);
        this.setDate(date);
    }

    /**
     * Setters
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setDate(String date) {
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");    
        try{
            this.date = fd.parse(date);
        } catch (ParseException e) {
            System.out.println(e);
        }
        
    }

    /**
     * Getters
     */
    public String getTitle() {
        return this.title;
    }

    public String getEditor() {
        return this.editor;
    }

    public Date getDate() {
        return this.date;
    }

    public String getInfo() {
        this.type = this.getClass().toString();
        return this.type.replace("class ", "");
    }

    /**
     * To String method;
     */
    public String toString() {
        String output = 
            "Id: " + this.getId() + "\n" +
            "Tipo: " + this.getInfo() + "\n" +
            "Titolo: " + this.getTitle() + "\n" +
            "Editore: " + this.getEditor() + "\n" +
            "Data d'uscita: " + this.getDate() + "\n";
        return output;
    }

    @Override    
    public int compareTo(Documento doc) {
        if(doc instanceof Quotidiano) {
            return this.getTitle().compareTo(doc.getTitle());
        }
        return -1;
    }

    public boolean equals(Quotidiano doc) {
        if(
            this.getTitle().equals(doc.getTitle()) && 
            this.getEditor().equals(doc.getEditor()) &&
            this.getDate().toString().equals(doc.getDate().toString())
        ) {
            return true;
        }
        return false;
    }
    
}