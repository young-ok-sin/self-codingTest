import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K;
	static int arr[][], original[][];
	static int minCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			original = new int[D][W];
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					original[i][j] = arr[i][j];
				}
			}
			minCnt = Integer.MAX_VALUE;
            if (checkAll()) {
                minCnt = 0;  // 약품을 사용하지 않아도 통과하면 0 출력
            } else {
                solve(0, 0);  // 첫 번째 막부터 시작
            }
			System.out.println("#" + test_case + " " + minCnt);
		}
		
	}
	
	static void solve(int depth, int cnt) {
		if(cnt >= minCnt)	return;
		
		if(checkAll()) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		
		if(depth == D) {
			return;
		}
		
		for(int type = 0; type < 2; type++) {
			change(depth, type);
			solve(depth + 1, cnt + 1);
			change(depth, -1);
		}
		
		solve(depth + 1, cnt);
	}
	
	static boolean checkAll() {
		for(int i = 0; i < W; i++) {
			if(!check(i)) return false;
		}
		return true;
	}
	
	// 약품 주입하는 코드
	static void change(int y, int type) {
		for(int i = 0; i < W; i++) {
			arr[y][i] = (type == -1) ? original[y][i] : type;
		}
	}
	
	// 줄 별로 가능한지 확인하는 함수 
	static boolean check(int x) {
		int cur_cnt = 1;
		int cur = arr[0][x];
		
        if(K == cur_cnt) {
			return true;
		}
		
        
		for(int i = 1; i < D; i++) {
			if(arr[i][x] == cur) {
				cur_cnt++;
				if(cur_cnt >= K)	return true;
			}
			else{
				cur = arr[i][x];
				cur_cnt = 1;
			}
		}
		return false;
	}
}
