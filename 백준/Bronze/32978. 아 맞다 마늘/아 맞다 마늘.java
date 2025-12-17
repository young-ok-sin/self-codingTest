import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> map = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] all = new String[N];
        for(int i = 0; i < N; i++){
            all[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            map.add(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            if(!map.contains(all[i])){
                System.out.println(all[i]);
                break;
            }
        }
    }
}
