import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DoctorsOffice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> queue = new ArrayList<>();
        Map<String, Integer> nameCount = new HashMap<>();

        String input;

        while (!(input = reader.readLine()).equals("End")) {
            String[] tokens = input.split(" ");

            String command = tokens[0];

            switch (command) {
                case "Append":
                    String name = tokens[1];
                    queue.add(name);
                    nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
                    System.out.println("Ok");
                    break;
                case "Insert":
                    int position = Integer.parseInt(tokens[1]);
                    if (position >= 0 && position <= queue.size()) {
                        String nameToInsert = tokens[2];
                        queue.add(position, nameToInsert);
                        nameCount.put(nameToInsert, nameCount.getOrDefault(nameToInsert, 0) + 1);
                        System.out.println("Ok");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "Find":
                    String findName = tokens[1];
                    System.out.println(nameCount.getOrDefault(findName, 0));
                    break;
                case "Examine":
                    int count = Integer.parseInt(tokens[1]);
                    if (count <= queue.size()) {
                        for (int i = 0; i < count; i++) {
                            String examinedName = queue.remove(0);
                            nameCount.put(examinedName, nameCount.get(examinedName) - 1);
                            System.out.print(examinedName + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Error");
                    }
                    break;
            }
        }
    }
}
