# DFS, BFS 활용

## 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)

### 설명
N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면
”NO"를 출력하는 프로그램을 작성하세요.

둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의
집합이 되어 합니다.

예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이
16으로 같은 경우가 존재하는 것을 알 수 있다.

### 입력
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.

### 출력
첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.

### 예시 입력 1
```
6
1 3 5 6 7 10
```
### 예시 출력 1
```
YES
```

### 문제 분석
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_01.png?raw=true)

### 풀이 
``` java
import java.util.Scanner;

public class Main {

    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {
        if (flag) {
            return;
        }

        if (sum > total / 2) {
            return;
        }

        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
```

## 2. 바둑이 승차(DFS)

### 설명
철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태
울수가 없다. 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운
무게를 구하는 프로그램을 작성하세요.

### 입력
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
둘째 줄부터 N마리 바둑이의 무게가 주어진다

### 출력
첫 번째 줄에 가장 무거운 무게를 출력한다.

### 예시 입력 1
```
259 5
81
58
42
33
61
```
### 예시 출력 1
```
242
```

### 풀이
``` java
import java.util.Scanner;

public class Main {

    static int answer = Integer.MIN_VALUE, n, c;

    public void DFS(int L, int sum, int[] arr) {
        if (sum > c) {
            return;
        }
        
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
```

## 3. 최대점수 구하기(DFS)

### 설명
이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를
풀려고 합니다. 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다. 
제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다. (해당문제는
해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

### 입력
첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.


### 출력
첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다

### 예시 입력 1
```
5 20
10 5
25 12
15 8
6 3
7 4
```
### 예시 출력 1
```
41
```

### 풀이
``` java
import java.util.Scanner;

public class Main {

    static int answer = Integer.MIN_VALUE, n, m;

    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if (time > m) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
            DFS(L+1, sum, time,ps, pt);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
            b[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
```

## 4. 중복순열 구하기

### 설명
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
하는 방법을 모두 출력합니다.

### 입력
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.

### 출력
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

### 예시 입력 1
```
3 2
```
### 예시 출력 1
```
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
```

### 풀이
``` java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] pm;
    static int n, m;

    public void DFS(int L) {
        if (L == m) {
            System.out.println(Arrays.toString(pm));
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}
```

## 5. 동전교환

### 설명
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.

### 입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종
류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
각 동전의 종류는 100원을 넘지 않는다.

### 출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

### 예시 입력 1
```
3
1 2 5
15
```
### 예시 출력 1
```
3
```

### 풀이
``` java
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {
        if (sum > m) {
            return;
        }

        if (L >= answer) {
            return;
        }

        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
```

## 6. 순열 구하기

### 설명
10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

### 입력
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.

### 출력
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

### 예시 입력 1
```
3 2
3 6 9
```
### 예시 출력 1
```
3 6
3 9
6 3
6 9
9 3
9 6
```

### 풀이
``` java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr, pm, ch;
    static int n, m;
    public void DFS(int L) {
        if (L == m) {
            System.out.println(Arrays.toString(pm));
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        T.DFS(0);
    }
}
```

## 7. 조합의 경우수(메모이제이션)

### 설명
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_02.png?raw=true)

### 입력
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.

### 출력
첫째 줄에 조합수를 출력합니다.

### 문제 분석
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_03.png?raw=true)

- r = 0 또는 n = r 같으면 리턴 값은 1이다.
- DFS(3,3)은 3개중에서 3개를 뽑는 경우는 1가지 경우 밖에 없음.
- DFS(1,0)은 r이 0이기 떄문에 경우의 수는 1이다.

### 예시 입력 1
```
5 3
```
### 예시 출력 1
```
10
```

### 예시 입력 2
```
33 19
```
### 예시 출력 2
```
818809200
```

### 풀이 1
``` java
import java.util.Scanner;

public class Main {

    public int DFS(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else {
            return DFS(n - 1, n -r) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(T.DFS(n, r));

    }
}
```

### 풀이 2
``` java
import java.util.Scanner;

public class Main {

    int[][] dy = new int[35][35];
    public int DFS(int n, int r) {

        if(dy[n][r] > 0) {
            return dy[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n - 1, n -r) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
```

## 8. 수열 추측하기

### 설명
가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼  
의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다. 예를 들어 N이 4 이고 가장 윗 줄에   
3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.

                                3  1  2  4
                                  4  3  6
                                   7  9
                                    16

N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.   
단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.

### 입력
첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다. N은 가장 윗줄에 있는 숫자의 개수를 의미하며   
F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.

### 출력
첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.   
답이 존재 하지 않는 경우는 입력으로 주어지지 않는다.

### 예시 입력 1
```
4 16
```
### 예시 출력 1
```
3 1 2 4
```
  
### 문제 분석
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_04.png?raw=true)


