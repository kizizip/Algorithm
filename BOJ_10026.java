import java.util.Scanner;

public class Main {

	static int n;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int countR, countG, countB, countRG;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();
		map = new char[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		countR = countG = countB = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'R' && !visit[i][j]) {
					countR++;
					findR(i, j);
				}

				else if (map[i][j] == 'G' && !visit[i][j]) {
					countG++;
					findG(i, j);
				}

				else if (map[i][j] == 'B' && !visit[i][j]) {
					countB++;
					findB(i, j);
				}

			}
		}

		reset();

		countRG = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((map[i][j] == 'R' || map[i][j] == 'G') && !visit[i][j]) {
					countRG++;
					findRG(i, j);
				}
			}
		}

		System.out.print(countR + countG + countB + " ");
		System.out.print(countB + countRG);
	}

	private static void findRG(int x, int y) {
		// TODO Auto-generated method stub

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'R' || map[nx][ny] == 'G')
					findRG(nx, ny);
			}
		}

	}

	private static void reset() {
		// TODO Auto-generated method stub

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = false;
			}
		}

	}

	private static void findR(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'R')
					findR(nx, ny);
			}
		}

	}

	private static void findG(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'G')
					findG(nx, ny);
			}
		}

	}

	private static void findB(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'B')
					findB(nx, ny);
			}
		}

	}

}
