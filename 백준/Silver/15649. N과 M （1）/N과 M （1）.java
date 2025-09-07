import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[];
    static int arr[];
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];
        back(0);
    }
    static void back(int depth){
        if(depth == M){
            for(int a : arr) System.out.print(a + " ");
            System.out.println();
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                back(depth+1);
                visited[i] = false;
            }
        }
    }
}
