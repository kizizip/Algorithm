import java.util.*;

public class Solution {
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};
    static int n;
    static int[][] dessert;
    static int startX, startY;
    static boolean eat[] = new boolean[101];
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            dessert = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dessert[i][j] = sc.nextInt();
                }
            }

            result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    startX = i;
                    startY = j;
                    dfs(i, j, 0, 0, 1); //x, y, dir, length, rotateCount(전환횟수)
                }
            }

            System.out.print("#" + tc + " ");
            if (result == 0) System.out.print(-1);
            else System.out.print(result);
            System.out.println();
        }
    }

    private static void dfs(int x, int y, int dir, int length, int rotateCount) {
        //회전 횟수가 4를 초과했을 때 끝
        if (rotateCount > 4) return;

        //시작점으로 돌아왔을 때+길이 4 이상일 때 끝(리턴)
        if (x == startX && y == startY && length >= 4) {
            if (result < length) result = length;
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
            if (!eat[dessert[nx][ny]]) { //아직 먹지 않은 디저트라면
                eat[dessert[nx][ny]] = true; //먹는다.
                dfs(nx, ny, dir, length + 1, rotateCount);
                dfs(nx, ny, (dir + 1) % 4, length + 1, rotateCount + 1);
                eat[dessert[nx][ny]] = false;
            }
        }
    }
}