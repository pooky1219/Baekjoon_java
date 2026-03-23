import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 1 ~ N, M자리의 순열
    static int[] arr; // 1 ~ N
    static int[] result; // 정답 중복 순열
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        for(int i = 0; i < N; i++)
            arr[i]= i + 1;

        perm(0);
        System.out.println(sb);
    }

    // 중복 순열
    static void perm(int idx) {
        // 종료조건
        if(idx == M) {
            for(int i = 0; i < M; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            result[idx] = arr[i];
            perm(idx + 1);
        }
    }
}
