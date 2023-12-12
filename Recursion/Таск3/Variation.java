import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Variation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        Arrays.sort(input);

        String output = "";
        variation(input,count,output);
    }
    private static void variation(String[] input, int count, String output){
        if(count == 0){
            System.out.println(output);
            return;
        }
        for (int i = 0; i < input.length; i++) {
            String write = output + input[i];
            variation(input,count - 1, write);
        }
    }
}