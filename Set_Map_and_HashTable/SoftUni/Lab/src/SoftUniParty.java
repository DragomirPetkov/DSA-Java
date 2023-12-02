import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Set<String> guest = new TreeSet<>();

        String input = sc.nextLine();

      input = guestParty(input, guest, sc);
        guestEnd(input, guest, sc);

        System.out.println(guest.size());
        guest.stream().forEach(System.out::println);
    }

    public static String guestParty(String input, Set<String> guestParty, Scanner sc) {
        while (!input.equals("PARTY")) {
            guestParty.add(input);
            input = sc.nextLine();

        }
        return input;
    }

    public static void guestEnd(String input, Set<String> guestParty, Scanner sc) {
        while (!input.equals("END")) {
            guestParty.remove(input);
            input = sc.nextLine();

        }
    }
}
