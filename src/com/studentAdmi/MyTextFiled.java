package com.studentAdmi;

import javax.swing.*;
import java.awt.*;

public class MyTextFiled extends JTextField {
    MyTextFiled(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
        setBorder(null);
        setFont(new Font("微软雅黑", Font.BOLD, 22));
        setForeground(Color.BLUE);

    }
}
