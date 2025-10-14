import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, result[];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        visited = new boolean[N+1];

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == N){
            for(int i = 0; i < N; i++){
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }


        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
