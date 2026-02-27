import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, d, k, c, max = 0;
    static int[] arr, window;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속 접시 수
        c = Integer.parseInt(st.nextToken()); //쿠폰

        arr = new int[n];
        window = new int[d+1];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i = 0; i < k; i++){
            if(window[arr[i]] == 0) cnt++;
            window[arr[i]]++;
        }
        max = cnt + (window[c] == 0 ? 1 : 0);

        for(int i = 1; i < n; i++){
            int left = arr[i-1];
            int right = arr[(i+k-1) % n];

            window[left]--;
            if(window[left] == 0) cnt--;

            if(window[right] == 0)  cnt++;
            window[right]++;

            int cur = cnt + (window[c] == 0 ? 1:0);
            max = Math.max(cur, max);
        }
        System.out.println(max);
    }
}
