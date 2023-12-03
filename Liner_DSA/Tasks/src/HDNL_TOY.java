import java.util.*;

public class HDNL_TOY {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        Stack<Tag> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("");
            String letter = line[0];
            int level = Integer.parseInt(line[1]);

            if (stack.empty() || stack.peek().level >= level) {
                System.out.println("  <" + letter + level + ">");
                stack.push(new Tag(letter, level));
            } else {
                while (!stack.empty() && stack.peek().level > level) {
                    System.out.println("</" + stack.pop().letter + stack.pop().level + ">");
                }
                System.out.println("  <" + letter + level + ">");
                stack.push(new Tag(letter, level));
            }
        }

        while (!stack.empty()) {
            System.out.println("</" + stack.pop().letter + stack.pop().level + ">");
        }
    }

    private static class Tag {
        String letter;
        int level;

        public Tag(String letter, int level) {
            this.letter = letter;
            this.level = level;
        }
    }
}
