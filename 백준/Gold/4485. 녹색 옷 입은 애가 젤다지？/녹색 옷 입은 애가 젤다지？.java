import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N , INF = Integer.MAX_VALUE, dp[][], arr[][];
    static boolean visited[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static class Edge implements Comparable<Edge>{
        int x,y,weight;
        Edge(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight );
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int caseNo = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            arr = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = dijkstra(0,0);
            sb.append("Problem ").append(caseNo++).append(": ").append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
    static int dijkstra(int x, int y){
        visited = new boolean[N][N];
        dp = new int[N][N];

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = INF;
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dp[x][y] = arr[x][y];
        pq.offer(new Edge(x, y, dp[x][y]));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            // 방문 확인
            if(visited[e.x][e.y]) continue;
            visited[e.x][e.y] = true;
            // 기저 조건
            if(e.x == N-1 && e.y == N-1) return e.weight;

            for(int d = 0; d < 4; d++){
                int nx = e.x + dx[d];
                int ny = e.y + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]
                    && dp[nx][ny] > e.weight + arr[nx][ny]){
                    dp[nx][ny] = e.weight + arr[nx][ny];
                    pq.offer(new Edge(nx, ny, dp[nx][ny]));
                }
            }
        }
    return -1;
    }
}
