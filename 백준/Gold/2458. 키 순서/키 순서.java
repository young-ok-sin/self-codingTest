import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
    static ArrayList<Integer>[] graph, rgraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        rgraph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            rgraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            rgraph[v].add(u);
        }
        for(int i = 1; i <= N; i++){
            int u = bfs(i, graph);
            int v = bfs(i, rgraph);
            if(u+v == N-1)  cnt++;
        }
        System.out.println(cnt);

    }
    static int bfs(int start, ArrayList<Integer>[] list){
        int result = 0;
        boolean visited[] = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()){
            int cur = q.poll();
            for(int i : list[cur]){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                    result++;
                }
            }
        }
        return result;
    }
}
