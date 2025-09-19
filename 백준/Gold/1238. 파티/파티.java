import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,X, MAX_VALUE=Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph, reverseGraph;
    static class Edge implements Comparable<Edge>{
        int e, t;
        Edge(int e, int t){
            this.e = e;
            this.t = t;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.t, o.t);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, t));
            reverseGraph[e].add(new Edge(s, t));
        }
        int[] fromX = dijkstra(graph, X);
        int[] toX = dijkstra(reverseGraph, X);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (toX[i] == MAX_VALUE || fromX[i] == MAX_VALUE) continue;
            ans = Math.max(ans, toX[i] + fromX[i]);
        }

        System.out.println(ans);
    }

        static int[] dijkstra (ArrayList < Edge >[]g,int start){
            int[] dist = new int[N + 1];
            Arrays.fill(dist, MAX_VALUE);
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            dist[start] = 0;
            pq.offer(new Edge(start, 0));

            while (!pq.isEmpty()) {
                Edge cur = pq.poll();
                int now = cur.e;
                int cost = cur.t;

                if (dist[now] < cost) continue;

                for (Edge next : g[now]) {
                    if (dist[next.e] > cost + next.t) {
                        dist[next.e] = cost + next.t;
                        pq.offer(new Edge(next.e, dist[next.e]));
                    }
                }
            }
            return dist;
        }

    }

