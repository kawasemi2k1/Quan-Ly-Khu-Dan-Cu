/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import com.gr12.prj.controller.ChuyenManHinhController;
import com.gr12.prj.even_obj.DanhMucBean;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author APC
 */
public class MainJFrame extends javax.swing.JFrame {

    public MainJFrame() {
        //this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        
        setTitle("Quản Lí Tổ Dân Phố 12");
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnTrangChu,jlbTrangChu);
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("TrangChu",jpnTrangChu,jlbTrangChu));
        listItem.add(new DanhMucBean("QuanLi",jpnQuanLi,jlbQuanLi));
        listItem.add(new DanhMucBean("LichSu",jpnLichSu,jlbLichSu));
        listItem.add(new DanhMucBean("ThongKe",jpnThongKe,jlbThongKe));
        
        controller.setEvent(listItem);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpnRoot = new javax.swing.JPanel();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnLichSu = new javax.swing.JPanel();
        jlbLichSu = new javax.swing.JLabel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnQuanLi = new javax.swing.JPanel();
        jlbQuanLi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        doc = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setLayout(null);

        jpnThongKe.setBackground(new java.awt.Color(239, 65, 101));

        jlbThongKe.setFont(new java.awt.Font("UTM Swiss 721 Black Condensed", 0, 24)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_timeline_white_24dp.png"))); // NOI18N
        jlbThongKe.setText("Thống kê");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jlbThongKe)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnRoot.add(jpnThongKe);
        jpnThongKe.setBounds(10, 580, 330, 90);

        jpnLichSu.setBackground(new java.awt.Color(239, 65, 101));

        jlbLichSu.setFont(new java.awt.Font("UTM Swiss 721 Black Condensed", 0, 24)); // NOI18N
        jlbLichSu.setForeground(new java.awt.Color(255, 255, 255));
        jlbLichSu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_history_white_24dp.png"))); // NOI18N
        jlbLichSu.setText("Lịch sử");

        javax.swing.GroupLayout jpnLichSuLayout = new javax.swing.GroupLayout(jpnLichSu);
        jpnLichSu.setLayout(jpnLichSuLayout);
        jpnLichSuLayout.setHorizontalGroup(
            jpnLichSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLichSuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jlbLichSu)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jpnLichSuLayout.setVerticalGroup(
            jpnLichSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLichSuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbLichSu, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnRoot.add(jpnLichSu);
        jpnLichSu.setBounds(10, 480, 330, 90);

        jpnTrangChu.setBackground(new java.awt.Color(239, 65, 101));

        jlbTrangChu.setFont(new java.awt.Font("UTM Swiss 721 Black Condensed", 0, 24)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_home_white_24dp.png"))); // NOI18N
        jlbTrangChu.setText("Trang chủ");

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnRoot.add(jpnTrangChu);
        jpnTrangChu.setBounds(10, 280, 330, 90);

        jpnQuanLi.setBackground(new java.awt.Color(239, 65, 101));

        jlbQuanLi.setFont(new java.awt.Font("UTM Swiss 721 Black Condensed", 0, 24)); // NOI18N
        jlbQuanLi.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_work_white_24dp.png"))); // NOI18N
        jlbQuanLi.setText("Quản lí");

        javax.swing.GroupLayout jpnQuanLiLayout = new javax.swing.GroupLayout(jpnQuanLi);
        jpnQuanLi.setLayout(jpnQuanLiLayout);
        jpnQuanLiLayout.setHorizontalGroup(
            jpnQuanLiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jlbQuanLi)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jpnQuanLiLayout.setVerticalGroup(
            jpnQuanLiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQuanLi, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnRoot.add(jpnQuanLi);
        jpnQuanLi.setBounds(10, 380, 330, 90);

        jLabel1.setFont(new java.awt.Font("UTM Avo", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tài khoản cấp 1");
        jpnRoot.add(jLabel1);
        jLabel1.setBounds(160, 0, 190, 30);

        jButton1.setBackground(new java.awt.Color(239, 65, 101));
        jButton1.setFont(new java.awt.Font("UTM Nokia", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Đăng xuất");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpnRoot.add(jButton1);
        jButton1.setBounds(40, 890, 270, 60);

        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 12.png"))); // NOI18N
        doc.setText("jLabel2");
        jpnRoot.add(doc);
        doc.setBounds(0, -180, 370, 1300);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1129, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoginJFrame login = new LoginJFrame();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel doc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbLichSu;
    private javax.swing.JLabel jlbQuanLi;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnLichSu;
    private javax.swing.JPanel jpnQuanLi;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
