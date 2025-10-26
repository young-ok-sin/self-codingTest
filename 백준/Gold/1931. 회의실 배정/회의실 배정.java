import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static ArrayList<Schedule> list = new ArrayList<>();
    static class Schedule implements Comparable<Schedule> {
        int start, end;
        Schedule(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Schedule o) {
           if(this.end == o.end){
               return this.start - o.start;
            }
           return this.end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Schedule(s,e));
        }
        Collections.sort(list);

        int cnt = 0;
        int lastEnd = 0;

        for(Schedule s : list){
            if(s.start >= lastEnd){
                cnt++;
                lastEnd = s.end;
            }
        }
        System.out.println(cnt);
    }
}
