# 정하형 (202530128)
# java-1

# (11월 20일) 강의



### 컴포넌트의 절대 위치와 크기 설정
- 배치 관리자가 없는 컨테이너에 컴포넌트를 삽입할때
    - 프로그램에서 컴포넌트의 절대 크기와 위치설정
    - 컴포넌트들이 서로 겹치게 할수 없음

- 컴포넌트의 크기와 위치 설정 메서드
    - vodi setSize(int width, int height) // 컴포넌트 크기 설정
    - void setLocation(int x,int y) // 컴포넌트 위치 설정
    - void setBounds(int x,int y , int width, int height) // 위치와 크기 동시설정
- 예) 버튼을 100x 40 크기로 하고 , JPanel 의 (50,50) 위치에 배치
```java
JPanel p = new  JPanel();
p.setLayout(null);
JButton clickButton = new JButton("Click");
clickButton.setSize(100,40);
clickButton.setLocations()
```

### 배치 관리자 없는 컨테이너
- 배치관리자가 없는 컨테이너가 필요한 경우
- 응용 프로그램에서 직접 컴포넌트의 크기와 위치를 결정하고자 하는 경우 
    - 컴포넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
    - 게임 프로그램과 같이 시간이나 마우스/키보드

```java
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex85GridLayoutEx extends JFrame {

    Ex85GridLayoutEx() {
        super("GridLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();

        // contentPane.setLayout(new GridLayout(1,10));

        contentPane.setLayout(null);

        for(int i  = 0 ; i < 10 ; i++) {
            String text =Integer.toString(i);
            JButton button = new JButton(text);
            contentPane.add(button);
        }
        
        setSize(300,150); // 프레임 크기 300x150 설정
        setVisible(true); // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new Ex85GridLayoutEx();
    }
}

```

### 그리드 레이아웃

```java
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex85GridLayoutEx extends JFrame {

    Ex85GridLayoutEx() {
        super("GridLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();

        contentPane.setLayout(new GridLayout(1,10));

        for(int i  = 0 ; i < 10 ; i++) {
            String text =Integer.toString(i);
            JButton button = new JButton(text);
            contentPane.add(button);
        }
        
        setSize(300,150); // 프레임 크기 300x150 설정
        setVisible(true); // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new Ex85GridLayoutEx();
    }
}

```

### GridLayout 배치 관리자
- 배치 방법
    - 컨테이너 공간을 동일한 사각형 격로 분할하고 각 셀에 컴포넌트 하나씩배치

### borderLayout

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class Ex82ContentPaneEx  extends JFrame{
    Ex82ContentPaneEx() {
        setTitle("ContentPane 과 JFrame 예제"); // 프레임의 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane(); // 컨텐트 팬 알아내기
        contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        contentPane.setLayout(new BorderLayout(10,20)); // 컨텐트팬에 FlowLayout
                                                    //배치 관리자 달기

        contentPane.add(new JButton("OK"),BorderLayout.CENTER); // OK 버튼 달기
        contentPane.add(new JButton("Cancel"),BorderLayout.EAST); // Cancel 버튼 달기
        contentPane.add(new JButton("Ignore"),BorderLayout.SOUTH); // Ignore 버튼 달기
        contentPane.add(new JButton("OK"),BorderLayout.WEST);
        contentPane.add(new JButton("OK"),BorderLayout.NORTH);

        setSize(300,150); // 프레임 크기 300x150 설정
        setVisible(true); // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new Ex82ContentPaneEx();
    }
}
```

### 컨테이너에 새로운 배치 관리자 설정
- 컨테이너에 새로운 배치관리자 설정
    - setLayout(LayoutManager lm) 메서드 호출 : lm 을 새로운 배치 관리자로 설정

### 사례
- Jpanel 컨테이너에 BorderLayout 배치관리자를 설정하는 예
```java
JPanel p = new JPanel();
p.setLayout(new BorderLayout()); // JPanel 에 BorderLayout 설정
```
- 컨텐트팬의 배치관리자를 FlowLayout 배치 관리자로 설정
```java
Container c = frame.getConentPane() // 프레임의 컨텐트 팬 알아내기
c.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout 설정
```
- 오류
```java
c.setLayout(FlowLayout);
```

### 배치 관리자 대표 유형 4가지
- FlowLayout 배치관리자
    - 왼쪽에서 오른쪽으로 배치
    - 공간이 없으면 아래로
- BorderLayout 배치관리자
    - 컨테이너 공간을 동 서 남 북 중앙의 5개 영역으로 나눔
    - 지정한 영역에서 컴포넌트 배치
- GridLayout 배치 관리자
    - 설정한 동일한 크기의 2차원 격자로 나눔
    - 좌에서 우로, 다시 위에서 아래로 배치
- CardLayout 
    - 카드를 쌓아 놓은 듯이 컴포넌트를 포개어 배치

### swing 응용프로그램 종료
응용프로그램 내에서 스스로 종료하는 방법
- 언제 어디서나 무조건 종료

- 프레임의 오른쪽 상단의 종료버튼이 클릭되면 어떤 일이 일어나는가?
- 프레임이 보이지 않게 되지만 응용프로그램이 종료한 것 아님
- setVisible(true) 를 호출하면 보이게 되고 이전 처럼 작동함

### 컨테이너 배치, 배치관리자 개념
- 컨테이너의 배치관리자
    - 컨테이너마다 하나의 배치 관리자가 존재
    - 컨테이너에 부착되는 컴포넌트의 위치와 크기 결정
    - 컨테이너의 크기가 변경되면, 컴포넌트의 위치와 크기 재결정


### 1.5 이후

```java
import javax.swing.*;
import java.awt.*;

