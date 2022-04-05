/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import static com.gr12.prj.view.QuanLiNhanKhau.listNK;
import static com.gr12.prj.view.QuanLiHoKhau.listSHK;
import com.gr12.prj.object.NhanKhau;
import com.gr12.prj.object.SoHoKhau;
import com.gr12.prj.utils.Validate_data;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author APC
 */
public class TachHoKhau extends javax.swing.JFrame {

    /**
     * Creates new form TachHoKhau
     */
    NhanKhau nk = new NhanKhau();
    ArrayList<NhanKhau> listNKMoi = new ArrayList<>();
    ArrayList<NhanKhau> listTimKiem = new ArrayList<>();
    static ArrayList<NhanKhau> listNK = new ArrayList<>();
    static ArrayList<SoHoKhau> listSHK = new ArrayList<>();

    private DefaultTableModel defaultTableModel;
    NumberFormat formater = new DecimalFormat("###,###");
    Validate_data validate = new Validate_data();
    public TachHoKhau() {
        //this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        setTitle("Tách Hộ Khẩu");
        loadFileNK();
        getDataNK(listNK);
        loadFileSHK();
        txt_maNK.setEnabled(false);
        txt_quanHe.setEnabled(false);
        txt_hoTen.setEnabled(false);

        btn_timKiem.setEnabled(false);
        txt_quanhevoichuho.setEnabled(false);
        txt_HOTENCHUHO.setEnabled(false);
        txt_hotenchuhocu.setEnabled(false);
        txt_DIACHI.setEnabled(false);
        txt_QUANHE.setEnabled(false);
        txt_SOHOKHAU.setEnabled(false);
        btn_luuchuho.setEnabled(false);
        btn_LUUQUANHE.setEnabled(false);
        btn_luuquanhe.setEnabled(false);
        btn_LUUSHK.setEnabled(false);
        btn_tachsanghomoi.setEnabled(false);
        btn_suathongtin12.setEnabled(false);
        btn_SUATHONGTIN.setEnabled(false);
        // tbl_nhanKhau.setEnabled(false);
    }
    public NhanKhau getNKByName(String name) {
        for (int i = 0; i < listNKMoi.size(); i++) {
            if (name.equals(listNKMoi.get(i).getHoTen())) {

                return listNKMoi.get(i);

            }
        }
        return null;
    }

    public void loadFileNK() {
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
    public void loadFileSHK() {
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
    /**
     * Creates new form frmBanHang
     */
    private void getDataNK(ArrayList<NhanKhau> listNK) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã nhân khẩu");
        defaultTableModel.addColumn("Số hộ khẩu");
        defaultTableModel.addColumn("Họ tên");
        // defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Sinh nhật");
        defaultTableModel.addColumn("Nơi sinh");
        // defaultTableModel.addColumn("Nguyên quán");
        defaultTableModel.addColumn("Dân tộc");
        defaultTableModel.addColumn("Nghê nghiệp");
        //defaultTableModel.addColumn("Nơi làm việc");
        defaultTableModel.addColumn("CMND");
        // defaultTableModel.addColumn("Ngày, nơi cấp CMND");
        //defaultTableModel.addColumn("Ngày ĐK thường trú");
        defaultTableModel.addColumn("Địa chỉ thường trú trước");
        defaultTableModel.addColumn("Quan hệ với chủ hộ");
        //defaultTableModel.addColumn("Ghi chú");

        for (NhanKhau obj : listNK) {
            Vector vector = new Vector();
            vector.add(obj.getMaNK());
            vector.add(obj.getSoHoKhau());
            vector.add(obj.getHoTen());
            //vector.add(obj.getGioiTinh());
            vector.add(obj.getSinhNhat());
            vector.add(obj.getNoiSinh());
            //vector.add(obj.getNguyenQuan());
            vector.add(obj.getDanToc());
            vector.add(obj.getNgheNghiep());
            //vector.add(obj.getNoiLamViec());
            vector.add(obj.getSoCMND());
            //vector.add(obj.getNgayNoiCapCMND());
            //vector.add(obj.getThoiGianDKThuongTru());
            vector.add(obj.getDiaChiTruoc());
            vector.add(obj.getQuanHeVoiChuHo());
            //vector.add(obj.getGhiChu());

            defaultTableModel.addRow(vector);
        }
        tbl_nhanKhau.setModel(defaultTableModel);
    }

    private void getDataNKMoi(ArrayList<NhanKhau> listNK) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã nhân khẩu");
        defaultTableModel.addColumn("Số hộ khẩu");
        defaultTableModel.addColumn("Họ tên");
        // defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Sinh nhật");
        defaultTableModel.addColumn("Nơi sinh");
        // defaultTableModel.addColumn("Nguyên quán");
        defaultTableModel.addColumn("Dân tộc");
        defaultTableModel.addColumn("Nghê nghiệp");
        //defaultTableModel.addColumn("Nơi làm việc");
        defaultTableModel.addColumn("CMND");
        // defaultTableModel.addColumn("Ngày, nơi cấp CMND");
        // defaultTableModel.addColumn("Ngày ĐK thường trú");
        defaultTableModel.addColumn("Địa chỉ thường trú trước");
        defaultTableModel.addColumn("Quan hệ với chủ hộ");
        //defaultTableModel.addColumn("Ghi chú");

        for (NhanKhau obj : listNK) {
            Vector vector = new Vector();
            vector.add(obj.getMaNK());
            vector.add(obj.getSoHoKhau());
            vector.add(obj.getHoTen());
            //vector.add(obj.getGioiTinh());
            vector.add(obj.getSinhNhat());
            vector.add(obj.getNoiSinh());
            //vector.add(obj.getNguyenQuan());
            vector.add(obj.getDanToc());
            vector.add(obj.getNgheNghiep());
            //vector.add(obj.getNoiLamViec());
            vector.add(obj.getSoCMND());
            //vector.add(obj.getNgayNoiCapCMND());
            //vector.add(obj.getThoiGianDKThuongTru());
            vector.add(obj.getDiaChiTruoc());
            vector.add(obj.getQuanHeVoiChuHo());
            //vector.add(obj.getGhiChu());

            defaultTableModel.addRow(vector);
        }
        tbl_NhanKhauMoi.setModel(defaultTableModel);
    }

