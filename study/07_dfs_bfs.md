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
```
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