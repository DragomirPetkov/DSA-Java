import java.util.*;

public class LargestSurface_DFS {
    private static int rows;
    private static int cols;
    private static int[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        rows = sc.nextInt();
        cols = sc.nextInt();
        sc.nextLine();
        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        int maxArea = longestMatrix();
        System.out.println(maxArea);

    }

    private static int longestMatrix() {
        int maxSize = 0;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    int size = check(i, j, matrix[i][j], 0);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    private static int check(int row, int col, int value, int maxSize) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || matrix[row][col] != value) {
            return maxSize;
        }

        visited[row][col] = true;
        maxSize++;

        int[][] cordinates = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] current : cordinates) {
            int newX = row + current[0];
            int newY = col + current[1];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && matrix[newX][newY] == value){
                maxSize = check(newX,newY,value,maxSize);
            }

        }
        visited[row][col] = false;
        return maxSize;
    }


}
