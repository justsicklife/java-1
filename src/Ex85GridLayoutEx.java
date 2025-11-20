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
