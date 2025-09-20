import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M,INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[][] dist = new int[N + 1][N + 1];
        int[][] path = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            path[a][b] = b;
        }
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if (dist[i][j] == INF) sb.append("0 ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(dist[i][j] == INF || i == j) sb.append("0\n");
                else{
                    List<Integer> route = new ArrayList<>();
                    int cur = i;
                    while(cur != j){
                        route.add(cur);
                        cur = path[cur][j];
                    }
                    route.add(j);
                    sb.append(route.size()).append(" ");
                    for(int city : route){
                        sb.append(city).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
