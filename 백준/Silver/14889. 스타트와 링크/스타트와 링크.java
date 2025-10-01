import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S[][];
    static boolean selected[];
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(minDiff);
    }
    static void dfs(int idx, int cnt){
        if(cnt == N/2){
            int teamA = 0;
            int teamB = 0;

            for(int i = 0; i < N; i++){
                for(int j = i+1; j < N; j++){
                    if(selected[i] && selected[j]) {
                        teamA += S[i][j] + S[j][i];
                    }
                    else if(!selected[i] && !selected[j]){
                        teamB += S[i][j] + S[j][i];
                    }
                }
            }
            int dif = Math.abs(teamA - teamB);
            if(dif == 0){
                System.out.println(0);
                System.exit(0);
            }

            minDiff = Math.min(minDiff, dif);
            return;
        }

        for(int i = idx; i < N; i++){
            if(!selected[i]){
                selected[i] = true;
                dfs(i + 1, cnt +1);
                selected[i] = false;
            }
        }
    }

}