    public void saveFileNK() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listNK.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listNK.get(i).getMaNK() + "\t";
                row = row + listNK.get(i).getSoHoKhau() + "\t";
                row = row + listNK.get(i).getHoTen() + "\t";
                row = row + listNK.get(i).getGioiTinh() + "\t";
                row = row + listNK.get(i).getSinhNhat() + "\t";
                row = row + listNK.get(i).getNoiSinh() + "\t";
                row = row + listNK.get(i).getNguyenQuan() + "\t";
                row = row + listNK.get(i).getDanToc() + "\t";
                row = row + listNK.get(i).getNgheNghiep() + "\t";
                row = row + listNK.get(i).getNoiLamViec() + "\t";
                row = row + listNK.get(i).getSoCMND() + "\t";
                row = row + listNK.get(i).getNgayNoiCapCMND() + "\t";
                row = row + listNK.get(i).getThoiGianDKThuongTru() + "\t";
                row = row + listNK.get(i).getDiaChiTruoc() + "\t";
                row = row + listNK.get(i).getQuanHeVoiChuHo() + "\t";
                row = row + listNK.get(i).getGhiChu() + "\n";

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

    public boolean kiemTraSoHK(String soHK) {
        for (int i = 0; i < listSHK.size(); i++) {
            if (listSHK.get(i).getSoHoKhau().equals(soHK)) {
                return false;
            }
        }
        return true;
    }

    public void saveFileSHK() {

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_timKiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_DIACHI = new javax.swing.JTextField();
        btn_LUUSHK = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_QUANHE = new javax.swing.JTextField();
        btn_LUUQUANHE = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_SOHOKHAU = new javax.swing.JTextField();
        txt_HOTENCHUHO = new javax.swing.JTextField();
        label_hoTenNKDangSua = new javax.swing.JLabel();
        btn_thoat1 = new javax.swing.JButton();
        txt_timKiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_hotenchuhocu = new javax.swing.JTextField();
        btn_luuchuho = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_luuquanhe = new javax.swing.JButton();
        label_hoTenNKCu = new javax.swing.JLabel();
        txt_quanhevoichuho = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanKhauMoi = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_nhanKhau = new javax.swing.JTable();
        btn_tachsanghomoi = new javax.swing.JButton();
        txt_maNK = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        txt_quanHe = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btn_SUATHONGTIN = new javax.swing.JButton();
        btn_suathongtin12 = new javax.swing.JButton();
        doc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        btn_timKiem.setBackground(new java.awt.Color(65, 50, 122));
        btn_timKiem.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp_1.png"))); // NOI18N
        btn_timKiem.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiem);
        btn_timKiem.setBounds(650, 80, 30, 30);

        jLabel2.setFont(new java.awt.Font("UTM Flamenco", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(65, 50, 122));
        jLabel2.setText("Hộ khẩu sau tách");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1030, 10, 430, 60);

