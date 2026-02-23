import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<String> listen = new HashSet<>();
    static List<String> ret = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            listen.add(input);
        }

        for(int i = 0; i < m; i++){
            String input = br.readLine();
            if(listen.contains(input)){
                ret.add(input);
            }
        }
        Collections.sort(ret);
        System.out.println(ret.size());
        for(String name : ret){
            System.out.println(name);
        }
    }
}