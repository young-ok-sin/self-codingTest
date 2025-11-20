import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, cnt;
    static int arr[];
    static boolean visited[];
    static int weight = 500;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        dfs(0,weight);
        System.out.println(cnt);
    }

    static void dfs(int depth, int total){
        if(total < weight){
            return;
        }

        if(depth == N){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, total - K + arr[i]);
                visited[i] = false;
            }
        }
    }
}
