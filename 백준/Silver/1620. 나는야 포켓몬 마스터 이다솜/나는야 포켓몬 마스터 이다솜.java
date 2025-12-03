import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashMap<String, Integer> map;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>(N);
        arr = new String[N+1];

        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            map.put(line, i);
            arr[i] = line;
        }

        for(int i = 0; i < M; i++){
            String que = br.readLine();

            if(Character.isDigit(que.charAt(0))){
                int num = Integer.parseInt(que);
                sb.append(arr[num]).append("\n");
            }
            else{
                sb.append(map.get(que)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
