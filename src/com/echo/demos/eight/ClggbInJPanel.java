package com.echo.demos.eight;

import com.echo.dao.ClggbDao;
import com.echo.javabean.Clgg;
import com.echo.utils.ToolUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClggbInJPanel {
    private JFrame frame;
    ClggbDao clggbDao;
    Clgg clgg;
    private JLabel mcLabel = new JLabel("材料名称:");
    private JLabel hhLabel = new JLabel("材料货号:");
    private JLabel ggxhLabel = new JLabel("材料规格型号:");
    private JLabel dwLabel = new JLabel("材料单位:");
    private JLabel slLabel = new JLabel("材料库存数:");
    private JLabel djLabel = new JLabel("材料单价:");
    private JLabel zjeLabel = new JLabel("材料总金额:");

    private JTextField mcText = new JTextField(20);
    private JTextField hhText = new JTextField(20);
    private JTextField ggxhText = new JTextField(20);
    private JTextField dwText = new JTextField(20);
    private JTextField slText = new JTextField(20);
    private JTextField djText = new JTextField(20);
    private JTextField zjeText = new JTextField(20);

    public ClggbInJPanel(){
        frame = new JFrame("材料型号新增");
        Container container = frame.getContentPane();
        ToolUtils.getCenter(frame, 900, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jPanel = new JPanel();
        frame.add(jPanel);
        setJPanel(jPanel);
    }

    public void setJPanel(JPanel jPanel){
        // 设置布局为null
        jPanel.setLayout(null);
        mcLabel.setBounds(10, 20, 80, 25);
        jPanel.add(mcLabel);


        mcText.setBounds(100, 20, 165, 25);
        jPanel.add(mcText);

        hhLabel.setBounds(10, 50, 80, 25);
        jPanel.add(hhLabel);


        hhText.setBounds(100, 50, 165, 25);
        jPanel.add(hhText);


        ggxhLabel.setBounds(10, 80, 80, 25);
        jPanel.add(ggxhLabel);

        ggxhText.setBounds(100, 80, 165, 25);
        jPanel.add(ggxhText);

        dwLabel.setBounds(10, 110, 80, 25);
        jPanel.add(dwLabel);

        dwText.setBounds(100, 110, 165, 25);
        jPanel.add(dwText);

        slLabel.setBounds(10, 140, 80, 25);
        jPanel.add(slLabel);


        slText.setBounds(100, 140, 165, 25);
        jPanel.add(slText);

        djLabel.setBounds(10, 170, 80, 25);
        jPanel.add(djLabel);

        djText.setBounds(100, 170, 165, 25);
        jPanel.add(djText);

        zjeLabel.setBounds(10, 210, 80, 25);
        jPanel.add(zjeLabel);

        zjeText.setBounds(100, 210, 165, 25);
        jPanel.add(zjeText);

        JButton inbound = new JButton("确认新增");
        inbound.setBounds(80, 240, 100, 25);
        jPanel.add(inbound);

        inbound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clggbDao = new ClggbDao();
                int i = 0;
                clgg = new Clgg();
                clgg.setMc(mcText.getText());
                clgg.setGgxh(ggxhText.getText());
                clgg.setHh(hhText.getText());
                clgg.setDw(dwText.getText());
                clgg.setKcs(Double.valueOf(slText.getText()));
                clgg.setPjj(Double.valueOf(djText.getText()));
                clgg.setKczj(Double.valueOf(zjeText.getText()));

                if("".equals(ggxhText.getText())){
                    // 文本框为空时
                    JOptionPane.showOptionDialog(jPanel, "您还没有输入规格型号", "提示"
                            , JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                    return;
                }

                if("".equals(hhText.getText())){
                    // 文本框为空时
                    JOptionPane.showOptionDialog(jPanel, "您还没有输入货号", "提示"
                            , JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                    return;
                }

                int userOption =  JOptionPane.showConfirmDialog(null,"是否确认新增该材料型号？","提示",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
                if (userOption == JOptionPane.OK_OPTION) {
                    System.err.println("是");
                    try {
                        i = clggbDao.clggbInsert(clgg);
                        if (i == 1){
                            JOptionPane.showMessageDialog(null,"新增材料成功！");
                        }else {
                            JOptionPane.showMessageDialog(null,"新增材料失败！");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    mcText.setText("");
                    ggxhText.setText("");
                    hhText.setText("");
                    dwText.setText("");
                    slText.setText("");
                    djText.setText("");
                    zjeText.setText("");
                }else {
                    System.out.println("否");
                }
            }
        });
    }


}
