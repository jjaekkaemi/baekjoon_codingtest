import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 인원수
        int[] arr = new int[n]; // 예상 등수를 담아둘 배열
        long answer = 0; // 정답


        for(int i = 0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 정렬
        int idx = 1 ;
        for(int i = 0 ; i<n ; i++) { // 가장 예상 등수와 실제 등수의 차가 적게 하기 위해 정렬을 하여 순차적으로 계산
            answer += Math.abs(arr[i] - idx++);
        }
        System.out.println(answer);
    }
}