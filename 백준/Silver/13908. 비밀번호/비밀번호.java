import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer;
    static boolean[] required = new boolean[10];
    static boolean[] used = new boolean[10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                required[num] = true;
            }
        }
        dfs(0);
        System.out.println(answer);
    }
    static void dfs(int depth){
        if(depth == n){
            for(int i = 0; i < 10; i++){
                if(required[i] && !used[i]){
                    return;
                }
            }
            answer++;
            return;
        }

        for(int i = 0; i < 10; i++){
            boolean prev = used[i];
            used[i] = true;
            dfs(depth+1);
            used[i] = prev;
        }
    }
}
