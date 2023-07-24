import java.util.*;

public class Main {

    public String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str1.toCharArray()) {
            System.out.println("c = "+x);
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for (Character key : map.keySet()) {
            System.out.println("key = " + key + " "+ map.get(key));
        }

        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            } else {
                map.put(x, map.get(x)-1);
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();

        System.out.println(T.solution(a, b));
    }
}