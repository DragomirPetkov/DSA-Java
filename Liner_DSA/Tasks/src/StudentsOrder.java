
import java.util.*;

public class StudentsOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = scanner.nextInt();
        int pairCount = scanner.nextInt();
        scanner.nextLine();

        Map<String, Integer> students = new HashMap<>();
        Map<Integer, String> studentsIntKey = new TreeMap<>();

        for (int i = 0; i < countStudents; i++) {
            String name = scanner.next();
            students.put(name, i);
            studentsIntKey.put(i, name);
        }
        scanner.nextLine();

        while (pairCount-- > 0){
            String[] pairsName = scanner.nextLine().split(" ");
            int indexFirstName = students.get(pairsName[1]);
            int indexSecondName = students.get(pairsName[0]);
            if (indexFirstName < indexSecondName) {
                for (Map.Entry<String, Integer> entry : students.entrySet()) {
                    if (entry.getValue() >= indexFirstName && entry.getValue() < indexSecondName) {
                        entry.setValue(entry.getValue() + 1);
                    }
                }
                students.put(pairsName[0], indexFirstName);

            } else if (indexFirstName > indexSecondName) {
                for (Map.Entry<String, Integer> entry : students.entrySet()) {
                    if (entry.getValue() > indexSecondName && entry.getValue() < indexFirstName) {
                        entry.setValue(entry.getValue() - 1);
                    }
                }
                students.put(pairsName[0], indexFirstName - 1);
            }
        }
        students.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> System.out.print(e.getKey() + " "));

    }
}
