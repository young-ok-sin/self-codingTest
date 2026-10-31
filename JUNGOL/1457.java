import java.io.*;
import java.util.*;

public class Main {

    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,k;
    static int num;
    static ArrayList<Integer> width = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int y = y1; y < y2; y++){
                for(int x = x1;x < x2; x++){
                    map[y][x] = 1;
                }
            }
        }

        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                if(map[y][x] == 0 && !visited[y][x]){
                    width.add(bfs(x,y));
                }
            }
        }

        Collections.sort(width);
        System.out.println(width.size());

        for(int w : width){
            System.out.print(w + " ");
        }
    }

    static int bfs(int start_x, int start_y){
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(start_x, start_y));
        visited[start_y][start_x] = true;

        int count = 1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n)  continue;
                if(map[ny][nx] == 0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.offer(new Pair(nx, ny));
                    count++;
                }
            }
        }
        return count;
    }
}
