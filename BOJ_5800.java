import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 1; i <= tc ; i++) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int gap = 0;
            ArrayList<Integer> list = new ArrayList<>();

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();

                max = Math.max(num, max);
                min = Math.min(num, min);

                list.add(num);
            }

            Collections.sort(list);

            for (int j = 0; j < list.size() - 1; j++) {
                int a = list.get(j);
                int b = list.get(j+1);

                int g = Math.abs(a - b);
                gap = Math.max(g, gap);
            }

            System.out.println("Class " + i);
            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + gap);
        }

    }
}
