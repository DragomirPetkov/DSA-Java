import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = sc.nextLine();

        while (!input.equals("END")){
            String[] token = input.split(", ");
            String direction = token[0];
            String carNumber = token[1];

            if (direction.equals("IN")){
                parkingLot.add(carNumber);
            }else {
                parkingLot.remove(carNumber);
            }
            input = sc.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            parkingLot.stream().forEach(System.out::println);
        }


     }
}
