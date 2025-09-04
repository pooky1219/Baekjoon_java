import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> arr;
	static int N, M, R;
	static int[] visited; // 방문했는지 안했는지
	static int seq = 1;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		visited = new int[N+1];
		arr = new ArrayList<>();
		
		// 그래프 생성
		for(int i = 0 ; i <= N; i++) {
			arr.add(new ArrayList<>());
		}
		
		// 간선 정보 저장
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		// 간선 오름차순 배열
		for(int i = 1; i <= N; i++)
			Collections.sort(arr.get(i));
		
		// dfs 호출
		dfs(R);
		for(int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int start) {
		// 방문하면 순서 저장
		visited[start] = seq++;
		
		for(int i = 0; i < arr.get(start).size(); i++) {
			// 방문하지 않았다면 해당 정점으로 감
			int idx = arr.get(start).get(i);
			if(visited[idx] == 0)
				dfs(idx);
		}
	}
}
