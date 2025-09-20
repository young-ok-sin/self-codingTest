import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, A[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int len = 0;
        int sort_arr[] = new int[N];
        for(int i = 0; i < N; i++){
            int idx = Arrays.binarySearch(sort_arr, 0, len, A[i]);

            if(idx < 0) idx = -(idx + 1);

            sort_arr[idx] = A[i];
            if(idx == len) len++;
        }
        System.out.println(len);
    }
}
