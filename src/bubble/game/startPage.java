package bubble.game;

import java.awt.*;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.Socket;


import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class startPage extends JFrame {

    private static Socket socket;
    private static DataOutputStream dos;
    private static DataInputStream dis;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;

    private static final int BUF_LEN = 128;

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

    // Server Message를 수신해서 화면에 표시
    static void ListenNetwork() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Msg cm = ReadMsg();
                    if (cm == null)
                        break;
                    if (socket == null)
                        break;
                    String msg;
                    msg = String.format("[%s] %s", cm.UserName, cm.data);
                    switch (cm.code) {
                        case "100":
                            if (cm.data.equals("2")) {/*
                                ((FriendsRun.MyPanel) gamepanel).gameStart();
                                gamepanel.requestFocus();
                                cl.show(frame.getContentPane(), "game");*/
                                new BubbleFrame();// 2명이면 게임화면 보내준다
                            }
                            System.out.println(msg);
                            break;
                        case "200": // 동작정보
                            /*if (cm.data.equals("jump")) {
                                if (c2.getCountJump() < 2)
                                    jump2();
                            }
                            if (cm.data.equals("slide")) {
                                downKeyOn2 = true; // downKeyOn 변수를 true로

                                if (c2.getImage() != slideIc2.getImage() // 쿠키이미지가 슬라이드 이미지가 아니고
                                        && !c2.isJump() // 점프 중이 아니며
                                        && !c2.isFall()) { // 낙하 중도 아닐 때

                                    c2.setImage(slideIc2.getImage()); // 이미지를 슬라이드이미지로 변경
                                }
                            }
                            if (cm.data.equals("unslide")) {
                                downKeyOn2 = false; // downKeyOn 변수를 false로

                                if (c2.getImage() != cookieIc2.getImage() // 쿠키이미지가 기본이미지가 아니고
                                        && !c2.isJump() // 점프 중이 아니며
                                        && !c2.isFall()) { // 낙하 중도 아닐 때

                                    c2.setImage(cookieIc2.getImage()); // 이미지를 기본이미지로 변경
                                }
                            }*/
                            System.out.println(msg);
                            break;
                        case "300": // 아이템정보
                            /*if (cm.data.equals("life")) {
                                if ((c1.getHealth() + 100) > 1000) {
                                    c1.setHealth(1000);
                                } else {
                                    c1.setHealth(c1.getHealth() + 100);
                                }
                            }*/
                            System.out.println(msg);
                            break;
                        case "400":
                            /*SendMsg(new Msg("player", "500", Integer.toString(resultScore)));
                            System.out.println(msg);*/
                            break;
                        case "500":
                            /*resultScore = Integer.valueOf(cm.data);
                            ((End) endpanel).setResultScore(resultScore);
                            cl.show(frame.getContentPane(), "end");
                            endpanel.requestFocus();
                            escKeyOn = true;
                            System.out.println(msg);
                            try {
                                out.close();
                                socket.close();
                                in.close();
                                socket = null;
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }*/
                            break;

                    }
                }
            }

        }).start();
    }
    public static Msg ReadMsg() {
        Object obj = null;
        String msg = null;
        Msg cm = new Msg("", "", "");
        try {
            obj = in.readObject();
            cm.code = (String) obj;
            obj = in.readObject();
            cm.UserName = (String) obj;
            obj = in.readObject();
            cm.data = (String) obj;
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            System.out.println("ReadChatMsg Error");
            e.printStackTrace();
            try {
                out.close();
                socket.close();
                in.close();
                socket = null;
                return null;
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                try {
                    out.close();
                    socket.close();
                    in.close();
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }

                socket = null;
                return null;
            }

            // textArea.append("메세지 송신 에러!!\n");
            // System.exit(0);
        }

        return cm;
    }

    // Windows 처럼 message 제외한 나머지 부분은 NULL 로 만들기 위한 함수
    public byte[] MakePacket(String msg) {
        byte[] packet = new byte[BUF_LEN];
        byte[] bb = null;
        int i;
        for (i = 0; i < BUF_LEN; i++)
            packet[i] = 0;
        try {
            bb = msg.getBytes("euc-kr");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
        for (i = 0; i < bb.length; i++)
            packet[i] = bb[i];
        return packet;
    }

    public static void SendMsg(Msg obj) {
        try {
            out.writeObject(obj.code);
            out.writeObject(obj.UserName);
            out.writeObject(obj.data);
            out.flush();
        } catch (IOException e) {
            System.out.println("SendChatMsg Error");
            e.printStackTrace();
            try {
                out.close();
                socket.close();
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            // textArea.append("메세지 송신 에러!!\n");
            // System.exit(0);
        }
    }



    public static void main(String[] args) {
        try {
            String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost 본인
            String serverPort = "30000";
            if (args.length == 2) {
                serverIP = args[0];
                serverPort = args[1];
            }

            System.out.println("Connecting " + serverIP + " " + serverPort);
            socket = new Socket(serverIP, Integer.parseInt(serverPort));
            System.out.println("Connected.");

            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            dos = new DataOutputStream(out);
            in = new ObjectInputStream(socket.getInputStream());
            dis = new DataInputStream(in);

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        // 첫 실행화면
                        startPage startPage = new startPage();
                        startPage.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
