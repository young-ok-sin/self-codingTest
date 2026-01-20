import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());

        System.out.println((a+b)*(a-b));
    }
}