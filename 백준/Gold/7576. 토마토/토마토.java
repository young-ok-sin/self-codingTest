import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, day = 0;
    static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static int arr[][];
    static Queue<Tomato> q;

    static class Tomato{
        int x, y;
        Tomato(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        q = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) q.offer(new Tomato(i, j));
            }
        }
        bfs();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, arr[i][j]);
            }
        }
        System.out.println(day - 1);
    }

    static void bfs(){
        while (!q.isEmpty()){
            Tomato cur = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N)  continue;
                if(arr[nx][ny] == 0){
                    arr[nx][ny] = arr[cur.x][cur.y] + 1;
                    q.offer(new Tomato(nx,ny));
                }
            }
        }
    }

}