public class Ex82ContentPaneEx  extends JFrame{
    Ex82ContentPaneEx() {
        setTitle("ContentPane 과 JFrame 예제"); // 프레임의 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // 컨텐트 팬 알아내기
        getContentPane().setBackground(Color.ORANGE); // 오렌지색 배경 설정
        getContentPane().setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout
                                                    //배치 관리자 달기

        add(new JButton("OK")); // OK 버튼 달기
        add(new JButton("Cancel")); // Cancel 버튼 달기
        add(new JButton("Ignore")); // Ignore 버튼 달기

        setSize(300,150); // 프레임 크기 300x150 설정
        setVisible(true); // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new Ex82ContentPaneEx();
    }
}

```


### 1.5 이전

```java
import javax.swing.*;
import java.awt.*;

public class Ex82ContentPaneEx  extends JFrame{
    Ex82ContentPaneEx() {
        setTitle("ContentPane 과 JFrame 예제"); // 프레임의 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane(); // 컨텐트 팬 알아내기
        contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        contentPane.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout
                                                    //배치 관리자 달기

        contentPane.add(new JButton("OK")); // OK 버튼 달기
        contentPane.add(new JButton("Cancel")); // Cancel 버튼 달기
        contentPane.add(new JButton("Ignore")); // Ignore 버튼 달기

        setSize(300,150); // 프레임 크기 300x150 설정
        setVisible(true); // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new Ex82ContentPaneEx();
    }
}

```


# (11월 13일) 강의

### 프레임 만들기, JFrame 클래스 상속
- 스윙 프레임
    - JFrame 클래스를 상속받은 클래스 작성
    - 프레임의 크기 반드시 지정 : setSize() 호출
    - 프레임을 화면에 출력하느 코드 반드시 필요 : setVisible(true) 호출

```java
import javax.swing.JFrame;

public class Ex81MyFrame  extends JFrame{

    public Ex81MyFrame() {
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
    // Ex81MyFrame frame = new Ex81MyFrame();
    javax.swing.SwingUtilities.invokeLater(() -> {
            new Ex81MyFrame();
        });
    }
}

