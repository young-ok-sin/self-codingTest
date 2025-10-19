import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, arr[][], num_arr[], dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
    static boolean visited[][];

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j =0; j < N; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        visited = new boolean[N][N];
        List<Integer> num_list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] ||  arr[i][j] == 0)   continue;
                int cnt = bfs(i, j);
                num_list.add(cnt);
            }
        }
        System.out.println(num_list.size());
        Collections.sort(num_list);
        for(int a : num_list){
            System.out.println(a);
        }
    }
    static int bfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new Point(x,y));
        int cnt = 1;

        while (!q.isEmpty()){
            Point p = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N)  continue;
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
