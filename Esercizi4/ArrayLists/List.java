import java.util.*;

public class List 
{
    public static void findPari(ArrayList<Integer> numbers)
    {
        int size = numbers.size();
        for(int i = 0; i < size; i++) {
            if((numbers.get(i) %2) != 0) {
                numbers.remove(i);
                size--;
                i--;
            }            
        }
    }

    public static void removeDuplicates(ArrayList<Integer> numbers)
    {
        int size = numbers.size();
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++) {
                if(numbers.get(i).equals(numbers.get(j))){
                    numbers.remove(j);
                    size--;
                    j--;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(2);
        array.add(6);
        array.add(7);
        array.add(2);
        array.add(77);
        array.add(2);
        array.add(2);
        array.add(9);
        array.add(10);
        array.add(40);
        array.add(56);
        array.add(7);
        array.add(9);
        array.add(30);
        array.add(56);
        array.add(23);
        array.add(56);
        array.add(9);
        array.add(77);
        array.add(98);
        array.add(103);
        array.add(77);
        array.add(98);
        
        System.out.println(array);
        removeDuplicates(array);
        System.out.println(array);
        findPari(array);
        System.out.println(array);
        
    }
}