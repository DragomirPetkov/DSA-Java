import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SmallWorld {

    private static int rows;
    private static int cols;
    private static Scanner sc;
    private static  int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static  int[][] matrix;
    private static boolean[][] visited;
    public static void main(String[] args)  {
        sc = new Scanner(System.in);

        rows = sc.nextInt();
        cols = sc.nextInt();
        matrix = new int[rows][cols];

        readMatrix();
        visited = new boolean[rows][cols];

        List<Integer> result = findcSize();
        result.sort((a,b) -> b - a );

        for (int size  : result){
            System.out.println(size);
        }



    }

    private static List<Integer> findcSize() {

        List<Integer> conques = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]){
                    int size = dfs(i,j);
                    conques.add(size);
                }
            }
        }

        return conques;
    }

    private static int dfs(int r, int c) {
        visited[r][c] = true;
        int size = 1;

        for (int[] direction : directions){
            int newR = direction[0] + r;
            int newC = direction[1] + c;

            boolean isValid;
            if (isValid(newR,newC)){
                size += dfs(newR,newC);
            }
        }
        return size;
    }

    private static boolean isValid(int r, int c){
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == 1 && !visited[r][c];

    }

    private static void readMatrix() {
        for (int i = 0; i < rows; i++) {
            String row = sc.next();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
    }
}
