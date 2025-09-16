import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		devide(N, 0);
		
		System.out.println(arr[1]);
	}
	
	static void devide(int n, int cnt) {
		// 이미 온 적 있으면 패스
		if(arr[n] != 0 && arr[n] <= cnt) return;
		arr[n] = cnt;
		
		// 종료
		if(n == 1) {
			return;
		}
		
		// 재귀
		if(n % 3 == 0)
			devide(n / 3, cnt + 1);
		if(n % 2 == 0)
			devide(n / 2, cnt + 1);
		if(n - 1 > 0)
			devide(n - 1, cnt + 1);
	}
}
