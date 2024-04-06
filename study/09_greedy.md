# Greedy Algorithm

## 1. 씨름 선수

### 설명
현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을   
했습니다. 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.  
현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.  
“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은
(크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”  
N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지   
알아내는 프로그램을 작성하세요.

### 입력
첫째 줄에 지원자의 수 N(5<=N<=100,000)이 주어집니다.  
두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다.     
각 선수의 키와 몸무게는 모두 다릅니다.

### 출력
첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.

### 예시 입력 1
```
5
172 67
183 65
180 70
170 72
181 60
```
### 예시 출력 1
```
3
```

### 출력 설명
> (183, 65), (180, 70), (170, 72) 가 선발됩니다. (181, 60)은 (183, 65)보다 키와   
> 몸무게 모두 낮기 때문에 탈락이고, (172, 67)은 (180, 70) 때문에 탈락입니다

### 풀이
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body> {

    public int h, w;

    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }
    
    @Override
    public int compareTo(Body o) {
        return o.h-this.h; // 내림차순
        //  return this.h-o.h; 오름차순
    }
}

public class Main {

    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;

        for (Body ob : arr) {
            if (ob.w > max) {
                max = ob.w;
                cnt ++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new Body(h, w));
        }
        System.out.println(T.solution(arr, n));
    }
}
```

## 2. 회의실 배정

### 설명
한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들  
려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하  
면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중  
단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

### 입력
첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정  
보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.  
회의 시간은 0시부터 시작된다.  
회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.

### 출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

### 예시 입력 1
```
5
1 4
2 3
3 5
4 6
5 7
```
### 예시 출력 1
```
3
```

- 예제설명
> (2, 3), (3, 5), (5, 7)이 회의실을 이용할 수 있다.

### 예시 입력 2
```
3
3 3
1 3
2 3
```
### 예시 출력 2
```
2
```

### 풀이
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {

    public int s, e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.e == o.e) {
            return this.s-o.s;
        } else {
            return this.e-o.e;
        }
    }
}

public class Main {

    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int et = 0;
        for (Time ob : arr) {
            if (ob.s >= et) {
                cnt ++;
                et = ob.e;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int e = kb.nextInt();
            int s = kb.nextInt();
            arr.add(new Time(e, s));
        }
        System.out.println(T.solution(arr, n));
    }
}
```

## 3. 결혼식

### 설명
현수는 다음 달에 결혼을 합니다.  
현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.  
피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.  
각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.  
현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을  
수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.  
만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는  
것이고 15시 정각에는 존재하지 않는다고 가정합니다.

### 입력
첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.  
두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.  
시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로   
오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.

### 출력
첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.

### 예시 입력 1
```
5
14 18
12 15
15 20
20 30
5 14
```
### 예시 출력 1
```
2
```

### 풀이
``` java
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {

    public int time;
    public char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time ob) {
        if (this.time == ob.time) {
            return this.state - ob.state;
        } else {
            return this.time - ob.time;
        }
    }
}

public class Main {

    public int solution(ArrayList<Time> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for (Time ob : arr) {
            System.out.println(ob.time + " "+ ob.state);
            if (ob.state == 's') {
                cnt ++;
            } else {
                cnt --;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(T.solution(arr));
    }
}
```

## PriorityQueue(우선순위 큐)

- 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조 (큐에 들어가는 원소는 비교가 가능한 기준이 있어야함)
- 내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있음
- 삽입, 삭제시 시간복잡도 O(logN)
- null을 허용하지 않는다.

### 예제
``` java
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        //PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 낮은순
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 높은순

        pQ.add(1);
        pQ.offer(2);
        pQ.offer(3);

        System.out.println(pQ.poll());
    }
}
```
``` log
3
``` 

## 4. 최대수입스케쥴(PriorityQueue 응용문제)

### 설명
현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강  
연을 해 주면 M만큼의 강연료를 주기로 했다.  
각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.  
단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

### 입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과  
D(1<=D<=10,000)가 차례로 주어진다.

### 출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

### 예시 입력 1
```
6
50 2
20 1
40 2
60 3
30 3
30 1
```
### 예시 출력 1
```
150
```

### 풀이
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{

    public int money;
    public int time;

    Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.time - this.time;
    }
}

public class Main {

    static int n, max = Integer.MIN_VALUE;

