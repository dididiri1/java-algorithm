# String(문자열)

## 1. 문자 찾기

### Scanner 문자 입력받기
- Scanner를 이용하여 char형 변수를 직접 입력받을 수 없다.
- char c = kb.next().charAt(0);
``` java
import java.util.Scanner;

public class Main {

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toLowerCase();
        t = Character.toLowerCase(t);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
               answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}

``` 

### 향상된 for문 & toCharArray
- String(문자열)을 char(문자)형 배열로 바꾼다.
``` java
for (char c : str.toCharArray()) {
    if (c == t) {
        answer++;
    }
}
``` 

### 대소문자 변환
- toLowerCase() 소문자 변환
- toUpperCase() 대문자 변환
``` java
String str = "computercooler"

System.out.println("str.toLowerCase() = " + str.toLowerCase()); // computercooler
System.out.println("str.toUpperCase() = " + str.toUpperCase()); // COMPUTERCOOLER

```

## 2. 대소문자 변환

### Character.toUpperCase(), Character.isUpperCase()
- 입력 받은 인자가 영문 대문자 인지 소문자 인지 여부를 판단하여 **true** 또는 **false**값을 리턴 한다.
``` java
import java.util.Scanner;

public class Main {
    public String solution(String str) {
            String answer= "";
    
            for (char c : str.toCharArray()) {
                if (Character.isUpperCase(c)) { 
                    answer += Character.toLowerCase(c);
                } else {
                    answer += Character.toUpperCase(c);
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
}
``` 

- ASCII
``` log
대문자(A-Z) : 65 - 90
소문자(a-z) : 97 - 122
``` 

## 3. 문장 속 단어(indexOf(), substring())

### nextLine() 
- next의 경우 공백문자를 받아들일 수가 없다.
- 공백 포함 한줄 입력 받기
``` java
Scanner kb = new Scanner(System.in);
String str = kb.nextLine(); 
``` 

### substring()
- 문자열을 자르는 함수.


### indexOf() 
- 특정 문자 위치 찾기 
- indexOf() 는 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환하며 만약 찾지 못했을 경우 "-1"을 반환 함.
``` java
public String solution(String str) { // indexOf
    String answer = "";
    int m = Integer.MAX_VALUE, pos;
    
    while ((pos = str.indexOf(' ')) != -1) {
        String tmp = str.substring(0, pos);
        int len = tmp.length();
        if (len > m) {
            m = len;
            answer = tmp;
        }       
        str = str.substring(pos+1);
    }
    
    if(str.length() > m) {
        answer = str;
    }

    return answer;
}
``` 

### split() 
- 문자열을 특정 구분자를 기준으로 나누어 String 배열로 리턴해줌.
``` java
public String solution(String str) {
    String answer= "";
    String[] strArray = str.split(" ");
    int m = Integer.MAX_VALUE;
    
    for (String s : strArray) {
        int len = s.length();
        if (len > m) {
            m = len;
            answer = s;
        }
    }
    
    return answer;
}
```

## 4. 단어 뒤집기(StringBuilder이용법 또는 직접뒤집기)

### reverse() - 문자 뒤집기
- java.lang.StringBuffer 클래스의 reverse() 메소드를 사용할 수 있다.
``` java
import java.util.Scanner;

class Main {

    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String s : str) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }

        for (String x : T.solution(n, str)) {
            System.out.println(x);
        }
    }
}

``` 
### 리버스 직접 구
``` java
public ArrayList<String> solution(int n, String[] str) {
    ArrayList<String> answer = new ArrayList<>();
    
    for (String x : str) {
        char[] s = x.toCharArray();
        
        int lt = 0, rt = s.length - 1;
        while (lt < rt) {
            char tmp = s[lt];
            s[lt] = s[rt];
            s[rt] = tmp;
            lt ++;
            rt --;
        }
        String tmp = String.valueOf(s);
        answer.add(tmp);
    }
    
    return answer;
}
``` 

## 5. 특정 문자 뒤집기(toCharArray())

### Character.isAlphabetic() (이즈 알파 베틱)
- isAlphabetic()은 char 값이 문자 인지 여부를 판단 boolean 값 리턴
``` java
import java.util.Scanner;

class Main {

    public String solution(String str) {
        String answer = "";
        char[] s = str.toCharArray();
        int lt = 0, rt = s.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if(!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt ++;
                rt --;
            }
        }

        answer = String.valueOf(s);

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

#### 사용 예시
``` java
public static void main(String[] args) {

    System.out.println(Character.isAlphabetic('a'));  // true
    System.out.println(Character.isAlphabetic('!'));  // false
    System.out.println(Character.isAlphabetic('ㄱ'));  // true
    System.out.println(Character.isAlphabetic('가')); // true
    System.out.println(Character.isAlphabetic('7')); // false
    System.out.println(Character.isAlphabetic('B')); // true
    
}
```

## 6. 중복문자제거

### indexOf()
- 특정 문자나 문자열이 앞에서부터 처음 부터 발견괴는 인덱스를 반환함.
- 찾지 못햇을 경우 -1 
``` java
import java.util.Scanner;

class Main {

