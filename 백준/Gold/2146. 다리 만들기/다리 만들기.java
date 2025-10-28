import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int N, cnt = 1, min = Integer.MAX_VALUE;
    static int[] dx = {-1,1,0,0}, dy = {0, 0, -1, 1};
    static boolean[][] visitedDFS, visitedBFS;
    static class Point {
        int x, y, dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visitedDFS = new boolean[N][N];
        visitedBFS = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visitedDFS[i][j] && arr[i][j] == 1){
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        for (int i = 1; i < cnt; i++) {
            bfs(i);
        }

        System.out.println(min);
    }
    static void bfs(int islandNum) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visitedBFS = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == islandNum) {
                    q.offer(new Point(i, j, 0));
                    visitedBFS[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visitedBFS[nx][ny]) continue;

                if (arr[nx][ny] == 0) {
                    visitedBFS[nx][ny] = true;
                    q.offer(new Point(nx, ny, p.dist + 1));
                }
                else if (arr[nx][ny] != islandNum) {
                    min = Math.min(min, p.dist);
                    return;
                }
            }
        }
    }
    static void dfs(int x, int y){
        visitedDFS[x][y] = true;
        arr[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 ||nx >= N || ny >= N)  continue;
            if(visitedDFS[nx][ny] || arr[nx][ny] == 0)   continue;

            dfs(nx,ny);
        }
    }
}


