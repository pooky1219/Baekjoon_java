import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];  // 수열
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());  // 0 ~ N-1번 인덱스에 값 담기
		}
		
		int[] ans = new int[N];  // 정답
		Arrays.fill(ans, -1);  // ans 배열 -1로 초기화
		
		Stack<Integer> s = new Stack<>();  // 수열의 인덱스 담기
		for (int i = 0; i < N; i++) {
			while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
				ans[s.pop()] = arr[i];
			}
			s.push(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}