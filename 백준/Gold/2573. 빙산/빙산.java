import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][], year;
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            int cnt = cntIce();

            if (cnt == 0) {
                System.out.println(0);
                return;
            }
            if (cnt >= 2) {
                System.out.println(year);
                return;
            }
            melt();
            year++;
        }

    }

    static int cntIce() {
        visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && visited[i][j] == false) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
                if (!visited[cx][cy] && arr[cx][cy] > 0) {
                    dfs(cx, cy);
                }
            }
        }
    }

    static void melt() {
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0) {
                    int water = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if (arr[nx][ny] == 0) {
                                water++;
                            }
                        }
                    }

                    temp[i][j] = Math.max(0, arr[i][j] - water);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}

