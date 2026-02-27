import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c, kinds;
    static int arr[];
    static int cnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        cnt = new int[d+1];
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < k; i++){
            if(cnt[arr[i]] == 0)    kinds++;
            cnt[arr[i]]++;
        }
        int ans = kinds + (cnt[c] == 0 ? 1 : 0);

        for(int start = 1; start < N; start++){
            int remove = arr[start -1];
            int add = arr[(start + k -1) % N];

            cnt[remove]--;
            if(cnt[remove] == 0)    kinds--;

            if(cnt[add] == 0)   kinds++;
            cnt[add]++;

            ans = Math.max(ans, kinds + (cnt[c] == 0 ? 1 : 0));
        }
      System.out.println(ans);
    }
}
