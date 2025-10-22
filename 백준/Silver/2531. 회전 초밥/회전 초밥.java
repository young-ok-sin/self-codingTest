import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int arr[];
    //N : 접시 수, d: 초밥의 종류 수, k : 접시 수, c: 쿠폰 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt[] = new int[d+1];
        int distinct = 0;

        for(int i = 0; i < k; i++){
            int sushi = arr[i % N];
            if(cnt[sushi] == 0) distinct++;
            cnt[sushi]++;
        }

        int max = cnt[c] == 0 ? distinct + 1 : distinct;

        for (int i = 1; i <= N; i++) {
            // 나가는 인덱스: i-1
            int outIdx = i - 1;
            int outSushi = arr[outIdx % N];
            cnt[outSushi]--;
            if (cnt[outSushi] == 0) distinct--;

            // 들어오는 인덱스: i + k - 1
            int inIdx = i + k - 1;
            int inSushi = arr[inIdx % N];
            if (cnt[inSushi] == 0) distinct++;
            cnt[inSushi]++;

            int current = (cnt[c] == 0) ? distinct + 1 : distinct;
            if (current > max) max = current;
            // early stop: 만약 최댓값이 k (윈도우 크기)이면 더 이상 커질 수 없음
            if (max == k + 1) break;
        }

        System.out.println(max);
    }

}
