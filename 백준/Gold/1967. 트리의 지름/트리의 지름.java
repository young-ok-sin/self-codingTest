import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visited;
    static class Edge{
        int to, cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static ArrayList<Edge>[] tree;
    static int max;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(0);
            return;
        }
        tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[from].add(new Edge(to, cost));
            tree[to].add(new Edge(from, cost));
        }
        visited = new boolean[n+1];
        dfs(1, 0);
        int start = idx;
        max = 0;
        visited = new boolean[n+1];
        dfs(start, 0);

        System.out.println(max);
    }
    static void dfs(int cur, int cnt){
        visited[cur] = true;
        if(max < cnt){
            max = cnt;
            idx = cur;
        }
        for(Edge edge : tree[cur]){
            int next = edge.to;
            int cost = edge.cost;
            if(visited[next]) continue;
            dfs(next, cnt + cost);
        }
    }
}
