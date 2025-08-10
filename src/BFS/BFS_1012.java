package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_1012 {
    static int m,n,k;
    static int arr[][];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        for(int tc = 0; tc < t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.valueOf(st.nextToken());
            n = Integer.valueOf(st.nextToken());
            k = Integer.valueOf(st.nextToken());

            arr= new int[n][m];
            for(int i = 0; i < k ; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int a = Integer.valueOf(st1.nextToken());
                int b = Integer.valueOf(st1.nextToken());

                arr[b][a] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    private static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        arr[y][x] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cy = now[0];
            int cx = now[1];

            for(int dir = 0; dir < 4; dir++){
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == 1) {
                    arr[ny][nx] = 0;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }

}

