import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][];
    static int[] dx = {-1,1,0,0,0}, dy = {0,0,-1,1,0};
    static boolean visited[][];
    static int min_result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(min_result);
    }
    static void dfs(int depth, int sum){
        if(depth == 3){
            min_result = Math.min(min_result, sum);
            return;
        }
        for(int i = 1; i < N-1; i++){ // 끝줄에서 시작을 할 경우 꽃은 무조건 죽는다
            for(int j = 1; j < N-1; j++){
                if(check(i,j)){
                    int cost = plant(i,j,true);
                    dfs(depth + 1, cost + sum);
                    plant(i,j,false);
                }
            }

        }
    }

    static boolean check(int x, int y){
        for(int d = 0; d < 5; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(visited[nx][ny]) return false;
        }
        return true;
    }

    static int plant(int x, int y, boolean flag){
        int cost = 0;
        for(int d = 0; d < 5; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            visited[nx][ny] = flag;
            cost += arr[nx][ny];
        }
        return cost;
    }
}
