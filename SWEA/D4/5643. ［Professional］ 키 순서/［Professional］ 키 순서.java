import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M; // N : 학생 수, M : 두 학생의 키를 비교한 횟수
    static int[][] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            height = new int[N+1][N+1];

            // 키 비교 입력
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                height[a][b] = 1;
            }

            for(int k = 1; k <= N; k++) {
                for(int i = 1; i <= N; i++) {
                    for(int j = 1; j <= N; j++) {
                        if(height[i][k] == 1 && height[k][j] == 1)
                            height[i][j] = 1;
                    }// 도착지
                }// 출발지
            }// 경유지

            // 연결되어 있는지 체크 배열
            int[] arr = new int[N+1];
            for(int i = 1; i <= N; i++) {
                for(int j = i+1; j <= N; j++) {
                    if(height[i][j] == 1 || height[j][i] == 1) {
                        arr[i]++;
                        arr[j]++;
                    }
                }
            }
            int ans = 0;
            for(int i = 1; i <= N; i++) {
                // 모두 연결되어 있음
                if(arr[i] == N-1)
                    ans++;
            }
            sb.append(ans).append("\n");
        }// test case
        System.out.println(sb.toString());
    }// main
}
