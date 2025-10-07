import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0}, normal_ver, rg_ver;
    static char normal_arr[][], rg_arr[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        normal_arr = new char[N][N];
        rg_arr = new char[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                normal_arr[i][j] = line.charAt(j);
                rg_arr[i][j] = line.charAt(j);
                if(rg_arr[i][j] == 'R') rg_arr[i][j] = 'G';
            }
        }
        visited = new boolean[N][N];
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i,j, normal_arr);
                    normal_ver++;
                }
            }
        }
        visited = new boolean[N][N];
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i,j, rg_arr);
                    rg_ver++;
                }
            }
        }
        System.out.println(normal_ver + " " + rg_ver);
    }
    static void bfs(int x,int y, char arr[][]){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});

        while (!q.isEmpty()){
            int cur[] = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            char cur_color = arr[cur_x][cur_y];

            for(int i = 0; i < 4; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(!visited[nx][ny] && arr[nx][ny]==cur_color){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
