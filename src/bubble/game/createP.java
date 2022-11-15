package bubble.game;

import javax.swing.*;

public class createP extends JFrame {

    JLabel createP;

    ImageIcon createPageimage = new ImageIcon("image/createPageimage.jpg");

    public createP(){
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
        createP = new JLabel(createPageimage);
        setContentPane(createP);
    }

}
