import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, ans = 0;
    static boolean[] cols, diag1, diag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cols = new boolean[N];
        diag1 = new boolean[N*2];
        diag2 = new boolean[N*2];

        dfs(0);
        System.out.println(ans);
    }
    static void dfs(int row){
        if(row == N){
            ans++;
            return;
        }
        for(int col = 0; col < N; col++){
            if(cols[col] || diag1[row - col + N] || diag2[row + col]) continue;

            cols[col] = diag1[row - col + N] = diag2[row + col] = true;
            dfs(row+1);
            cols[col] = diag1[row - col + N] = diag2[row + col] = false;
        }
    }
}
