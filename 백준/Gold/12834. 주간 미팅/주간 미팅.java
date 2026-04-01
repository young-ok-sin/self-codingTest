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
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] graph = new ArrayList[v+1];
        for(int i = 1; i <= v; i++){
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }
        int[] distA = dijkstra(a, graph);
        int[] distB = dijkstra(b, graph);

        long ans = 0;

        for(int i = 1; i <= n; i++){
            int person = arr[i];

            int d1 = (distA[person] == Integer.MAX_VALUE) ? -1 : distA[person];
            int d2 = (distB[person] == Integer.MAX_VALUE) ? -1 : distB[person];

            ans += (d1 + d2);
        }
        System.out.println(ans);
    }
    static int[] dijkstra(int start, ArrayList<Edge>[] graph){
        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if(now.cost > dist[now.to]) continue;

            for(Edge next : graph[now.to]){
                if(dist[next.to] > now.cost + next.cost){
                    dist[next.to] = now.cost + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
