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
