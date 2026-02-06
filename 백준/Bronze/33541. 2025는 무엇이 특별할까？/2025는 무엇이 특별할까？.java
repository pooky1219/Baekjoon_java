import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 현재 연도 X 입력
        int X = Integer.parseInt(br.readLine());

        // X + 1년 부터 9999년까지 반복
        for (int year = X + 1; year <= 9999; year++) {
            // 앞 두 자리 (몫)
            int front = year / 100;
            // 뒤 두 자리 (나머지)
            int back = year % 100;

            // 두 부분의 합
            int sum = front + back;

            // 합의 제곱이 원래 연도와 같은지 확인
            if (sum * sum == year) {
                System.out.println(year);
                return; // 찾으면 바로 출력 후 종료
            }
        }

        // 반복문이 끝날 때까지 못 찾았으면 -1 출력
        System.out.println(-1);
    }
}