import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static boolean visited[];
    static int N, minDist;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            arr = new int[N+2][2];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N+2; i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());

            }
            minDist = Integer.MAX_VALUE;
            dfs(0, 0,0);
            System.out.println("#" + test_case+" "+ minDist);
        }

    }
    static void dfs(int idx, int cnt, int dist){
        if(dist >= minDist) return;

        if(cnt == N){
            dist += getDist(idx,1);
            minDist = Math.min(minDist, dist);
            return;
        }
        for(int i = 0; i < N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+2, cnt+1, dist + getDist(idx, i+2));
                visited[i] = false;
            }
        }
    }
    static int getDist(int a, int b){
        return Math.abs(arr[a][0] - arr[b][0]) + Math.abs(arr[a][1] - arr[b][1]);
    }
}
