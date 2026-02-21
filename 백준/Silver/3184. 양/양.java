import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, sheep, wolf;
    static int o, v;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            String line = br.readLine();
            for(int j = 0; j < c; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if(arr[i][j] != '#' && !visited[i][j]){
                    o = 0;
                    v = 0;
                    dfs(i,j);

                    if(o > v) sheep += o;
                    else wolf += v;
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        if(arr[x][y] == 'o')    o++;
        else if(arr[x][y] == 'v')   v++;

        for(int d = 0; d < 4; d++){
            int nr = x + dx[d];
            int nc = y + dy[d];

            if(nr >= r || nr < 0 || nc >= c || nc < 0)  continue;
            if(visited[nr][nc])    continue;
            if(arr[nr][nc] == '#')  continue;

            dfs(nr,nc);
        }
    }
}