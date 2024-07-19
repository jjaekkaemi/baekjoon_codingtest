
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
       int[][] load = new int[N][3];

        for(int i = 0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            load[i][0] = Integer.parseInt(st.nextToken());
            load[i][1] = Integer.parseInt(st.nextToken());
            load[i][2] = Integer.parseInt(st.nextToken());
        }
       int[] dp = new int[D+1]; // 도로 길이를 나타내는 dp 배열
        for(int i = 0 ; i<D+1 ; i++){ // 도로 길이 init
            dp[i] = i;
        }
       for(int i = 0 ; i<D+1 ; i++){ // 도로 길이 1씩
           if(i>0) dp[i] = Math.min(dp[i-1]+1,dp[i]); // 최소 도로 길이로 update
           for(int j = 0 ; j<N ; j++){ // 지름길 for문
               if(i == load[j][0] && load[j][1]<D+1) { // 현재 도로와 해당하는 시작 지름길 찾기, 지름길 끝이 도로 길이 보다 작은 경우에만
                   dp[load[j][1]] = Math.min(dp[load[j][1]], dp[load[j][0]]+load[j][2]); // 현재 지름길 끝 길이와 지름길 + 지름길 시작 길이 비교
               }
           }
       }
       System.out.println(dp[D]); // 최소 도로 길이 가져오기
    }
}