### 풀이 
``` java
import java.util.Scanner;

public class Main {

    static int[] b, p, ch;

    static int n, f;

    boolean flag = false;

    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
        }
    }
    public void DFS(int L, int sum) {
        if (flag) {
            return;
        }

        if (L == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.println(x + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n-1, i);
        }
        T.DFS(0, 0);
    }
}
```

## 9. 조합 구하기

### 설명
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그
램을 작성하세요.

### 입력
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.


### 출력
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

### 예시 입력 1
```
4 2
```
### 예시 출력 1
```
1 2
1 3
1 4
2 3
2 4
3 4
```

### 풀이
``` java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] combi;

    static int n, m;

    public void DFS(int L, int s) {
        if (L == m) {
            System.out.println(Arrays.toString(combi));
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        T.DFS(0, 1);
    }
}
```

## 10. 미로탐색(DFS)

### 설명
7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.   
출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.   
격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_05.png?raw=true)

위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.

### 입력
7*7 격자판의 정보가 주어집니다.

### 출력
첫 번째 줄에 경로의 가지수를 출력한다.

### 예시 입력 1
```
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
```
### 예시 출력 1
```
8
```

### 풀이
``` java
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            answer ++;
        } else {
            // 현재 칸(x,y)에서 네가지 방향을 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동 가능한 범위
                // nx>= 1 && nx<=7 && ny>=1 && ny<=7 : 경계선 안쪽
                // board[nx][ny] == 0 : 통로
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { 
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        board[1][1] = 1;
        T.DFS(1, 1);
        System.out.println(answer);
    }
}
```

## 11. 미로탐색(BFS)

### 설명
7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.   
출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.   
격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_06.png?raw=true)

위와 같은 경로가 최단 경로의 길이는 12이다.

### 입력
7*7 격자판의 정보가 주어집니다.

### 출력
첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.

### 예시 입력 1
```
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0
```
### 예시 출력 1
```
12
```

### 풀이
``` java
public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

```

``` java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y] = 1;
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        T.BFS(1, 1);
        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }
}
```

## 12. 토마토(BFS 활용)

### 설명

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_07.png?raw=true)


### 입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수, N  
은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.  
둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄  
에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토  
의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수  
-1은 토마토가 들어있지 않은 칸을 나타낸다.

### 출력
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든  
토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을  
출력해야 한다.

### 예시 입력 1
```
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
```
### 예시 출력 1
```
4
```

### 풀이
``` java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m, answer = 0;

    static Queue<Point> Q = new LinkedList<>();

    public void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        m = kb.nextInt();
        n = kb.nextInt();

        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = kb.nextInt();
                if (board[i][j] == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }
}
```

## 13. 섬나라 아일랜드(DFS)

### 설명
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다. 각 섬은 1로 표시되어 상하좌우와  
대각선으로 연결되어 있으며, 0은 바다입니다. 섬나라 아일랜드에 몇 개의 섬이 있는지  
구하는 프로그램을 작성하세요.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_08.png?raw=true)

만약 위와 같다면 섬의 개수는 5개입니다.

### 입력
첫 번째 줄에 섬의 개수를 출력한다.

### 출력
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든  
토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을  
출력해야 한다.

### 예시 입력 1
```
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

```
### 예시 출력 1
```
5
```

### 풀이
``` java
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0, n;

    public void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n  && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer ++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
```

## 14. 섬나라 아일랜드(BFS)

### 설명
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다. 각 섬은 1로 표시되어 상하좌우와  
대각선으로 연결되어 있으며, 0은 바다입니다. 섬나라 아일랜드에 몇 개의 섬이 있는지  
구하는 프로그램을 작성하세요.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_08.png?raw=true)

만약 위와 같다면 섬의 개수는 5개입니다.

### 입력
첫 번째 줄에 섬의 개수를 출력한다.

### 출력
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든  
토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을  
출력해야 한다.

### 예시 입력 1
```
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

```
### 예시 출력 1
```
5
```

### 풀이
``` java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0, n;
    Queue<Point> queue = new LinkedList<>();

    public void BFS(int x, int y, int[][] board) {
        queue.add(new Point(x , y));
        while (!queue.isEmpty()) {
            Point pos = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n  && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.add(new Point(nx , ny));
                }
            }
        }

    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer ++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
```

## 15. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)


### 설명
N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다. 각  
격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)  
로 표현됩니다. 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.  
도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재  
하는 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.  
집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.  
예를 들어, 도시의 지도가 아래와 같다면  

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/08_09.png?raw=true)

(1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.  
최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다. 도시 시장은  
도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.  
시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는  
M개의 피자집을 선택하려고 합니다.  
도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.  

### 입력
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.  
둘째 줄부터 도시 정보가 입력된다.

### 출력
첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.

### 예시 입력 1
```
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
```
### 예시 출력 1
```
6
```

### 풀이
``` java
import java.util.*;

public class Main {

    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs;

    public void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h: hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) {
                    hs.add(new Point(i, j));
                } else if (tmp == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }
        len = pz.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
```












