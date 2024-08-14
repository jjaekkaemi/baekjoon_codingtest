import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX_NUM = 500; // 번호 최대 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[MAX_NUM+1][1]; // 행의 index = A, [행][0] = B
        int[] dp = new int[MAX_NUM+1]; // 최장 증가 부분 수열
        int answer = 0;
        for(int i = 0 ; i<MAX_NUM+1 ; i++){ // 모든 어레이 init
            arr[i][0] = 0;
        }
       for(int i = 0 ; i<n ; i++){
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           arr[start][0] = end;

       }
       for(int i = 0 ; i<MAX_NUM+1 ; i++){
           if(arr[i][0]!=0){ // 선이 있는 경우만
               dp[i]=1; // 초기값
               for(int j = i-1 ; j>-1 ; j--){ // 최장 증가 부분 수열 만들기
                   if(arr[i][0]>arr[j][0]){ // 겹쳐지지 않는다면
                       dp[i] = Math.max(dp[i], dp[j]+1); // 현재 값과 비교하여 더 큰 값 넣기
                   }
                   answer = Math.max(dp[i], answer);
               }
           }
       }
       System.out.println(n-answer);
    }
}
