import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 연산의 개수
        int N = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < N; t++) {
        	int x = Integer.parseInt(br.readLine());
        	// 입력이 0이면 출력
        	if(x == 0) {
        		if(pq.isEmpty())
        			sb.append(0).append("\n");
        		else
        			sb.append(pq.poll()).append("\n");
        	} else {
        		pq.offer(x);
        	}
        }// 연산 끝
        
        System.out.println(sb);
    }
}
