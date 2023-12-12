import java.util.*;

public class CipherMap {
    private static Map<Character, String> cipherLibrary = new HashMap<>();
    private static String message;
    private static List<String> variations = new ArrayList<>();
    private static char[] decipheredMessage = new char[message.length()];
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        message = sc.nextLine();
        String cipher = sc.nextLine();


        for (int i = 0; i < cipher.length(); i++) {
            String num = "";
            char symbols = '\0';
            if (Character.isAlphabetic(cipher.charAt(i))) {
                symbols = cipher.charAt(i);
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
            cipherLibrary.put(symbols, num);
        }
//        decipherMessage(message, decipheredMessage, cipherLibrary);

        Collections.sort(variations);

        result.append("");

        for (String item : variations) {
            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) != ' ') {
                    result.append(item.charAt(i));
                }
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }

//    private static void decipherMessage(String message, char[] decipheredMessage, Map<Character, String> cipherLibrary) {
//        if (decipheredMessage.length == message.length()) {
//            variations.add(new String(decipheredMessage));
//            return;
//        }
//
//        String messageToDecipher = message.substring(decipheredMessage.length);
//
//        for (Map.Entry<String, Character> kvp : cipherLibrary.entrySet()) {
//            if (messageToDecipher.startsWith(kvp.getKey())) {
//                decipheredMessage[decipheredMessage.length] = kvp.getValue();
//                decipherMessage(messageToDecipher.substring(kvp.getKey().length()), decipheredMessage, cipherLibrary);
//            }
//        }
    }