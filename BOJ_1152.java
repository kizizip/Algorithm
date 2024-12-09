import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		int count = 0;
		
		// 한 줄 입력 받기
		String line = sc.nextLine().trim();  // 입력에서 앞뒤 공백 제거
		
		// 빈 입력이면 단어 개수는 0
		if (!line.isEmpty()) {
			// 공백 기준으로 단어 나누기
			String[] words = line.split("\\s+");
			
			// 단어 개수 세기
			count = words.length;
		}
		
		// 결과 출력
		System.out.println(count);
		
		sc.close();
	}
}
