import java.util.Scanner;

public class BOJ_16987 {

    static int[] st;
    static int[] weight;
    static int max;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        st = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) { //i+1번째에 있는 계란
            st[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        crush(0, n);
        System.out.println(max);

    }

    private static void crush(int current, int eggs) {

        //마지막 계란까지 탐색 완료시 끝
        if (current == eggs) {
            int broken = 0;
            for (int i = 0; i < eggs; i++) {
                if(st[i] <=0) {
                    broken++;
                }
            }
            max = Math.max(max, broken);
            return;
        }

        //다른계란 칠 수 있는지
        boolean canCrush = false;

        if(st[current] <=0) { //현재 계란이 이미 깨졌다면...
            crush(current+1, eggs); //다음계란으로 넘어감
            return;
        }

        //다른계란 충돌 시도
        for (int i = 0; i < eggs; i++) {
            if (i != current && st[i] > 0) { //상대 계란이 깨지지 않은 경우
                canCrush = true;

                //친다
                st[current] -= weight[i];
                st[i] -= weight[current];

                //다음계란 넘어감
                crush(current + 1, eggs);

                //상태 되돌리기
                st[current] += weight[i];
                st[i] += weight[current];
            }
        }

        //충돌 가능 계란이 없는 경우, 다음 계란으로 바로 이동
        if(!canCrush) {crush(current + 1, eggs);}
    }
}