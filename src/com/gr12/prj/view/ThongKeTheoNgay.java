/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import com.gr12.prj.object.NhanKhau;
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
public class ThongKeTheoNgay extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeTheoNgay
     */
    private DefaultTableModel defaultTableModel;
    NhanKhau nk = new NhanKhau();
    ArrayList<NhanKhau> listNK = new ArrayList<>();
    public ThongKeTheoNgay() {
        this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        setTitle("Thống Kê Theo Ngày");
        loadFile();
        getData(listNK);
    }
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listNK = new ArrayList<>(); //lưu ý
            fr = new FileReader("nhankhau.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    NhanKhau nv = new NhanKhau();
                    nv.setMaNK(arr[0]);
                    nv.setSoHoKhau(arr[1]);
                    nv.setHoTen(arr[2]);
                    nv.setGioiTinh(arr[3]);
                    nv.setSinhNhat(arr[4]);
                    nv.setNoiSinh(arr[5]);
                    nv.setNguyenQuan(arr[6]);
                    nv.setDanToc(arr[7]);
                    nv.setNgheNghiep(arr[8]);
                    nv.setNoiLamViec(arr[9]);
                    nv.setSoCMND(arr[10]);
                    nv.setNgayNoiCapCMND(arr[11]);
                    nv.setThoiGianDKThuongTru(arr[12]);
                    nv.setDiaChiTruoc(arr[13]);
                    nv.setQuanHeVoiChuHo(arr[14]);
                    nv.setGhiChu(arr[15]);

                    listNK.add(nv);
                }
            } catch (IOException ex) {
                // Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //  Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void getData(ArrayList<NhanKhau> listNK) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã nhân khẩu");
        defaultTableModel.addColumn("Số hộ khẩu");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Sinh nhật");
        defaultTableModel.addColumn("Nơi sinh");
        defaultTableModel.addColumn("Nguyên quán");
        defaultTableModel.addColumn("Dân tộc");
        defaultTableModel.addColumn("Nghê nghiệp");
        defaultTableModel.addColumn("Nơi làm việc");
        defaultTableModel.addColumn("CMND");
        defaultTableModel.addColumn("Ngày, nơi cấp CMND");
        defaultTableModel.addColumn("Ngày ĐK thường trú");
        defaultTableModel.addColumn("Địa chỉ thường trú trước");
        defaultTableModel.addColumn("Quan hệ với chủ hộ");
        defaultTableModel.addColumn("Ghi chú");

        for (NhanKhau obj : listNK) {
            Vector vector = new Vector();
            vector.add(obj.getMaNK());
            vector.add(obj.getSoHoKhau());
            vector.add(obj.getHoTen());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getSinhNhat());
            vector.add(obj.getNoiSinh());
            vector.add(obj.getNguyenQuan());
            vector.add(obj.getDanToc());
            vector.add(obj.getNgheNghiep());
            vector.add(obj.getNoiLamViec());
            vector.add(obj.getSoCMND());
            vector.add(obj.getNgayNoiCapCMND());
            vector.add(obj.getThoiGianDKThuongTru());
            vector.add(obj.getDiaChiTruoc());
            vector.add(obj.getQuanHeVoiChuHo());
            vector.add(obj.getGhiChu());

            defaultTableModel.addRow(vector);
        }
        tbl_thongKeTheoNgay.setModel(defaultTableModel);
    }
    
    public String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_thoat1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        datetimeTK_From = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        datetimeTK_To = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        btn_reset2 = new javax.swing.JButton();
        bttn_thongKe = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_thongKeTheoNgay = new javax.swing.JTable();
        doc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

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

        jLabel15.setFont(new java.awt.Font("UTM American Sans", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(65, 50, 122));
        jLabel15.setText("Thống kê nhân khẩu theo khoảng thời gian");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(700, 50, 690, 70);

        datetimeTK_From.setBackground(new java.awt.Color(140, 123, 185));
        datetimeTK_From.setForeground(new java.awt.Color(65, 50, 122));
        datetimeTK_From.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(datetimeTK_From);
        datetimeTK_From.setBounds(580, 150, 250, 50);

        jLabel14.setFont(new java.awt.Font("UVN La Xanh", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(140, 123, 185));
        jLabel14.setText("Từ ngày");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(430, 140, 150, 60);

        datetimeTK_To.setBackground(new java.awt.Color(140, 123, 185));
        datetimeTK_To.setForeground(new java.awt.Color(65, 50, 122));
        datetimeTK_To.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(datetimeTK_To);
        datetimeTK_To.setBounds(1060, 150, 250, 50);

        jLabel16.setFont(new java.awt.Font("UVN La Xanh", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(140, 123, 185));
        jLabel16.setText("Đến ngày");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(890, 140, 170, 60);

        btn_reset2.setBackground(new java.awt.Color(65, 50, 122));
        btn_reset2.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_reset2.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_settings_backup_restore_white_24dp.png"))); // NOI18N
        btn_reset2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reset2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset2);
        btn_reset2.setBounds(1350, 150, 60, 50);

        bttn_thongKe.setBackground(new java.awt.Color(65, 50, 122));
        bttn_thongKe.setFont(new java.awt.Font("UTM God's Word", 0, 24)); // NOI18N
        bttn_thongKe.setForeground(new java.awt.Color(255, 255, 255));
        bttn_thongKe.setText("Thống kê");
        bttn_thongKe.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        bttn_thongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_thongKeActionPerformed(evt);
            }
        });
        jPanel1.add(bttn_thongKe);
        bttn_thongKe.setBounds(1430, 150, 130, 50);

        tbl_thongKeTheoNgay.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_thongKeTheoNgay.setForeground(new java.awt.Color(65, 50, 122));
        tbl_thongKeTheoNgay.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_thongKeTheoNgay.setCellSelectionEnabled(true);
        tbl_thongKeTheoNgay.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_thongKeTheoNgay.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane4.setViewportView(tbl_thongKeTheoNgay);
        tbl_thongKeTheoNgay.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(70, 240, 1770, 710);

        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 1nen.png"))); // NOI18N
        doc.setText("jLabel1");
        jPanel1.add(doc);
        doc.setBounds(0, 0, 1920, 1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoat1ActionPerformed

    private void bttn_thongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_thongKeActionPerformed
        // TODO add your handling code here:
        ArrayList<Date> ListDate = new ArrayList<>();
        ArrayList<NhanKhau> ListTK = new ArrayList<>();
        int i = 0;
        Date tmp;
        
        for (i = 0; i < listNK.size(); i++) {
            tmp = covertStringToDate(listNK.get(i).getThoiGianDKThuongTru());
            
            if (datetimeTK_From.getDate().before(tmp) && datetimeTK_To.getDate().after(tmp)) {
                ListTK.add(listNK.get(i));
            }
        }
        getData(ListTK);
    }//GEN-LAST:event_bttn_thongKeActionPerformed

    private void btn_reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reset2ActionPerformed
        // TODO add your handling code here:
        getData(listNK);
    }//GEN-LAST:event_btn_reset2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset2;
    private javax.swing.JButton btn_thoat1;
    private javax.swing.JButton bttn_thongKe;
    private com.toedter.calendar.JDateChooser datetimeTK_From;
    private com.toedter.calendar.JDateChooser datetimeTK_To;
    private javax.swing.JLabel doc;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_thongKeTheoNgay;
    // End of variables declaration//GEN-END:variables
}
