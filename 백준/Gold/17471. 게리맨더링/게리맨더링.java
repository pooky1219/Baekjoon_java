import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int min = Integer.MAX_VALUE;
        boolean found = false;
        
        for (int i = 1; i < (1<<N)-1; i++) {
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1<<j)) != 0) A.add(j+1);
                else B.add(j+1);
            }
            if (bfs(A) && bfs(B)) {
                // 두구역 각각 원소들이 인접함! 이제 차 구해야해
                found = true;
                int cntA = 0;
                int cntB = 0;
                for (int a : A) cntA += arr[a];
                for (int b : B) cntB += arr[b];
                min = Math.min(min, Math.abs(cntA-cntB));
            }
        }
        System.out.print(found? min : -1);
    }

    static boolean bfs(List<Integer> key) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        int cnt = 1;
        dq.offer(key.get(0));
        visited[key.get(0)] = true;

        while(!dq.isEmpty()) {
            int cur = dq.poll();

            for (int i = 0; i < adj[cur].size(); i++) {
                if (key.contains(adj[cur].get(i)) && !visited[adj[cur].get(i)]) {
                    dq.offer(adj[cur].get(i));
                    visited[adj[cur].get(i)] = true;
                    cnt++;
                }
            }
        }
        if (key.size() == cnt) return true;
        return false;
    }
}