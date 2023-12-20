import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int output = findSequence(k,n);
        System.out.println(output);
    }

    public static int findSequence(int k, int n){
        if (n == 1){
            return k;
        } else if (n == 2) {
            return k + 1;
        }else if (n == 3){
            return 2 * k + 1;
        } else if (n % 3 == 0) {
            return findSequence(k,(n /3)) * 2 + 1;
        } else if (n % 3 == 1) {
            return findSequence(k,n/3) + 2;
        }else {
            return findSequence(k,(n/3)) + 1;
        }
    }
}
