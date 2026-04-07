import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[100001];
        int[] prev = new int[100001];
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            int[] nexts = {now - 1, now + 1, now * 2};

            for(int next:nexts){
                if(next >= 0 && next <= 100000 && !visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    prev[next] = now;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        for(int i = k; i != n; i = prev[i]){
            path.add(i);
        }
        path.add(n);
        Collections.reverse(path);
        System.out.println(path.size() - 1);
        for(int x : path){
            System.out.println(x + " ");
        }
    }
}
