import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt; // 2 x n 크기의 직사각형
    static int[] arr; // 경우의 수 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        int ans = cal(n);
        System.out.println(ans);
    }

    static int cal(int n) {
        if(n <= 2)
            return n;
        if(arr[n] == 0) {
            arr[n] = (cal(n-2) + cal(n-1)) % 10007;
        }

        return arr[n];
    }
}
