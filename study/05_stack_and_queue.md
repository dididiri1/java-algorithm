# Stack, Queue(자료구조)

## Stack 이란?

- 먼저 들어간 자료가 나중에 나오는 LIFO 구조
- 그래프의 깊이 우선 탐색(DFS)에서 사용
- 재귀적(Recursive) 함수를 호출 할 때 사용

### 

## 1. 올바른 괄호
### 설명

괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.

(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


### 입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.


### 출력
첫 번째 줄에 YES, NO를 출력한다.


### 예시 입력 1
```
(()(()))(()
```
### 예시 출력 1
```
NO
```

### 풀이
``` java
import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "YES";

        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
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
```