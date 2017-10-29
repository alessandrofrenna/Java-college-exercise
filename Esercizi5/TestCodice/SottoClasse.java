class SuperClasse {
    static int s;
    private int i;
    
    SuperClasse() {
        i++;
        s++;
    }

    protected int getValue() {
        return this.i;
    }
}

// s = 1; i = 1
// s = 2; i = 1 poiché è private dentro superclasse, quindi non è visibile in SottoClasse

public class SottoClasse extends SuperClasse {
    public static void main(String[] args) {
        SuperClasse sup = new SuperClasse();
        SottoClasse sot = new SottoClasse();
        System.out.println(SuperClasse.s);
        System.out.println(sot.getValue());
    }
}