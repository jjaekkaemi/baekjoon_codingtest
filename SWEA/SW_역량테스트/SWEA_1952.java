import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int answer;
    static int[] money ;
    static int[] used;
    static ArrayList<ArrayList<Integer>> tree; // 조합으로 안되는 list 담기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TEST_CASE = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= TEST_CASE; t++) {
            answer = 0;
            money = new int[4]; // 요금 어레이
            used = new int[12]; // 달 이용계획
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<4 ; i++){
                money[i] = Integer.parseInt(st.nextToken());

            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<12 ; i++){
                used[i] = Integer.parseInt(st.nextToken());
            }
            answer = money[3]; // 1년 이용 가격
            dfs(0,0);
            System.out.println("#" + t + " " + answer);
        }

        br.close(); // BufferedReader 닫기
    }
    static void dfs(int month, int currentCost){
        if(currentCost>answer) { // 현재 가격이 최소값보다 크다면 그냥 return 가지치기!
            return ;
        }
        if(month>=12){ // 12달 이상이라면 최소 값 넣고 return
            answer = Math.min(answer, currentCost);
            return;
        }

        dfs(month+1, currentCost+used[month]*money[0]); //1일 이용권
        dfs(month+1, currentCost+money[1]);//1달 이용권
        dfs(month+3, currentCost+money[2]); //3달 이용권
    }

}
