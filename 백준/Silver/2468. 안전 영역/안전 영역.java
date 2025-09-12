import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int row, col;

		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int N, tasty, max; // 치즈 한 변의 길이, 치즈에서 가장 맛있는 부분, 최대 덩어리 개수
	static int[][] cheese; // 치즈
	static boolean[][] visited; // 방문여부
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
			
		cheese = new int[N][N];
		tasty = 0;
		max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(tasty < cheese[i][j])
					tasty = cheese[i][j];
			}
		}// 입력받기
			
		// 덩어리 몇 개인지 세기
		countCheese();
		System.out.println(max);
	}// main
	
	// 덩어리 개수 세기
	static void countCheese() {
		for(int taste = 0; taste < tasty; taste++) {
			int cnt = 0; // 해당 일자에서 덩어리 개수
			visited = new boolean[N][N]; // 방문여부
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 먹은 게 아니면서 방문하지 않은 곳 체크
					if(cheese[i][j] > taste && !visited[i][j]) {
						bfs(i, j, taste);
						cnt++;
					}
				}
			}
			
			max = Math.max(max, cnt);
		}
	}
	
	// bfs
	static void bfs(int row, int col, int taste) {
		Queue<Pos> q = new ArrayDeque<>();
		visited[row][col] = true;
		q.offer(new Pos(row, col));
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = curr.row + dr[i];
				int nc = curr.col + dc[i];
				
				// 범위체크, 방문체크, 먹었는지 체크
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || cheese[nr][nc] <= taste)
					continue;
				visited[nr][nc] = true;
				q.offer(new Pos(nr, nc));
			}
		}
	}
}
