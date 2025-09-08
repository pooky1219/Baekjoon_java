import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // N: 컴퓨터 수, M: 연결되어 있는 컴퓨터 쌍의 수
	static List<Integer>[] arr; // 그래프 구현을 위한 인접리스트
	static int cnt = 0; // 바이러스에 걸리게 되는 컴퓨터 수
	static boolean[] visited; // 방문 여부
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// 그래프 구현을 위한 배열 초기화
		arr = new ArrayList[N+1];
		for(int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		// 간선 정보 저장
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		visited = new boolean[N+1];
		
		bfs(1);
		System.out.println(cnt);
	}// main
	
	// bfs
	static void bfs(int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(idx);
		visited[idx] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int n : arr[curr]) {
				// 방문하지 않은 것 q에 넣기
				if(!visited[n]) {
					visited[n] = true; // 방문으로 변경
					cnt++; // 카운트 개수 증가
					q.offer(n);
				}
			}
		}
	}
}
