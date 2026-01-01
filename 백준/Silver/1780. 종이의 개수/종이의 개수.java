import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, one, zero, minus;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    static void recursive(int x, int y, int size) {
        int tmp = arr[x][y];
        boolean isSame = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (tmp != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            if (tmp == -1) minus++;
            else if (tmp == 0) zero++;
            else one++;
            return;
        }
        recursive(x, y, size / 3);
        recursive(x, y + size / 3, size / 3);
        recursive(x, y + (size / 3) * 2, size / 3);
        recursive(x + size / 3, y, size / 3);
        recursive(x + size / 3, y + size / 3, size / 3);
        recursive(x + size / 3, y + (size / 3) * 2, size / 3);
        recursive(x + (size / 3) * 2, y, size / 3);
        recursive(x + (size / 3) * 2, y + size / 3, size / 3);
        recursive(x + (size / 3) * 2, y + (size / 3) * 2, size / 3);
    }
}