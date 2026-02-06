import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄에서 N(학생 수)과 M(카드 수) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 학생들의 번호표를 저장할 배열
        int[] A = new int[N];
        
        // N개의 줄에 걸쳐 번호표 값 입력
        for (int k = 0; k < N; k++) {
            A[k] = Integer.parseInt(br.readLine());
        }

        // 시뮬레이션 시작
        // i: 현재 카드의 번호 (1부터 M까지)
        for (int i = 1; i <= M; i++) {
            // j: 학생의 위치 (0부터 N-2까지, j와 j+1을 비교하기 때문)
            for (int j = 0; j < N - 1; j++) {
                // 조건: 현재 카드 번호(i)로 나눈 나머지를 비교
                if (A[j] % i > A[j+1] % i) {
                    // 조건 만족 시 두 학생의 번호표 교환 (Swap)
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int val : A) {
            sb.append(val).append("\n");
        }
        System.out.print(sb);
    }
}