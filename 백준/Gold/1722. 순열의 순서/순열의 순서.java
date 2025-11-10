import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long K;
    static long f[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        f = new long[N+1];
        f[0] = 1;
        for(int i = 1; i <= N; i++) f[i] = f[i-1] * i;
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        if(num == 1){
            K = Long.parseLong(st.nextToken());
            getPermutation(K);
        }
        else{
            int arr[] = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            getOrder(arr);
        }
    }
    static void getPermutation(long K) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;

                if (f[N - i] < K) {
                    K -= f[N - i];
                } else {
                    sb.append(j).append(" ");
                    visited[j] = true;
                    break;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    static void getOrder(int[] arr) {
        long order = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < arr[i]; j++) {
                if (!visited[j]) order += f[N - i - 1];
            }
            visited[arr[i]] = true;
        }
        System.out.println(order);
    }
}

