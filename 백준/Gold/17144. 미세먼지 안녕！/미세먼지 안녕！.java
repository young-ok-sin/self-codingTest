import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int top = -1, bottom = -1;
    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == -1) {
                    if (top == -1) top = i;
                    else bottom = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            move();
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
    
    static void spread() {
        int[][] temp = new int[R][C];
        temp[top][0] = -1;
        temp[bottom][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    int dust = arr[i][j] / 5;
                    int cnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if (arr[nx][ny] == -1) continue;

                        temp[nx][ny] += dust;
                        cnt++;
                    }

                    temp[i][j] += arr[i][j] - dust * cnt;
                }
            }
        }
        arr = temp;
    }
    
    static void move() {
        for (int i = top - 1; i > 0; i--) arr[i][0] = arr[i - 1][0];
        for (int j = 0; j < C - 1; j++) arr[0][j] = arr[0][j + 1];
        for (int i = 0; i < top; i++) arr[i][C - 1] = arr[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) arr[top][j] = arr[top][j - 1];
        arr[top][1] = 0;
        
        for (int i = bottom + 1; i < R - 1; i++) arr[i][0] = arr[i + 1][0];
        for (int j = 0; j < C - 1; j++) arr[R - 1][j] = arr[R - 1][j + 1];
        for (int i = R - 1; i > bottom; i--) arr[i][C - 1] = arr[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) arr[bottom][j] = arr[bottom][j - 1];
        arr[bottom][1] = 0;
        
        arr[top][0] = -1;
        arr[bottom][0] = -1;
    }
}
