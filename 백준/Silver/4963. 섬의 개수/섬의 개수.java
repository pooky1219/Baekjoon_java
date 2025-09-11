import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h, cnt; // w : 너비, h : 높이, cnt : 섬의 개수
	static int[][] map; // 지도
	static boolean[][] visited; // 방문여부
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 둘 다 0이면 종료
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}// 입력받기
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					// 육지이고 방문하지 않았으면 bfs
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}// test case
	}// main
	
	static void bfs(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {row, col});
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			// 8방탐색으로 섬확인
			for(int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				// 경계와 바다와 방문여부 확인
				if(nr < 0 || nc < 0 || nr >= h || nc >= w || map[nr][nc] == 0 || visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
	}
}
