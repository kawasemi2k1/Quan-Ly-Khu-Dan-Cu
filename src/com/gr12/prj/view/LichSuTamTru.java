/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import com.gr12.prj.object.NhanKhau;
import com.gr12.prj.object.SoHoKhau;
import com.gr12.prj.object.TamTru;
import com.gr12.prj.object.TamVang;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author APC
 */
public class LichSuTamTru extends javax.swing.JFrame {

    /**
     * Creates new form LichSuTamTru
     */
    private DefaultTableModel defaultTableModel;
    SoHoKhau shk = new SoHoKhau();
    NhanKhau nk = new NhanKhau();
    ArrayList<SoHoKhau> listSHK = new ArrayList<>();
    ArrayList<TamTru> listTamTru = new ArrayList<>();
    ArrayList<NhanKhau> listNK = new ArrayList<>();
    ArrayList<TamVang> listTamVang = new ArrayList<>();
    public LichSuTamTru() {
        //this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        setTitle("Lịch Sử Tạm Trú Tạm Vắng");
        loadFileTamVang();
        getDataTamVang(listTamVang);
        loadFileTamTru();
        getDataTamTru(listTamTru);
    }
    public void loadFileTamTru() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
           // listNK = new ArrayList<>(); //lưu ý
            fr = new FileReader("tamtru.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    TamTru tt = new TamTru();
                    tt.setThoiGian(arr[0]);
                    tt.setHoTen(arr[1]);
                    tt.setNgaySinh(arr[2]);
                    tt.setDiaChi(arr[3]);
                    tt.setSoHK(arr[4]);
                    tt.setHoTenChuHo(arr[5]);

                    listTamTru.add(tt);
                }
            } catch (IOException ex) {
                // Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //  Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadFileTamVang() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listTamVang = new ArrayList<>(); //lưu ý
            fr = new FileReader("tamvang.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    TamVang nv = new TamVang();
                    nv.setThoiGian(arr[0]);
                    nv.setMaNK(arr[1]);
                    nv.setSoHoKhau(arr[2]);
                    nv.setHoTen(arr[3]);
                    nv.setGioiTinh(arr[4]);
                    nv.setSinhNhat(arr[5]);
                    
                    nv.setNguyenQuan(arr[7]);
                    
                    nv.setNgheNghiep(arr[9]);
                    nv.setNoiLamViec(arr[10]);
                    nv.setSoCMND(arr[11]);
                    
                    nv.setQuanHeVoiChuHo(arr[15]);
                    nv.setGhiChu(arr[16]);

                    listTamVang.add(nv);
                }
            } catch (IOException ex) {
                // Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //  Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void getDataTamVang(ArrayList<TamVang> listTV) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Thời gian");
        defaultTableModel.addColumn("Mã nhân khẩu");
        defaultTableModel.addColumn("Số hộ khẩu");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Sinh nhật");
        
        defaultTableModel.addColumn("Nguyên quán");
        
        defaultTableModel.addColumn("Nghê nghiệp");
        defaultTableModel.addColumn("Nơi làm việc");
        defaultTableModel.addColumn("CMND");
        
        defaultTableModel.addColumn("Quan hệ với chủ hộ");
        defaultTableModel.addColumn("Ghi chú");

        for (TamVang obj : listTV) {
            Vector vector = new Vector();
            vector.add(obj.getThoiGian());
            vector.add(obj.getMaNK());
            vector.add(obj.getSoHoKhau());
            vector.add(obj.getHoTen());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getSinhNhat());
            
            vector.add(obj.getNguyenQuan());
            
            vector.add(obj.getNgheNghiep());
            vector.add(obj.getNoiLamViec());
            vector.add(obj.getSoCMND());
            
            vector.add(obj.getQuanHeVoiChuHo());
            vector.add(obj.getGhiChu());

            defaultTableModel.addRow(vector);
        }
        tbl_tamVang.setModel(defaultTableModel);
    }
    private void getDataTamTru(ArrayList<TamTru> listTT) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Thời gian");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số hộ khẩu");
        defaultTableModel.addColumn("Họ tên chủ hộ");

        for (TamTru obj : listTT) {
            Vector vector = new Vector();
            vector.add(obj.getThoiGian());
            vector.add(obj.getHoTen());
            vector.add(obj.getNgaySinh());
            vector.add(obj.getDiaChi());
            vector.add(obj.getSoHK());
            vector.add(obj.getHoTenChuHo());

            defaultTableModel.addRow(vector);
        }
        tbl_tamTru.setModel(defaultTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_thoat1 = new javax.swing.JButton();
        txt_timKiem1 = new javax.swing.JTextField();
        btn_timKiem1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btn_timKiemThoiGian1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        datetimeTV = new com.toedter.calendar.JDateChooser();
        txt_timKiem2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        datetimeTT = new com.toedter.calendar.JDateChooser();
        btn_timKiemThoiGian2 = new javax.swing.JButton();
        btn_timKiem2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_tamVang = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_tamTru = new javax.swing.JTable();
        doc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel19.setFont(new java.awt.Font("UTM Flamenco", 0, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(65, 50, 122));
        jLabel19.setText("Tạm vắng");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(380, 60, 250, 70);

        jLabel18.setFont(new java.awt.Font("UTM Flamenco", 0, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(65, 50, 122));
        jLabel18.setText("Tạm trú");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(1340, 50, 170, 70);

        btn_thoat1.setBackground(new java.awt.Color(65, 50, 122));
        btn_thoat1.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_thoat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_arrow_back_ios_new_white_24dp.png"))); // NOI18N
        btn_thoat1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_thoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoat1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_thoat1);
        btn_thoat1.setBounds(20, 10, 100, 90);

        txt_timKiem1.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_timKiem1.setForeground(new java.awt.Color(65, 50, 122));
        txt_timKiem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        txt_timKiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiem1KeyReleased(evt);
            }
        });
        jPanel1.add(txt_timKiem1);
        txt_timKiem1.setBounds(480, 160, 250, 40);

        btn_timKiem1.setBackground(new java.awt.Color(65, 50, 122));
        btn_timKiem1.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_timKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp.png"))); // NOI18N
        btn_timKiem1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_timKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiem1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiem1);
        btn_timKiem1.setBounds(750, 160, 40, 40);

        jLabel11.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(140, 123, 185));
        jLabel11.setText("Tìm kiếm theo tên");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(210, 160, 220, 50);

        btn_timKiemThoiGian1.setBackground(new java.awt.Color(65, 50, 122));
        btn_timKiemThoiGian1.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_timKiemThoiGian1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp.png"))); // NOI18N
        btn_timKiemThoiGian1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_timKiemThoiGian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemThoiGian1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiemThoiGian1);
        btn_timKiemThoiGian1.setBounds(750, 240, 40, 40);

        jLabel12.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(140, 123, 185));
        jLabel12.setText("Tìm kiếm theo thời gian");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(210, 240, 280, 50);

        datetimeTV.setBackground(new java.awt.Color(140, 123, 185));
        datetimeTV.setForeground(new java.awt.Color(65, 50, 122));
        datetimeTV.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(datetimeTV);
        datetimeTV.setBounds(480, 240, 250, 40);

        txt_timKiem2.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_timKiem2.setForeground(new java.awt.Color(65, 50, 122));
        txt_timKiem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        txt_timKiem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiem2KeyReleased(evt);
            }
        });
        jPanel1.add(txt_timKiem2);
        txt_timKiem2.setBounds(1430, 170, 250, 40);

        jLabel13.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(140, 123, 185));
        jLabel13.setText("Tìm kiếm theo tên");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(1160, 170, 220, 50);

        jLabel14.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(140, 123, 185));
        jLabel14.setText("Tìm kiếm theo thời gian");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1160, 250, 280, 50);

        datetimeTT.setBackground(new java.awt.Color(140, 123, 185));
        datetimeTT.setForeground(new java.awt.Color(65, 50, 122));
        datetimeTT.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(datetimeTT);
        datetimeTT.setBounds(1430, 250, 250, 40);

        btn_timKiemThoiGian2.setBackground(new java.awt.Color(65, 50, 122));
        btn_timKiemThoiGian2.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_timKiemThoiGian2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp.png"))); // NOI18N
        btn_timKiemThoiGian2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_timKiemThoiGian2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemThoiGian2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiemThoiGian2);
        btn_timKiemThoiGian2.setBounds(1700, 250, 40, 40);

        btn_timKiem2.setBackground(new java.awt.Color(65, 50, 122));
        btn_timKiem2.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_timKiem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp.png"))); // NOI18N
        btn_timKiem2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_timKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiem2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiem2);
        btn_timKiem2.setBounds(1700, 170, 40, 40);

        tbl_tamVang.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_tamVang.setForeground(new java.awt.Color(65, 50, 122));
        tbl_tamVang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_tamVang.setCellSelectionEnabled(true);
        tbl_tamVang.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_tamVang.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane4.setViewportView(tbl_tamVang);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(80, 330, 850, 630);

        tbl_tamTru.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_tamTru.setForeground(new java.awt.Color(65, 50, 122));
        tbl_tamTru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_tamTru.setCellSelectionEnabled(true);
        tbl_tamTru.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_tamTru.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane5.setViewportView(tbl_tamTru);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(1040, 330, 850, 630);

        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 1nen.png"))); // NOI18N
        doc.setText("jLabel1");
        jPanel1.add(doc);
        doc.setBounds(0, 0, 1920, 1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoat1ActionPerformed

    private void btn_timKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiem1ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem1.getText();
        if (tuKhoa.equals("")) {
            getDataTamVang(listTamVang);
        } else {
            ArrayList<TamVang> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listTamVang.size(); i++) {
                if (listTamVang.get(i).getHoTen().contains(tuKhoa)) {

                    listTimKiem.add(listTamVang.get(i));
                }
            }
            getDataTamVang(listTimKiem);
        }
    }//GEN-LAST:event_btn_timKiem1ActionPerformed
    public Date covertStringToDate(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(str);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(QuanLiNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date date2 = new Date();
        return date2;
    }
    public String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
    private void btn_timKiemThoiGian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemThoiGian1ActionPerformed
        // TODO add your handling code here:
        String dateSearch = convertDateToString(datetimeTV.getDate());
        
        ArrayList<TamVang> ListTV = new ArrayList<>();

        for (int i = 0; i < listTamVang.size(); i++) {
            if (dateSearch.equals(listTamVang.get(i).getThoiGian())) {
                ListTV.add(listTamVang.get(i));
            }
        }
        getDataTamVang(ListTV);
    }//GEN-LAST:event_btn_timKiemThoiGian1ActionPerformed

    private void btn_timKiemThoiGian2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemThoiGian2ActionPerformed
        // TODO add your handling code here:
        String dateSearch = convertDateToString(datetimeTT.getDate());
        
        ArrayList<TamTru> ListTT = new ArrayList<>();

        for (int i = 0; i < listTamTru.size(); i++) {
            if (dateSearch.equals(listTamTru.get(i).getThoiGian())) {
                ListTT.add(listTamTru.get(i));
            }
        }
        getDataTamTru(ListTT);
    }//GEN-LAST:event_btn_timKiemThoiGian2ActionPerformed

    private void btn_timKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiem2ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem2.getText();
        if (tuKhoa.equals("")) {
            getDataTamTru(listTamTru);
        } else {
            ArrayList<TamTru> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listTamTru.size(); i++) {
                if (listTamTru.get(i).getHoTen().contains(tuKhoa)) {

                    listTimKiem.add(listTamTru.get(i));
                }
            }
            getDataTamTru(listTimKiem);
        }
    }//GEN-LAST:event_btn_timKiem2ActionPerformed

    private void txt_timKiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiem1KeyReleased
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem1.getText();
        if (tuKhoa.equals("")) {
            getDataTamVang(listTamVang);
        } else {
            ArrayList<TamVang> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listTamVang.size(); i++) {
                if (listTamVang.get(i).getHoTen().contains(tuKhoa)) {

                    listTimKiem.add(listTamVang.get(i));
                }
            }
            getDataTamVang(listTimKiem);
        }
    }//GEN-LAST:event_txt_timKiem1KeyReleased

    private void txt_timKiem2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiem2KeyReleased
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem2.getText();
        if (tuKhoa.equals("")) {
            getDataTamTru(listTamTru);
        } else {
            ArrayList<TamTru> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listTamTru.size(); i++) {
                if (listTamTru.get(i).getHoTen().contains(tuKhoa)) {

                    listTimKiem.add(listTamTru.get(i));
                }
            }
            getDataTamTru(listTimKiem);
        }
    }//GEN-LAST:event_txt_timKiem2KeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_thoat1;
    private javax.swing.JButton btn_timKiem1;
    private javax.swing.JButton btn_timKiem2;
    private javax.swing.JButton btn_timKiemThoiGian1;
    private javax.swing.JButton btn_timKiemThoiGian2;
    private com.toedter.calendar.JDateChooser datetimeTT;
    private com.toedter.calendar.JDateChooser datetimeTV;
    private javax.swing.JLabel doc;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbl_tamTru;
    private javax.swing.JTable tbl_tamVang;
    private javax.swing.JTextField txt_timKiem1;
    private javax.swing.JTextField txt_timKiem2;
    // End of variables declaration//GEN-END:variables
}
