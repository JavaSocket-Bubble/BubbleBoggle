package bubble.game;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter

public class RoomButton extends JLabel {


    private waitingRoom mContext;

    private JButton roomButton;


    private int x;
    private int y;

    private ImageIcon roomButtonIcon = new ImageIcon(("image/roomButton.png"));


    public RoomButton(waitingRoom mContext) {
        this.mContext = mContext;
        initObject();
        initSetting();
    }

    public void initObject(){
        roomButton= new JButton(roomButtonIcon);


    }
    public void initSetting(){
        x = 30;
        y = 500;

        setRoomButton(roomButton);
        setSize(430, 169);
    }
}
