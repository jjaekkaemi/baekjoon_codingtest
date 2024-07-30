import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Food {
    int t1;
    int t2 ;
    Food(int t1, int t2){
        this.t1 = t1;
        this.t2 = t2;
    }
}
public class Main {
    static int N = 0;
    static Food foods[] ;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        foods = new Food[N];
        for(int i = 0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            foods[i] = new Food(t1, t2);
        }
        findFood(0, 1, 0,0); // 신맛은 곱하기 때문에 초기값 1
        System.out.println(answer);
    }

    public static void findFood(int idx, int sour, int bitter, int selectedNum){ // idx : 다음 index, sour : 신맛,
                                                                                // bitter : 쓴맛, selectedNum : 선택된 수
        if(selectedNum>0) {// 선택한 수가 0이상이라면 값 구하기
            answer = Math.min(answer, Math.abs(sour-bitter));
        }

        if(idx==N) { // 재귀 종료
            return ;
        }
        findFood(idx+1, sour*foods[idx].t1, bitter+foods[idx].t2, selectedNum+1); // 선택한 경우
        findFood(idx+1, sour, bitter, selectedNum); // 선택하지 않고 다음 index 로
    }
}