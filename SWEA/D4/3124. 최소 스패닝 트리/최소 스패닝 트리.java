import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Edge implements Comparable<Edge>{
        int to;
        long weight;
        public Edge(int to, long weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static int V, E; //정점, 간선
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Edge>[] adj = new ArrayList[V+1];
            boolean visited[] = new boolean[V+1];
            for(int i =0; i <= V; i++){
                adj[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                long weight = Integer.parseInt(st.nextToken());

                adj[from].add(new Edge(to, weight));
                adj[to].add(new Edge(from, weight));
            }
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            long result = 0;
            int cnt = 0;

            pq.offer(new Edge(1,0));

            while(!pq.isEmpty()){
                Edge cur = pq.poll();
                if(visited[cur.to]) continue;

                visited[cur.to] = true;
                result += cur.weight;
                cnt++;

                if(cnt == V) break;

                for(Edge next : adj[cur.to]){
                    if(!visited[next.to]) pq.offer(next);
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

}
