import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[] arr, parents;
    static void make(){
        for(int i = 1; i <= n; i++) parents[i] = i;
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b)  return;
        parents[b] = a;
    }

    static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        parents = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        make();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v,w);
        }
        int[] minCost = new int[n+1];
        Arrays.fill(minCost, 10001);

        for(int i = 1; i <= n; i++){
            int root = find(i);
            minCost[root] = Math.min(minCost[root], arr[i]);
        }
        int sum = 0;
        for(int i =1; i <= n; i++){
            if(parents[i] == i) sum += minCost[i];
        }
        System.out.println(sum <= k ? sum : "Oh no");;
    }
}
