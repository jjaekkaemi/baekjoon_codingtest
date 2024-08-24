
import java.util.*;

public class Main {
    static int N, M ;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        getSequence(0, 1);

    }
    // 재귀로 수열을 만들어주는 함수
    public static void getSequence(int cnt, int idx){ // cnt: 어레이 index, idx: 항상 더 큰 값만 넣도록 +1
        if(cnt == M) { // 자릿 수 다 찼으면 print, 재귀 종료
            for(int i = 0 ; i<M ; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = idx ; i<N+1 ; i++){ // for문을 돌면서
            arr[cnt] = i; // 현재 자리수에 숫자 넣어주기
            getSequence(cnt+1, i+1); // 다음 자릿수
        }
    }
}
