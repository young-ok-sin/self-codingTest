import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken().replace(":", ""));
        int E = Integer.parseInt(st.nextToken().replace(":", ""));
        int Q = Integer.parseInt(st.nextToken().replace(":", ""));


        HashSet<String> enter = new HashSet<>();
        HashSet<String> exit = new HashSet<>();
        int ret = 0;

        String line;
        while ((line = br.readLine()) != null){
            if (line.isEmpty()) break;

            st = new StringTokenizer(line);
            int time = Integer.parseInt(st.nextToken().replace(":", ""));
            String name = st.nextToken();
            if(time <= S){
                enter.add(name);
            } else if (time >= E && time <= Q ) {
                exit.add(name);
            }
        }

        for(String name : exit){
            if(enter.contains(name)){
                ret++;
            }
        }
        System.out.println(ret);
    }
}
