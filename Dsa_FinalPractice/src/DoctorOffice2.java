import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorOffice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> queue = new ArrayList<>();
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        while (!input.equals("End")){
            String[] tokens = input.split(" ");

            if (tokens[0].equals("Append")){
                queue.add(tokens[1]);
                System.out.println("OK");
            } else if (tokens[0].equals("Examine")) {
                int remove = Integer.parseInt(tokens[1]);

                if (queue.size() < remove){
                    System.out.println("Error");
                    input = sc.nextLine();
                    continue;
                }
                for (int i = 0; i < remove; i++) {
                    sb.append(queue.get(0) + " ");
                    queue.remove(0);
                }
                System.out.println(sb.toString().trim());
                sb.setLength(0);
            } else if (tokens[0].equals("Insert")) {
                int index = Integer.parseInt(tokens[1]);
                String name = tokens[2];

                if (index < 0 || index > queue.size()){
                    System.out.println("Error");
                    input = sc.nextLine();
                    continue;
                }
                queue.add(index,name);
                System.out.println("OK");
            }else if (tokens[0].equals("Find")){
                String name = tokens[1];
                if (!queue.contains(name)){
                    System.out.println(0);
                }else {
                    int counter = 0;
                    for(String n : queue){
                        if (n.equals(name)){
                            counter++;
                        }
                    }
                    System.out.println(counter);
                }
            }
            input = sc.nextLine();
        }
    }
}
