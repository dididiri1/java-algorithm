# Recursive, Tree, Graph(DFS, BFS 기초)

## 재귀 함수(Recursive method)
- 재귀함수는 자신을 다시 호출하는 함수.

## DFS(Depth-First Search) - 깊이 우선 검색
- 깊이 우선 탐색은 **Stack**을 이용해 구현한다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/07_01.png?raw=true)


## BFS(Breadth-First Search) - 넓이 우선 검색
- 넓이 우선 탐색은 **Queue**을 이용해 구현한다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/07_02.png?raw=true)


## 1. 재귀함수(스택프래임)

### 설명
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.

### 입력
첫 번째 줄은 정수 N(3<=N<=10)이 입렫된다.

### 출력
첫째 줄에 출력한다.

### 예시 입력 1
```
3
```
### 예시 출력 1
```
1 2 3
```

### 풀이 
``` java
public class Main {

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n-1);
            System.out.println(n+" ");
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        T.DFS(3);
    }
}
```

## 2. 이진수 출력(재귀)

### 설명
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.

단 재귀함수를 이용해서 출력해야 합니다.

### 입력
첫 번째 줄에 10진수 N(1<=N<=1000)이 입렫된다.

### 출력
첫 번째 줄에 이진수를 출력하세요.

### 예시 입력 1
```
11
```
### 예시 출력 1
```
1011
```

### 풀이
``` java
public class Main {

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n/2);
            System.out.println(n%2+" ");
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        T.DFS(11);
    }
}
```

## 3. 팩토리얼

### 설명
자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.

예를 들어 5! = 5*4*3*2*1 = 120 입니다.

### 입력
첫 번째 줄에 10진수 N(1<=N<=100)이 입렫된다.

### 출력
첫 번째 줄에 N팩토리얼 값을 출력합니다.

### 예시 입력 1
```
5
```
### 예시 출력 1
```
120
```

### 예시
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/07_03.png?raw=true)

### 풀이
``` java
public class Main {

    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        System.out.println(T.DFS(5));
    }
}
```

- 배열 vs 재귀함수
 - 재귀함수는 스택을 이용해서 배열보다 무거움

## 4. 피보나치 수열

### 설명
1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

### 입력
첫 줄에 총 항수 N(3<=N<=45)이 입렫된다.

### 출력
첫 줄에 피보나치 수열을 출력합니다.

### 예시 입력 1
```
10
```
### 예시 출력 1
```
1 1 2 3 5 8 13 21 34 55
```

### 풀이 1
``` java
import java.util.*;

public class Main {
    public int DFS(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return DFS(n-2) + DFS(n-1);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        int n = 10;
        for (int i = 1; i <= n; i++) {
            System.out.println(T.DFS(i)+ " ");
        }
    }
}
```

### 풀이 2
``` java
import java.util.*;

public class Main {

    static int[] fibo;
    
    public int DFS(int n) {

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS(n-2) + DFS(n-1);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        int n = 45;
        fibo = new int[n+1];
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo[i]+ " ");
        }
    }
}
```

## 5. 이진트리순회(DFS)

### 설명
아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/07_04.png?raw=true)

- 전위순회 출력 : 부모 - 왼쪽 - 오른쪽
  - 1 2 4 5 3 6 7
- 중위순회 출력 : 왼쪽 - 부목 오른쪽 
  - 4 2 5 1 6 3 7
- 후위순회 출력 : 왼쪽 - 오른쪽 - 부모 
  - 4 5 2 6 7 3 1

### 입력
첫 줄에 총 항수 N(3<=N<=45)이 입렫된다.

### 출력
첫 줄에 피보나치 수열을 출력합니다.

### 예시 입력 1
```
10
```
### 예시 출력 1
```
1 1 2 3 5 8 13 21 34 55
```

### 예시
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/07_05.png?raw=true)

### 풀이 1
``` java
import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node (int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main {

    Node root;

    public void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            //System.out.println(root.data); // 전위
            DFS(root.lt);
            System.out.println(root.data); // 중위
            DFS(root.rt);
            //System.out.println(root.data); // 후위
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);

        System.out.println(tree.root.toString());
    }
}
```

## 6. 부분 집합 구하기(DFS)

### 설명
자연수 N이 주어지면 1부터 N까지의 원수를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.

### 입력
첫 번째 줄에 자연수 N(1<=N<=10)이 입렫된다.

### 출력
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.

단 공집합은 출력하지 않습니다.

### 예시 입력 1
```
3
```
### 예시 출력 1
```
1 2 3
1 2
1 3
1 
2 3
2
3
```

### 풀이
```
import java.util.*;

public class Main {

    static int n;
    static int[] ch;

    public void DFS(int L) {
        if (L == n+1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i+" ");
                }
            }

            if (tmp.length() > 0) {
                System.out.println(tmp);
            }

        } else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
```

## 7. 이진트리 레벨탐색(BFS)

### 설명
아래 그림과 같은 이진트리를 레벨탐색 연습하세요.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/07_06.png?raw=true)

레벨 탐색 순회 출력 : 1 2 3 4 5 6 7


### 풀이
```
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.println(L+" : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.println(cur.data+" ");
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }

                if (cur.rt != null){
                    Q.offer(cur.rt);
                }
            }
            L++;
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
```

## 8. 송아지 찾기 1(BFS : 상태트리탐색)

### 설명
현수는 송아지를 잃어버렸다. 다행이 송아지에는 위치추적기가 달려 있다.

현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현제 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.

송아지는 움직이지 않고 제자리에 있다.

현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.

최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

### 입력
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000 까지이다.

### 출력
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재한다.

### 예시 입력 1
```
5 14
```
### 예시 출력 1
```
3
```

### 풀이
```
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                if (x == e) {
                    return  L;
                }
                for (int j = 0; j < 3; j++) {
                    int nx = x+dis[j];
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
```

## 7. 이진트리 레벨탐색(BFS)

### 설명
아래 그림과 같은 이진트리를 레벨탐색 연습하세요.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/07_06.png?raw=true)

레벨 탐색 순회 출력 : 1 2 3 4 5 6 7


### 풀이
```