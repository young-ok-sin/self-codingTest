import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int people[];
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        people = new int[N+1];

        for(int i = 1; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        //인구수 입력
        for(int i = 1; i < N+1; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        //인접 구역 입력
        for(int i = 1; i < N+1; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st1.nextToken());

            for(int j = 1; j <= input; j++){
                int con = Integer.parseInt(st1.nextToken());
                graph[i].add(con);
            }
        }

        //mask를 통해 원소가 집합에 포함되는지 여부를 나타냄
        for(int mask = 1; mask < (1 << N); mask++){
            ArrayList<Integer> g1 = new ArrayList<>();
            ArrayList<Integer> g2 = new ArrayList<>();

            for(int i = 0; i < N; i++){
                if((mask & (1 << i)) != 0) g1.add(i+1);
                else g2.add(i+1);
            }

            if(g1.isEmpty() || g2.isEmpty()) continue;

            if(isConnected(g1) && isConnected(g2)){
                int sum1 = 0, sum2 = 0;
                for(int node : g1) sum1 += people[node];
                for(int node : g2) sum2 += people[node];
                minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
            }
        }
        if (minDiff == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minDiff);

    }
    static boolean isConnected(ArrayList<Integer> group){
        boolean visited[] = new boolean[N+1];
        ArrayList<Integer> q = new ArrayList<>();

        q.add(group.get(0));
        visited[group.get(0)] = true;

        while(!q.isEmpty()){
            int cur = q.remove(0);
            for(int next: graph[cur]){
                if(group.contains(next) && !visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        int cnt = 0;
        for(int node : group){
            if(visited[node]) cnt++;
        }
        return cnt == group.size();
    }

}
