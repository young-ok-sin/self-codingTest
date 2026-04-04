import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge{
        int to;
        int cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static int n,m,r;
    static int[] item;
    static ArrayList<Edge>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= r; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, cost));
            list[to].add(new Edge(from,cost));
        }
        int ret = 0;
        for(int i = 1; i <= n; i++){
            ret = Math.max(ret,dijkstra(i));
        }
        System.out.println(ret);
    }
    static int dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Edge(start, 0));
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            int curTo = cur.to;
            int curCost = cur.cost;
            if(dist[curTo] < curCost)   continue;
            for(Edge next : list[curTo]){
                int nextCost = curCost + next.cost;
                if(dist[next.to] > nextCost){
                    dist[next.to] = nextCost;
                    pq.offer(new Edge(next.to, nextCost));
                }
            }
        }
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] <= m){
                sum += item[i];
            }
        }
        return sum;
    }
}
