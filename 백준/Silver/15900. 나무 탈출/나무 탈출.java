import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] tree;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }
        visited = new boolean[n+1];
        int num = dfs(1,0);
        // 리프 노드의 수를 세서 홀짝으로 세기
        int rest = num % 2;
        System.out.println(rest == 0 ? "No" : "Yes");
        //자식 노드가 없고, 방문하지 않은 노드의 수를 세기
    }
    static int dfs(int idx, int cnt){
        visited[idx] = true;
        if(idx != 1 && tree[idx].size() == 1){
            return cnt;
        }
        int ret = 0;
        for(int next : tree[idx]){
            if(visited[next]) continue;
            ret += dfs(next, cnt + 1);
        }
        return ret;
    }
}
