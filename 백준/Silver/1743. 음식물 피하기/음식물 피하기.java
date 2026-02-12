import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k, max;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static boolean[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a-1][b-1] = true;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j]){
                    max = Math.max(dfs(i,j), max);
                }
            }
        }
        System.out.println(max);
    }
    static int dfs(int r, int c){
        arr[r][c] = false;
        int cnt = 1;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= n ||  nc < 0 || nc >= m)  continue;

            if(arr[nr][nc]){
                cnt += dfs(nr,nc);
            }
        }
        return cnt;
    }
}
