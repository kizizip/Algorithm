import java.util.*;

public class Main {
    static int n;
    static long[][] grid;
    static long[] rowSum;
    static long maxScore;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        n = sc.nextInt();
        grid = new long[n][n];
        rowSum = new long[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextLong();
                rowSum[i] += grid[i][j];
            }
        }

        maxScore = Long.MIN_VALUE;

        chooseRows(new ArrayList<>(), 0);

        System.out.println(maxScore);
    }

    public static void chooseRows(List<Integer> selectedRows, int start) {
        // 모든 행을 선택한 경우 점수를 계산
        if (selectedRows.size() > 0) {
            calculateScore(selectedRows);
        }

        for (int i = start; i < n; i++) {
            selectedRows.add(i);  // 현재 행 선택
            chooseRows(selectedRows, i + 1);  // 다음 행 선택
            selectedRows.remove(selectedRows.size() - 1);
        }
    }

    public static void calculateScore(List<Integer> selectedRows) {
        long score = 0;
        long totalColumnBenefit = 0;


        for (int i : selectedRows) {
            score += rowSum[i];
        }

        for (int j = 0; j < n; j++) {
            long minwooBenefit = 0;
            long jongjinBenefit = 0;

            for (int i = 0; i < n; i++) {
                if (selectedRows.contains(i)) {
                    minwooBenefit -= grid[i][j];
                    jongjinBenefit += grid[i][j];
                } else {
                    minwooBenefit += grid[i][j];
                    jongjinBenefit -= grid[i][j];
                }
            }

            if (jongjinBenefit > 0) {
                score += minwooBenefit;
                totalColumnBenefit += jongjinBenefit;
            }
        }

        maxScore = Math.max(maxScore, score);
    }
}
