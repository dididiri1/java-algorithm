import java.util.*;
class Main {

    public String solution(String str) {
        String answer= "";

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) { // 대문자이면.
                answer += Character.toLowerCase(c);
            } else {
                answer += Character.toUpperCase(c);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
