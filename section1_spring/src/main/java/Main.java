import java.util.*;

class Main {

    /*
      5. 특정 문자 뒤집기

      설명
        영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
        특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

      입력
        첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

      출력
        첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

      예시 입력 1
        a#b!GE*T@S

      예시 출력 1
        S#T!EG*b@a
     */


    /*
      내 풀이
     */
//    public String solution(String str) {
//        String answer = "";
//
//        char[] s = str.toCharArray();
//        int lt = 0, rt = s.length - 1;
//
//        while (lt < rt) {
//
//            char c = s[lt];
//
//            if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
//                //System.out.println(c+"는 대문자 또는 소문자");
//
//                char tmp = s[lt];
//                s[lt] = s[rt];
//                s[rt] = tmp;
//            }
//
//            lt ++;
//            rt --;
//        }
//
//        answer = String.valueOf(s);
//
//        return answer;
//    }


    /*
       강의 풀이
     */
    public String solution(String str) {
        String answer = "";


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

    }
}
