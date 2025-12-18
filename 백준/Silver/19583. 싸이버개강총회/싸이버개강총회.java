import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken().replace(":", ""));
        int E = Integer.parseInt(st.nextToken().replace(":", ""));
        int Q = Integer.parseInt(st.nextToken().replace(":", ""));


        HashMap<String, Integer> start_map = new HashMap<>();
        HashMap<String, Integer> end_map = new HashMap<>();
        int ret = 0;

        String line;
        while ((line = br.readLine()) != null){
            if (line.isEmpty()) break;

            st = new StringTokenizer(line);
            int time = Integer.parseInt(st.nextToken().replace(":", ""));
            String name = st.nextToken();
            if(time <= S){
                start_map.put(name, time);
            } else if (time >= E && time <= Q ) {
                end_map.put(name, time);
            }
        }

        for(String name : end_map.keySet()){
            if(start_map.containsKey(name)){
                ret++;
            }
        }
        System.out.println(ret);
    }
}
