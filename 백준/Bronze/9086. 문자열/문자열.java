import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            sb.append(line.charAt(0))
              .append(line.charAt(line.length() - 1))
              .append('\n');
        }

        System.out.print(sb);
    }
}