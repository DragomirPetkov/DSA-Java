import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class JustCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String input = reader.readLine();

        Map<Character,Integer> specialSymbols = new TreeMap<>();
        Map<Character,Integer> lowerCase = new TreeMap<>();
        Map<Character,Integer> upperCase = new TreeMap<>();
        
        for (char symbols : input.toCharArray()){
            if (Character.isUpperCase(symbols)){
                upperCase.put(symbols,upperCase.getOrDefault(symbols,0) + 1);
            } else if (Character.isLowerCase(symbols)) {
                lowerCase.put(symbols,lowerCase.getOrDefault(symbols,0)+1);
            }else {
                specialSymbols.put(symbols,specialSymbols.getOrDefault(symbols,0)+1);
            }
        }
        findLangestCount(specialSymbols);
        findLangestCount(lowerCase);
        findLangestCount(upperCase);
    }

    private static void findLangestCount(Map<Character, Integer> map) {

        if (map.isEmpty()){
            System.out.println("-");
        }else {
            Character maxKey = null;
            int maxValue = 0;

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            System.out.println(maxKey + " " + maxValue);
        }
    }
}
