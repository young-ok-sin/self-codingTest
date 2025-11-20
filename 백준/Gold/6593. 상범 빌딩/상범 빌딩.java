import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visited;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};

    static class Point{
        int x, y, z, dist;
        Point(int z, int x, int y, int dist){
            this.z = z;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)  break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            int sz = 0, sx = 0, sy = 0;
            int ez = 0, ex = 0, ey = 0;

            for(int z = 0; z < L; z++){
                for(int x = 0; x < R; x++){
                    String line = br.readLine();
                    for (int y = 0; y < C; y++){
                        map[z][x][y] = line.charAt(y);
                        if (map[z][x][y] == 'S') {
                            sz = z; sx = x; sy = y;
                        } else if (map[z][x][y] == 'E') {
                            ez = z; ex = x; ey = y;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(sz, sx, sy, ez, ex, ey);

            if(result == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + result + " minute(s).");
        }
    }
    static int bfs(int sz, int sx, int sy, int ez, int ex, int ey){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(sz, sx, sy, 0));
        visited[sz][sx][sy] = true;

        while (!q.isEmpty()){
            Point cur = q.poll();

            if (cur.z == ez && cur.x == ex && cur.y == ey) {
                return cur.dist;
            }

            for(int i = 0; i < 6; i++){
                int nz = cur.z + dz[i];
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C) continue;
                if(visited[nz][nx][ny]) continue;
                if(map[nz][nx][ny] == '#')  continue;

                visited[nz][nx][ny] = true;
                q.offer(new Point(nz,nx,ny, cur.dist + 1));
            }
        }
        return -1;
    }
}
