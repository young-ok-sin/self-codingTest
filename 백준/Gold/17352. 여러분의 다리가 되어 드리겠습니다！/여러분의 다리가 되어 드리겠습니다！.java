import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parents;
    static void make(){
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(a == parents[a]) return a;
        else return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot)  return false;
        parents[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        parents = new int[n];
        make();

        for(int i = 0; i < n-2; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            union(from, to);
        }
        int root = find(0);

        for(int i = 1; i < n; i++){
            if(find(i) != root){
                System.out.println((root + 1) + " " + (i+1));
                return;
            }
        }
    }
}
