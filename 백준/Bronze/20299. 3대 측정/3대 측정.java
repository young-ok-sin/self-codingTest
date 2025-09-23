import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, S, M, cnt;
	
	static class Member{
		int n1, n2, n3;
		Member(int n1, int n2, int n3){
			this.n1 = n1;
			this.n2 = n2;
			this.n3 = n3;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Member> list = new ArrayList<>();

		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			list.add(new Member(n1,n2,n3));
		}
		
		for(int i = 0; i < N; i++) {
			int a = list.get(i).n1;
			int b = list.get(i).n2;
			int c = list.get(i).n3;
			
			if(a < M || b < M || c < M) continue;
			if(a+b+c < S) continue;
			else {
				cnt++;
				sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
		
	}

}