```

### Swing GUI 프로그램 만들기
- 스윙 GUI 프로그램을 만드는 과정
    - 스윙 프레임 만들기
    - main() 메서드 작성

### 컨테이너와 컴포넌트
- 컨테이너
    - 다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트 : java.awt.Container를 상속받음
    - 다른 컨테이너에 포함될 수 있음
    - AWT 컨테이너 : Panel,Fraem,Applet,Dialog,Window
    - Swing 컨테이너 : JPanel , JFrame, JApplet, JDialog, JWindow
- 컴포넌트  
    - 컨테이너에 포함되어야 화면에 출력될 수있는 GUI 객체
    - 다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
    - 모든 GUI 컴포넌트가 상속받는 클래스 : java.awt.Component
    - 스윙 컴포넌트가 상속받는 클래스 : javax.swing.Jcomponent
- 최상위 컨테이너
    - 다른 컨테이너에 포함되지 않고도 화면에 출력되며, 독립적으로 존재 가능한 컨테이너 
    - 스스로 화면에 자신을 출력하는 컨테이너 : JFrame,JDialog,JApplet


### 자바의 GUI

[ Swing 패키지 ]
- AWT 기술을 기반으로 작성된 자바 라이브러리
- 모든 AWT 기능 + 추가된 풍부하고 화려한 고급 컴포넌트
- AWT 컴포넌트를 모두 스윙으로 재작성
- AWT 컴포넌트 이름 앞에 J 자를 덧붙임
- 순수 자바 언어로 구현
- 스윙 컴포넌트는 경량 컴포넌트 
- 스윙 컴포넌트는 운영체제의 도움을 받지 않고 ,직접 그리기 때문에 운영체제 부담주지 않음
- 현재 자바의 GUI 표준으로 사용됨


### 스트링 활용
- 스트링 비교,equals()와 compareTo()
    - ->스트링 비교에 == 연산자 절대 사용 금지
    - equlas() : 스트링이 같으면 true, 아니면 false 리턴
```java
String java = "java";
if(java.equals("java")) // true
```

- int compareTo(String anotherString)
    - 문자열이 같으면 0 리턴
    - 이 문자열이 anotherString 보다 먼저 나오면 음수 리턴
    - 이 문자열이 anotherString 보다 나중에 나오면 양수 리턴

```java
String java = "java";
String cpp = "C++";
int res = java.compareTo(cpp);
if(res == 0) System.out.println("the same");
else if(res < 0) System.out.println(java + " < " + cpp);
else System.out.println(java + " > " + cpp);
```

### 스트링 객체의 주요 특징
- 스트링 객체는 수정 불가능 
    - 리터럴 스트링이든 new String()을 생성했든 객체의 문자열 수정 불가능
    - 스트링 비교 : 두 스트링을 비교할 때 반드시 equals() 를 사용하여야 함
    - -> equals는 내용을 비교하기 때문

### 스트링  리터럴 과 new String()

- 스트링 리터럴
    - 자바 가상 기계 내부에서 리터럴 테이블에 저장되고 관리됨
    - 응용프로그램에서  공유됨
    - 스트링 리터럴 사례) String s = "Hello";

- new String() 으로 생성된 스트링
    - 스트링 객체는 힙에 생성
    - 스트링은 공유되지 않음


### String 의 생성과 특징
- String 클래스는 문자열을 나타냄
- 스트링 리터럴은 String 객체로 처리됨
- 스트링 객체의 생성 사례
```java
String str1 = "abcd";

char data[] = {'a','b','c','d'};
String str2 = new String(data);
Strin gstr3 = new String("abcd"); // str2 와 str3은 모두 "abcd" 스트링
```

### 박싱과 언박싱
- 박싱 : 기본 타입의 값을 Wrapper 객체로 변환하는 것.
- 언박싱 : Wrapper 객체에 들어 있는 기본 타입의 값을 빼내는 것, 박싱의 반대

```java
Integer ten = 10; // 자동 박싱
int n = ten; // 자동 언박싱
```

### Wrapper 객체 생성
- 기본 타입의 값으로 Wrapper 객체 생성
```java
Integer i = Integer.valueOf(10);
Character c = Character.valueOf('C');
Double f = Double.valueOf(3.14);
Boolean b = Boolean.valueOf(true);
```

- 문자열로 Wrapper 객체 생성
```java
Integer i = Integer.valueOf("10");
Double d = Double.valueOf("3.14");
Boolean b = Boolean.valueOf("false");
```

- Float 객체는 double 타입의 값으로 생성가능

### wrapper 활용

### Wrapper 클래스
- Wrapper 클래스 : 자바의 기본 타입을 클래스화 한 8개 클래스 통칭
- 용도 : 객체만 사용할 수 있는 컬렉션 등에 기본 타입의 값을 사용하기 위해 Wrapper 객체로 만들어 사용

### 객체 비교 == 와 equals() 메서드
- == 연산자 : 객체 레퍼런스 비교

```java
public class Ex63EqualsEx {

    public static void main(String[] args) {
        Point3 a = new Point3(2,3);
        Point3 b = new Point3(2,3);
        Point3 c = new Point3(3,4);
        if(a == b) {
            System.out.println("a==b");
        } 

        if(a.equals(b)) {
            System.out.println("a is equal to b");
        }

        if(a.equals(c)) {
            System.out.println("a is eqaul to c");
        }
    }
}

