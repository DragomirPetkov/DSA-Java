import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ScroogeMcDuckIteration {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = reader.read();
        int cols = reader.read();
        int[][] matrix = new int[rows][cols];

        int startRow = 0;
        int startCol = 0;


        for (int i = 0; i < rows; ++i) {
            int[] row = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                if (row[j] == 0) {
                    startRow = i;
                    startCol = j;
                }
                matrix[i][j] = row[j];
            }
        }

        int maxCoins = collectCoins(matrix,startRow,startCol);

        System.out.println(maxCoins);

    }

    private static int collectCoins(int[][] matrix, int currentRow, int currentCol) {
        int collectedCoins = 0;
        while (true) {
            int nextStepCoinsMax = 0;
            int nextRow = -1;
            int nextCol = -1;

            if (currentRow + 1 < matrix.length && matrix[currentRow + 1][currentCol] >= nextStepCoinsMax) {
                nextStepCoinsMax = matrix[currentRow + 1][currentCol];
                nextRow = currentRow + 1;
                nextCol = currentCol;
            }

            if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol] >= nextStepCoinsMax) {
                nextStepCoinsMax = matrix[currentRow - 1][currentCol];
                nextRow = currentRow - 1;
                nextCol = currentCol;
            }

            if (currentCol + 1 < matrix[0].length && matrix[currentRow][currentCol + 1] >= nextStepCoinsMax) {
                nextStepCoinsMax = matrix[currentRow][currentCol + 1];
                nextRow = currentRow;
                nextCol = currentCol + 1;
            }

            if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1] >= nextStepCoinsMax) {
                nextStepCoinsMax = matrix[currentRow][currentCol - 1];
                nextRow = currentRow;
                nextCol = currentCol - 1;
            }

            if (nextStepCoinsMax == 0) {
                return collectedCoins;
            }

            matrix[nextRow][nextCol]--;
            collectedCoins++;
            currentRow = nextRow;
            currentCol = nextCol;
        }
    }
}

