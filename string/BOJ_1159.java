import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<Character, Integer> map = new HashMap<>(); // HashMap을 이용하여 중복 없이 알파벳과 count 수 담기
        String result = "";
        for(int i = 0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            char na = name.charAt(0);
            map.put(na, map.getOrDefault(na, 0)+1); // getOrDefault를 사용하여 HashMap에 존재하지 않으면 default값으로
        }
        for(char na : map.keySet()){
            if(map.get(na)>=5){
                result+=String.valueOf(na);
            }
        }
        if(result.isEmpty()) System.out.println("PREDAJA");
        else System.out.println(result);


    }
}