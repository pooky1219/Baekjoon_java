import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;

			plus(0);
			sb.append(cnt).append("\n");
		}// test case
		System.out.println(sb.toString());
	}// main

	static void plus(int k) {
		// 종료
		if(k == n) {
			cnt++;
			return;
		}
		if(k > n)
			return;

		plus(k + 1);
		plus(k + 2);
		plus(k + 3);
	}
}
