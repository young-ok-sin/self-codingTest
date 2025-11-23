import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T, gram_x, gram_y, min_time = Integer.MAX_VALUE;
    static int arr[][];
    static boolean visited[][];
    static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static boolean isGram = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    gram_x = i;
                    gram_y = j;
                }
            }
        }
        int dist[][] = bfs();
        int prince = dist[N-1][M-1];
        int gram = dist[gram_x][gram_y];

        if(prince != -1){
            min_time = prince;
        }
        if(gram != -1){
            int withGram = (N-1-gram_x) + (M-1-gram_y);
            min_time = Math.min(min_time, gram + withGram);
        }
        if(min_time <= T) System.out.println(min_time);
        else System.out.println("Fail");
    }


    static int[][] bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        int dist[][] = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], -1);
        }

        q.offer(new int[]{0,0});
        dist[0][0] = 0;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0], y = cur[1];

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)  continue;

                if(arr[nx][ny] == 1)    continue;

                if(dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }
}
