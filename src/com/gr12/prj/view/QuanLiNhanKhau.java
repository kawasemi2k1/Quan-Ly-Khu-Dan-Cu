/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.gr12.prj.view.QuanLiHoKhau.listSHK;

/**
 *
 * @author APC
 */
public class QuanLiNhanKhau extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    NhanKhau nk = new NhanKhau();
    static ArrayList<NhanKhau> listNK = new ArrayList<>();
    SoHoKhau shk = new SoHoKhau();
    ArrayList<SoHoKhau> listSHK2 = new ArrayList<>();
    Validate_data validate = new Validate_data();
    public QuanLiNhanKhau() {
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
        loadFile2();
        getData(listNK);
        btn_luu.setEnabled(false);
        txt_maNK.setEnabled(false);
        btn_daQuaDoi.setEnabled(false);
        btn_xoa.setEnabled(false);
        btn_sua.setEnabled(false);
    }
    public void saveFile() {

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
        defaultTableModel.addColumn("Nghề nghiệp");
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
        tbl_NhanKhau.setModel(defaultTableModel);
    }
    
    
    public void saveFile2() {
        
        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listSHK2.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listSHK2.get(i).getSoHoKhau() + "\t";
                row = row + listSHK2.get(i).getHoTenChuHo() + "\t";
                row = row + listSHK2.get(i).getDiaChi() + "\n";                
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
    
    public void loadFile2() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listSHK2 = new ArrayList<>(); //lưu ý
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
                    listSHK2.add(nv);
                }
            } catch (IOException ex) {
                //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
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
        btn_thoat = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_daQuaDoi = new javax.swing.JButton();
        btn_timKiemTheoSHK = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        txt_danToc = new javax.swing.JTextField();
        txt_soHoKhau = new javax.swing.JTextField();
        txt_maNK = new javax.swing.JTextField();
        txt_ngheNghiep = new javax.swing.JTextField();
        txt_noiLamViec = new javax.swing.JTextField();
        txt_noiSinh = new javax.swing.JTextField();
        txt_QuanHeVoiChuHo = new javax.swing.JTextField();
        txt_noiChuyenDi = new javax.swing.JTextField();
        txt_ngayCapVaNoiCap = new javax.swing.JTextField();
        txt_diaChiThuongTruTruocKhiDen = new javax.swing.JTextField();
        txt_GhiChu = new javax.swing.JTextField();
        txt_hoTen = new javax.swing.JTextField();
        txt_tuKhoaSoHoKhau = new javax.swing.JTextField();
        txt_CMND = new javax.swing.JTextField();
        txt_gioiTinh = new javax.swing.JComboBox<>();
        date_Chuyendi = new com.toedter.calendar.JDateChooser();
        date_sinhNhat = new com.toedter.calendar.JDateChooser();
        date_DK = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanKhau = new javax.swing.JTable();
        txt_nguyenQuan = new javax.swing.JTextField();
        doc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btn_thoat.setBackground(new java.awt.Color(255, 0, 102));
        btn_thoat.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_arrow_back_ios_new_white_24dp.png"))); // NOI18N
        btn_thoat.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        jPanel1.add(btn_thoat);
        btn_thoat.setBounds(20, 10, 100, 90);

        btn_them.setBackground(new java.awt.Color(204, 153, 0));
        btn_them.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");
        btn_them.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them);
        btn_them.setBounds(160, 160, 80, 50);

        btn_sua.setBackground(new java.awt.Color(65, 50, 122));
        btn_sua.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Sửa");
        btn_sua.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua);
        btn_sua.setBounds(160, 220, 80, 50);

        btn_xoa.setBackground(new java.awt.Color(65, 50, 122));
        btn_xoa.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa);
        btn_xoa.setBounds(160, 280, 80, 50);

        btn_reset.setBackground(new java.awt.Color(65, 50, 122));
        btn_reset.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset);
        btn_reset.setBounds(160, 340, 80, 50);

        btn_daQuaDoi.setBackground(new java.awt.Color(65, 50, 122));
        btn_daQuaDoi.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_daQuaDoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_daQuaDoi.setText("Qua đời");
        btn_daQuaDoi.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_daQuaDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daQuaDoiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_daQuaDoi);
        btn_daQuaDoi.setBounds(160, 400, 80, 50);

        btn_timKiemTheoSHK.setBackground(new java.awt.Color(65, 50, 122));
        btn_timKiemTheoSHK.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_timKiemTheoSHK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp.png"))); // NOI18N
        btn_timKiemTheoSHK.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_timKiemTheoSHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemTheoSHKActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiemTheoSHK);
        btn_timKiemTheoSHK.setBounds(660, 500, 50, 50);

        btn_luu.setBackground(new java.awt.Color(65, 50, 122));
        btn_luu.setFont(new java.awt.Font("UTM God's Word", 0, 24)); // NOI18N
        btn_luu.setForeground(new java.awt.Color(255, 255, 255));
        btn_luu.setText("Lưu");
        btn_luu.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });
        jPanel1.add(btn_luu);
        btn_luu.setBounds(1610, 380, 150, 50);

        txt_danToc.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_danToc.setForeground(new java.awt.Color(65, 50, 122));
        txt_danToc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_danToc);
        txt_danToc.setBounds(470, 370, 220, 25);

        txt_soHoKhau.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_soHoKhau.setForeground(new java.awt.Color(65, 50, 122));
        txt_soHoKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_soHoKhau);
        txt_soHoKhau.setBounds(470, 150, 220, 25);

        txt_maNK.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_maNK.setForeground(new java.awt.Color(65, 50, 122));
        txt_maNK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_maNK);
        txt_maNK.setBounds(1120, 150, 220, 25);

        txt_ngheNghiep.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_ngheNghiep.setForeground(new java.awt.Color(65, 50, 122));
        txt_ngheNghiep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_ngheNghiep);
        txt_ngheNghiep.setBounds(470, 410, 220, 25);

        txt_noiLamViec.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_noiLamViec.setForeground(new java.awt.Color(65, 50, 122));
        txt_noiLamViec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_noiLamViec);
        txt_noiLamViec.setBounds(470, 450, 220, 25);

        txt_noiSinh.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_noiSinh.setForeground(new java.awt.Color(65, 50, 122));
        txt_noiSinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_noiSinh);
        txt_noiSinh.setBounds(470, 320, 220, 25);

        txt_QuanHeVoiChuHo.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_QuanHeVoiChuHo.setForeground(new java.awt.Color(65, 50, 122));
        txt_QuanHeVoiChuHo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_QuanHeVoiChuHo);
        txt_QuanHeVoiChuHo.setBounds(1120, 240, 220, 25);

        txt_noiChuyenDi.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_noiChuyenDi.setForeground(new java.awt.Color(65, 50, 122));
        txt_noiChuyenDi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_noiChuyenDi);
        txt_noiChuyenDi.setBounds(1650, 300, 200, 25);

        txt_ngayCapVaNoiCap.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_ngayCapVaNoiCap.setForeground(new java.awt.Color(65, 50, 122));
        txt_ngayCapVaNoiCap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_ngayCapVaNoiCap);
        txt_ngayCapVaNoiCap.setBounds(1120, 320, 220, 25);

        txt_diaChiThuongTruTruocKhiDen.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_diaChiThuongTruTruocKhiDen.setForeground(new java.awt.Color(65, 50, 122));
        txt_diaChiThuongTruTruocKhiDen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_diaChiThuongTruTruocKhiDen);
        txt_diaChiThuongTruTruocKhiDen.setBounds(1120, 410, 220, 25);

        txt_GhiChu.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_GhiChu.setForeground(new java.awt.Color(65, 50, 122));
        txt_GhiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_GhiChu);
        txt_GhiChu.setBounds(1120, 450, 220, 25);

        txt_hoTen.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_hoTen.setForeground(new java.awt.Color(65, 50, 122));
        txt_hoTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_hoTen);
        txt_hoTen.setBounds(470, 240, 220, 25);

        txt_tuKhoaSoHoKhau.setFont(new java.awt.Font("UTM Times", 0, 36)); // NOI18N
        txt_tuKhoaSoHoKhau.setForeground(new java.awt.Color(65, 50, 122));
        txt_tuKhoaSoHoKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 122, 185)));
        txt_tuKhoaSoHoKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tuKhoaSoHoKhauKeyReleased(evt);
            }
        });
        jPanel1.add(txt_tuKhoaSoHoKhau);
        txt_tuKhoaSoHoKhau.setBounds(310, 500, 320, 50);

        txt_CMND.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_CMND.setForeground(new java.awt.Color(65, 50, 122));
        txt_CMND.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_CMND);
        txt_CMND.setBounds(1120, 280, 220, 25);

        txt_gioiTinh.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_gioiTinh.setForeground(new java.awt.Color(65, 50, 122));
        txt_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        txt_gioiTinh.setAutoscrolls(true);
        txt_gioiTinh.setBorder(null);
        jPanel1.add(txt_gioiTinh);
        txt_gioiTinh.setBounds(470, 190, 80, 28);

        date_Chuyendi.setBackground(new java.awt.Color(140, 123, 185));
        date_Chuyendi.setForeground(new java.awt.Color(65, 50, 122));
        date_Chuyendi.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(date_Chuyendi);
        date_Chuyendi.setBounds(1650, 240, 200, 30);

        date_sinhNhat.setBackground(new java.awt.Color(140, 123, 185));
        date_sinhNhat.setForeground(new java.awt.Color(65, 50, 122));
        date_sinhNhat.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(date_sinhNhat);
        date_sinhNhat.setBounds(470, 280, 160, 30);

        date_DK.setBackground(new java.awt.Color(140, 123, 185));
        date_DK.setForeground(new java.awt.Color(65, 50, 122));
        date_DK.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(date_DK);
        date_DK.setBounds(1120, 360, 160, 30);

        tbl_NhanKhau.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_NhanKhau.setForeground(new java.awt.Color(65, 50, 122));
        tbl_NhanKhau.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_NhanKhau.setCellSelectionEnabled(true);
        tbl_NhanKhau.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_NhanKhau.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbl_NhanKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanKhauMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanKhau);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 570, 1840, 390);

        txt_nguyenQuan.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_nguyenQuan.setForeground(new java.awt.Color(65, 50, 122));
        txt_nguyenQuan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_nguyenQuan);
        txt_nguyenQuan.setBounds(1120, 190, 220, 25);

        doc.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 1QuanLiNhanKhau.png"))); // NOI18N
        doc.setText("jLabel1");
        jPanel1.add(doc);
        doc.setBounds(0, -10, 1920, 1000);

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

    public void reset() {
        Date date = new Date();

        txt_soHoKhau.setEnabled(true);
        txt_maNK.setEnabled(true);
        txt_maNK.setText("");
        txt_hoTen.setText("");
        txt_gioiTinh.setSelectedIndex(0);
        txt_soHoKhau.setText("");
        date_sinhNhat.setDate(date);
        date_Chuyendi.setDate(date);
        txt_noiSinh.setText("");
        txt_danToc.setText("");
        txt_ngheNghiep.setText("");
        txt_nguyenQuan.setText("");
        txt_noiLamViec.setText("");
        txt_CMND.setText("");
        txt_ngayCapVaNoiCap.setText("");
        date_DK.setDate(date);
        txt_diaChiThuongTruTruocKhiDen.setText("");
        txt_QuanHeVoiChuHo.setText("");
        txt_GhiChu.setText("");
        txt_noiChuyenDi.setText("");
        //btn_moiSinh.setEnabled(true);
        btn_them.setEnabled(true);
        btn_timKiemTheoSHK.setEnabled(true);
        btn_luu.setEnabled(false);
        txt_maNK.setEnabled(false);
        btn_daQuaDoi.setEnabled(false);
        btn_xoa.setEnabled(false);
        btn_sua.setEnabled(false);
        //btn_daQuaDoi.setEnabled(false);
        txt_tuKhoaSoHoKhau.setText("");

        getData(listNK);

    }

    public boolean kiemTraSoHK(String soHoKhau, ArrayList<SoHoKhau> listSHK) {
        for (SoHoKhau obj : listSHK) {
            if (obj.getSoHoKhau().equalsIgnoreCase(soHoKhau)) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraChuHo(String soHoKhau, ArrayList<SoHoKhau> listSHK) {
        ArrayList<NhanKhau> listTimKiem = new ArrayList<>();
        for (int i = 0; i < listNK.size(); i++) {
            if (listNK.get(i).getSoHoKhau().contains(soHoKhau)) {
                listTimKiem.add(listNK.get(i));
            }
        }
        for (NhanKhau obj : listTimKiem) {
            if (obj.getQuanHeVoiChuHo().equalsIgnoreCase("Chủ hộ")) {
                return true;
            }
        }
        return false;
    }

//    public void DoiTenChuHo(String soHoKhau,String ten, ArrayList<SoHoKhau> listSHK) {
//        for (int i=0;i<listSHK.size();i++) {
//            if (listSHK.get(i).getSoHoKhau().equalsIgnoreCase(soHoKhau)) {
//                listSHK.get(i).setHoTenChuHo(ten);
//                listSHK.set(i, listSHK.get(i));
//            }
//        }
//       
//    }
    public boolean kiemTraHopLe() {
        Date date = new Date();
        String hoTen = txt_hoTen.getText().trim();
        String maNK = txt_maNK.getText().trim();
        String soHK = txt_soHoKhau.getText().trim();
        String noiSinh = txt_noiSinh.getText().trim();
        String danToc = txt_danToc.getText().trim();
        String ngheNghiep = txt_ngheNghiep.getText().trim();
        String nguyenQuan = txt_nguyenQuan.getText().trim();
        String noiLamViec = txt_noiLamViec.getText().trim();
        String CMND = txt_CMND.getText().trim();
        String ngayCapNoiCap = txt_ngayCapVaNoiCap.getText().trim();
        String diaChiTruoc = txt_diaChiThuongTruTruocKhiDen.getText().trim();
        String quanHe = txt_QuanHeVoiChuHo.getText().trim();
        String ghiChu = txt_GhiChu.getText().trim();

        loadFile2();
        // ArrayList<SoHoKhau> listSHK = listSHK2;

        if (!kiemTraSoHK(soHK, listSHK2)) {
            JOptionPane.showMessageDialog(this, "Không có số hộ khẩu này trong hệ thống");
            return false;
        }

        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được trống");
            return false;
        } else if (soHK.equals("")) {
            JOptionPane.showMessageDialog(this, "Số hộ khẩu không được trống");
            return false;
        } else if (noiSinh.equals("")) {
            JOptionPane.showMessageDialog(this, "Nơi sinh không được trống");
            return false;
        } else if (danToc.equals("")) {
            JOptionPane.showMessageDialog(this, "Dân tộc không được trống");
            return false;
        } else if (ngheNghiep.equals("")) {
            JOptionPane.showMessageDialog(this, "Nghề nghiệp không được trống");
            return false;
        } else if (nguyenQuan.equals("")) {
            JOptionPane.showMessageDialog(this, "Nguyên quán không được trống");
            return false;
        } else if (noiLamViec.equals("")) {
            JOptionPane.showMessageDialog(this, "Nơi làm việc không được trống");
            return false;
        } else if (CMND.equals("")) {
            JOptionPane.showMessageDialog(this, "CMND không được trống");
            return false;
        } else if (ngayCapNoiCap.equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày và nơi cấp CMND không được trống");
            return false;
        } else if (diaChiTruoc.equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ trước khi đến không được trống");
            return false;
        } else if (quanHe.equals("")) {
            JOptionPane.showMessageDialog(this, "Quan hệ với chủ hộ không được trống");
            return false;
        }
        if (!validate.khongChuaSo(txt_hoTen.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số!");
            return false;
        } else if (!validate.khongChuaChu(txt_CMND.getText().trim())) {
            JOptionPane.showMessageDialog(this, "CMND không được chứa chữ!");
            return false;
        }

        if (date_DK.getDate().after(date)) {
            JOptionPane.showMessageDialog(this, "Ngày đăng kí phải trong quá khứ hoặc hiện tại");
            return false;
        }
        if (date_sinhNhat.getDate().after(date)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải trong quá khứ hoặc hiện tại");
            return false;
        }

        if (kiemTraChuHo(soHK, listSHK) && txt_QuanHeVoiChuHo.getText().trim().equalsIgnoreCase("chủ hộ")) {
            JOptionPane.showMessageDialog(this, "Sổ hộ khẩu này đã có chủ hộ");
            JOptionPane.showMessageDialog(this, "Sau khi thêm vui lòng chỉnh sửa thông tin quan hệ chủ hộ đối với các thành viên trong hộ");
        }
        return true;
    }
    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void btn_timKiemTheoSHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemTheoSHKActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_tuKhoaSoHoKhau.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listNK);
        } else {
            ArrayList<NhanKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listNK.size(); i++) {
                if (listNK.get(i).getSoHoKhau().equalsIgnoreCase(tuKhoa) || listNK.get(i).getHoTen().equalsIgnoreCase(tuKhoa)) {

                    listTimKiem.add(listNK.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_btn_timKiemTheoSHKActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        NhanKhau nkThem = new NhanKhau();
        String gioiTinh = "";
        if (txt_gioiTinh.getSelectedItem().equals("Nam")) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String maHK = txt_soHoKhau.getText().trim() + "-" + sdf.format(date);
        nkThem.setHoTen(txt_hoTen.getText().trim());
        nkThem.setGioiTinh(gioiTinh);
        nkThem.setMaNK(maHK);
        nkThem.setSoHoKhau(txt_soHoKhau.getText().trim());
        nkThem.setNoiSinh(txt_noiSinh.getText().trim());
        nkThem.setDanToc(txt_danToc.getText().trim());
        nkThem.setNgheNghiep(txt_ngheNghiep.getText().trim());
        nkThem.setNguyenQuan(txt_nguyenQuan.getText().trim());
        nkThem.setNoiLamViec(txt_noiLamViec.getText().trim());
        nkThem.setSoCMND(txt_CMND.getText().trim());
        nkThem.setNgayNoiCapCMND(txt_ngayCapVaNoiCap.getText().trim());
        nkThem.setDiaChiTruoc(txt_diaChiThuongTruTruocKhiDen.getText().trim());
        nkThem.setQuanHeVoiChuHo(txt_QuanHeVoiChuHo.getText().trim());
        nkThem.setGhiChu(txt_GhiChu.getText().trim());
        String date_SN = convertDateToString(date_sinhNhat.getDate());
        String date_DangKy = convertDateToString(date_DK.getDate());
        nkThem.setSinhNhat(date_SN);
        nkThem.setThoiGianDKThuongTru(date_DangKy);
        if (!kiemTraHopLe()) {
            return;
        } else {
            listNK.add(nkThem);
            saveFile();
            getData(listNK);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            reset();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        NhanKhau nkThem = new NhanKhau();
        String gioiTinh = "";
        if (txt_gioiTinh.getSelectedItem().equals("Nam")) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        nkThem.setGioiTinh(gioiTinh);
        nkThem.setMaNK(txt_maNK.getText().trim());
        nkThem.setHoTen(txt_hoTen.getText().trim());
        nkThem.setSoHoKhau(txt_soHoKhau.getText().trim());
        nkThem.setNoiSinh(txt_noiSinh.getText().trim());
        nkThem.setDanToc(txt_danToc.getText().trim());
        nkThem.setNgheNghiep(txt_ngheNghiep.getText().trim());
        nkThem.setNguyenQuan(txt_nguyenQuan.getText().trim());
        nkThem.setNoiLamViec(txt_noiLamViec.getText().trim());
        nkThem.setSoCMND(txt_CMND.getText().trim());
        nkThem.setNgayNoiCapCMND(txt_ngayCapVaNoiCap.getText().trim());
        nkThem.setDiaChiTruoc(txt_diaChiThuongTruTruocKhiDen.getText().trim());
        nkThem.setQuanHeVoiChuHo(txt_QuanHeVoiChuHo.getText().trim());
        nkThem.setGhiChu(txt_GhiChu.getText().trim());
        String date_SN = convertDateToString(date_sinhNhat.getDate());
        String date_DangKy = convertDateToString(date_DK.getDate());
        nkThem.setSinhNhat(date_SN);
        nkThem.setThoiGianDKThuongTru(date_DangKy);

        if (!kiemTraHopLe()) {
            return;
        } else {

            if (txt_QuanHeVoiChuHo.getText().trim().equalsIgnoreCase("chủ hộ")) {
                loadFile2();
                for (int i = 0; i < listSHK2.size(); i++) {
                    if(listSHK2.get(i).getSoHoKhau().equalsIgnoreCase(txt_soHoKhau.getText().trim()))
                    {
                    listSHK2.get(i).setHoTenChuHo(txt_hoTen.getText().trim());
                    break;
                    }
                }
                saveFile2();
            }
            listNK.set(index, nkThem);
            saveFile();
            getData(listNK);
            JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công");
            reset();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_daQuaDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daQuaDoiActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn là đã qua đời không?", "Có", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            nk.setGhiChu("Đã qua đời");
            listNK.set(index, nk);
            saveFile();
            getData(listNK);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");

            reset();
        }
    }//GEN-LAST:event_btn_daQuaDoiActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    public boolean kiemtraMotNguoi(String s){
        int j = 0;
        for (int i = 0; i < listNK.size(); i++) {
            if(listNK.get(i).getSoHoKhau().equals(s)){
                j++;
                if(j == 2){
                    return false;
                }
                
            }
        }
        return true;
    }
    
    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Xóa", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            if(kiemtraMotNguoi(nk.getSoHoKhau())){
                 loadFile2();
               
//                for(NhanKhau obj : listNK2)
//                {
//                    System.out.println("!!!!: "+listNK2.size());
//                    if(obj.getSoHoKhau().equals(soHK))
//                        listNK2.remove(obj);
//                }
                    
                String soHK = nk.getSoHoKhau();
                for (int i = 0; i < listSHK2.size(); i++) {
                    System.out.println("!!!!: "+listSHK2.size());
                    if (listSHK2.get(i).getSoHoKhau().equals(soHK)) {  
                        listSHK2.remove(i); 
                    }
                }
                
                //System.out.println("!!!!: "+listNK2.get(4).getSoHoKhau());
                saveFile2();
            }
            if(nk.getQuanHeVoiChuHo().equalsIgnoreCase("Chủ Hộ")){
                JOptionPane.showMessageDialog(this, "Đây là chủ hộ, hãy thiết lập chủ hộ mới! ");
            }
            if (listNK.remove(nk)) {
                saveFile();
                getData(listNK);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
        
        reset();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        // TODO add your handling code here:
        if (!kiemTraHopLe()) {
            return;
        }
        String noiDi = txt_noiChuyenDi.getText().trim();
        if (noiDi.equals("")) {
            JOptionPane.showMessageDialog(this, "Nơi đi không được rỗng");
            return;
        }
        nk.setGhiChu("Chuyển đi " + txt_noiChuyenDi.getText().trim() + " vào thời gian " + convertDateToString(date_Chuyendi.getDate()));
        listNK.set(index, nk);
        saveFile();
        getData(listNK);
        JOptionPane.showMessageDialog(this, "Lưu thành công");
        reset();
    }//GEN-LAST:event_btn_luuActionPerformed
    int index = -1;
    NhanKhau nkClicked = new NhanKhau();
    private void tbl_NhanKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanKhauMouseClicked
        // TODO add your handling code here:
        txt_soHoKhau.setEnabled(false);
        btn_xoa.setEnabled(true);
        btn_sua.setEnabled(true);

        int row = tbl_NhanKhau.getSelectedRow();
        String maNK = tbl_NhanKhau.getValueAt(row, 0).toString();
        for (int i = 0; i < listNK.size(); i++) {
            if (maNK.equalsIgnoreCase(listNK.get(i).getMaNK())) {
                nk = listNK.get(i);
                index = i;
                break;
            }
        }
        // String dateSinhNhat = convertDateToString(date_sinhNhat.getDate());
        btn_luu.setEnabled(true);
        btn_daQuaDoi.setEnabled(true);
        btn_luu.setEnabled(true);
        txt_maNK.setEnabled(false);
        btn_daQuaDoi.setEnabled(true);
        btn_xoa.setEnabled(true);
        btn_sua.setEnabled(true);
        Date date;
        date = covertStringToDate(nk.getSinhNhat());
        date_sinhNhat.setDate(date);
        btn_them.setEnabled(false);
        //btn_moiSinh.setEnabled(false);
        txt_maNK.setText(nk.getMaNK());
        txt_hoTen.setText(nk.getHoTen());
        txt_gioiTinh.setSelectedItem(nk.getGioiTinh());
        txt_soHoKhau.setText(nk.getSoHoKhau());
        date = covertStringToDate(nk.getThoiGianDKThuongTru());
        date_DK.setDate(date);
        //date_Chuyendi.setDate(date);
        txt_noiSinh.setText(nk.getNoiSinh());
        txt_danToc.setText(nk.getDanToc());
        txt_ngheNghiep.setText(nk.getNgheNghiep());
        txt_nguyenQuan.setText(nk.getNguyenQuan());
        txt_noiLamViec.setText(nk.getNoiLamViec());
        txt_CMND.setText(nk.getSoCMND());
        txt_ngayCapVaNoiCap.setText(nk.getNgayNoiCapCMND());

        txt_diaChiThuongTruTruocKhiDen.setText(nk.getDiaChiTruoc());
        txt_QuanHeVoiChuHo.setText(nk.getQuanHeVoiChuHo());
        txt_GhiChu.setText(nk.getGhiChu());                                     
    }//GEN-LAST:event_tbl_NhanKhauMouseClicked

    private void txt_tuKhoaSoHoKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tuKhoaSoHoKhauKeyReleased
        // TODO add your handling code here:
        String tuKhoa = txt_tuKhoaSoHoKhau.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listNK);
        } else {
            ArrayList<NhanKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listNK.size(); i++) {
                if (listNK.get(i).getSoHoKhau().contains(tuKhoa) || listNK.get(i).getHoTen().contains(tuKhoa)) {

                    listTimKiem.add(listNK.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_txt_tuKhoaSoHoKhauKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_daQuaDoi;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_timKiemTheoSHK;
    private javax.swing.JButton btn_xoa;
    private com.toedter.calendar.JDateChooser date_Chuyendi;
    private com.toedter.calendar.JDateChooser date_DK;
    private com.toedter.calendar.JDateChooser date_sinhNhat;
    private javax.swing.JLabel doc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_NhanKhau;
    private javax.swing.JTextField txt_CMND;
    private javax.swing.JTextField txt_GhiChu;
    private javax.swing.JTextField txt_QuanHeVoiChuHo;
    private javax.swing.JTextField txt_danToc;
    private javax.swing.JTextField txt_diaChiThuongTruTruocKhiDen;
    private javax.swing.JComboBox<String> txt_gioiTinh;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maNK;
    private javax.swing.JTextField txt_ngayCapVaNoiCap;
    private javax.swing.JTextField txt_ngheNghiep;
    private javax.swing.JTextField txt_nguyenQuan;
    private javax.swing.JTextField txt_noiChuyenDi;
    private javax.swing.JTextField txt_noiLamViec;
    private javax.swing.JTextField txt_noiSinh;
    private javax.swing.JTextField txt_soHoKhau;
    private javax.swing.JTextField txt_tuKhoaSoHoKhau;
    // End of variables declaration//GEN-END:variables
}
