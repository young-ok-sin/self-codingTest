import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge{
        int to;
        int cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static class Node implements Comparable<Node> {
        int vertex;
        long dist;
        Node(int vertex, long dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] dist = new long[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        boolean visited[] = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0L));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int v = cur.vertex;
            if(visited[v]) continue;
            visited[v] = true;
            
            if(v==end) break;
            
            for(Edge e : graph[v]) {
                if (visited[e.to]) continue;
                long nd = dist[v] + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new Node(e.to, nd));
                }
            }
        }
        System.out.println(dist[end]);



    }
}
