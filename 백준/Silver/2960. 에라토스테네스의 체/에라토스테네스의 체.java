import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }

        int num = 0;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == true) {
                for (int j = i; j <= N; j += i) {
                    if (arr[j] == true) {
                        arr[j] = false;
                        num++;
                        if (num == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}