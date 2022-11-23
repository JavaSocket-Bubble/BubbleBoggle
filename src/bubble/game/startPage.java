package bubble.game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class startPage extends JFrame {

    ImageIcon startPageimage = new ImageIcon("image/startPage.png");

//    Image img = startPageimage.getImage();
//    Image changeImg = img.getScaledInstance(1000,640, Image.SCALE_SMOOTH);
//    ImageIcon changeIcon = new ImageIcon(changeImg);
    JLabel startP;

    public startPage(){
        initObject();
        initSetting();
        initListener();
        setVisible(true);
    }

    public void initObject(){
        startP = new JLabel(startPageimage);
        setContentPane(startP); //JLabel을 JPanel로 바꿔버림
    }

    public void initSetting() {
        setSize(1000, 640);
        setLayout(null); //absoulte 레이아웃(자유롭게 그림을 그릴 수 있다.
        setLocationRelativeTo(null); //JFrame 가운데 배치하기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼으로 창을 끌 때 JVM같이 종료
    }

    public void initListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            //키보드 클릭 핸들러 이벤트
            public void keyPressed(KeyEvent e) {
                new waitingRoom();
                //new BubbleFrame();
                setVisible(false);
            }
        });
    }

    /*public static void main(String[] args) {
        new startPage();
    }*/
}
