import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, cnt;
    static int[] dx = {-1,1,0,0,-1,-1,1,1}, dy = {0,0,-1,1,-1,1,-1,1};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 1){
                    if(visited[i][j])   continue;
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static void bfs(int x, int y){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int d = 0; d < 8; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N)  continue;
                if(visited[nx][ny]) continue;

                if(arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}
