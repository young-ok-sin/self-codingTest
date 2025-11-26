import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long cnt;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            arr[i] = line.length();
        }
        
        ArrayList<Integer>[] pos = new ArrayList[21];
        for (int i = 0; i < 21; i++) pos[i] = new ArrayList<>();
        int[] count = new int[21];
        
        for (int i = 0; i < N; i++) {
            int len = arr[i];
            ArrayList<Integer> list = pos[len];
            
            while (!list.isEmpty() && list.get(0) < i - K) {
                list.remove(0);
                count[len]--;
            }
            cnt += count[len];
            list.add(i);
            count[len]++;
        }
        System.out.println(cnt);
    }
}
