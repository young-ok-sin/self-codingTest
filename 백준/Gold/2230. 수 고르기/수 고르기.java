import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[], min_value = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start = 0, end = 0;

        while(end < N){
            int diff = arr[end] - arr[start];

            if(diff >= M){
                if(diff == M){
                    min_value = M;
                    break;
                }
                min_value = Math.min(diff, min_value);
                start++;
            }
            else{
                end++;
            }
        }
        System.out.println(min_value);
    }
}
