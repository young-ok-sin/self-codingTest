import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static int R, C;
    static int j_x, j_y, time;
    static char arr[][];
    static int dist[][];
    static boolean visited[][];
    static Queue<Point> q = new ArrayDeque<>();
    static Queue<Point> fire = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        dist = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'F') fire.offer(new Point(i, j));
                if (arr[i][j] == 'J') {
                    j_x = i;
                    j_y = j;
                    dist[i][j] = 0;
                }
            }
        }
        int res = bfs();
        System.out.println(res != -1 ? res : "IMPOSSIBLE");
    }

    static int bfs() {
        q.offer(new Point(j_x, j_y));
        while (!q.isEmpty()) {
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                Point p = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (arr[nx][ny] != '.') continue;
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    arr[nx][ny] = 'F';
                    fire.offer(new Point(nx, ny));
                }
            }
            int j_size = q.size();
            for (int i = 0; i < j_size; i++) {
                Point cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) return dist[cur.x][cur.y] + 1;
                    if (arr[nx][ny] != '.') continue;
                    if (dist[nx][ny] != 0) continue;

                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
