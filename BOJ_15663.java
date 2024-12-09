import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static int[] current;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        current = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); 

        backtrack(0);
    }

    static void backtrack(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(current[i] + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1; // 이전에 사용한 숫자 저장
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i] != prev) {
                visited[i] = true;
                current[depth] = arr[i];
                prev = arr[i]; // 중복 제거 위해 현재 숫자 저장
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
