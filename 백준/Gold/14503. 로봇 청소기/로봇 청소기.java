import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, d, x, y, cnt;
    static int dx[] = {-1,0,1,0},dy[] = {0,1,0,-1};
    static boolean visited[][], arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = st.nextToken().equals("1");
            }
        }
        dfs(x, y);
        System.out.println(cnt);
    }

    static void dfs(int x, int y){
        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if(!visited[x][y]) {
            visited[x][y] = true;
            cnt++;
        }
        for(int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (check(nx, ny)) {
                dfs(nx, ny);
                return;
            }
        }
        int backDir = (d+2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];
        if(arr[bx][by] == false){
            dfs(bx, by);
        }
    }
    static boolean check(int nx, int ny){
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) return false;
        if(visited[nx][ny] == true || arr[nx][ny] == true)  return false;
        return true;
    }
}
