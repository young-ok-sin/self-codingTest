import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] arr,sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1];
        sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i-1];
        }
        int max = sum[k];
        for(int i = k+1; i <= n; i++){
            max = Math.max(max, sum[i]-sum[i-k]);
        }
        System.out.print(max);
    }
}
