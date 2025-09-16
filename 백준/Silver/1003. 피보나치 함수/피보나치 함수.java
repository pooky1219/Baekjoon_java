import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] zeroCnt, oneCnt; // memoization을 하기 위함
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				zeroCnt = new int[2];
				oneCnt = new int[2];
			} else {
				zeroCnt = new int[N+1];
				oneCnt = new int[N+1];				
			}
			zeroCnt[0] = 1;
			zeroCnt[1] = 0;
			oneCnt[0] = 0;
			oneCnt[1] = 1;
			
			zeroFibonacci(N);
			oneFibonacci(N);
			
			sb.append(zeroCnt[N]).append(" ").append(oneCnt[N]).append("\n");
		}// test case
		System.out.println(sb.toString());
	}// main
	static int zeroFibonacci(int n) {
		if(n == 0)
			return 1;
		if(n == 1)
			return 0;
		if(zeroCnt[n] == 0)
			zeroCnt[n] = zeroFibonacci(n - 2) + zeroFibonacci(n - 1);
		return zeroCnt[n];
	}
	
	static int oneFibonacci(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(oneCnt[n] == 0)
			oneCnt[n] = oneFibonacci(n - 2) + oneFibonacci(n - 1);
		return oneCnt[n];
	}
}