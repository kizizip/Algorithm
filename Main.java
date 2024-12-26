import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 초기 두 문자열
        String str1 = "a";
        String str2 = "ab";

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 첫 두 문자열 출력
        System.out.println(str1);
        System.out.println(str2);

        // 세 번째 문자열부터 시작하여 주어진 패턴처럼 이어짐
        for (int i = 3; i <= n; i++) {
            // str1과 str2를 이어서 새로운 문자열을 생성
            String nextStr = str2 + str1;
            System.out.println(nextStr);

            // str1과 str2를 다음 단계로 이동
            str1 = str2;
            str2 = nextStr;
        }
    }
}
