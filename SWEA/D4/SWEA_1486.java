
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int answer = Integer.MAX_VALUE ;
    static int n ;
    static int b ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TEST_CASE = Integer.parseInt(st.nextToken());
        for(int t = 0 ; t<TEST_CASE ; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            answer = Integer.MAX_VALUE; // 가장 높은 값으로 리셋
            int[] arr = new int[n];
            for(int i = 0 ; i<n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            findTop(0, 0, arr); // 재귀함수 호출
            System.out.printf("#%d %d\n", t+1, answer-b);
        }
    }

    public static void findTop(int idx, int sum, int[] arr){ // idx: 다음 index 값, sum: 키의 합, arr: 저장한 키
        if(b<=sum) {
            answer = Math.min(answer, sum); // 키의 합이 제시한 키보다 높은 경우 가장 작은 값 answer에 넣기 !
            return;
        }
        if(idx==arr.length) return ; // 재귀 탈출
        findTop(idx+1, sum+arr[idx], arr); // 합해서 함수 호출
        findTop(idx+1, sum, arr);// 합하지 않고 함수 호출
    }
}
