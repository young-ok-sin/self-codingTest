import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        int x = n / 2;
        int y = n / 2;

        int num = 1;
        arr[x][y] = num;

        int ansX = x;
        int ansY = y;

        int len = 1;
        int dir = 0;

        while (num < n * n) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int i = 0; i < len; i++) {

                    if (num == n * n) break;

                    x += dx[dir];
                    y += dy[dir];
                    num++;

                    arr[x][y] = num;

                    if (num == k) {
                        ansX = x;
                        ansY = y;
                    }
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(ansX + 1).append(" ").append(ansY + 1);
        System.out.print(sb);
    }
}