```

- boolean equals(Object obj)
    - 두객체의 내용물 비교
    - 객체의 내용물을 비교하기 위해 클래스의 멤버로 작성



# 테크페어 인증샷
![Image](https://github.com/user-attachments/assets/d4b857ff-a3be-478f-a1fb-8671edbae4f8)

# (11월 6일) 강의 

### 패키지 개념과 필요성
동일한 이름의 클래스가 존재할 가능성 있음. 
개발자가 서로 다른 디렉터리로 코드 관리하여 해결

### 자바의 패키지와 모듈이란?
- 패키지 
    - 클래스 파일들을 묶어 놓은 디렉터리
    - 하나의 응용프로그램은 한 개 이상의 패키지로 작성
    - 패키지는 jar 파일로 압축할 수 있음

- 모듈 
    - 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
    - 하나의 모듈을 하나의 .jmod 파일에 저장

### 자바 API의 모듈 파일들
- 자바 jdk 에 제공되는 모듈 파일들
    - 포멧이 zip 이며 , 확장자는 .jmod 입니다.
    - jmod 명령을 이용하여 모듈 파일에 들어 있는 패키지를 

### 패키지 사용하기, import 문
- 다른 패키지에 작성된 클래스 사용

```java

import java.util.Scanner;

Scanner scanner = new Scanner();

```

- 패키지 전체를 import 
    - import 패키지.*

```java
import java.util.*;

Scanner scanner = new Scanner(System.in);
```

### 패키지 만들기
- 패키지 선언
    - 소스 파일의 맨 앞에 컴파일 후 저장될 패키지 지정

```java
package UI;

public class Tools {

}

package Graphic; 

import UI.Tools; // UI.Tools 클래스이 경로명 임포트

...

```

### 디폴트 패키지
- package 선언문이 없는 자바 소스 파일의 경우
    - 컴파일러는 클래스나 인터페이스


### 패키지의 운영방법
- 패키지 이름은 도메인 기반으로 시작
- 기능 /역할별로 하위 패키지를 구분 
- 디렉토리에  구조와 package 선언을 정확히 일치해야 합니다.
- import 는 필요한 만큼만, * 전체 import 는 피하는 것이 좋다.

### 모듈 개념
- 패키지와 이미지등의 리소스를 담은 컨테이너

### 자바 플랫폼의 모듈화
- 자바 플랫폼
    - 자바의 개발 환경과 자바의 실행 환경을 지칭. java SE 포함.
    - 자바 API의 모든 클래스가 여러개의 모듈로 재구성됨
    - 모듈 파일은 JDK의 jmods 디렉터리에 저장

### 자바 모듈화의 
- 자바 컴포넌트들을 필요에 따라 조립하여 사용하기 위함
- 컴퓨터 시스템의 불필요한 부담 감소

### Object 클래스
- 모든 자바 클래스는 반드시 Object를 상속받도록 자동 컴파일
- 모든 클래스의 슈퍼클래스
- 모든 클래스가 상속받는 공통 메서드 포함

### 객체 속성

- hashCode() 메서드
    - 객체의 해시 코드 값을 리턴하며, 객체마다 다름
- getClass() 메서드 
    - 객체의 클래스 정보를 담은 Class 객체 리턴
    - Class 객체의 getName() 메서드는 객체의 클래스 이름 리턴
- toString() 메서드
    - 객체를 문자열로 리턴  

# (10월 31일) 강의

그렇다면 왜 p = s 로 업캐스팅을 한 걸까?

```java
Person[] people = new Person[3];
people[0] = new Student("홍길동");
people[1] = new Student("김영희");
people[2] = new Student("이순신");
```

- 공통된 타입으로 여러 자식 클래스르 한 배열에 담을 수 있습니다.
- 하지만 접근은 Person 수준에서만 가능 합니다.

### 다운 캐스팅
- 업 캐스팅 된 것을 다시 원래대로 되돌리는 것
- 반드시 명시적 타입 변환지정

```java
public class DowncastingEx {
    public static void main() {
        Person p = new Student("이재문"); // 업캐스팅
        Student s;

        s = (Student)p; // 다운캐스팅

        System.out.println(s.name); // 오류없음
        s.grade = "A"; // 오류없음
    }
}
```
---
### 업 캐스팅 레퍼런스로 객체 구별
- 업캐스팅 된 레퍼런스로는 객체의 실제 타입을 구분하기 어려움
- 슈퍼 클래스는 여러 서브 클래스에 상속되기 때문
---
### instanceof 연산자 사용
- 레퍼런스가 가리키는 객체의 타입 식별 : 연산의 결과는 true/false 의 불린값으로 반환
- 연산자 사용 사례

```java
Person p = new Professor();
if (p instanceof Person) // true
if (p instanceof Studnet) // false Studnet 를 상속받지 ㅇ낳기 떄문
if (p instanceof Researcher) // true
if (p instanceof Professor) // true
```

### instanceof 연산자 활용
```java
class Person {}
class Studnet extends Person{}
class Researcher extends Person {}
class Professor extends Researcher {}

