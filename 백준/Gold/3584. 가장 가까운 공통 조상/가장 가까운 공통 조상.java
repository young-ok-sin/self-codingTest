import java.io.*;
import java.util.*;

public class Main {
    static int n,t,start,end;
    static ArrayList<Integer>[] tree;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < t; test_case++){
            n = Integer.parseInt(br.readLine());
            tree = new ArrayList[n+1];
            for(int i = 1; i <= n; i++){
                tree[i] = new ArrayList<>();
            }

            for(int i = 0; i < n-1; i++){
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                tree[from].add(to);
            }
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            dfs(start);
            end = Integer.parseInt(st.nextToken());
            dfs(end);
        }
        System.out.print(sb);
    }
    static void dfs(int idx){
        if(visited[idx]){
            sb.append(idx).append("\n");
            return;
        }
        visited[idx] = true;
        if(tree[idx].isEmpty()){
            return;
        }

        for(int next : tree[idx]){
            dfs(next);
        }
    }
}
