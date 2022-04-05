/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import com.gr12.prj.object.QuanLy;
import com.gr12.prj.utils.Validate_data;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author APC
 */
public class LoginJFrame extends javax.swing.JFrame {
    ArrayList<QuanLy> listQL = new ArrayList<>();
    Map<String, String> mapUP = new HashMap<>();
    String userR = "";
    String passR = "";
    Validate_data val = new Validate_data();
    
    private String kindSelected = "";
    private Color color1 = new Color(255, 153, 0);
 
    public LoginJFrame() {
        this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize); 
        
        loadFile();
        this.txt_username.setText(userR);
        this.txt_password.setText(passR);
    }
  
    
    public void loadFile() {
        try {
            FileReader fr = null;
            BufferedReader br = null;
            listQL = new ArrayList<>();
            fr = new FileReader("userpass.txt");
            br = new BufferedReader(fr);
            String s = null;
            try {
                while ((s = br.readLine()) != null) {
                    String[] arr = s.split("\t");
                    mapUP.put(arr[0], arr[1]);
                    userR = arr[0];
                    passR = arr[1];

                }
            } catch (IOException ex) {
                //Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadFileQuanLy() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listQL = new ArrayList<>(); //lưu ý
            fr = new FileReader("quanly.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    QuanLy ql = new QuanLy();
                    ql.setUsername(arr[0]);
                    ql.setPassword(arr[1]);
                    listQL.add(ql);
                }
            } catch (IOException ex) {
                // Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveFile() {
        loadFile();
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;
            String data = "";
            String row = "";

            row += txt_username.getText() + "\t";
            row += txt_password.getText() + "\t";
            data += row;

            fw = new FileWriter("userpass.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkUserAndPass(String userName, String password) {
        System.out.println("user: " + userName);
        System.out.println("pass: " + password);
        for (int i = 0; i < listQL.size(); i++) {
            if (userName.equals(listQL.get(i).getUsername()) && password.equals(listQL.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void deleteContentFile() {
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;
            String data = "";
            String row = "";
            fw = new FileWriter("userpass.txt");
            bw = new BufferedWriter(fw);
            bw.write(row);
            bw.close();
        } catch (IOException ex) {
            // Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        txt_username = new javax.swing.JTextField();
        txt_erroruserpw = new javax.swing.JLabel();
        rememberpw = new javax.swing.JCheckBox();
        jlbDangNhap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 65, 101));

        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(239, 65, 101));
        jButton1.setFont(new java.awt.Font("UTM Nokia", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ĐĂNG NHẬP");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(920, 600, 280, 60);

        txt_password.setForeground(new java.awt.Color(239, 65, 101));
        txt_password.setBorder(null);
        txt_password.setSelectionColor(new java.awt.Color(239, 65, 101));
        jPanel2.add(txt_password);
        txt_password.setBounds(960, 482, 240, 30);

        txt_username.setForeground(new java.awt.Color(239, 65, 101));
        txt_username.setBorder(null);
        txt_username.setSelectionColor(new java.awt.Color(239, 65, 101));
        jPanel2.add(txt_username);
        txt_username.setBounds(960, 400, 240, 30);

        txt_erroruserpw.setForeground(new java.awt.Color(239, 65, 101));
        jPanel2.add(txt_erroruserpw);
        txt_erroruserpw.setBounds(970, 560, 180, 16);

        rememberpw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberpwActionPerformed(evt);
            }
        });
        jPanel2.add(rememberpw);
        rememberpw.setBounds(910, 530, 20, 25);

        jlbDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/login3_1.png"))); // NOI18N
        jlbDangNhap.setText("jLabel1");
        jPanel2.add(jlbDangNhap);
        jlbDangNhap.setBounds(-10, -10, 1440, 930);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rememberpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberpwActionPerformed
        // TODO add your handling code here:
        String txt_username = this.txt_username.getText();
        String txt_password = this.txt_password.getText();
        if (rememberpw.isSelected()) {
            if (mapUP.size() > 1) {
                deleteContentFile();
            }
            saveFile();
            loadFile();
            for (Map.Entry<String, String> entry : mapUP.entrySet()) {
                userR = entry.getKey();
                passR = entry.getValue();
            }
        } else {
            deleteContentFile();
        }
    }//GEN-LAST:event_rememberpwActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!rememberpw.isSelected()) {
            deleteContentFile();
        } else {
            loadFile();
        }
        String txt_username = this.txt_username.getText();
        String txt_password = this.txt_password.getText();
        txt_password = val.md5(txt_password);
        loadFileQuanLy();

        if (!checkUserAndPass(txt_username, txt_password)) {
            txt_erroruserpw.setText("Sai tài khoản hoặc mật khẩu!");
        } else {
            if (1 == 2) {
                return;
            }
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            // maNV = txt_username;
            if (txt_username.equals("canbonhavanhoa@gmail.com")) {
                new Main2JFrame().setVisible(true);
                this.dispose();
                return;
            } else {
                new MainJFrame().setVisible(true);
                this.dispose();
                return;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlbDangNhap;
    private javax.swing.JCheckBox rememberpw;
    private javax.swing.JLabel txt_erroruserpw;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
