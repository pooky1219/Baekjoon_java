import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tomato {
		int row, col, day;

		public Tomato(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
	
	static int N, M; // 상자 크기
	static int[][] map; // 상자
	static int ans; // 필요한 날
	static int[] dr = {-1, 1, 0, 0}; // 사방탐색
	static int[] dc = {0, 0, -1, 1};
	static Queue<Tomato> q = new ArrayDeque<>(); // bfs를 위한 큐
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 토마토 있는 부분 q에 넣기
				if(map[i][j] == 1)
					q.offer(new Tomato(i, j, 0));
			}
		}// 입력
		
		bfs();
		boolean isOk = true; // 디폴트는 모두 익을 수 있음
		// 모두 익을 수 있는 상태인지 체크
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					isOk = false;
					break;
				}
			}
			if(!isOk) break;
		}
		
		if(isOk)
			System.out.println(ans);
		else
			System.out.println(-1);
		
	}// main
	
	static void bfs() {
		while(!q.isEmpty()) {
			// 토마토 꺼내기
			Tomato curr = q.poll();
			ans = curr.day;
			for(int i = 0; i < 4; i++) {
				int nr = curr.row + dr[i];
				int nc = curr.col + dc[i];
				
				// 경계와 빈 칸 토마토가 있는 곳 체크
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == -1 || map[nr][nc] == 1) continue;
				
				// 토마토 썩음
				map[nr][nc] = 1;
				// 칸 이동 후 day+1
				q.offer(new Tomato(nr, nc, curr.day+1));
			}
		}
	}
}
