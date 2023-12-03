import com.company.dsa.LinkedList;

import java.util.*;
import java.util.stream.Collectors;

public class StudentsOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int countStudents = numbers[0];
        int steps = numbers[1];

        List<String> list = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        for (int i = 0; i < steps; i++) {
            String[] names = sc.nextLine().split(" ");
            for (int j = 0; j < list.size(); j++) {
                int index = 0;
                if (list.get(j).equals(names[1])){
                    index = j;
                    list.remove(names[0]);
                    if (j == 0){
                        list.add(0,names[0]);
                    }else {
                        list.add(j-1,names[0]);
                    }
                    break;
                }
            }
        }
        for (String s : list){
            System.out.print(s +" ");
        }
    }
}
