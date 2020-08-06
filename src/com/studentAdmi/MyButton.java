package com.studentAdmi;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    MyButton(int x, int y, int width, int height, String title) {
        setText(title);
        setBounds(x, y, width, height);
        setMargin(new Insets(0, 0, 0, 0));   //内边距
       // setContentAreaFilled(false);                         //按钮透明
        setBorderPainted(false);                              //无边框
        setFont(new Font("微软雅黑", Font.ROMAN_BASELINE, 20));
        setBackground(Color.CYAN);
    }
}
