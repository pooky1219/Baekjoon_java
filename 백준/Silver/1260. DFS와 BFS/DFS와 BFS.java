import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V; // N: 정점의 개수, M: 간선의 개수, V: 시작할 정점의 번호
	static List<Integer>[] arr; // 그래프 표현을 위한 인접리스트
	static boolean[] visited; // dfs에서 사용할 방문여부
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 배열 초기화
		arr = new ArrayList[N+1];
		for(int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();
		visited = new boolean[N+1];
		
		// 그래프 생성
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		// 순서 오름차순
		for(int i = 1; i <= N; i++)
			Collections.sort(arr[i]);
		
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1]; // boolean 배열 다시 초기화
		bfs(V);
		
		System.out.println(sb.toString());
	}
	
	// dfs
	static void dfs(int idx) {
		// 재귀
		visited[idx] = true;
		sb.append(idx).append(" ");
		
		for(int n : arr[idx]) {
			// visited가 아닐 경우 방문
			if(!visited[n]) {
				dfs(n);
			}
		}
	}
	
	// bfs
	static void bfs(int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(idx);
		visited[idx] = true;
		sb.append(idx).append(" ");
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			// curr과 연결된 방문되지 않은 모든 요소 q에 집어넣음
			for(int n : arr[curr]) {
				if(!visited[n]) {
					q.add(n);
					visited[n] = true;
					sb.append(n).append(" ");
				}
			}
		}
	}
}
