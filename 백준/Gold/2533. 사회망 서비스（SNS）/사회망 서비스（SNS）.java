import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int dp[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    static void dfs(int start){
        visited[start] = true;
        dp[start][0] = 0;
        dp[start][1] = 1;

        for(int next : graph[start]){
            if(!visited[next]){
                dfs(next);

                dp[start][0] += dp[next][1];
                dp[start][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
