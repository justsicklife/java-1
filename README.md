# 정하형 (202530128)
# java-1

(10월 30일) 강의

# static 메서드의 제약 조건

- static 메서드는 오직 static 멤버만 접근 가능
- static 메서드는 this 사용불가

# final 클래스와 메서드
final 클래스 더 이상 클래스 상속불가능

final 메서드 더이상 오버라이딩 불가능

# final 필드
상수를 선언할 때 사용

상수 필드는 선언 시에 초기 값을 지정하여야 한다.

# 상속의 필요성

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

# 자바 상속의 특징

- 클래스 다중 상속 불허

- 인터페이스 다중 상속 허용

- 클래스는 묵시적으로 Object 클래스 상속받음

# 슈퍼 클래스의 멤버에 대한 서브  클래스의 접근

- 슈퍼클래스의 private 멤버 서브클래스에서 접근할 수 없음

# 서브 클래스/ 슈퍼 클래스의 생성자 호출과 실행
- 서브 클래스의 객체가 생성될 때 : 슈퍼클래스 생성자와 서브 클래스 생성자 모두 실행
- 호출 순서 : 서브 클래스의 생성자 먼저 호출 -> 슈퍼 클래스 생성자 호출
- 실행 순서 : 슈퍼클래스의 생성자가 먼저 실행 -> 서브 클래스의 생성자 실행