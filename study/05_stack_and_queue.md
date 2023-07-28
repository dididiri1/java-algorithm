# 
, Queue(자료구조)

## Stack 이란?

- 먼저 들어간 자료가 나중에 나오는 LIFO 구조
- 그래프의 깊이 우선 탐색(DFS)에서 사용
- 재귀적(Recursive) 함수를 호출 할 때 사용

### 사용법
``` java
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,3,3,2,2,5,1};

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]); // 추가
        }

        System.out.println("stack.pop() = " + stack.pop()); // 마지막 삭제 
        System.out.println("stack.peek() = " + stack.peek());// 마지막 조회
        System.out.println("stack.isEmpty() = " + stack.isEmpty()); // 비어있는지 확인, true, false
    }
}

```

``` console
stack.pop() = 1
stack.peek() = 5
stack.isEmpty() = false
```


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

## 2. 괄호문자제거

### 설명
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

### 입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

### 출력
남은 문자만 출력한다.

### 예시 입력 1
```
(A(BC)D)EF(G(H)(IJ)K)LM(N)
```
### 예시 출력 1
```
EFLM
```