import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> S = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 문자와 숫자 입력 받기
			String line = st.nextToken();
			int num = 0;
			if(st.hasMoreTokens())
				num = Integer.parseInt(st.nextToken());
			
			switch(line) {
			case "add":
				// 포함하지 않는다면 추가
				if(!S.contains(num))
					S.add(num);
				break;
			case "remove":
				// 포함한다면 제거
				if(S.contains(num))
					S.remove(S.indexOf(num));
				break;
			case "check":
				// 포함하면 1출력, 아니면 0출력
				if(S.contains(num))
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
				break;
			case "toggle":
				// 포함하면 제거, 아니면 추가
				if(S.contains(num))
					S.remove(S.indexOf(num));
				else
					S.add(num);
				break;
			case "all":
				// 전체 제거 후 1~20추가
				S.clear();
				for(int j = 1; j <= 20; j++)
					S.add(j);
				break;
			case "empty":
				// 전체 제거
				S.clear();
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
