import java.util.HashMap;
import java.util.Scanner;

public class Ex02 {

    public String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            } else{
                map.put(x, map.get(x)-1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex02 T = new Ex02();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a, b));
    }
}
