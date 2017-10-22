import java.util.*;

public class Array
{
    public static void stampaArray(int[] array)
    {
        if(array.length == 0){
            System.out.println("[ ]");
        }

        String arrayString = "[ ";

        for(int element : array) {
            arrayString += element +", ";
        }

        arrayString = arrayString.substring(0, arrayString.lastIndexOf(",")) + " ]";
        System.out.println(arrayString);
    }

    public static double mediaValori(int[] array)
    {
        double media = 0.00;
        int elements = array.length;

        if(elements == 0) {
            return media;
        }

        for(int element : array) {
            media += element;
        }

        return media/elements;
    }

    public static int[] findPari(int[] array) 
    {
        ArrayList<Integer> even = new ArrayList<Integer>();
        
        if(array.length == 0) {
            return array;
        }

        for(int element : array) {
            if (element%2 == 0) {
                even.add(element);
            }
        }

        int[] result = new int[even.size()];

        for(int i = 0; i < even.size(); i++) {
            result[i] = even.get(i);
        }

        return result;
    }

    public static int[] eliminaDuplicati(int[] array)
    {   
        if(array.length == 0) {
            return array;
        }

        int length = array.length;

        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                if(array[i] == array[j]){
                    array[j] = array[length-1];
                    length--;
                    j--;
                }
            }
        }

        int[] result = Arrays.copyOf(array, length);
        
        return result; 
    }

    public static void main(String[] args)
    {
        int[] array = {2,6,7,9,10,40, 7, 30, 23, 56, 77, 98, 103};
        int[] duplicati = {2, 3, 5, 2, 5, 2, 4};
        stampaArray(array);

        System.out.println("La media dei valori dell'array di sopra e': " + mediaValori(array));
        stampaArray(findPari(array));
        stampaArray(eliminaDuplicati(duplicati));

    }
}