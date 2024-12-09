import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				
//				System.out.println(map[i][j]);
			}
		}
		
		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
	}

	static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visit[x][y] = true;
		
		while (!queue.isEmpty()) {
			Point currentPoint=queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = currentPoint.x + dx[i];
				int nextY = currentPoint.y + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >=m) continue;
				if (map[nextX][nextY] == 0) continue;
				if (visit[nextX][nextY]) continue;
				
				queue.offer(new Point(nextX, nextY));
				visit[nextX][nextY] = true;
				
				map[nextX][nextY] = map[currentPoint.x][currentPoint.y] +1;
				
			}
		}
		
	}
}
