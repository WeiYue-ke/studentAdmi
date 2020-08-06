package com.studentAdmi;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    MyLabel(int x, int y, int width, int height, String text){
        super();
        setBounds(x,y,width,height);
        setText(text);
        setFont(new Font("微软雅黑", Font.BOLD, 25));
        setForeground(Color.black);
    }
}
