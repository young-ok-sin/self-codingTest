import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[] dx = {-1,1,0,0,0,0}, dy = {0,0,-1,1,0,0}, dz = {0,0,0,0,1,-1};
    static Queue<int[]> q = new ArrayDeque<>();
    static int[][][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1)   q.offer(new int[] {i,j,k});
                }
            }
        }
        bfs();
        int ret = result();
        System.out.println(ret);
    }

    static void bfs(){
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for(int i = 0; i < 6; i++){
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) continue;
                if(arr[nz][ny][nx] != 0)    continue;

                arr[nz][ny][nx] = arr[z][y][x] + 1;
                q.offer(new int[]{nz, ny, nx});
            }
        }
    }

    static int result() {
        int day = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) return -1;

                    day = Math.max(day, arr[i][j][k]);
                }
            }
        }
        return day - 1;
    }
}