        jLabel1.setFont(new java.awt.Font("UVN Lac Long Quan", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(65, 50, 122));
        jLabel1.setText("Chỉnh sửa thông tin bên hộ mới tách ra");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1030, 600, 440, 40);

        jLabel4.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(140, 123, 185));
        jLabel4.setText("Tìm kiếm theo số hộ khẩu");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(230, 70, 300, 50);

        jLabel15.setFont(new java.awt.Font("UVN Lac Long Quan", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(65, 50, 122));
        jLabel15.setText("Chỉnh sửa thông tin bên hộ cũ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(50, 670, 330, 40);

        jPanel2.setBackground(new java.awt.Color(184, 173, 247));

        jLabel5.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Những nhân khẩu tách ra");

        txt_DIACHI.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_DIACHI.setForeground(new java.awt.Color(65, 50, 122));
        txt_DIACHI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        btn_LUUSHK.setBackground(new java.awt.Color(65, 50, 122));
        btn_LUUSHK.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_LUUSHK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_get_app_white_24dp.png"))); // NOI18N
        btn_LUUSHK.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_LUUSHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LUUSHKActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Họ tên");

        jLabel7.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quan hệ với chủ hộ");

        jLabel8.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("số hộ khẩu mới");

        txt_QUANHE.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_QUANHE.setForeground(new java.awt.Color(65, 50, 122));
        txt_QUANHE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        btn_LUUQUANHE.setBackground(new java.awt.Color(65, 50, 122));
        btn_LUUQUANHE.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_LUUQUANHE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_get_app_white_24dp.png"))); // NOI18N
        btn_LUUQUANHE.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_LUUQUANHE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LUUQUANHEActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Chủ hộ mới");

        jLabel18.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Địa chỉ mới");

        txt_SOHOKHAU.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_SOHOKHAU.setForeground(new java.awt.Color(65, 50, 122));
        txt_SOHOKHAU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        txt_HOTENCHUHO.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_HOTENCHUHO.setForeground(new java.awt.Color(65, 50, 122));
        txt_HOTENCHUHO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        label_hoTenNKDangSua.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        label_hoTenNKDangSua.setForeground(new java.awt.Color(0, 51, 0));
        label_hoTenNKDangSua.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_DIACHI, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SOHOKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_HOTENCHUHO, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LUUSHK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_hoTenNKDangSua, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(txt_QUANHE, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_LUUQUANHE, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SOHOKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_HOTENCHUHO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_DIACHI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_LUUSHK)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_hoTenNKDangSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_QUANHE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(btn_LUUQUANHE, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68))))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(1010, 660, 810, 310);

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

        txt_timKiem.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_timKiem.setForeground(new java.awt.Color(65, 50, 122));
        txt_timKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });
        jPanel1.add(txt_timKiem);
        txt_timKiem.setBounds(550, 80, 90, 30);

        jPanel3.setBackground(new java.awt.Color(184, 173, 247));

        jLabel10.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Những nhân khẩu còn lại");

        jLabel9.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Chủ hộ");

        txt_hotenchuhocu.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_hotenchuhocu.setForeground(new java.awt.Color(65, 50, 122));
        txt_hotenchuhocu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        btn_luuchuho.setBackground(new java.awt.Color(65, 50, 122));
        btn_luuchuho.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_luuchuho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_get_app_white_24dp.png"))); // NOI18N
        btn_luuchuho.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_luuchuho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuchuhoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Họ tên");

        jLabel13.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Họ tên");

        btn_luuquanhe.setBackground(new java.awt.Color(65, 50, 122));
        btn_luuquanhe.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_luuquanhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_get_app_white_24dp.png"))); // NOI18N
        btn_luuquanhe.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_luuquanhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuquanheActionPerformed(evt);
            }
        });

        label_hoTenNKCu.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        label_hoTenNKCu.setForeground(new java.awt.Color(51, 51, 0));
        label_hoTenNKCu.setText("...");

        txt_quanhevoichuho.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_quanhevoichuho.setForeground(new java.awt.Color(65, 50, 122));
        txt_quanhevoichuho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        jLabel21.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Quan hệ với chủ hộ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_hotenchuhocu, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_luuchuho, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_hoTenNKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(txt_quanhevoichuho, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btn_luuquanhe, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txt_hotenchuhocu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_hoTenNKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_luuquanhe)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_quanhevoichuho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_luuchuho))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(50, 720, 810, 250);

        jLabel14.setFont(new java.awt.Font("UTM Flamenco", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(65, 50, 122));
        jLabel14.setText("Hộ khẩu cần tách");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(300, 10, 400, 50);

        tbl_NhanKhauMoi.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_NhanKhauMoi.setForeground(new java.awt.Color(65, 50, 122));
        tbl_NhanKhauMoi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_NhanKhauMoi.setCellSelectionEnabled(true);
        tbl_NhanKhauMoi.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_NhanKhauMoi.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbl_NhanKhauMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanKhauMoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanKhauMoi);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(1010, 230, 840, 320);

        tbl_nhanKhau.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_nhanKhau.setForeground(new java.awt.Color(65, 50, 122));
        tbl_nhanKhau.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_nhanKhau.setCellSelectionEnabled(true);
        tbl_nhanKhau.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_nhanKhau.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbl_nhanKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanKhauMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_nhanKhau);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 240, 880, 370);

        btn_tachsanghomoi.setBackground(new java.awt.Color(65, 50, 122));
        btn_tachsanghomoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_tachsanghomoi.setForeground(new java.awt.Color(255, 0, 204));
        btn_tachsanghomoi.setText("Tách sang hộ mới");
        btn_tachsanghomoi.setBorder(null);
        btn_tachsanghomoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tachsanghomoiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tachsanghomoi);
        btn_tachsanghomoi.setBounds(690, 630, 220, 40);

        txt_maNK.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_maNK.setForeground(new java.awt.Color(65, 50, 122));
        txt_maNK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_maNK);
        txt_maNK.setBounds(130, 170, 190, 26);

        jLabel12.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(140, 123, 185));
        jLabel12.setText("Mã Nhân Khẩu");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(140, 130, 170, 30);

        jLabel19.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(140, 123, 185));
        jLabel19.setText("Họ tên");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(380, 130, 100, 30);

        txt_hoTen.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_hoTen.setForeground(new java.awt.Color(65, 50, 122));
        txt_hoTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_hoTen);
        txt_hoTen.setBounds(380, 170, 190, 26);

        txt_quanHe.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_quanHe.setForeground(new java.awt.Color(65, 50, 122));
        txt_quanHe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_quanHe);
        txt_quanHe.setBounds(660, 170, 190, 26);

        jLabel20.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(140, 123, 185));
        jLabel20.setText("Quan hệ với chủ hộ");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(650, 130, 230, 30);

        btn_SUATHONGTIN.setBackground(new java.awt.Color(65, 50, 122));
        btn_SUATHONGTIN.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_SUATHONGTIN.setForeground(new java.awt.Color(0, 204, 102));
        btn_SUATHONGTIN.setText("Chỉnh sửa thông tin hộ mới");
        btn_SUATHONGTIN.setBorder(null);
        btn_SUATHONGTIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SUATHONGTINActionPerformed(evt);
            }
        });
        jPanel1.add(btn_SUATHONGTIN);
        btn_SUATHONGTIN.setBounds(1570, 590, 250, 45);

        btn_suathongtin12.setBackground(new java.awt.Color(65, 50, 122));
        btn_suathongtin12.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_suathongtin12.setForeground(new java.awt.Color(255, 0, 51));
        btn_suathongtin12.setText("Chỉnh sửa thông tin hộ cũ");
        btn_suathongtin12.setBorder(null);
        btn_suathongtin12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suathongtin12ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_suathongtin12);
        btn_suathongtin12.setBounds(360, 630, 250, 40);

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

    String maNK1 = "";
    NhanKhau nk1 = new NhanKhau();

    public ArrayList ham() {
        ArrayList<NhanKhau> listTimKiemFULL = new ArrayList<>();
        // ArrayList<NhanKhau> listTimKiem = new ArrayList<>();
        String tuKhoa = txt_timKiem.getText().trim();
        if (tuKhoa.equals("")) {
            // getDataNK(listNK);
        } else {

            for (int i = 0; i < listNK.size(); i++) {
                if (listNK.get(i).getSoHoKhau().contains(tuKhoa)) {

                    listTimKiemFULL.add(listNK.get(i));
                }
            }
            // getDataNK(listTimKiem);
        }

        return listTimKiemFULL;
    }
    public boolean kiemTraTenChuHoMoi(String s) {
        for (int i = 0; i < listNKMoi.size(); i++) {
            if (listNKMoi.get(i).getHoTen().equals(s)) {
                return true;
            }
        }
        return false;
    }
    int viTriNK;

    public NhanKhau getNKByCode(ArrayList<NhanKhau> arr, String maNK) {

        for (int i = 0; i < arr.size(); i++) {
            if (maNK.equals(arr.get(i).getMaNK())) {
                viTriNK = i;
                return arr.get(i);
            }
        }
        return null;
    }
    int viTriNKMOI;

    public NhanKhau getNKMoiByCode(String maNK) {
        for (int i = 0; i < listNK.size(); i++) {
            if (maNK.equals(listNK.get(i).getMaNK())) {
                viTriNKMOI = i;
                return listNK.get(i);
            }
        }
        return null;
    }
    int viTriSHK;

    public SoHoKhau getSHKByCode(String maSHK) {
        loadFileSHK();
        ArrayList<SoHoKhau> arrayList = listSHK;
        for (int i = 0; i < arrayList.size(); i++) {
            if (maSHK.equals(arrayList.get(i).getSoHoKhau())) {
                viTriSHK = i;
                return arrayList.get(i);
            }
        }
        return null;
    }
    private void btn_LUUSHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LUUSHKActionPerformed
        // TODO add your handling code here:
         txt_HOTENCHUHO.setEnabled(false);
        txt_DIACHI.setEnabled(false);
        txt_SOHOKHAU.setEnabled(false);
        btn_LUUSHK.setEnabled(false);

        txt_QUANHE.setEnabled(true);
        btn_LUUQUANHE.setEnabled(true);
        String soHK = txt_SOHOKHAU.getText().trim();
        String hoTen = txt_HOTENCHUHO.getText().trim();
        String diaChi = txt_DIACHI.getText().trim();

        if (soHK.equals("")) {
            JOptionPane.showMessageDialog(this, "Số hộ khẩu không được trống");
            txt_HOTENCHUHO.setEnabled(true);
            txt_DIACHI.setEnabled(true);
            txt_SOHOKHAU.setEnabled(true);
            btn_LUUSHK.setEnabled(true);
            txt_QUANHE.setEnabled(false);
            btn_LUUQUANHE.setEnabled(false);
            return;
        } else if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên chủ hộ không được trống");
            txt_HOTENCHUHO.setEnabled(true);
            txt_DIACHI.setEnabled(true);
            txt_SOHOKHAU.setEnabled(true);
            btn_LUUSHK.setEnabled(true);
            btn_LUUQUANHE.setEnabled(false);
            txt_QUANHE.setEnabled(false);
            return;
        } else if (diaChi.equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được trống");
            txt_HOTENCHUHO.setEnabled(true);
            txt_DIACHI.setEnabled(true);
            txt_SOHOKHAU.setEnabled(true);
            btn_LUUSHK.setEnabled(true);
            btn_LUUQUANHE.setEnabled(false);
            txt_QUANHE.setEnabled(false);
            return;
        } else if (!kiemTraSoHK(soHK)) {
            JOptionPane.showMessageDialog(this, "Trùng số hộ khẩu");
            txt_HOTENCHUHO.setEnabled(true);
            txt_DIACHI.setEnabled(true);
            txt_SOHOKHAU.setEnabled(true);
            btn_LUUSHK.setEnabled(true);
            txt_QUANHE.setEnabled(false);
            btn_LUUQUANHE.setEnabled(false);
            return;
        }
        if (!validate.khongChuaSo(hoTen)) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số!");
            txt_HOTENCHUHO.setEnabled(true);
            txt_DIACHI.setEnabled(true);
            txt_SOHOKHAU.setEnabled(true);
            btn_LUUSHK.setEnabled(true);
            txt_QUANHE.setEnabled(false);
            btn_LUUQUANHE.setEnabled(false);
            return;
        }
        if (!kiemTraTenChuHoMoi(hoTen)) {
            JOptionPane.showMessageDialog(this, "Không tồn tại tên này trong những nhân khẩu ở hộ mới.");
            txt_HOTENCHUHO.setEnabled(true);
            txt_DIACHI.setEnabled(true);
            txt_SOHOKHAU.setEnabled(true);
            btn_LUUSHK.setEnabled(true);
            txt_QUANHE.setEnabled(false);
            btn_LUUQUANHE.setEnabled(false);

            return;
        }

        SoHoKhau shk = new SoHoKhau();
        shk.setSoHoKhau(soHK);
        shk.setHoTenChuHo(hoTen);
        shk.setDiaChi(diaChi);
        listSHK.add(shk);
        saveFileSHK();

        JOptionPane.showMessageDialog(this, "Lưu hộ khẩu mới thành công");
        btn_LUUSHK.setEnabled(false);
        txt_SOHOKHAU.setEnabled(false);
        txt_DIACHI.setEnabled(false);
        txt_HOTENCHUHO.setEnabled(false);
        String ma = nksua.getMaNK();
        if (nksua.getHoTen().equals(txt_HOTENCHUHO.getText().trim())) {
            
            nksua = getNKByCode(listNK, ma);
            nksua.setQuanHeVoiChuHo("chủ hộ");
            nksua.setSoHoKhau(txt_SOHOKHAU.getText().trim());
            nksua.setDiaChiTruoc("Tách hộ");
            listNK.set(viTriNK, nksua);
            saveFileNK();
            NhanKhau nkPhai = getNKByCode(listNKMoi, nksua.getMaNK());
            nkPhai.setQuanHeVoiChuHo("chủ hộ");
            nkPhai.setSoHoKhau(txt_SOHOKHAU.getText().trim());
            nkPhai.setDiaChiTruoc("Tách hộ");
            listNKMoi.set(viTriNK, nkPhai);
        }

        getDataNKMoi(listNKMoi);
    }//GEN-LAST:event_btn_LUUSHKActionPerformed

    private void btn_thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoat1ActionPerformed

    private void btn_LUUQUANHEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LUUQUANHEActionPerformed
        // TODO add your handling code here:
        String quanHe = txt_QUANHE.getText().trim();
        if (quanHe.equals("")) {
            JOptionPane.showMessageDialog(this, "Quan hệ với chủ hộ không được để trống");
            return;
        }
        String ma = nksua.getMaNK();
        if (!nksua.getHoTen().equals(txt_HOTENCHUHO.getText().trim())) {
            System.out.println("***" + nksua.getMaNK());
            
            nksua = getNKByCode(listNK, ma);
            nksua.setQuanHeVoiChuHo(quanHe);
            nksua.setSoHoKhau(txt_SOHOKHAU.getText().trim());
            nksua.setDiaChiTruoc("Tách hộ");
            
            listNK.set(viTriNK, nksua);
            saveFileNK();
            
            JOptionPane.showMessageDialog(this, "Lưu nhân khẩu mới ở hộ khẩu được tách ra thành công");
            getDataNKMoi(listNKMoi);
        } else {
            //nk.setQuanHeVoiChuHo("chủ hộ");
            JOptionPane.showMessageDialog(this, "Đây là chủ hộ, đã lưu. Hãy thiết lập cho nhân khẩu khác");
        }

        txt_QUANHE.setText("");
        label_hoTenNKDangSua.setText("...");
    }//GEN-LAST:event_btn_LUUQUANHEActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
        txt_quanhevoichuho.setEnabled(false);
        txt_HOTENCHUHO.setEnabled(false);
        txt_hotenchuhocu.setEnabled(false);
        txt_DIACHI.setEnabled(false);
        txt_QUANHE.setEnabled(false);
        txt_SOHOKHAU.setEnabled(false);
        btn_luuchuho.setEnabled(false);
        btn_LUUQUANHE.setEnabled(false);
        btn_luuquanhe.setEnabled(false);
        btn_LUUSHK.setEnabled(false);
        btn_tachsanghomoi.setEnabled(false);
        btn_suathongtin12.setEnabled(false);
        btn_SUATHONGTIN.setEnabled(false);
        txt_timKiem.setEnabled(false);
        String tuKhoa = txt_timKiem.getText().trim();

        ArrayList<NhanKhau> listTimKiemFULL = new ArrayList<>();
        for (int i = 0; i < listNK.size(); i++) {
            if (listNK.get(i).getSoHoKhau().equals(tuKhoa)) {

                listTimKiemFULL.add(listNK.get(i));
            }
        }

        listTimKiem = listTimKiemFULL;
        getDataNK(listTimKiem);

        System.out.println("khi nhấn nút tìm: " + listTimKiem.size());
    }//GEN-LAST:event_btn_timKiemActionPerformed
    public boolean kiemTraTenChuHoCU(String s) {
        // ArrayList<NhanKhau> listTimKiem = ham();
        System.out.println("size Ho Cu: " + listTimKiem.size());
        for (int i = 0; i < listTimKiem.size(); i++) {
            if (listTimKiem.get(i).getHoTen().equals(s)) {
                return true;
            }

        }

        return false;
    }
    private void btn_luuchuhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuchuhoActionPerformed
        // TODO add your handling code here:
        txt_hotenchuhocu.setEnabled(false);
        btn_luuchuho.setEnabled(false);
        txt_quanhevoichuho.setEnabled(true);
        btn_luuquanhe.setEnabled(true);
        String hoTen = txt_hotenchuhocu.getText().trim();

        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên chủ hộ không được trống");
            return;
        }
        if (!validate.khongChuaSo(hoTen)) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số!");
            return;
        }
        if (!kiemTraTenChuHoCU(hoTen)) {
            JOptionPane.showMessageDialog(this, "Không tồn tại người này trong hộ");
            txt_hotenchuhocu.setEnabled(true);
            btn_luuchuho.setEnabled(true);
            txt_quanhevoichuho.setEnabled(false);
            btn_luuquanhe.setEnabled(false);
            return;
        }
        JOptionPane.showMessageDialog(this, "Lưu chủ hộ mới thành công");

