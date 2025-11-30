import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int res, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt[] = new int[100001];

        int start = 0;
        for(int end = 0; end < N; end++){
            cnt[arr[end]]++;

            while (cnt[arr[end]] > K){
                cnt[arr[start]]--;
                start++;
            }
            res = Math.max(res, end-start+1);
        }
        System.out.println(res);
    }
}
