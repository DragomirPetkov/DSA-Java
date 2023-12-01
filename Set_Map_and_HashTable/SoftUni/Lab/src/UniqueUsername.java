import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> parkingLot = new HashSet<>();

        String input = sc.nextLine();

        while (!input.equals("END")){
            String[] token = input.split(", ");
            String record = token[0];
            String carNumber = token[1];

            if (record.equals("IN")){
                parkingLot.add(carNumber);
            }else {
                parkingLot.remove(carNumber);
            }
            input = sc.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        parkingLot.stream().forEach(System.out::println);
    }
}
