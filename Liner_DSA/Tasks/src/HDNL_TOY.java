import java.util.*;

public class HDNL_TOY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Stack<Character> tags = new Stack<>();
        Stack<Integer> orders = new Stack<>();
        String indentation = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Character tag = line.charAt(0);
            int order = Integer.parseInt(line.substring(1));

            while (!orders.isEmpty() && orders.peek() >= order) {
                indentation = indentation.substring(1);
                result.append(String.format("%s</%c%d>\n", indentation, tags.pop(), orders.pop()));
            }

            tags.push(tag);
            orders.push(order);
            result.append(String.format("%s<%c%d>\n", indentation, tag, order));
            indentation += " ";
        }

        while (!orders.isEmpty()) {
            indentation = indentation.substring(1);
            result.append(String.format("%s</%c%d>\n", indentation, tags.pop(), orders.pop()));
        }

        System.out.println(result.toString());
    }
}
