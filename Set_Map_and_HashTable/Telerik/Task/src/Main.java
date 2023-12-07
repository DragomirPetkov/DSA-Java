import java.util.*;
import java.util.stream.Collectors;

class Item implements Comparable<Item>{
    String name;
    Double price;
    String type;

    public Item(String name, Double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(type, item.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type);
    }

    @Override
    public String toString() {
        return getName() + "(" + String.format("%.2f", getPrice()) + ")";
    }

    @Override
    public int compareTo(Item o) {
        return Comparator.comparing(Item::getPrice)
                .thenComparing(Item::getName)
                .thenComparing(Item::getType)
                .compare(this,o);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Item> inventory = new HashMap<>();

        String command = sc.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "add":
                    addItem(tokens, inventory);
                    break;
                case "filter":
                    filterItem(tokens, inventory);
                    break;
            }
            command = sc.nextLine();
        }
    }

    private static void addItem(String[] tokens, Map<String, Item> inventory) {
        String name = tokens[1];
        double price = Double.parseDouble(tokens[2]);
        String type = tokens[3];

        if (inventory.containsKey(name)) {
            System.out.println(String.format("Error: Item %s already exists", name));
        } else {
            Item newItem = new Item(name, price, type);
            inventory.put(name, newItem);
            System.out.println(String.format("Ok: Item %s added successfully", name));
        }
    }

    private static void filterItem(String[] tokens, Map<String, Item> inventory) {
        List<Item> filteredItem = new LinkedList<>();
        String typeFilter = tokens[1] + tokens[2];
        switch (typeFilter) {
            case "bytype":
                filterByType(tokens[3], inventory, filteredItem);
                break;
            case "byprice":
                if (tokens.length > 5) {
                    double min = Double.parseDouble(tokens[4]);
                    double max = Double.parseDouble(tokens[6]);
                    filterFromMinToMax(min, max, inventory, filteredItem);
                } else if (tokens[3].equals("from")) {
                    double min = Double.parseDouble(tokens[4]);
                    filterFromMin(min, inventory, filteredItem);
                } else {
                    double max = Double.parseDouble(tokens[4]);
                    filterToMax(max, inventory, filteredItem);
                }
                break;
        }
    }

    private static void filterToMax(double max, Map<String, Item> inventory, List<Item> filteredItem) {
        filteredItem = inventory.values().stream().filter(i -> i.getPrice() <= max).collect(Collectors.toList());

        printFilter(filteredItem);
    }

    private static void filterFromMin(double min, Map<String, Item> inventory, List<Item> filteredItem) {
        filteredItem = inventory.values().stream().filter(i -> i.getPrice() > min).collect(Collectors.toList());

        printFilter(filteredItem);
    }

    private static void filterFromMinToMax(double min, double max, Map<String, Item> inventory, List<Item> filteredItem) {
        filteredItem = inventory.values().stream().filter(i -> i.getPrice() > min && i.getPrice() < max).collect(Collectors.toList());

        printFilter(filteredItem);
    }

    private static void filterByType(String itemType, Map<String, Item> inventory, List<Item> filteredItem) {
        filteredItem = inventory.values().stream().filter(i -> i.type.equals(itemType)).collect(Collectors.toList());

        if (filteredItem.size() == 0) {
            System.out.println(String.format("Error: Type %s does not exist", itemType));
            return;
        }
        printFilter(filteredItem);

    }

    private static void printFilter(List<Item> filteredData) {
        filteredData.sort(Comparator.comparing(Item::getPrice)
                .thenComparing(Item::getName)
                .thenComparing(Item::getType));

        if (filteredData.isEmpty()) {
            System.out.println("Ok:");
        } else {
            System.out.print("Ok: ");

            StringJoiner joiner = new StringJoiner(", ");
            int limit = Math.min(10, filteredData.size());

            for (Item item : filteredData.subList(0, limit)) {
                joiner.add(item.toString());
            }
            System.out.println(joiner);
        }
    }
}
//    long startTime = System.nanoTime();
//    //Logic you want to test
//    long endTime = System.nanoTime();
//    System.out.println(endTime - startTime);
//}