//        NhanKhau nk1 = getNKByCode(maNK1);
        SoHoKhau shk = getSHKByCode(nk.getSoHoKhau());
        shk.setHoTenChuHo(hoTen);
        listSHK.set(viTriSHK, shk);
        saveFileSHK();
        String ma = nk.getMaNK();
        NhanKhau nkTrai = getNKByCode(listTimKiem, nk.getMaNK());
        if (nk.getHoTen().equals(hoTen)) {
            nkTrai.setQuanHeVoiChuHo("chủ hộ");
            listTimKiem.set(viTriNK, nkTrai);

            nk = getNKByCode(listNK, ma);
            nk.setQuanHeVoiChuHo("chủ hộ");
            listNK.set(viTriNK, nk);
            saveFileNK();

        }
        getDataNK(listTimKiem);
        btn_luuchuho.setEnabled(false);
        txt_hotenchuhocu.setEnabled(false);
        System.out.println("OK? " + nkTrai.getMaNK());
    }//GEN-LAST:event_btn_luuchuhoActionPerformed

    private void btn_luuquanheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuquanheActionPerformed
        // TODO add your handling code here:
        String quanHe = txt_quanhevoichuho.getText().trim();
        if (quanHe.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập quan hệ với chủ hộ");
            return;
        }
        String ma = nk.getMaNK();
        // String tenThayDoiQH = label_hoTenNKCu.getText().trim();
        if (!nk.getHoTen().equals(txt_hotenchuhocu.getText().trim())) {
            System.out.println("***" + nk.getMaNK());

            nk = getNKByCode(listNK, ma);
            nk.setQuanHeVoiChuHo(quanHe);
            listNK.set(viTriNK, nk);
            saveFileNK();

            JOptionPane.showMessageDialog(this, "Lưu quan hệ mới ở hộ cũ thành công");
            getDataNK(listTimKiem);
        } else {
            //nk.setQuanHeVoiChuHo("chủ hộ");
            JOptionPane.showMessageDialog(this, "Đây là chủ hộ, đã lưu. Hãy thiết lập cho nhân khẩu khác");
        }

        txt_QUANHE.setText("");
        label_hoTenNKDangSua.setText("...");
        txt_quanhevoichuho.setText("");
        btn_luuquanhe.setEnabled(false);
        txt_quanhevoichuho.setEnabled(false);
    }//GEN-LAST:event_btn_luuquanheActionPerformed

    private void btn_suathongtin12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suathongtin12ActionPerformed
        // TODO add your handling code here:
        System.out.println("họ tên chủ hộ cũ: " + txt_hotenchuhocu.getText().trim());
        if (txt_hotenchuhocu.getText().trim().equals("")) {
            txt_hotenchuhocu.setEnabled(true);
            btn_luuchuho.setEnabled(true);
            txt_quanhevoichuho.setEnabled(false);
            btn_luuquanhe.setEnabled(false);
        } else {
            txt_hotenchuhocu.setEnabled(false);
            btn_luuchuho.setEnabled(false);
            txt_quanhevoichuho.setEnabled(true);
            btn_luuquanhe.setEnabled(true);

        }

        label_hoTenNKCu.setText(nk.getHoTen());
    }//GEN-LAST:event_btn_suathongtin12ActionPerformed

    private void btn_SUATHONGTINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SUATHONGTINActionPerformed
        // TODO add your handling code here:
        if (txt_SOHOKHAU.getText().trim().equals("")) {
            txt_HOTENCHUHO.setEnabled(true);
            txt_DIACHI.setEnabled(true);
            txt_SOHOKHAU.setEnabled(true);
            btn_LUUSHK.setEnabled(true);
            btn_LUUQUANHE.setEnabled(false);
            txt_QUANHE.setEnabled(false);
        } else {
            txt_HOTENCHUHO.setEnabled(false);
            txt_DIACHI.setEnabled(false);
            txt_SOHOKHAU.setEnabled(false);
            btn_LUUSHK.setEnabled(false);
            btn_LUUQUANHE.setEnabled(true);
            txt_QUANHE.setEnabled(true);
        }
    }//GEN-LAST:event_btn_SUATHONGTINActionPerformed

    private void btn_tachsanghomoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tachsanghomoiActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn tách không? Hay kiểm tra kỹ thông tin!", "Tách", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            listNKMoi.add(nk);
            getDataNKMoi(listNKMoi);
            getDataNK(listTimKiem);
            JOptionPane.showMessageDialog(this, "Hãy sang bảng bên phải chỉnh sửa thông tin");
            listTimKiem.remove(viTriNK);
            System.out.println(nk.getMaNK());
            System.out.println("TK~~~");
            for (int i = 0; i < listTimKiem.size(); i++) {
                System.out.println(listTimKiem.get(i).getMaNK());
            }
            System.out.println("3ListTIMKiem.size = " + listTimKiem.size());
            //listTimKiem=ham2();
            getDataNK(listTimKiem);

        }
