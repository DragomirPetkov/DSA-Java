import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LargestSurface_BFS {

    private static int rows,cols;
    private static int[][] matrix;
    private static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        rows = sc.nextInt();
        cols = sc.nextInt();
        sc.nextLine();
        matrix = new int[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0 ; i < rows; i++){
            int[] row = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        int maxArea = largestArea();
        System.out.println(maxArea);
    }

    private static int largestArea(){
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]){
                    int currentArea = BFS(i,j);
                    maxArea = Math.max(maxArea,currentArea);
                }
            }
        }
        return maxArea;
    }

    private static int BFS(int row, int col){
        int area = 1;
        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});

        while (!queue.isEmpty()){
            int[] current = queue.poll();

            int[][] coordinates = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

            for(int[] arr : coordinates){
                int nextX = current[0] + arr[0];
                int nextY = current[1] + arr[1];

                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !visited[nextX][nextY]
                        && matrix[nextX][nextY] == matrix[current[0]][current[1]]){
                    area++;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }
        return area;
    }
}
