import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Noahs_Ark {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int countRows = sc.nextInt();
        sc.nextLine();

        TreeMap<String, Integer> animals = new TreeMap<>();

        while (countRows -->0){
            String animal = sc.nextLine();
           if (!animals.containsKey(animal)){
               animals.put(animal,1);
           }else {
               int current = animals.get(animal);
               animals.put(animal,current+1);
           }
        }

        for (Map.Entry<String,Integer> entry : animals.entrySet()){
            if (entry.getValue() %2 == 1){
                System.out.println(entry.getKey() + " " + entry.getValue() + " No");
            }else {
                System.out.println(entry.getKey() + " " + entry.getValue() + " Yes");
            }
        }

    }
}
