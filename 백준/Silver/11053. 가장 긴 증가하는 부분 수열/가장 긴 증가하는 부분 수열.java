import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 0;
        int sort[] = new int[N];
        for(int i = 0; i < N; i++){
            int idx = Arrays.binarySearch(sort, 0,len,arr[i]);
            if(idx < 0) idx = -(idx+1);
            sort[idx] = arr[i];
            if(idx == len) len++;
        }
        System.out.println(len);
    }
}
