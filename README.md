# 정하형 (202530128)
# java-1

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

