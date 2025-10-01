import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean set[] = new boolean[21];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            switch(cmd){
                case "add" :
                    set[num] = true;
                    break;
                case "remove":
                    set[num] = false;
                    break;
                case "check" :
                    sb.append(set[num] ? "1\n" : "0\n");
                    break;
                case "toggle":
                    set[num] = !set[num];
                    break;
                case "all" :
                    Arrays.fill(set,true);
                    break;
                case "empty" :
                    Arrays.fill(set,false);
                    break;
            }
        }
        System.out.println(sb);
    }
}
