import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] length;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			length = new long[N + 1];

			long ans = calLength(N);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static long calLength(int n) {
		if(n <= 3) return 1;
		if(n == 4 || n == 5) return 2;
		
		if(length[n] == 0)
			length[n] = calLength(n - 5) + calLength(n - 1);
		
		return length[n];
	}
}
