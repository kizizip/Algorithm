import java.util.Scanner;

public class BOJ_26529 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] result = new int[46];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < 46; i++) {
            result[i] = result[i-1] + result[i-2];
        }

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.print(result[n] + " ");
        }
    }
}
