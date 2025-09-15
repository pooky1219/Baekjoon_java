import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] charge = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < charge.length; i++) {
				int ans = N / charge[i];
				sb.append(ans).append(" ");
				N %= charge[i];
			}
			sb.append("\n");
		}// test case
		System.out.println(sb.toString());
	}
}
