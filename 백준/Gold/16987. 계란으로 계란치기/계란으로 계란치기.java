import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, weight[], HP[], result;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        weight = new int[N];
        HP = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            HP[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result);
    }
    static void dfs(int idx){
        if (idx == N) {
            int broken = 0;
            for (int hp : HP) {
                if (hp <= 0) broken++;
            }
            result = Math.max(result, broken);
            return;
        }
        if(HP[idx] <= 0){
            dfs(idx+1);
            return;
        }
        boolean theRest = false;
        for(int i = 0; i < N; i++){
            if(i == idx || HP[i] <= 0)  continue;

            theRest = true;
            HP[idx] -= weight[i];
            HP[i] -= weight[idx];

            dfs(idx+1);

            HP[idx] += weight[i];
            HP[i] += weight[idx];
        }

        if(!theRest) dfs(idx+1);
    }
}
