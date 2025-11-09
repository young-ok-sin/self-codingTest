import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max_cnt = 0, min_guitar_cnt = Integer.MAX_VALUE;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            String s = st.nextToken();
            long bit = 0L;
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == 'Y') bit |= (1L << j);
            }
            arr[i] = bit;
        }
        dfs(0,0,0L);

        if(max_cnt == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(min_guitar_cnt);
        }
    }
    static void dfs(int idx, int cnt, long mask){
        if(idx == N){
            int songCnt = Long.bitCount(mask);
            if(songCnt > max_cnt){
                max_cnt = songCnt;
                min_guitar_cnt = cnt;
            } else if (songCnt == max_cnt) {
                min_guitar_cnt = Math.min(min_guitar_cnt, cnt);
            }
            return;
        }
        dfs(idx + 1, cnt + 1, mask | arr[idx]);

        dfs(idx + 1, cnt, mask);
    }
}
