package bubble.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gameoverPage extends JFrame{
    JLabel gameoverPage;
    ImageIcon retryC = new ImageIcon("image/retryC.png");
    ImageIcon gameexitC = new ImageIcon("image/gameoverExitbuttonC.png");

    //private JButton temproomButton;

    //private RoomButton roomButton;
    private JButton retry;
    private JButton gameexit;

    public gameoverPage(){
        initObject();
        initSetting();
        //initListener();
        setVisible(true);
    }

    public void initObject(){
        gameoverPage = new JLabel(new ImageIcon("image/gameoverPage.png"));
        setContentPane(gameoverPage);
        retry = new JButton(new ImageIcon("image/retry.png"));
        retry.setBounds(700,30,128,113);
        retry.setBorderPainted(false);
        retry.setFocusPainted(false);
        retry.setContentAreaFilled(false);
        add(retry);
        retry.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                retry.setIcon(retryC);
                retry.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                retry.setIcon(new ImageIcon("image/retry.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new startReady();
                setVisible(false);
            }
        }));
        //임시 roomButton
        gameexit = new JButton(new ImageIcon("image/roomButton.png"));
        gameexit.setBounds(30,200,430,169);
        gameexit.setBorderPainted(false);
        gameexit.setFocusPainted(false);
        gameexit.setContentAreaFilled(false);
        add(gameexit);
        gameexit.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                gameexit.setIcon(gameexitC);
                gameexit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gameexit.setIcon(new ImageIcon("image/roomButton.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new waitingRoom();
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
}
