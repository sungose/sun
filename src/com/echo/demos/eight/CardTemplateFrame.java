package com.echo.demos.eight;
import com.echo.demos.six.DBNavigate;
import com.echo.demos.six.PagePanel;

import javax.swing.*;
import java.awt.*;

public class CardTemplateFrame extends JInternalFrame {//JInternalFrame
    CardPanel cardpanel;    // 卡片输入面板部分
    DBNavigate dbpanel;    // 导航条部分
    PagePanel tabpanel;    // 选项卡面板部分

    public CardTemplateFrame() {
        super();
//        setLayout(new BorderLayout());
        tabpanel = new PagePanel();
        cardpanel = new CardPanel();
        dbpanel = new DBNavigate();
        add(dbpanel, BorderLayout.SOUTH);
        add(cardpanel, BorderLayout.WEST);
        add(tabpanel, BorderLayout.CENTER);
        //  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        maximizable = true;
        resizable = true;
        closable = true;
// 设置窗体最大化
//   setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        validate();
    }

    public CardTemplateFrame(String title) {
        super(title);
    }
}