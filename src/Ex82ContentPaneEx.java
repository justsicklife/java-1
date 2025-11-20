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
