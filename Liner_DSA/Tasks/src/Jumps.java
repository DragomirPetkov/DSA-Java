import java.util.*;

public class Jumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countNumber = Integer.parseInt(scanner.nextLine());

        int[] integers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        LinkedList<Integer> result = new LinkedList<>();
        int maxCount = 0;

        for (int i = 0; i < integers.length; i++) {
            int first = integers[i];
            int countJumps = 0;
            for (int j = i + 1; j < integers.length; j++) {
                int second = integers[j];
                if (first < second) {
                    countJumps++;
                    first = second;
                }
            }
            if (countJumps > maxCount) {
                maxCount = countJumps;
            }
            result.add(countJumps);
        }
        System.out.println(maxCount);
        for (Integer i : result) {
            if (i == result.size()) {
                System.out.print(i);
            }
            System.out.print(i + " ");
        }
    }
}

