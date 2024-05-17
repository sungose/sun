package com.echo.demos.eight;

import com.echo.demos.four.*;

import javax.swing.*;
import java.awt.*;

public class MDIFrame2 extends JFrame {
    private static JDesktopPane desktopPane;
    Container contentPane;
    JMenuBar menubar;
    JMenu jMenu[] = new JMenu[5];

    MapMenuItem itemLiterature,itemLiterature2,itemLiterature3,itemLiterature4;

    public MDIFrame2() {
        this("");
    }

    public MDIFrame2(String s) {

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        init(s);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,600));
        this.pack();
        setResizable(true);
        setVisible(true);
        desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);
    }

    void init(String s) {
        menubar = new JMenuBar();  // 菜单栏

        jMenu[1] = new JMenu("查询");
        jMenu[2] = new JMenu("入库");
        jMenu[3] = new JMenu("出库");
        jMenu[4] = new JMenu("修改");
        jMenu[0] = new JMenu("仓库信息管理");

        itemLiterature = new MapMenuItem("目录树修改",  LiteratureForm.class.getName());
        itemLiterature2 = new MapMenuItem("材料规格表查询",  LiteratureForm2.class.getName());
        itemLiterature3 = new MapMenuItem("材料规格表浏览",  LiteratureForm3.class.getName());
        itemLiterature4 = new MapMenuItem("出库记录查询",  LiteratureForm4.class.getName());

        jMenu[1].add(itemLiterature3);
        jMenu[1].addSeparator();  // 分割线
        jMenu[1].add(itemLiterature2);

        jMenu[4].add(itemLiterature);

        jMenu[2].add(new MapMenuItem("材料入库",  ClIn.class.getName()));
        jMenu[2].addSeparator();
        jMenu[2].add(new MapMenuItem("材料进货",  ClggbIn.class.getName()));
        jMenu[2].addSeparator();
        jMenu[2].add(new MapMenuItem("入库记录查询",ClrkSelect.class.getName()));

        jMenu[3].add(new MapMenuItem("材料出库",  ClOut.class.getName()));
        jMenu[3].addSeparator();
        jMenu[3].add(new MapMenuItem("材料退货",  ClggbOut.class.getName()));
        jMenu[3].addSeparator();
        jMenu[3].add(itemLiterature4);


        menubar.add(jMenu[1]);
        menubar.add(jMenu[2]);
        menubar.add(jMenu[3]);
        menubar.add(jMenu[4]);
        menubar.add(jMenu[0]);
        setJMenuBar(menubar);
    }

    public static JDesktopPane getDesktopPane() {
        return desktopPane;
    }

}