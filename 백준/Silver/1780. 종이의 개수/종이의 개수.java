import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 종이 크기
	static int[][] arr; // 종이
	static int mOneCnt, zeroCnt, oneCnt; // -1, 0, 1 개수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		// 종이 생성
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// check함수로 종이 개수 구하기
		check(N, 0, 0);
		System.out.println(mOneCnt + "\n" + zeroCnt + "\n" + oneCnt);
	}// main
	static void check(int size, int row, int col) {
		// 처음 값
		int num = arr[row][col];
		// 종료
		if(size == 1) {
			if(num == -1)
				mOneCnt++;
			else if(num == 0)
				zeroCnt++;
			else
				oneCnt++;
			return;
		}
		
		// 재귀
		boolean isOk = true; // 같은 수만 있는지 체크
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col+size; j++) {
				// 다른 수가 있음
				if(num != arr[i][j]) {
					isOk = false;
					break;
				}
			}
			if(!isOk) break;
		}
		
		// 같은 수만 있다면
		if(isOk) {
			if(num == -1)
				mOneCnt++;
			else if(num == 0)
				zeroCnt++;
			else
				oneCnt++;
			return;
		}
		// 다른 수가 있음
		else {
			for(int i = row; i < row+size; i += size/3) {
				for(int j = col; j < col+size; j+= size/3) {
					check(size/3, i, j);
				}
			}
		}
	}
}
