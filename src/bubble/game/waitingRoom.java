package bubble.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class waitingRoom extends JFrame{

    JLabel waitingRoom;
    ImageIcon createRoomC = new ImageIcon("image/createRoomC.png");
    ImageIcon temproomButtonC = new ImageIcon("image/roomButtonC.png");

    private JButton temproomButton;

    private RoomButton roomButton;
    private waitingRoom mContext = this;
    private JButton createRoom;

    public waitingRoom(){
        initObject();
        initSetting();
        //initListener();
        setVisible(true);
    }

    public void initObject(){
        waitingRoom = new JLabel(new ImageIcon("image/WaitingRoom.png"));
        setContentPane(waitingRoom);
        createRoom = new JButton(new ImageIcon("image/createRoom.png"));
        createRoom.setBounds(700,30,128,113);
        createRoom.setBorderPainted(false);
        createRoom.setFocusPainted(false);
        createRoom.setContentAreaFilled(false);
        add(createRoom);
        createRoom.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                createRoom.setIcon(createRoomC);
                createRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createRoom.setIcon(new ImageIcon("image/createRoom.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new createP();
                setVisible(false);
            }
        }));
        //임시 roomButton
        temproomButton = new JButton(new ImageIcon("image/roomButton.png"));
        temproomButton.setBounds(30,200,430,169);
        temproomButton.setBorderPainted(false);
        temproomButton.setFocusPainted(false);
        temproomButton.setContentAreaFilled(false);
        add(temproomButton);
        temproomButton.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                temproomButton.setIcon(temproomButtonC);
                temproomButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                temproomButton.setIcon(new ImageIcon("image/roomButton.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new startReady();
                setVisible(false);
            }
        }));
        //roomButton = new RoomButton(mContext);
       // roomButton.setBounds(30,500,430,169);
        //add(roomButton);
    }

    public void initSetting() {
        setSize(1000, 640);
        setLayout(null); //absoulte 레이아웃(자유롭게 그림을 그릴 수 있다.
        setLocationRelativeTo(null); //JFrame 가운데 배치하기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼으로 창을 끌 때 JVM같이 종료
    }

    //roomButton1 = new JButton(new ImageIcon("image/BackgroundMap.png));

}
