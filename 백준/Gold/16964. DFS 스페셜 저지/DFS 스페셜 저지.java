import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check;
    static int[] input, ret, orderIdx;
    static ArrayList<Integer>[] graph;
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        check = new boolean[n+1];
        input = new int[n];
        ret = new int[n];
        orderIdx = new int[n+1];

        StringTokenizer st;
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            input[i] = Integer.parseInt(st.nextToken());
            orderIdx[input[i]] = i;
        }
        if(input[0] != 1){
            System.out.println(0);
            return;
        }
        for(int i = 1; i <= n; i++){
            graph[i].sort((a,b) -> orderIdx[a] - orderIdx[b]);
        }
        dfs(1);

        for (int i = 0; i < n; i++) {
            if (input[i] != ret[i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
    static void dfs(int x){
        check[x] = true;
        ret[idx++] = x;

        for(int next : graph[x]){
            if(!check[next]){
                dfs(next);
            }
        }
    }
}
