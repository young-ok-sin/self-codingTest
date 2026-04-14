import java.io.*;
import java.util.*;

public class Main {
    static int[] cap = new int[3];
    static boolean[] capacity;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cap[0] = Integer.parseInt(st.nextToken());
        cap[1] = Integer.parseInt(st.nextToken());
        cap[2] = Integer.parseInt(st.nextToken());
        capacity = new boolean[cap[2]+1];
        visited = new boolean[cap[0]+1][cap[1]+1][cap[2]+1];

        dfs(new int[]{0,0,cap[2]});

        for(int i = 0; i < cap[2]+1; i++){
            if(capacity[i]){
                System.out.print(i + " ");
            }
        }
    }
    static void dfs(int[] now){
        visited[now[0]][now[1]][now[2]] = true;
        if(now[0] == 0 && !capacity[now[2]]){
            capacity[now[2]] = true;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j) continue;
                int[] next = now.clone();
                int amount = Math.min(now[i], cap[j] - now[j]);
                next[i] -= amount;
                next[j] += amount;
                if(visited[next[0]][next[1]][next[2]]) continue;
                dfs(next);
            }
        }
    }
}
