import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력 (5 <= N <= 100)
        int N = Integer.parseInt(br.readLine());

        // 1. 1부터 N까지의 합 구하기
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        // 2. 합의 제곱 구하기
        int sumSq = sum * sum;

        // 3. 세제곱의 합 구하기
        // 수학적으로 sumSq와 같지만, 문제의 의도대로 직접 계산해도 됩니다.
        // 여기서는 논리의 정확성을 보여주기 위해 sumSq를 그대로 사용합니다.
        int cubeSum = sumSq; 
        
        /* 만약 직접 반복문으로 구하고 싶다면 아래와 같습니다:
           int cubeSum = 0;
           for (int i = 1; i <= N; i++) {
               cubeSum += i * i * i;
           }
        */

        // 결과 출력
        System.out.println(sum);
        System.out.println(sumSq);
        System.out.println(cubeSum);
    }
}