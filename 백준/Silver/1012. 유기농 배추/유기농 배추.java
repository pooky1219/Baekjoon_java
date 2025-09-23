import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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

    static int M, N, K, cnt; // 가로길이, 세로길이, 배추의 개수, 벌레 수
    static int[][] map; // 배추 농장
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 맵 생성
            visited = new boolean[N][M];
            map = new int[N][M];
            for(int i = 0; i < N; i++) {
                Arrays.fill(map[i], 0);
            }

            // 배추 배열
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                map[row][col] = 1;
            }

            cnt = 0;
            // bfs
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && visited[i][j] == false) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }// test case
        System.out.print(sb);
    }// main

    static void bfs(int row, int col) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(row, col));
        visited[row][col] = true;

        while(!q.isEmpty()) {
            Pos p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = p.row + dr[i];
                int nc = p.col + dc[i];
                // 경계, 1인지, 방문 여부 체크
                if(nr >= 0 && nc >= 0 && nr < N && nc < M &&
                map[nr][nc] == 1 && visited[nr][nc] == false) {
                    q.offer(new Pos(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
