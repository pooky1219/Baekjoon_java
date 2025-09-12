import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, min; // N : 수빈위치, K : 동생위치, min : 최소시간
	static int[] dist = new int[100001]; // 걸린 시간 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(dist[min]);
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);
		Arrays.fill(dist, -1);
		dist[N] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			// 해당 위치에 도달했다면 out
			if(curr == K) {
				min = curr;
				return;
			}
			
			// +1, -1, *2 후 dist가 -1일 때 이동
			int[] arr = {curr + 1, curr - 1, curr * 2};
			for(int pos : arr) {
				// 범위 안에 들어오고 해당 위치 dist[]가 -1일때만 이동
				if(pos >= 0 && pos <= 100000 && dist[pos] == -1) {
					q.offer(pos);
					dist[pos] = dist[curr] + 1; // 시간 갱신
				}
			}
		}
	}
}
