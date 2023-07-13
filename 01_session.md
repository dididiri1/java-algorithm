# String(문자열)

## 1. 문자 찾기

### Scanner 문자 입력받기
- Scanner를 이용하여 char형 변수를 직접 입력받을 수 없다.
- char c = kb.next().charAt(0);
``` java
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

#### 예시
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