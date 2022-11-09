package bubble.game;

import javax.swing.*;

public class waitingRoom extends JFrame{

    JLabel waitingRoom;
    JButton roomButton1;

    public waitingRoom(){
        initObject();
        initSetting();
        //initListener();
        setVisible(true);
    }

    public void initObject(){
        waitingRoom = new JLabel(new ImageIcon("image/BackgroundMap.png"));
        setContentPane(waitingRoom);
    }

    public void initSetting() {
        setSize(1000, 640);
        setLayout(null); //absoulte 레이아웃(자유롭게 그림을 그릴 수 있다.
        setLocationRelativeTo(null); //JFrame 가운데 배치하기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼으로 창을 끌 때 JVM같이 종료
    }

    //roomButton1 = new JButton(new ImageIcon("image/BackgroundMap.png));

}
