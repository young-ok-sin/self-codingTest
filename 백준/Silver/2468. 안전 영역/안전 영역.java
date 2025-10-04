import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][], max_height, result = 1;
    static int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i= 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(max_height, arr[i][j]);
            }
        }
        for(int h = 0; h <= max_height; h++){
            visited = new boolean[N][N];
            int cnt = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && arr[i][j] > h){
                        dfs(i,j,h);
                        cnt++;
                    }
                }
            }
            result = Math.max(result,cnt);
        }
        System.out.println(result);
    }
    static void dfs(int x, int y, int h){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < N && nx >= 0 && ny < N && ny >= 0){
                if(arr[nx][ny] > h && !visited[nx][ny]){
                    dfs(nx,ny,h);
                }
            }
        }
    }
}
