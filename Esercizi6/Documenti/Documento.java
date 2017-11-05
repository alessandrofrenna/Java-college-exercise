abstract class Documento implements Comparable<Documento> {
    protected String title;
    private static int progressive = 0;
    private String id;
    protected String type; 

    public Documento() {
        this.generateId();
    }

    private void generateId () {
        progressive += 1;
        this.id = String.valueOf(progressive);
    }

    public String getId() {
        return this.id;
    }

    abstract public String getTitle();
    abstract public void setTitle(String title);
    abstract public String getInfo();
}