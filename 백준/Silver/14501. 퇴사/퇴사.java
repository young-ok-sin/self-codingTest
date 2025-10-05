import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, weight[], value[],DP[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        weight = new int[N];
        value = new int[N];
        DP = new int[N+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            //오늘 상담 x
            DP[i+1] = Math.max(DP[i+1], DP[i]);

            //오늘 상담 o
            if(i + value[i] <= N){ //퇴사일 안 넘을 때
                DP[i + value[i]] = Math.max(DP[i + value[i]], DP[i] + weight[i]);
            }
        }
        System.out.println(DP[N]); //최대 수익
    }
}
