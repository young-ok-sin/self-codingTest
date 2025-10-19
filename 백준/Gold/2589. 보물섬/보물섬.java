import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, W, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static char arr[][];
    static boolean visited[][];

    static class Point{
        int x, y, dist;
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new char[L][W];

        for(int i = 0; i < L; i++){
            String line = br.readLine();
            for(int j = 0; j < W; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        int ans = 0;
        for(int i = 0 ; i < L; i++){
            for(int j = 0; j < W; j++){
                if(arr[i][j] == 'L'){
                    ans = Math.max(ans, bfs(i,j));
                }
            }
        }
        System.out.println(ans);
    }


    static int bfs(int x, int y){
        visited = new boolean[L][W];
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x,y,0));
        visited[x][y] = true;

        int maxDist = 0;

        while (!q.isEmpty()){
            Point p = q.poll();
            maxDist = Math.max(maxDist, p.dist);
            for(int d = 0; d < 4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= L || ny >= W ) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 'W') continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx,ny, p.dist + 1));
            }
        }
        return maxDist;
    }
}
