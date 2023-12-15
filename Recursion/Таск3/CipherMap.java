import java.util.*;

public class CipherMap {

    private static Map<String, String> maps = new HashMap<>();
    private static String message;
    private static String result;
    private static TreeSet<String> toPrint = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        message = sc.nextLine();
        String cipher = sc.nextLine();

        mapsAdd(cipher);

        print();

    }

    private static void print() {
        result = "";
        decripted(message,result,maps);
        System.out.println(result.length());
        toPrint.forEach(System.out::println);
    }

    private static void mapsAdd(String cipher) {
        for (int i = 0; i < cipher.length(); i++) {
            String num = "";
            String symbols = "";
            if (Character.isAlphabetic(cipher.charAt(i))) {
                symbols = cipher.substring(i,i+1);
            } else {
                continue;
            }
            for (int j = i + 1; j < cipher.length(); j++) {
                char a = cipher.charAt(j);
                if (Character.isDigit(cipher.charAt(j))) {
                    num += a;
                } else {
                    break;
                }

            }
            maps.put(num,symbols);
        }
    }

    private static void decripted(String message, String result, Map<String, String> maps){
        int index = message.length();

        if (index == 0){
            toPrint.add(result);
        }

        for (int i = 0; i < index; i++) {
            String current = message.substring(0,i + 1);
            if (maps.containsKey(current)){
                decripted(message.substring(i + 1), result + maps.get(current),maps);
            }
        }
    }
}