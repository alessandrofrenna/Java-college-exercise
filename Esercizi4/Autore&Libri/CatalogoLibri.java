import java.util.*;

public class CatalogoLibri
{


    private ArrayList<Libro> catalogo = new ArrayList<Libro>();

    public static void menu()
    {
        System.out.println(
            "Benvenuto\n\n" +
            "1. Inserisci un nuovo libro;\n" + 
            "2. Visualizza catalogo;\n" +
            "3. Cerca il libro tramite nome; \n" + 
            "4. Esci.\n"
        );
    }

    public CatalogoLibri()
    {
        Scanner input = new Scanner(System.in);

        int num;

        do{
            num = 0;
            CatalogoLibri.menu();
            System.out.print("Cosa scegli? (1-4) : ");
            num = input.nextInt();
            
            this.selection(num);

        }while(num != 4);

    }

    public void selection(int selection)
    {
        switch(selection) {
            case 1: 
                this.catalogo.add(new Libro());
            break;
            
            case 2: 
                this.printCatalogo();
            break;

            case 3:
                Scanner input = new Scanner(System.in);
                System.out.println("Inserisci nome libro: ");
                Libro found = this.searchLibro(input.nextLine());
                if(found != null) {
                    System.out.println(
                        "Libro trovato: \n\n" +
                        found.toString()
                    );
                } else {
                    System.out.println("Non ho trovato nulla!");
                }
            break;
                
            default: break;
        }
    }

    public void printCatalogo()
    {
        for(Libro libro : catalogo){
            System.out.println(libro.toString());
            System.out.println("\n");
        }
    }

    public Libro searchLibro(String titolo)
    {
        for(Libro libro: catalogo){
            if(libro.getTitolo().equals(titolo)){
                return libro;
            }
        }

        return null;
    }
}