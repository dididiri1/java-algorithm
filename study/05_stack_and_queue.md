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

### 풀이
```
import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
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

## 3. 크레인 인형뽑기(카카오)
### 설명

게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.

죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/05_01.png?raw=true)

게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.

(위 그림은 5 x 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.

모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.

게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데,

이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.

다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/05_02.png?raw=true)

만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.

위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/05_03.png?raw=true)

크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.

또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)

게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,

크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.


### 입력
첫 줄에 자연수 N(5<=N<=30)이 주어집니다.

두 번째 줄부터 N*N board 배열이 주어집니다.

board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.

0은 빈 칸을 나타냅니다.

1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.

board배열이 끝난 다음줄에 moves 배열의 길이 M이 주어집니다.

마지막 줄에는 moves 배열이 주어집니다.

moves 배열의 크기는 1 이상 1,000 이하입니다.

moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

### 출력
첫 줄에 터트려져 사라진 인형의 개수를 출력합니다.


### 예시 입력 1
```
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4
```
### 예시 출력 1
```
4
```

## 풀이 
```
import java.util.*;

public class Ex03 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos-1] != 0) {
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if (!stack.isEmpty() && stack.peek() == tmp) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(tmp);
                    }

                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03 T = new Ex03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(T.solution(board, moves));
    }
}
```

## 4. 후위식 연산(postfix)

### 설명
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.

만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


### 입력
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.

식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

### 출력
연산한 결과를 출력합니다.


### 예시 입력 1
```
352+*9-
```
### 예시 출력 1
```
12
```

### 플이
``` java
 import java.util.*;

public class Main {

    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
                // stack.push(Character.getNumericValue(x)); char를 int로 변경
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (x == '+') {
                    stack.push(lt+rt);
                } else if (x == '-') {
                    stack.push(lt-rt);
                } else if (x == '*') {
                    stack.push(lt*rt);
                } else if (x == '/') {
                    stack.push(lt/rt);
                }
            }
        }

        answer = stack.get(0);

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

## 5. 쇠막대기
### 설명

여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,

레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.

• 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되,

끝점은 겹치지 않도록 놓는다.

• 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.

• 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.

아래 그림은 위 조건을 만족하는 예를 보여준다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치,

수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/05_05.png?raw=true)

이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.

1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반 드시 레이저를 표현한다.

2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.

위 예의 괄호 표현은 그림 위에 주어져 있다.

쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘려지고,

이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘려진다.

쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.


### 입력
한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.


### 출력
잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.


### 예시 입력 1

()(((()())(())()))(())
예시 출력 1

17
### 예시 입력 2
```
(((()(()()))(())()))(()())
```
### 예시 출력 2
```
24
```

### 풀이
``` java
import java.util.*;

public class Main {

    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
                if (str.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer ++;
                }
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
```