    /**
     * 60 3
     * 30 3
     * 50 2
     * 40 2
     * 20 1
     * 30 1
     */
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        Collections.sort(arr);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for ( ; j < n; j++) {               
                if (arr.get(j).time < i) {
                    System.out.println(" ================ ");
                    break;
                }
                System.out.println("j = " + j);
                pQ.offer(arr.get(j).money);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) {
                max = d;
            }
        }
        System.out.println(T.solution(arr));
    }
}
```
## 다익스트라 알고리즘(Dijkstra Algorithm)
다익스트라(Dijkstra) 알고리즘은 다이나믹 프로그래밍을 활용한 대표적인 최단 경로(Shortest Path) 탐색 알고리즘이다.  
흔히 인공위성 GPS 소프트웨어 등에서 가장 많이 사용된다. 다익스트라 알고리즘은 특정한 하나의 정점에서 다른 모든 정점으로  
가는 최단 경로를 알려준다. 다만 이 때 **음의 간선을 포함할 수 없다. 현실 세계에서는 음의 간선이 존재하지 않기 떄문에   
다익스트라는 현실 세계에 사용하기 매우 적합한 알고리즘 중 하나라고 할 수 있다.

다익스트라 알고리즘이 다이나믹 프로그래밍 문제인 이유는 '최단 거리는 여러개의 최단 거리로 이루어져있기 때문이다.' 작은  
문제가 큰 문제의 부분 집합에 속해 있다고 볼 수 있다. 기본적으로 다익스트라는 하나의 최단 거리를 구할 때 그 이전까지 구했던
최단 거리 정보를 그대로 사용한다는 특징이 있다.


## 5. 다익스트라 알고리즘

### 설명
아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요.   
(경로가 없으면 Impossible를 출력한다)

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/09_01.png?raw=true)

### 입력
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보와   
거리비용이 주어진다.

### 출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

### 예시 입력 1
```
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

```
### 예시 출력 1
```
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible

```

### 풀이
``` java
import java.util.*;

class Edge2 implements Comparable<Edge2>{

    public int vex;
    public int cost;

    Edge2(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge2 ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Edge2>> graph;
    static int[] dis;

    public void solution(int v) {
        PriorityQueue<Edge2> pQ = new PriorityQueue<>();
        pQ.offer(new Edge2(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge2 tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) {
                continue;
            }
            for (Edge2 ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge2(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Edge2>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge2>());
        }
        dis=new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge2(b, c));
        }
        T.solution(1);
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : " +"impossible");
            }
        }
    }
}
```
## Union-Find(합집합 찾기)
Union-Find는 대표적인 그래프 알고리즘이다. 바로 '합집합 찾기'라는 의미를 가진 알고리즘이다.
**서로소 집합(Disjoint-Set) 알고리즘**이라고도 부른다. 구체적으로 여러 개의 노드가 존재할 떄  
두 개의 노드를 선택해서, 현재 이 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘이다.



## 6. 친구인가? (Disjoint-Set : Union&Find)

### 설명
오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각  
학생들의 친구관계를 알고 싶다.  
모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계  
가 번호로 표현된 숫자쌍이 주어진다. 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학    
생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.  
그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.  
학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램  
을 작성하세요. 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.  


### 입력
첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이  
주어지고, 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.  
마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.  

### 출력
첫 번째 줄에 “YES"또는 "NO"를 출력한다.

### 예시 입력 1
```
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8
```
### 예시 출력 1
```
NO
```

### 풀이
``` java
import java.util.*;

public class Main {

    static int[] unf;

    public static int Find(int v) {
        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n+1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Union(a, b);
        }
        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
```
## 크루스칼 알고리즘(Kruskal Algorithm)
크루스칼 알고리즘은 **가장 적은 비용으로 모든 노드를 연결**하기 위해 사용하는 알고리즘이다.  
다시 말해 최소 비용 신장 트리를 만들기 위한 대표적인 알고리즘이라고 할 수 있다. 흔히 여러 개의  
도시가 있을 때 각 도시를 이용해 연결하고자 할 때 비용을 최소한으로 하고자 할 때 실제로 적용되는 알고리즘이다.

## 7. 원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용

### 설명
원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.  
원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지  
도로는 폐쇄하려고 한다.  
아래의 그림은 그 한 예를 설명하는 그림이다.  

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/09_02.png?raw=true)

위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시  
를 연결하는 방법을 찾아낸 것이다.

### 입력
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다. 다음 E개의  
줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 도시와 B번  
도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.

### 출력
모든 도시를 연결하면서 드는 최소비용을 출려한다.


### 예시 입력 1
```
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
```
### 예시 출력 1
```
196
```

### 풀이
``` java
import java.util.*;

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static int[] unf;

    public static int Find(int v) {
        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n+1];
        ArrayList<Edge> arr = new ArrayList<Edge>();
        for (int i = 1; i < n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Edge(a, b, c));
        }
        int answer = 0;
        Collections.sort(arr);

        for (Edge ob : arr) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);
    }
}
```

## 8. 원더랜드(최소 스패닝 트리 - 프림 : PriorityQueue 활용)

### 설명
원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.  
원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지  
도로는 폐쇄하려고 한다.  
아래의 그림은 그 한 예를 설명하는 그림이다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/09_02.png?raw=true)

위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시  
를 연결하는 방법을 찾아낸 것이다.

### 입력
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다. 다음 E개의  
줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 도시와 B번  
도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.

### 출력
모든 도시를 연결하면서 드는 최소비용을 출려한다.


### 예시 입력 1
```
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
```
### 예시 출력 1
```
196
```

### 풀이
``` java
import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static int[] ch;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        ch = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b ,c));
            graph.get(b).add(new Edge(a ,c));
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));

        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int ev = tmp.vex;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for (Edge ob : graph.get(ev)) {
                    if (ch[ob.vex] == 0) {
                        pQ.offer(new Edge(ob.vex, ob.cost));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
```

- [인프런 - 자바(Java) 알고리즘](https://inf.run/SgLm1)
- [유투브 - 동빈나](https://www.youtube.com/@dongbinna)