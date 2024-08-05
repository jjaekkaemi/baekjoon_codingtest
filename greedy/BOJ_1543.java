import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine(); // 문서 받기
        String word = sc.nextLine(); // 단어 받기

        int wordLen = word.length(); // 단어의 길이
        int docLen = doc.length(); // 문서의 길이
        int idx = 0; // 문서에서 단어를 찾아나갈 때 사용하는 index
        int answer = 0 ;
        while(idx+wordLen<=docLen){ // 길이 체크
            if(doc.substring(idx, idx+wordLen).equals(word)){ // 단어를 substring으로 잘라 체크
                answer++;
                idx+=wordLen; // 일치할 경우 idx를 word 길이 만큼 더하기
            }
            else {
                idx++;
            }
        }
        System.out.println(answer);
    }
}
