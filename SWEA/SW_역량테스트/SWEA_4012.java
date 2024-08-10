
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N = 0;
    static int foods[][] ;
    static int answer = Integer.MAX_VALUE;
    static int TEST_CASE ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TEST_CASE = Integer.parseInt(st.nextToken());

        for(int t = 1 ; t<TEST_CASE+1 ; t++){
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N];
            foods = new int[N][N];
            for(int i = 0 ; i<N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j<N ; j++){
                    foods[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            findFood(0, visited, 0);
            System.out.printf("#%d %d\n", t, answer);
        }

    }

    public static void findFood(int idx,  boolean[] visited, int selectedNum){ // idx : 다음 index, visited : a 음식 레시피, selectedNum: 선택한 음식수
        if(selectedNum==N/2) {// 선택한 수가 N/2 라면
            int a = 0;
            int b = 0 ;
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for(int i = 0 ; i<N ; i++){
                if(visited[i]){ // a음식
                    aList.add(i);
                } else { // b음식
                    bList.add(i);
                }
            }

            for(int i = 0 ; i<aList.size() ; i++){
                for(int j = i+1 ; j<aList.size() ; j++){
                    a += foods[aList.get(i)][aList.get(j)] ;
                    a += foods[aList.get(j)][aList.get(i)] ;

                    b += foods[bList.get(i)][bList.get(j)] ;
                    b += foods[bList.get(j)][bList.get(i)];
                }
            }
            answer = Math.min(Math.abs(a-b), answer);
        }

        if(idx==N) { // 재귀 종료
            return ;
        }
        visited[idx] = true;
        findFood(idx+1, visited, selectedNum+1); // 선택한 경우
        visited[idx] = false;
        findFood(idx+1, visited, selectedNum); // 선택하지 않고 다음 index 로
    }
}