public class Ex53InstanceofEx {
    
    static void print(Person p) {
        if(p instanceof Person) {
            System.out.println("Person");
        }
        if(p instanceof Studnet) {
            System.out.println("Studnet");
        }
        if(p instanceof Researcher) {
            System.out.println("Researcher");
        }
        if(p instanceof Professor) {
            System.out.println("Professor");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("new Student() -> ");
        print(new Studnet());
        System.out.println("new Researcher() -> ");
        print(new Researcher());
        System.out.println("new Professer() ->");
        print(new Professor());
    }
}
```
---
### 메소드 오버라이딩

- 오버라이딩의 조건 -> 슈퍼 클래스 메소드의 원형(메서드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성
---
### 서브 클래스 객체와 오버라이딩된 메서드 호출
---
### 오버라이딩의 목적, 다형성 실현
- 오버라이딩으로 다형성실현
- 하나의 인터페이스 (같은이름)에 서로 다른 구현
- 슈퍼 클래스의 메서드를 서브 클래스에서 각각 목적에 맞게 다르게 구현

```java
class Shape {
    public void draw() {
        System.out.println("Shape");
    }
}

class Line extends Shape {
    public void darw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("circle");
    }
}

public class Ex54 {
    
    static void paint(Shape p) {
        p.draw();
    }

    public static void main(String[] args) {
        Line line = new Line();
        paint(line);

        paint(new Shape());
        paint(new Line());
        paint(new Rect());
        paint(new Circle());
    }
}
```

---
### 동적 바인딩 - 오버라이딩된 메서드 호출

- SuperObject 하나만 있는 응용프로그램의 경우 혹은 상속받은 경우 모두 동적바인딩을 한다.

- 오버라이딩 메서드가 항상 호출된다.


---

### 추상 클래스
- 추상 메서드 
- abstract 로 선언 된 메서드 , 메서드의 코드는 없고 원형만 선언

- 추상 클래스 
- 추상 메서드를 가지며, abstract 로 선언된 클래스
- 추상 메서드 없이, abstract 로 선언한 클래스

### 추상 클래스 상속과 구현
- 추상 클래스 상속 
- 추상 크래스를 상속받으면 추상 클래스가 됨
- 서브 클래스도 abstract 로 선언해야 됨

- 추상 클래스 구현 
- 서브 클래스에서 슈퍼 클래스의추상 메서드 구현
- 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님

```java
abstract class A { // 추상 클래스
    abstract public int add(int x,int y); // 추상 메서드
}

abstract class B extends A { // 추상 클래스
    public void show() {
        System.out.println("B");
    }
}

A a = new A();
B b = new B();
```

```java
class C extends A { // 추상 클래스 구현. C는 정상 클래스
    public int add(int x,int y ) {return x+y;} // 추상 메서드 구현. 오버라이딩
    public void show() {
        System.out.println("C");
    }
}

