import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // N x M크기
	static char[][] miro;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] dist; // 미로 내 거리 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 미로생성
		miro = new char[N][M];
		for(int i = 0; i < N; i++)
			miro[i] = br.readLine().toCharArray();
		dist = new int[N][M];
		
		bfs(0, 0);
		System.out.println(dist[N-1][M-1]);
	}
	
	// bfs
	static void bfs(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		// 시작점 넣기
		q.offer(new int[] {row, col});
		// 시작 칸수는 1
		dist[row][col] = 1;
		
		while(!q.isEmpty()) {
			// 큐에서 젤 앞에 있는 것 꺼내기
			int[] curr = q.poll();
			// 마지막 칸이면 종료
			if(curr[0] == N-1 && curr[1] == M-1) return;
			
			for(int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				// 경계, 벽, 왔던곳 체크
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || miro[nr][nc] == '0' || dist[nr][nc] != 0)
					continue;
				
				// 체크 끝났으면?
				dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
				q.offer(new int[] {nr, nc});
			}
		}
	}
}
