import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; // 체스판의 크기, 최소 이동 횟수
	static int[] start = new int[2]; // 시작위치
	static int[] goal = new int[2]; // 목적지
	static boolean[][] visited; // 방문여부
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			
			// 시작위치와 끝 위치 입력받기
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++)
				start[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++)
				goal[i] = Integer.parseInt(st.nextToken());
			
			int ans = bfs(start[0], start[1]);
			
			sb.append(ans).append("\n");
		}// test case
		System.out.println(sb.toString());
	}// main
	
	// bfs
	static int bfs(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		
		// q에 넣기
		q.offer(new int[] {row, col, 0});
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); // 하나 꺼내기
			if(curr[0] == goal[0] && curr[1] == goal[1]) return curr[2];
			
			for(int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				// 유효한 위치인지 체크
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
				
				visited[nr][nc] = true; // 방문체크
				q.offer(new int[] {nr, nc, curr[2]+1});// q에 넣기
			}
		}
		
		return -1;
	}
}
