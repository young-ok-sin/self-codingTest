import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x, y;
        int ret = 0;
        x = Integer.parseInt(br.readLine());
        y = Integer.parseInt(br.readLine());

        if(x > 0 && y > 0)  ret = 1;
        else if(x < 0 && y > 0) ret = 2;
        else if(x < 0 && y < 0) ret = 3;
        else if(x > 0 && y < 0) ret = 4;
        System.out.println(ret);
    }
}