C c = new C(); // 정상
```

### 추상 클래스의 목적

- 추상 클래스의 목적
- 상속을 위한 슈퍼 클래스로 활용하는것
- 다형성 실현

### 자바의 인터페이스
- 소프트웨어를 규격화된 모듈로 만들고 안터페이스가 맞는 모듈을 조립하듯이 응용프로그램 작성하기 위해사용

- 메서드들이 선언되는 추상형
- interface 키워드로 선언
- 자바 7 상수와 추상 메서드로만 구성

### 인터페이스 구성 요소들의 특징
- default 메서드 
- 인터페이스에 코드가 작성된 메서드
- 인터페이스를 구현하는 클래스에 자동상속
- public 접근 지정만 허용.

- private 메서드 
- 인터페이스 내에 메서드 코드가 작성되어야 함
- 인터페이스 내에 있는 다른 메서드에 의해서 호출 가능
- static 메서드 : public, private 모두 지정 가능. 생략 하면 public

### 자바 인터페이스 특징

- 인터페이스의 객체  생성 불가
```java
new PhoneInterface(); // 오류 인터페이스 PhoneInterface 객체 생성 불가
```
- 인터페이스 타입의 레퍼런스 변수 선언 가능
```java
PhoneInterface galaxy; // galxy 는 인터페이스에 대한 레퍼런스 변수
```

### 인터페이스 상속

- 상속 가능

- 다중 상속 허용

### 인터페이스의 구현
- implements 키워드 사용
- 여러 개의 인터페이스 동시 구현 가능

### 인터페이스 구현과 동시에 슈퍼 클래스 상속


# (10월 30일) 강의

### static 메서드의 제약 조건

- static 메서드는 오직 static 멤버만 접근 가능
- static 메서드는 this 사용불가

### final 클래스와 메서드
final 클래스 더 이상 클래스 상속불가능

final 메서드 더이상 오버라이딩 불가능

### final 필드
상수를 선언할 때 사용

상수 필드는 선언 시에 초기 값을 지정하여야 한다.

### 상속의 필요성

- 상속 선언 : extends 키워드 사용
- 부모 클래스를 물려받아 자식 클래스를 확장한다는 의미
- 부모 클래스 -> 슈퍼 클래스
- 자식 클래스 -> 서브 클래스

```java
public class Ex51ColorPointEx {
    public static void main(String[] args) {
        Point p = new Point(); // point 객체생성
        p.set(1, 2); // point 클래스의 set() 호출
        p.showPoint();

        ColorPoint cp = new ColorPoint();
        cp.set(3, 4); // point 클래스의 set 호출
        cp.setColor("red"); // ColorPoint 의 setColor() 호출
        cp.showColorPoint(); // 컬러와 좌표 출력
    }
}

class Point {
    private int x,y; // 한 점을 구성하는 x,y 좌표

    public void set(int x , int y ) {
        this.x = x;
        this.y = y;
    }

    public void showPoint() { // 점의 좌표 출력
        System.out.println("(" + x + "," + y + ")");
    }
}

// Point 상속받은 ColorPoint 선언
class ColorPoint extends Point  {
    private String color;  // 점의색

    public void setColor(String color) {
        this.color = color;
    }

    public void showColorPoint() { // 컬러 점의 좌표 출력

        System.out.println(color);
        showPoint(); // Point 의 showPoint() 호출   
    }
}
```

### 자바 상속의 특징

- 클래스 다중 상속 불허

- 인터페이스 다중 상속 허용

- 클래스는 묵시적으로 Object 클래스 상속받음

### 슈퍼 클래스의 멤버에 대한 서브  클래스의 접근

- 슈퍼클래스의 private 멤버 서브클래스에서 접근할 수 없음

### 서브 클래스/ 슈퍼 클래스의 생성자 호출과 실행
- 서브 클래스의 객체가 생성될 때 : 슈퍼클래스 생성자와 서브 클래스 생성자 모두 실행
- 호출 순서 : 서브 클래스의 생성자 먼저 호출 -> 슈퍼 클래스 생성자 호출
- 실행 순서 : 슈퍼클래스의 생성자가 먼저 실행 -> 서브 클래스의 생성자 실행

---
```java
class Point1 {
    private int x,y; // 한점을 구성하는 x,y 좌표
    public Point1() {
        this.x = 0;
        this.y = 0;
    }

    public Point1(int x ,int y) {
        this.x = x;
        this.y = y;
    }

    public void ShowPoint() { // 점의 좌표 출력
        System.out.println("(" + x + ","  +  y + ")");
    }
}

class ColorPoint1 extends Point1 {
    private String color; // 점의 색
    public ColorPoint1(int x, int y , String color) {
        super(x,y); // Point 의 생성자  Point(x.y) 호출
        this.color = color;
    }

    public void showColorPoint() { // 컬러 점의 좌표 출력
        System.out.println(color);
        ShowPoint(); // Point 클래스의 showPoint() 호출
    }
}

public class Ex52SuperEx {
    public static void main(String[] args) {
        ColorPoint1 cp = new ColorPoint1(5, 6, "blue");
        cp.showColorPoint();
    }
}
```

### 업캐스팅 개념
- 하위 클래스의 레퍼런스는 상위 클래스를 가리킬수 없지만 상위 클래스의 레퍼런스는 하위클래스를 가리킬 수 있다는 설명.

- 생물이 들어가는 박스에 사람이나 코끼리를 넣어도 무방

- 슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 되는 현상

```java
class Person {} // 슈퍼클래스
class Studnet extends Person {}

Person p;
Student s = new Student();
p = s; // 업캐스팅
```

