import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 웅덩이 개수
		int L = Integer.parseInt(st.nextToken()); // 널판지 길이
		final int INFO = 2;
		int[][] arr = new int[N][INFO]; // 웅덩이 정보 받는 배열
		int answer = 0 ;
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() { // 첫 번째 index로 정렬 후, 두 번째 index 정렬
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
	     int range = 0;

		for(int i = 0 ; i<N ; i++) {
			if(arr[i][0]>range) { // 현재의 널판지 위치가 웅덩이 위치보다 작으면 웅덩이 위치로 reset
				range = arr[i][0];
			}
			if(arr[i][1]>range) { // 현재 널판지를 웅덩이 끝 위치까지 깔지 않았다면
				while(arr[i][1]-1>=range) { // 웅덩이 끝을 다 덮을 때까지 널판지 길이 만큼 더해주기
					range += L;
					answer++;
				}
			}
		}
		System.out.println(answer);

	}
}