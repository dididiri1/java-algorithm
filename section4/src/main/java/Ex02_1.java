import java.util.HashMap;
import java.util.Scanner;

public class Ex02_1 {

    public String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for (char x : str1.toCharArray()) {
            am.put(x, am.getOrDefault(x, 0)+1);
        }

        for (char x : str2.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0)+1);
        }

        if (!am.equals(bm)) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex02_1 T = new Ex02_1();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a, b));
    }
}
