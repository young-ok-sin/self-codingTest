import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[], min[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        min = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start_idx = 0;
        int end_idx = N - 1;
        long min_value = Long.MAX_VALUE;

        while(start_idx < end_idx){
            long sum = arr[start_idx] + arr[end_idx];
            long abs = Math.abs(sum);

            if(abs < min_value){
                min_value = abs;
                min[0] = arr[start_idx];
                min[1] = arr[end_idx];
            }

            if(sum > 0){
                end_idx--;
            }else{
                start_idx++;
            }
        }
        System.out.println(min[0] + " " + min[1]);
    }
}