    public String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
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


#### 예시
``` java
public static void main(String[] args) {
    String str = "Hello world";
    
    System.out.println(str.indexOf("o")); //4
    System.out.println(str.indexOf("a")); //-1
    System.out.println(str.indexOf("w")); //6
    
}
``` 

## 7. 회문문자열

### StringBuilder reverse()
- 문자열 뒤집어서 원래 문자열과 비교
``` java
import java.util.Scanner;

class Main {
    
    public String solution(String str) {
        String answer = "YES";
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) { // equalsIgnoreCase() 사용 대소문자 구분 안함.
            answer = "NO";
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

### 좌우 대칭 Index 계산
``` java
import java.util.Scanner;

class Main {
    
    public String solution(String str) {
        String answer = "YES";

        str = str.toUpperCase();
        int len = str.length();

        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len-i-1)) {
                answer = "NO";
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
#### 결과
``` java
gooG
YES
```

## 8. 팰린드롬(replaceAll 정규식이용)
### replace와 replaceAll 차이 
- 대상 문자열을 원하는 문자 값으로 변환하는 함수이다.
- 첫번쩨 매개변수는 변환하고자 하는 대상이 될 문자열
- 두번째 매개변수는 변활할 문자 값
- replaceAll는 replace의 기능 외에 + 졍규표현식을 사용할 수 있다.
``` java
import java.util.Scanner;

class Main {

    public String solution(String str) {
        
        String answer = "YES";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        int len = str.length();

        for (int i = 0; i < len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) {
                answer = "NO";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));

    }
}
``` 

## 9. 숫자만 추출

### 1) 아스키 코드 풀이
- 0~9 는 ASCII 코드로 48~57 이다.
``` java
import java.util.Scanner;

class Main {

    public int solution(String str) {
        int answer = 0;

        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));

    }
}

``` 

### 2) Character.isDitigt(), Integer.parseInt() 사용
- isDitigt() 함수는 명시된 char 값이 숫자 인지 여부를 판단하여 **true** 또는 false 값으로 리턴 한다.
``` java
public int solution(String str) {
    int answer = 0;
    for (char x : str.toCharArray()) {
        if (Character.isDigit(x)) {
            answer += x;
        }
    }
    return Integer.valueOf(answer);
}
``` 

> 참고: valueOf() 와 parseInt() 의 차이점
> Integer.valueOf("10") 은 Integer 타입으로 반환한하고,
> Integer.parseInt("10") 은 int 타입으로 반환한다.

## 10. 가장 짧은 문자거리
> **설명**  
> 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
> 
> **입력**      
> 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
> 
> 문자열의 길이는 100을 넘지 않는다.
> 
> **출력**  
> 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


### 예시 입력 1
```
teachermode e
```
### 예시 출력 1
```
1 0 1 2 1 0 1 2 2 1 0
```
### 풀이
``` java
import java.util.Scanner;

class Main {

    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p ++;
                answer[i] = p;
            }
        }

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p ++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        for (int x : T.solution(str, c)) {
            System.out.println(x+" ");
        }

    }
}
```

## 11. 문자열 압축
### 설명
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는

문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.

단 반복횟수가 1인 경우 생략합니다.

### 입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

### 출력
첫 줄에 압축된 문자열을 출력한다.

### 예시 입력 1
```
KKHSSSSSSSE
```
### 예시 출력 1
```
K2HS7E
```  

### 예시 입력 2
```
KSTTTSEEKFKKKDJJGG
```
### 예시 출력 2
```
KST3SE2KFK3DJ2G2
```  

### 풀이
``` java
import java.util.Scanner;

class Main {

    public String solution(String s) {
        String answer = "";
        s = s + " "; // 한칸 뛰어쓰기 주의!
        int cnt = 1;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                cnt ++;
            } else {
                answer += s.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                }
                cnt = 1;
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

## 12. 암호(replace(), parseInt(string, 2))

### 설명

현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.

비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있습니다.

비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.

만약 현수가 “#*****#”으로 구성된 문자를 보냈다면 영희는 현수와 약속한 규칙대로 다음과 같이 해석합니다.

1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.

2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.

3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.

참고로 대문자들의 아스키 번호는 'A'는 65번, ‘B'는 66번, ’C'는 67번 등 차례대로 1씩 증가하여 ‘Z'는 90번입니다.

현수가 4개의 문자를 다음과 같이 신호로 보냈다면

#****###**#####**#####**##**

이 신호를 4개의 문자신호로 구분하면

#****## --> 'C'

#**#### --> 'O'

#**#### --> 'O'

#**##** --> 'L'

최종적으로 “COOL"로 해석됩니다.

현수가 보낸 신호를 해석해주는 프로그램을 작성해서 영희를 도와주세요.

### 입력
첫 줄에는 보낸 문자의 개수(10을 넘지 안습니다)가 입력된다. 다음 줄에는 문자의 개수의 일곱 배 만큼의 #또는 * 신호가 입력됩니다.

현수는 항상 대문자로 해석할 수 있는 신호를 보낸다고 가정합니다.

### 출력
영희가 해석한 문자열을 출력합니다.

### 예시 입력 1
```
4
#****###**#####**#####**##** 
```
### 예시 출력 1
```
COOL
```  

- Integer.parseInt(string, 2) -> 2진수에서 10진수로 변환
- char = (char) num -> 아스키코드 문자로변경
### 풀이
``` java
import java.util.Scanner;

class Main {

    public String solution(int n, String s) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            char c = (char) num;
            answer += c;

            System.out.println("tmp = " + tmp);
            s = s.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();

        System.out.println(T.solution(n, str));
    }
}

```