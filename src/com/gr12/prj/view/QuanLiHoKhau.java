/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import com.gr12.prj.object.NhanKhau;
import static com.gr12.prj.view.QuanLiNhanKhau.listNK;
import com.gr12.prj.object.SoHoKhau;
import com.gr12.prj.utils.Validate_data;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author APC
 */
public class QuanLiHoKhau extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    SoHoKhau shk = new SoHoKhau();
    static ArrayList<SoHoKhau> listSHK = new ArrayList<>();
    NhanKhau nk = new NhanKhau();
    ArrayList<NhanKhau> listNK2 = new ArrayList<>();
    Validate_data validate = new Validate_data();
    public QuanLiHoKhau() {
        //this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        setTitle("Quản Lí Hộ Khẩu");
        loadFile();
        getData(listSHK);
        btn_xoa.setEnabled(false);
    }
    public void saveFile() {
        
        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listSHK.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listSHK.get(i).getSoHoKhau() + "\t";
                row = row + listSHK.get(i).getHoTenChuHo() + "\t";
                row = row + listSHK.get(i).getDiaChi() + "\n";                
                data += row;
            }
            fw = new FileWriter("sohokhau.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listSHK = new ArrayList<>(); //lưu ý
            fr = new FileReader("sohokhau.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    SoHoKhau nv = new SoHoKhau();
                    nv.setSoHoKhau(arr[0]);
                    nv.setHoTenChuHo(arr[1]);
                    nv.setDiaChi(arr[2]);
                    listSHK.add(nv);
                }
            } catch (IOException ex) {
                //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void saveFile2() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listNK2.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listNK2.get(i).getMaNK() + "\t";
                row = row + listNK2.get(i).getSoHoKhau() + "\t";
                row = row + listNK2.get(i).getHoTen() + "\t";
                row = row + listNK2.get(i).getGioiTinh() + "\t";
                row = row + listNK2.get(i).getSinhNhat() + "\t";
                row = row + listNK2.get(i).getNoiSinh() + "\t";
                row = row + listNK2.get(i).getNguyenQuan() + "\t";
                row = row + listNK2.get(i).getDanToc() + "\t";
                row = row + listNK2.get(i).getNgheNghiep() + "\t";
                row = row + listNK2.get(i).getNoiLamViec() + "\t";
                row = row + listNK2.get(i).getSoCMND() + "\t";
                row = row + listNK2.get(i).getNgayNoiCapCMND() + "\t";
                row = row + listNK2.get(i).getThoiGianDKThuongTru() + "\t";
                row = row + listNK2.get(i).getDiaChiTruoc() + "\t";
                row = row + listNK2.get(i).getQuanHeVoiChuHo() + "\t";
                row = row + listNK2.get(i).getGhiChu() + "\n";

                data += row;
            }
            fw = new FileWriter("nhankhau.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadFile2() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listNK2 = new ArrayList<>(); //lưu ý
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

                    listNK2.add(nv);
                }
            } catch (IOException ex) {
                // Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //  Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void getData(ArrayList<SoHoKhau> listSoHK) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Số hộ khẩu");
        defaultTableModel.addColumn("Họ tên chủ hộ");
        defaultTableModel.addColumn("Địa chỉ");
        
        for (SoHoKhau obj : listSoHK) {
            Vector vector = new Vector();
            vector.add(obj.getSoHoKhau());
            vector.add(obj.getHoTenChuHo());
            vector.add(obj.getDiaChi());
            
            defaultTableModel.addRow(vector);
        }
        tbl_soHK.setModel(defaultTableModel);
    }
    
    public void reset() {
        
        btn_them.setEnabled(true);
        btn_xoa.setEnabled(false);
        txt_search.setText("");
        txt_soHK.setText("");
        txt_diaChi.setText("");
        txt_tenChuHo.setText("");
        txt_tenChuHo.setEnabled(true);
         txt_diaChi.setEnabled(true);
        txt_soHK.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_thoat = new javax.swing.JButton();
        txt_soHK = new javax.swing.JTextField();
        txt_tenChuHo = new javax.swing.JTextField();
        txt_diaChi = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_soHK = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        btn_thoat.setBackground(new java.awt.Color(65, 50, 122));
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_arrow_back_ios_new_white_24dp.png"))); // NOI18N
        btn_thoat.setBorder(null);
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        jPanel2.add(btn_thoat);
        btn_thoat.setBounds(20, 10, 100, 90);

        txt_soHK.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_soHK.setForeground(new java.awt.Color(65, 50, 122));
        txt_soHK.setBorder(null);
        txt_soHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soHKActionPerformed(evt);
            }
        });
        jPanel2.add(txt_soHK);
        txt_soHK.setBounds(280, 280, 410, 40);

        txt_tenChuHo.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_tenChuHo.setForeground(new java.awt.Color(65, 50, 122));
        txt_tenChuHo.setBorder(null);
        txt_tenChuHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenChuHoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_tenChuHo);
        txt_tenChuHo.setBounds(280, 370, 410, 40);

        txt_diaChi.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_diaChi.setForeground(new java.awt.Color(65, 50, 122));
        txt_diaChi.setBorder(null);
        jPanel2.add(txt_diaChi);
        txt_diaChi.setBounds(280, 460, 410, 40);

        btn_them.setBackground(new java.awt.Color(65, 50, 122));
        btn_them.setFont(new java.awt.Font("UTM God's Word", 0, 24)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm ");
        btn_them.setBorder(null);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel2.add(btn_them);
        btn_them.setBounds(220, 580, 170, 60);

        btn_xoa.setBackground(new java.awt.Color(65, 50, 122));
        btn_xoa.setFont(new java.awt.Font("UTM God's Word", 0, 24)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.setBorder(null);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_xoa);
        btn_xoa.setBounds(410, 580, 170, 60);

        btn_reset.setBackground(new java.awt.Color(65, 50, 122));
        btn_reset.setFont(new java.awt.Font("UTM God's Word", 0, 24)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.setBorder(null);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel2.add(btn_reset);
        btn_reset.setBounds(600, 580, 160, 60);

        jButton1.setBackground(new java.awt.Color(65, 50, 122));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_24dp.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(730, 810, 80, 60);

        txt_search.setFont(new java.awt.Font("UTM Times", 0, 36)); // NOI18N
        txt_search.setForeground(new java.awt.Color(65, 50, 122));
        txt_search.setBorder(null);
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel2.add(txt_search);
        txt_search.setBounds(220, 810, 470, 60);

        tbl_soHK.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_soHK.setForeground(new java.awt.Color(65, 50, 122));
        tbl_soHK.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_soHK.setCellSelectionEnabled(true);
        tbl_soHK.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_soHK.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbl_soHK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_soHKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_soHK);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(920, 220, 970, 720);

        jLabel1.setFont(new java.awt.Font("UVN Bai Sau", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 1QuanLiHoKhau.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 1900, 1000);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1912, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
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
    public boolean kiemTraSoHK(String soHK) {
        for (int i = 0; i < listSHK.size(); i++) {
            if (listSHK.get(i).getSoHoKhau().equals(soHK)) {
                return false;
            }
        }
        return true;
    }
    int index = -1;
    private void txt_tenChuHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenChuHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenChuHoActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void txt_soHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soHKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soHKActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        String soHK = txt_soHK.getText();
        String hoTen = txt_tenChuHo.getText();
        String diaChi = txt_diaChi.getText();
        
        if (soHK.equals("")) {
            JOptionPane.showMessageDialog(this, "Số hộ khẩu không được trống");
            return;
        } else if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên chủ hộ không được trống");
            return;
        } else if (diaChi.equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được trống");
            return;
        } else if (!kiemTraSoHK(soHK)) {
            JOptionPane.showMessageDialog(this, "Trùng số hộ khẩu");
            return;
        }
        if (!validate.khongChuaSo(hoTen)) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số!");
            return;
        }
        
        SoHoKhau shk = new SoHoKhau();
        shk.setSoHoKhau(soHK);
        shk.setHoTenChuHo(hoTen);
        shk.setDiaChi(diaChi);
        listSHK.add(shk);
        saveFile();
        getData(listSHK);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        reset();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        String soHK = txt_soHK.getText().trim();
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Xóa", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            if (listSHK.remove(shk)) {
                saveFile();
                getData(listSHK);
                
                loadFile2();
             
                for (int i = 0; i < listNK2.size(); i++) {
                    System.out.println("!!!!: "+listNK2.size());
                    if (listNK2.get(i).getSoHoKhau().equals(soHK)) {
                        System.out.println("***: "+listNK2.get(i).getMaNK());
                        listNK2.remove(i); 
                        i--;
                       
                    }
                }
              
                saveFile2();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
        reset();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_search.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listSHK);
        } else {
            ArrayList<SoHoKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listSHK.size(); i++) {
                if (listSHK.get(i).getSoHoKhau().equalsIgnoreCase(tuKhoa) || listSHK.get(i).getDiaChi().equalsIgnoreCase(tuKhoa)) {
                    
                    listTimKiem.add(listSHK.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void tbl_soHKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_soHKMouseClicked
        // TODO add your handling code here:
        btn_them.setEnabled(false);
        btn_xoa.setEnabled(true);
        txt_diaChi.setEnabled(false);
        txt_soHK.setEnabled(false);
        txt_tenChuHo.setEnabled(false);
        int row = tbl_soHK.getSelectedRow();
        String soHK = tbl_soHK.getValueAt(row, 0).toString();
        for (int i = 0; i < listSHK.size(); i++) {
            if (soHK.equalsIgnoreCase(listSHK.get(i).getSoHoKhau())) {
                shk = listSHK.get(i);
                index = i;
                break;
            }
        }
        txt_soHK.setText(shk.getSoHoKhau());
        txt_tenChuHo.setText(shk.getHoTenChuHo());
        txt_diaChi.setText(shk.getDiaChi());
    }//GEN-LAST:event_tbl_soHKMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        String tuKhoa = txt_search.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listSHK);
        } else {
            ArrayList<SoHoKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listSHK.size(); i++) {
                if (listSHK.get(i).getSoHoKhau().contains(tuKhoa) || listSHK.get(i).getDiaChi().contains(tuKhoa)) {
                    
                    listTimKiem.add(listSHK.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_txt_searchKeyReleased
                    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_soHK;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soHK;
    private javax.swing.JTextField txt_tenChuHo;
    // End of variables declaration//GEN-END:variables
}
