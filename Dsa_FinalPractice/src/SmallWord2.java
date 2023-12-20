import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallWord2 {

    private static int[][] matrix;
    private static Scanner sc;
    private static int rows;
    private static int cols;

    private static boolean[][] visited;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        rows = sc.nextInt();
        cols = sc.nextInt();

        matrix = new int[rows][cols];
        visited = new boolean[rows][cols];

        List<Integer> result = new ArrayList<>();
        readMatrix();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    int currSuface = getSufaceLength(i, j);
                    result.add(currSuface);
                }
            }
        }
        result.sort((a,b) -> b - a);
        for(Integer path : result){
            System.out.println(path);
        }
    }

    private static int getSufaceLength(int row, int col) {
        int result = 1;
        visited[row][col] = true;
        int currElement = matrix[row][col];
        //left
        if (col - 1 >= 0 && matrix[row][col - 1] == currElement && !visited[row][col - 1]) {
            result += getSufaceLength(row, col - 1);
        }
        //right
        if (col + 1 < matrix.length && matrix[row][col + 1] == currElement && !visited[row][col + 1]) {
            result += getSufaceLength(row, col + 1);
        }
        //up
        if (row - 1 >= 0 && matrix[row - 1][col] == currElement && !visited[row - 1][col]) {
            result += getSufaceLength(row - 1, col);
        }
        //down
        if (row + 1 < matrix.length && matrix[row + 1][col] == currElement && !visited[row + 1][col]) {
            result += getSufaceLength(row + 1, col);
        }
        return result;
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
