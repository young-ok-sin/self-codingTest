import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, min_dif = Integer.MAX_VALUE;
    static int arr[];
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> group1, group2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                int con = Integer.parseInt(st.nextToken());
                list[i].add(con);
            }
        }

        for(int mask = 1; mask < (1 << N) -1 ;mask++){
            group1 = new ArrayList<>();
            group2 = new ArrayList<>();
            for(int i = 0; i < N; i++){
                if((mask & (1 << i)) != 0)  group1.add(i+1);
                else group2.add(i+1);
            }

            if (isCon(group1) && isCon(group2)){
                int dif = Math.abs(sum(group1) - sum(group2));
                min_dif = Math.min(min_dif, dif);
            }
        }
        System.out.println(min_dif == Integer.MAX_VALUE ? -1 : min_dif);
    }

    static boolean isCon(ArrayList<Integer> group){
        boolean visited[] = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[group.get(0)] = true;
        q.offer(group.get(0));

        int cnt = 1;
        while (!q.isEmpty()){
            int cur = q.poll();
            for(int i : list[cur]){
                if(!visited[i] && group.contains(i)){
                    visited[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return cnt == group.size();
    }

    static int sum(ArrayList<Integer> area){
        int sum = 0;
        for(int i : area){
            sum += arr[i];
        }
        return sum;
    }
}
