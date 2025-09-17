import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] S,B;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,1,0,0);
        System.out.println(minDiff);
    }
    static void dfs(int idx, int sour, int bitter, int cnt){
        if(idx == N){
            if(cnt > 0){
                minDiff = Math.min(minDiff, Math.abs(sour - bitter));
            }
            return;
        }

        dfs(idx + 1, sour * S[idx], bitter + B[idx], cnt + 1);
        dfs(idx + 1, sour, bitter, cnt);
    }
}
