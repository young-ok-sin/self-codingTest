import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, cnt, dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static char arr[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        visited[R-1][0] = true;
        back(R-1, 0, 1);

        System.out.println(cnt);
    }

    static void back(int x, int y, int p_cnt) {
        if(x == 0 && y == C-1){
            if(p_cnt == K) {
                cnt++;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if(x1 < 0 || y1 < 0 || x1 >= R || y1 >= C)  continue;
            if(visited[x1][y1]) continue;
            if(arr[x1][y1] == 'T')  continue;

            visited[x1][y1] = true;
            back(x1, y1, p_cnt + 1);
            visited[x1][y1] = false;
        }
    }
}
