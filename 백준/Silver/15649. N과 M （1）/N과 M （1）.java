import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 길이가 M인 수열
    static int[] arr; // 1 ~ N
    static int[] result; // 결과 순열
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        for(int i = 0; i < N; i++)
            arr[i] = i + 1;

        perm(0);
        System.out.println(sb);
    }

    static void perm(int idx) {
        // 종료조건
        if(idx == M) {
            for(int i = 0; i < M; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }

        // 반복문
        for(int i = 0; i < N; i++) {
            // i번째 원소를 사용한 경우
            if(visited[i]) continue;

            // 여기 왔따는 것은 i번째 원소 사용되지 않았음
            result[idx] = arr[i];
            visited[i] = true; // 방문처리
            perm(idx + 1);
            visited[i] = false; // 원상복구
        }
    }
}
