import java.util.Comparator;

class DocTitleComp implements Comparator<Documento> {

    @Override
    public int compare(Documento doc1, Documento doc2) {
        return doc1.getTitle().compareTo(doc2.getTitle());
    }

}