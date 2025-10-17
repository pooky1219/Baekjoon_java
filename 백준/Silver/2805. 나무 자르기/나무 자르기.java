import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxTree; // 나무의 수, 가장 높은 나무 높이
	static long M; // 가져가려는 나무의 길이
	static int[] arr; // 나무 높이 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		arr = new int[N];
		maxTree = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > maxTree)
				maxTree = arr[i];
		}
		
		// 벌목기 높이 구하기
		int lo = 0, hi = maxTree;
		int result = 0;
		
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			long tree = 0; // 잘린 나무 길이
			for(int h : arr) {
				if(h > mid)
					tree += h - mid;
			}
			
			// 잘린 나무가 M보다 큼
			if(tree >= M) {
				result = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}
