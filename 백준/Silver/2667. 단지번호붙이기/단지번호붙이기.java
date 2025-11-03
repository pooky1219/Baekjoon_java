import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int cnt = 0, cnt2 = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N]; 
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					bfs(i, j);
					list.add(cnt2);
					cnt2 = 0;
				}
			}
		}
		sb.append(cnt + "\n");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.print(sb);	
	}
    
	static void bfs(int r, int c) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {r, c});
		arr[r][c] = 0;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int curr = cur[0];
			int curc = cur[1];
			cnt2++;
			
			for (int i = 0; i < 4; i++) {
				int nr = curr + dr[i];
				int nc = curc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] == 0) continue;
				arr[nr][nc] = 0;
				dq.offer(new int[] {nr, nc});
			}
		}
		cnt++;
	}
}
