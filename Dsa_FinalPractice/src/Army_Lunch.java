import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Army_Lunch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countSoldiers = Integer.parseInt(reader.readLine());
        String[] soldiers = reader.readLine().split(" ");

        List<String> optimization = optimizationSolders(soldiers);

        for (String s : optimization) {
            System.out.print(s + " ");
        }
    }

    public static List<String> optimizationSolders(String[] soldiers) {
        List<String> sergeants = new ArrayList<>();
        List<String> corporals = new ArrayList<>();
        List<String> privates = new ArrayList<>();

        for (String sol : soldiers) {
            char rank = sol.charAt(0);
            int num = Integer.parseInt(sol.substring(1));
            switch (rank) {
                case 'S':
                    sergeants.add(sol);
                    break;
                case 'C':
                    corporals.add(sol);
                    break;
                case 'P':
                    privates.add(sol);
                    break;
            }
        }

        List<String> allSoldiers = new ArrayList<>();
        allSoldiers.addAll(sergeants);
        allSoldiers.addAll(corporals);
        allSoldiers.addAll(privates);

        return allSoldiers;
    }

}
