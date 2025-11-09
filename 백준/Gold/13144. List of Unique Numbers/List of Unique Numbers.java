import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int max_num = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max_num)    max_num = arr[i];
        }
        boolean visited[] = new boolean[max_num + 1];

        int start = 0;
        long ans = 0;
        for(int end = 0; end < N; end++){
            while(visited[arr[end]]){
                visited[arr[start]] = false;
                start++;
            }
            visited[arr[end]] = true;
            ans += (end-start+1);
        }
        System.out.println(ans);
    }
}
