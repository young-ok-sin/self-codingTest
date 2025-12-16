import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String name = br.readLine();
            map.put(name, i);
        }
        for(int i = 0; i < N; i++){
            arr[i] = map.get(br.readLine());
        }
        int ret = 0;
        for(int i = 0; i < N-1; i++){
            int cur = arr[i];
            for(int j = i+1; j < N; j++){
                int next = arr[j];

                if(next < cur){
                    ret++;
                    break;
                }
            }
        }
        System.out.println(ret);
    }
}
