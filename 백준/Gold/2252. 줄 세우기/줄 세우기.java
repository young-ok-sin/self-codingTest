import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int indgree[];
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        indgree =new int[N+1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            indgree[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(indgree[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();

        while (!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            for(int i : list[cur]){
                indgree[i]--;
                if(indgree[i] == 0) q.offer(i);
            }
        }
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
