
import java.io.IOException;
import java.util.*;

public class Main {
    static int N, M ;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        getSequence(0, new boolean[N+1]);

    }
    // 재귀로 수열을 만들어주는 함수
    public static void getSequence(int cnt, boolean[] selected){ // cnt: 어레이 index, selected: 현재 수가 선택됐는지 체크
        if(cnt == M) { // 자릿 수 다 찼으면 print, 재귀 종료
            for(int i = 0 ; i<M ; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1 ; i<N+1 ; i++){ // for문을 돌면서
            if(selected[i]) continue; // 수의 중복 체크
            selected[i] = true; // 선택한 수 true
            arr[cnt] = i; // 현재 자리수에 숫자 넣어주기
            getSequence(cnt+1, selected); // 다음 자릿수
            selected[i] = false; // 선택 해제
        }
    }
}