//        ArrayList<NhanKhau> listTimKiem = ham();
//        getDataNK(listTimKiem);
    }//GEN-LAST:event_btn_tachsanghomoiActionPerformed

    private void tbl_nhanKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanKhauMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
        btn_suathongtin12.setEnabled(true);
        btn_tachsanghomoi.setEnabled(true);
        int row = tbl_nhanKhau.getSelectedRow();
        String maNK = tbl_nhanKhau.getValueAt(row, 0).toString();
        maNK1 = maNK;
        String tenNK = tbl_nhanKhau.getValueAt(row, 2).toString();
        nk = getNKByCode(listTimKiem, maNK);
        txt_maNK.setText(nk.getMaNK());
        txt_hoTen.setText(nk.getHoTen());
        txt_quanHe.setText(nk.getQuanHeVoiChuHo());

        getDataNK(listTimKiem);
    }//GEN-LAST:event_tbl_nhanKhauMouseClicked
    NhanKhau nksua = new NhanKhau();
    private void tbl_NhanKhauMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanKhauMoiMouseClicked
        // TODO add your handling code here:
        int row = tbl_NhanKhauMoi.getSelectedRow();
        String maNK = tbl_NhanKhauMoi.getValueAt(row, 0).toString();
        nksua = getNKMoiByCode(maNK);
        String tenNK = tbl_NhanKhauMoi.getValueAt(row, 2).toString();
        // NhanKhau nk = new NhanKhau();
        for (int i = 0; i < listNKMoi.size(); i++) {
            if (tenNK.equals(listNKMoi.get(i).getHoTen())) {
                // listNKMoi.get(i).setQuanHeVoiChuHo("chủ hộ");
                label_hoTenNKDangSua.setText(listNKMoi.get(i).getHoTen());
                break;
            }
        }
        btn_SUATHONGTIN.setEnabled(true);
    }//GEN-LAST:event_tbl_NhanKhauMoiMouseClicked

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased
        // TODO add your handling code here:
        btn_timKiem.setEnabled(true);
        String tuKhoa = txt_timKiem.getText().trim();
        ArrayList<NhanKhau> listTimKiemFULL = new ArrayList<>();
        listTimKiemFULL = ham();
        System.out.println("!!!!!: " + listTimKiemFULL.size());
        if (tuKhoa.equals("")) {
            getDataNK(listNK);
        } else {
            listTimKiemFULL.remove(listNKMoi);
            getDataNK(listTimKiemFULL);
        }
    }//GEN-LAST:event_txt_timKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LUUQUANHE;
    private javax.swing.JButton btn_LUUSHK;
    private javax.swing.JButton btn_SUATHONGTIN;
    private javax.swing.JButton btn_luuchuho;
    private javax.swing.JButton btn_luuquanhe;
    private javax.swing.JButton btn_suathongtin12;
    private javax.swing.JButton btn_tachsanghomoi;
    private javax.swing.JButton btn_thoat1;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JLabel doc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_hoTenNKCu;
    private javax.swing.JLabel label_hoTenNKDangSua;
    private javax.swing.JTable tbl_NhanKhauMoi;
    private javax.swing.JTable tbl_nhanKhau;
    private javax.swing.JTextField txt_DIACHI;
    private javax.swing.JTextField txt_HOTENCHUHO;
    private javax.swing.JTextField txt_QUANHE;
    private javax.swing.JTextField txt_SOHOKHAU;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_hotenchuhocu;
    private javax.swing.JTextField txt_maNK;
    private javax.swing.JTextField txt_quanHe;
    private javax.swing.JTextField txt_quanhevoichuho;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
