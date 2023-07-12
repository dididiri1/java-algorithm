# String(문자열)

## 1. 문자 찾기

![](https://github.com/dididiri1/data-jpa/blob/main/study/images/01_01.png?raw=true)

### Scanner 문자 입력받기
- Scanner를 이용하여 char형 변수를 직접 입력받을 수 없다.
- char c = kb.next().charAt(0);
``` java
Scanner kb = new Scanner(System.in);
String str = kb.next();
char c = kb.next().charAt(0);
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

System.out.println("str.toLowerCase() = " + str.toLowerCase());
System.out.println("str.toUpperCase() = " + str.toUpperCase());

```

## 2. 대소문자 변환

### 대소문자 구분 클래스
``` java
public String solution(String str) {
    String answer= "";
    
    for (char c : str.toCharArray()) {
        if (Character.isUpperCase(c)) { // 대문자이면.
            answer += Character.toLowerCase(c);
        } else {
            answer += Character.toUpperCase(c);
        }
    }
    
    return answer;
}
``` 

## 3. 문장 속 단어(indexOf(), substring())

### nextLine() 
- next의 경우 공백문자를 받아들일 수가 없다.
- 공백 포함 한줄 입력 받기
``` java
public static void main(String[] args) {
    Ex03 T = new Ex03();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine(); 
    System.out.println(T.solution(str));
}
``` 
### indexOf() 
- 특정 문자 위치 찾기 
- indexOf() 는 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환하며 만약 찾지 못했을 경우 "-1"을 반환 함.

### indexOf() 
- 문자열을 특정 구분자를 기준으로 나누어 배열로 리턴해줌.

``` java
String str = "it is time to study"
String[] strArray = str.split("\\s");

for (String s : strArray) {
    System.out.println("s = " + s);
}

``` 

#### 결과
``` java
s = it
s = is
s = time
s = to
s = study
```

## 4. 단어 뒤집기(StringBuilder이용법 또는 직접뒤집기)

### reverse()
- java.lang.StringBuffer 클래스의 reverse() 메소드를 사용할 수 있다.
``` java
public String solution(String str) {

    String answer = "";
    StringBuffer stringBuffer = new StringBuffer(str);
    answer = stringBuffer.reverse().toString();
    
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
class Main2 {
    
    public String solution(String str) {
        String answer = "YES";

        str = str.toUpperCase();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(len-i-1)) {
                answer = "NO";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
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