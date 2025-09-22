import java.io.*;
import java.util.*;

public class Main {
     static class Pair {
        int num;
        String key;
        Pair(int n, String k) { num = n; key = k; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] words = {
            "zero","one","two","three","four",
            "five","six","seven","eight","nine"
        };

        List<Pair> list = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            String s = String.valueOf(i);
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (j > 0) key.append(' ');
                key.append(words[s.charAt(j) - '0']);
            }
            list.add(new Pair(i, key.toString()));
        }

        Collections.sort(list, Comparator.comparing(p -> p.key));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && i % 10 == 0) sb.append('\n');
            else if (i > 0) sb.append(' ');
            sb.append(list.get(i).num);
        }
        System.out.println(sb.toString());
    }
}
