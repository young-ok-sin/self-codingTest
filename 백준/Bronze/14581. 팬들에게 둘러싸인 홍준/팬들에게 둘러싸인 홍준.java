import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        sb.append(":fan:").append(":fan:").append(":fan:").append("\n")
                .append(":fan:").append(":").append(word).append(":").append(":fan:").append("\n")
                .append(":fan:").append(":fan:").append(":fan:");
        System.out.print(sb);
    }
}