package bubble.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class startReady extends JFrame {
    JLabel startReadyP;

    JButton readyButton;
    JButton exitButton;

    ImageIcon exitButtonC = new ImageIcon("image/EXITC.png");
    ImageIcon readyButtonC = new ImageIcon("image/READYC.png");
    ImageIcon startReadyPageimage = new ImageIcon("image/startReady.png");

    public startReady(){
        initObject();
        initSetting();
        //initListener();
        setVisible(true);
    }

    private void initSetting() {
        setSize(1000, 640);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initObject() {
        startReadyP = new JLabel(startReadyPageimage);
        setContentPane(startReadyP);

        readyButton = new JButton(new ImageIcon("image/READY.png"));
        readyButton.setBounds(570, 285, 430, 208);
        readyButton.setBorderPainted(false);
        readyButton.setFocusPainted(false);
        readyButton.setContentAreaFilled(false);
        add(readyButton);
        readyButton.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                readyButton.setIcon(readyButtonC);
                readyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                readyButton.setIcon(new ImageIcon("image/READY.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new BubbleFrame();
                setVisible(false);
            }
        }));

        exitButton = new JButton(new ImageIcon("image/EXIT.png"));
        exitButton.setBounds(570, 430, 430, 208);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        add(exitButton);
        exitButton.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonC);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(new ImageIcon("image/EXIT.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new waitingRoom();
                setVisible(false);
            }
        }));
    }
}

