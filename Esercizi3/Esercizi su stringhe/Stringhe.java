import java.util.regex.*;
import java.util.Arrays;

public class Stringhe
{

    public static void iniziali(String nome, String cognome)
    {
        System.out.println(nome.toUpperCase().charAt(0) + "&" + cognome.toUpperCase().charAt(0));
    }

    public static void stringReverse(String stringa)
    {
        StringBuilder string = new StringBuilder(stringa);
        System.out.println(string.reverse());
    }

    public static int contaOccorrenze(String stringa, String pattern)
    {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(stringa);
        
        int index = 0;
        int counter = 0;

        while(matcher.find(index) != false)
        {
            counter++;
            index = matcher.start() + 1;
        }

        return counter;
    }

    public static boolean isValidEmailRegex(String email)
    {
        String regex = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)*\\.(it|com|biz|eu|net|co.uk|info|[a-z]{2})";
        return email.matches(regex);
    }

    public static String fibonacci(int number)
    {
        String a = "a";
        String b = "b";

        if(number == 1) return b;
        if(number == 2) return a;

        for (int i = 3; i <= number; i++){
            String temp = b;
            b = a;
            a = b + temp;
        }

        return a;
    }

    public static void alfabeto(int a, int n) 
    {
        String alfabeto = "";

        for(int i = 0; i < n; i++){
            int val = (int) (a * Math.random());
            alfabeto += val;
        }

        System.out.println(alfabeto);
    }

    public static int sumOfDigits(int number)
    {
        String num = String.valueOf(number);
        
        int acc = 0;

        for(int i = 0; i < num.length(); i++){
            acc += num.charAt(i) - 48;
        }

        return acc;
    }

    public static boolean isAnagram(String string, String string2)
    {        
        char[] first = string.toLowerCase().replaceAll(" ", "").toCharArray();
        char[] second = string2.toLowerCase().replaceAll(" ", "").toCharArray();

        if(first.length != second.length) {
            return false;
        }

        Arrays.sort(first);
        Arrays.sort(second);

        if(Arrays.equals(first,second)){
            return true;
        } else {
            return false;
        }
    }

    public static String eliminaVocali(String stringa)
    {
        return stringa.replaceAll("(a|e|i|o|u|A|E|I|O|U)+", "");
    }

    public static String convertiUnario(int number)
    {
        StringBuilder convertita = new StringBuilder("");

        for(int i = 0; i < number; i++){
            convertita.append("0");
        }

        return convertita.toString();
    }

    public static String stringCapitalize(String stringa)
    {
        if(stringa == null) return stringa;
        if(stringa.length() == 0) return stringa;

        StringBuilder capitalized = new StringBuilder();
        capitalized.append(Character.toUpperCase(stringa.charAt(0)));
        Pattern regex = Pattern.compile("\\s");
        Matcher matcher = regex.matcher(stringa);
        int index = 1;

        while(matcher.find(index)) {
            capitalized.append(stringa.substring(index, matcher.start() + 1));
            capitalized.append(Character.toUpperCase(stringa.charAt(matcher.start() + 1 )));
            index = matcher.start() + 2 ;
        }
        capitalized.append(stringa.substring(index));
        return capitalized.toString();
        
    }

    public static void main(String[] args)
    {
        iniziali("alessandro", "frenna");
        stringReverse("al capitano mancano tre denti");
        int occorrenze = contaOccorrenze("Alessaaaandro", "aaa");
        System.out.println("Il numero delle occorrenze e': " + occorrenze);

        String email = "alessandrofrenna@gmail.com";
        if(isValidEmailRegex(email)){
            System.out.println("The email " + email + " is valid!");
        } else {
            System.out.println("The email " + email + " isn't valid!");
        }

        System.out.println(fibonacci(6));
        alfabeto(5, 10);
        System.out.println(sumOfDigits(1554567));

        if(isAnagram("Ciccio mangia la cacca", "Acacia Coca Mica Cling")){
            System.out.println("Le due stringhe sono una l'anagramma di un'altra!");
        } else {
            System.out.println("Le due stringhe non sono una l'anagramma di un'altra!");
        }

        System.out.println("Elimino le vocali: " + eliminaVocali(
            "ciao come stai? io so che non sono solo anche quando sono solo, io lo so che non sono solo." +
            " Ciao come stai ? cosa cavolo vuoi da questo bagno infestato da demoni?"
        ));

        System.out.println(convertiUnario(0));

        System.out.println(stringCapitalize("ciao come stai? Io sto bene, tu ? Non c'è di che"));
    }

}