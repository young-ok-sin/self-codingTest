import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int to;
        int cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        boolean[] visited = new boolean[n+1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start,0));

        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            int v = cur.to;
            if(visited[v])  continue;
            visited[v] = true;

            if(v == end)    break;

            for(Edge e : graph[v]){
                if(visited[e.to])   continue;
                long nc = dist[v] + (long)e.cost;
                if(nc < dist[e.to]){
                    dist[e.to] = nc;
                    pq.offer(new Edge(e.to, (int)nc));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
