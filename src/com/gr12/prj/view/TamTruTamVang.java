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
import com.gr12.prj.utils.Validate_data;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author APC
 */
public class TamTruTamVang extends javax.swing.JFrame {

    /**
     * Creates new form TamTruTamVang
     */
    private DefaultTableModel defaultTableModel;
    SoHoKhau shk = new SoHoKhau();
    NhanKhau nk = new NhanKhau();
    ArrayList<SoHoKhau> listSHK = new ArrayList<>();
    ArrayList<TamTru> listTamTru = new ArrayList<>();
    ArrayList<NhanKhau> listNK = new ArrayList<>();
    ArrayList<TamVang> listTamVang = new ArrayList<>();
    Validate_data validate = new Validate_data();
    public TamTruTamVang() {
        //this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        setTitle("Tạm Trú Tạm Vắng");
        loadFile();
        loadFile2();
        loadFileTamTru();
        loadFileTamVang();
        getData(listNK);
        getData2(listSHK);
        btn_luu.setEnabled(false);
        txt_maNK.setEnabled(false);
        txt_hoTen.setEnabled(false);
        txt_soHK.setEnabled(false);
        txt_ngaySinh.setEnabled(false);
        txt_ghiChu.setEnabled(false);
        btn_timKiem.setEnabled(false);
        txt_hoTen2.setText("");
        txt_diaChiTamTru.setText("");
        btn_luu2.setEnabled(false);
        txt_hoTen2.setEnabled(false);
        txt_diaChiTamTru.setEnabled(false);
        date_ngaySinh.setEnabled(false);
        txt_timKiem2.setEnabled(false);
        tbl_hoKhau.setEnabled(false);
        tbl_nhanKhau.setEnabled(false);
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
                    nv.setNoiSinh(arr[6]);
                    nv.setNguyenQuan(arr[7]);
                    nv.setDanToc(arr[8]);
                    nv.setNgheNghiep(arr[9]);
                    nv.setNoiLamViec(arr[10]);
                    nv.setSoCMND(arr[11]);
                    nv.setNgayNoiCapCMND(arr[12]);
                    nv.setThoiGianDKThuongTru(arr[13]);
                    nv.setDiaChiTruoc(arr[14]);
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
            // listNK = new ArrayList<>(); //lưu ý
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
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Ghi chú");

        for (NhanKhau obj : listNK) {
            if (obj.getGhiChu().contains("Chuyển đi") || obj.getGhiChu().contains("Đã qua đời") || obj.getGhiChu().contains("Tạm vắng")) {
                continue;
            }
            Vector vector = new Vector();
            vector.add(obj.getMaNK());
            vector.add(obj.getSoHoKhau());
            vector.add(obj.getHoTen());
            vector.add(obj.getSinhNhat());
            vector.add(obj.getGhiChu());

            defaultTableModel.addRow(vector);
        }
        tbl_nhanKhau.setModel(defaultTableModel);
    }

    public String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public void saveFileTamVang() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            Date date = new Date();
            for (int i = 0; i < listTamVang.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listTamVang.get(i).getThoiGian() + "\t";
                row = row + listTamVang.get(i).getMaNK() + "\t";
                row = row + listTamVang.get(i).getSoHoKhau() + "\t";
                row = row + listTamVang.get(i).getHoTen() + "\t";
                row = row + listTamVang.get(i).getGioiTinh() + "\t";
                row = row + listTamVang.get(i).getSinhNhat() + "\t";
                row = row + listTamVang.get(i).getNoiSinh() + "\t";
                row = row + listTamVang.get(i).getNguyenQuan() + "\t";
                row = row + listTamVang.get(i).getDanToc() + "\t";
                row = row + listTamVang.get(i).getNgheNghiep() + "\t";
                row = row + listTamVang.get(i).getNoiLamViec() + "\t";
                row = row + listTamVang.get(i).getSoCMND() + "\t";
                row = row + listTamVang.get(i).getNgayNoiCapCMND() + "\t";
                row = row + listTamVang.get(i).getThoiGianDKThuongTru() + "\t";
                row = row + listTamVang.get(i).getDiaChiTruoc() + "\t";
                row = row + listTamVang.get(i).getQuanHeVoiChuHo() + "\t";
                row = row + listTamVang.get(i).getGhiChu() + "\n";

                data += row;
            }
            fw = new FileWriter("tamvang.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveFile2() {

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

    public void loadFile2() {
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

    private void getData2(ArrayList<SoHoKhau> listSoHK) {
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
        tbl_hoKhau.setModel(defaultTableModel);
    }

    public void saveFileTamTru() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            Date date = new Date();
            for (int i = 0; i < listTamTru.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listTamTru.get(i).getThoiGian() + "\t";
                row = row + listTamTru.get(i).getHoTen() + "\t";
                row = row + listTamTru.get(i).getNgaySinh() + "\t";
                row = row + listTamTru.get(i).getDiaChi() + "\t";
                row = row + listTamTru.get(i).getSoHK() + "\t";
                row = row + listTamTru.get(i).getHoTenChuHo() + "\n";

                data += row;
            }
            fw = new FileWriter("tamtru.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reset2() {
        Date date = new Date();
        date_ngaySinh.setDate(date);
        txt_hoTen2.setText("");
        txt_diaChiTamTru.setText("");
        btn_luu2.setEnabled(false);
        txt_hoTen2.setEnabled(false);
        txt_diaChiTamTru.setEnabled(false);
        date_ngaySinh.setEnabled(false);
        txt_timKiem2.setEnabled(false);
        tbl_hoKhau.setEnabled(true);
    }

    public void reset() {
        txt_ghiChu.setText("");
        txt_hoTen.setText("");
        txt_maNK.setText("");
        txt_ngaySinh.setText("");
        txt_soHK.setText("");
        txt_tuKhoaNK.setText("");
        btn_luu.setEnabled(false);
        txt_maNK.setEnabled(false);
        txt_hoTen.setEnabled(false);
        txt_soHK.setEnabled(false);
        txt_ngaySinh.setEnabled(false);
        txt_ghiChu.setEnabled(false);
        btn_timKiem.setEnabled(false);
        tbl_nhanKhau.setEnabled(false);
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
        btn_luu = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_thoat1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_tamTru = new javax.swing.JButton();
        btn_tamVang = new javax.swing.JButton();
        txt_maNK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        txt_ngaySinh = new javax.swing.JTextField();
        txt_ghiChu = new javax.swing.JTextField();
        txt_soHK = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_tuKhoaNK = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_nhanKhau = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_hoTen2 = new javax.swing.JTextField();
        txt_diaChiTamTru = new javax.swing.JTextField();
        date_ngaySinh = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_hoKhau = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txt_timKiem2 = new javax.swing.JTextField();
        btn_timKiem2 = new javax.swing.JButton();
        btn_luu2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        doc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        btn_luu.setBackground(new java.awt.Color(65, 50, 122));
        btn_luu.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_get_app_white_24dp.png"))); // NOI18N
        btn_luu.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });
        jPanel1.add(btn_luu);
        btn_luu.setBounds(670, 270, 80, 60);

        jButton3.setBackground(new java.awt.Color(65, 50, 122));
        jButton3.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_settings_backup_restore_white_24dp.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(670, 350, 80, 60);

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

        jLabel18.setFont(new java.awt.Font("UTM Flamenco", 0, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(65, 50, 122));
        jLabel18.setText("Tạm trú");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(1340, 50, 170, 70);

        jLabel19.setFont(new java.awt.Font("UTM Flamenco", 0, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(65, 50, 122));
        jLabel19.setText("Tạm vắng");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(380, 60, 250, 70);

        btn_tamTru.setBackground(new java.awt.Color(65, 50, 122));
        btn_tamTru.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_tamTru.setForeground(new java.awt.Color(255, 255, 255));
        btn_tamTru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_done_white_24dp.png"))); // NOI18N
        btn_tamTru.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_tamTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tamTruActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tamTru);
        btn_tamTru.setBounds(1520, 70, 49, 49);

        btn_tamVang.setBackground(new java.awt.Color(65, 50, 122));
        btn_tamVang.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_tamVang.setForeground(new java.awt.Color(255, 255, 255));
        btn_tamVang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_done_white_24dp.png"))); // NOI18N
        btn_tamVang.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_tamVang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tamVangActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tamVang);
        btn_tamVang.setBounds(640, 70, 49, 49);

        txt_maNK.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_maNK.setForeground(new java.awt.Color(65, 50, 122));
        txt_maNK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_maNK);
        txt_maNK.setBounds(370, 220, 250, 40);

        jLabel6.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(140, 123, 185));
        jLabel6.setText("Mã nhân khẩu");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(140, 210, 160, 50);

        jLabel7.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(140, 123, 185));
        jLabel7.setText("Họ tên");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(140, 260, 100, 50);

        jLabel8.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(140, 123, 185));
        jLabel8.setText("Ngày sinh");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(140, 310, 110, 50);

        jLabel10.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(140, 123, 185));
        jLabel10.setText("Ghi chú");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(140, 370, 110, 50);

        jLabel9.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(140, 123, 185));
        jLabel9.setText("Số hộ khẩu");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(140, 160, 140, 50);

        txt_hoTen.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_hoTen.setForeground(new java.awt.Color(65, 50, 122));
        txt_hoTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_hoTen);
        txt_hoTen.setBounds(370, 270, 250, 40);

        txt_ngaySinh.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_ngaySinh.setForeground(new java.awt.Color(65, 50, 122));
        txt_ngaySinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_ngaySinh);
        txt_ngaySinh.setBounds(370, 320, 250, 40);

        txt_ghiChu.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_ghiChu.setForeground(new java.awt.Color(65, 50, 122));
        txt_ghiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_ghiChu);
        txt_ghiChu.setBounds(370, 370, 250, 40);

        txt_soHK.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_soHK.setForeground(new java.awt.Color(65, 50, 122));
        txt_soHK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_soHK);
        txt_soHK.setBounds(370, 170, 250, 40);

        jLabel11.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(140, 123, 185));
        jLabel11.setText("Tìm kiếm");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(110, 440, 100, 50);

        txt_tuKhoaNK.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_tuKhoaNK.setForeground(new java.awt.Color(65, 50, 122));
        txt_tuKhoaNK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        txt_tuKhoaNK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tuKhoaNKKeyReleased(evt);
            }
        });
        jPanel1.add(txt_tuKhoaNK);
        txt_tuKhoaNK.setBounds(240, 450, 250, 40);

        btn_timKiem.setBackground(new java.awt.Color(65, 50, 122));
        btn_timKiem.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp.png"))); // NOI18N
        btn_timKiem.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timKiem);
        btn_timKiem.setBounds(500, 450, 40, 40);

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
        jScrollPane4.setViewportView(tbl_nhanKhau);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(110, 510, 810, 440);

        jLabel12.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(140, 123, 185));
        jLabel12.setText("Họ tên");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(1110, 180, 100, 50);

        jLabel13.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(140, 123, 185));
        jLabel13.setText("Địa chỉ tạm trú");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(1110, 280, 160, 50);

        jLabel14.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(140, 123, 185));
        jLabel14.setText("Ngày sinh");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1110, 230, 110, 50);

        txt_hoTen2.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_hoTen2.setForeground(new java.awt.Color(65, 50, 122));
        txt_hoTen2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_hoTen2);
        txt_hoTen2.setBounds(1310, 180, 250, 40);

        txt_diaChiTamTru.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_diaChiTamTru.setForeground(new java.awt.Color(65, 50, 122));
        txt_diaChiTamTru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_diaChiTamTru);
        txt_diaChiTamTru.setBounds(1310, 280, 250, 40);

        date_ngaySinh.setBackground(new java.awt.Color(140, 123, 185));
        date_ngaySinh.setForeground(new java.awt.Color(65, 50, 122));
        date_ngaySinh.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(date_ngaySinh);
        date_ngaySinh.setBounds(1310, 230, 250, 40);

        tbl_hoKhau.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_hoKhau.setForeground(new java.awt.Color(65, 50, 122));
        tbl_hoKhau.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_hoKhau.setCellSelectionEnabled(true);
        tbl_hoKhau.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_hoKhau.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbl_hoKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoKhauMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_hoKhau);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(1070, 510, 810, 440);

        jLabel15.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(140, 123, 185));
        jLabel15.setText("Tìm kiếm theo số hộ khẩu/địa chỉ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(1070, 440, 370, 50);

        txt_timKiem2.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_timKiem2.setForeground(new java.awt.Color(65, 50, 122));
        txt_timKiem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        txt_timKiem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiem2KeyReleased(evt);
            }
        });
        jPanel1.add(txt_timKiem2);
        txt_timKiem2.setBounds(1480, 440, 250, 40);

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
        btn_timKiem2.setBounds(1740, 440, 40, 40);

        btn_luu2.setBackground(new java.awt.Color(65, 50, 122));
        btn_luu2.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_luu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_get_app_white_24dp.png"))); // NOI18N
        btn_luu2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_luu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_luu2);
        btn_luu2.setBounds(1620, 180, 80, 60);

        jButton2.setBackground(new java.awt.Color(65, 50, 122));
        jButton2.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_settings_backup_restore_white_24dp.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1620, 260, 80, 60);

        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 1nen.png"))); // NOI18N
        doc.setText("jLabel1");
        jPanel1.add(doc);
        doc.setBounds(1, -4, 1920, 1010);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int index = -1;
    NhanKhau nkClicked = new NhanKhau();
    private void btn_thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoat1ActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        // TODO add your handling code here:
        TamVang tv = new TamVang();
        if (nk.getGhiChu().equalsIgnoreCase("Đã qua đời")) {
            JOptionPane.showMessageDialog(this, "Nhân khẩu đã qua đời");
            return;
        }
        Integer confirm = JOptionPane.showConfirmDialog(this, "Xác nhận cấp giấy tạm vắng ?", "Có", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            nk.setGhiChu("Tạm vắng");
            listNK.set(index, nk);
            Date date = new Date();
            tv.setThoiGian(convertDateToString(date));
            tv.setMaNK(nk.getMaNK());
            tv.setSoHoKhau(nk.getSoHoKhau());
            tv.setHoTen(nk.getHoTen());
            tv.setGioiTinh(nk.getGioiTinh());
            tv.setSinhNhat(nk.getSinhNhat());
            tv.setNoiSinh(nk.getNoiSinh());
            tv.setNguyenQuan(nk.getNguyenQuan());
            tv.setDanToc(nk.getDanToc());
            tv.setNgheNghiep(nk.getNgheNghiep());
            tv.setNoiLamViec(nk.getNoiLamViec());
            tv.setSoCMND(nk.getSoCMND());
            tv.setNgayNoiCapCMND(nk.getNgayNoiCapCMND());
            tv.setThoiGianDKThuongTru(nk.getThoiGianDKThuongTru());
            tv.setDiaChiTruoc(nk.getDiaChiTruoc());
            tv.setQuanHeVoiChuHo(nk.getQuanHeVoiChuHo());
            tv.setGhiChu(nk.getGhiChu());
            listTamVang.add(tv);
            saveFile();
            saveFileTamVang();
            getData(listNK);
            JOptionPane.showMessageDialog(this, "Cập nhật thàng công");
            reset();
        }
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_tuKhoaNK.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listNK);
        } else {
            ArrayList<NhanKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listNK.size(); i++) {
                if (listNK.get(i).getGhiChu().contains("Chuyển đi") || listNK.get(i).getGhiChu().contains("Đã qua đời") || listNK.get(i).getGhiChu().contains("Tạm vắng")) {
                continue;
            }
                if (listNK.get(i).getSoHoKhau().equalsIgnoreCase(tuKhoa)) {

                    listTimKiem.add(listNK.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_timKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiem2ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem2.getText().trim();
        if (tuKhoa.equals("")) {
            getData2(listSHK);
        } else {
            ArrayList<SoHoKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listSHK.size(); i++) {
                if (listSHK.get(i).getSoHoKhau().equalsIgnoreCase(tuKhoa) || listSHK.get(i).getDiaChi().contains(tuKhoa)) {

                    listTimKiem.add(listSHK.get(i));
                }
            }
            getData2(listTimKiem);
        }
    }//GEN-LAST:event_btn_timKiem2ActionPerformed

    private void btn_luu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu2ActionPerformed
        // TODO add your handling code here:
        String hoTen = txt_hoTen2.getText().trim();
        String date = convertDateToString(date_ngaySinh.getDate());
        String diaChi = txt_diaChiTamTru.getText().trim();
        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Họ tên không được trống");
            return;
        } else if (!validate.khongChuaSo(hoTen)) {
            JOptionPane.showMessageDialog(this, "Họ tên không được chứa số");
            return;
        }
        Date time = new Date();
        TamTru tt = new TamTru();
        tt.setThoiGian(convertDateToString(time));
        tt.setHoTen(hoTen);
        tt.setNgaySinh(date);
        tt.setDiaChi(diaChi);
        tt.setSoHK(shk.getSoHoKhau());
        tt.setHoTenChuHo(shk.getHoTenChuHo());

        listTamTru.add(tt);
        saveFileTamTru();
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        reset2();

    }//GEN-LAST:event_btn_luu2ActionPerformed

    private void btn_tamVangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tamVangActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        btn_luu.setEnabled(true);
        txt_maNK.setEnabled(true);
        txt_hoTen.setEnabled(true);
        txt_soHK.setEnabled(true);
        txt_ngaySinh.setEnabled(true);
        txt_ghiChu.setEnabled(true);
        btn_timKiem.setEnabled(true);
        tbl_nhanKhau.setEnabled(true);
    }//GEN-LAST:event_btn_tamVangActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_nhanKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanKhauMouseClicked
        // TODO add your handling code here:
        int row = tbl_nhanKhau.getSelectedRow();
        String maNK = tbl_nhanKhau.getValueAt(row, 0).toString();
        for (int i = 0; i < listNK.size(); i++) {
            if (maNK.equalsIgnoreCase(listNK.get(i).getMaNK())) {
                nk = listNK.get(i);
                index = i;
                break;
            }
        }
        // String dateSinhNhat = convertDateToString(date_sinhNhat.getDate());

        //btn_moiSinh.setEnabled(false);
        txt_maNK.setText(nk.getMaNK());
        txt_hoTen.setText(nk.getHoTen());
        txt_soHK.setText(nk.getSoHoKhau());
        txt_ngaySinh.setText(nk.getSinhNhat());
        txt_ghiChu.setText(nk.getGhiChu());
    }//GEN-LAST:event_tbl_nhanKhauMouseClicked

    private void btn_tamTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tamTruActionPerformed
        // TODO add your handling code here:
        tbl_hoKhau.setEnabled(true);
        btn_timKiem2.setEnabled(true);
        txt_timKiem2.setEnabled(true);
    }//GEN-LAST:event_btn_tamTruActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_hoKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoKhauMouseClicked
        // TODO add your handling code here:
        btn_luu2.setEnabled(true);
        txt_hoTen2.setEnabled(true);
        //txt_diaChiTamTru.setEnabled(true);
        date_ngaySinh.setEnabled(true);
        int row = tbl_hoKhau.getSelectedRow();
        String soHK = tbl_hoKhau.getValueAt(row, 0).toString();
        for (int i = 0; i < listSHK.size(); i++) {
            if (soHK.equalsIgnoreCase(listSHK.get(i).getSoHoKhau())) {
                shk = listSHK.get(i);
                index = i;
                break;
            }
        }
        // String dateSinhNhat = convertDateToString(date_sinhNhat.getDate());

        //btn_moiSinh.setEnabled(false);
        txt_diaChiTamTru.setText(shk.getDiaChi());
    }//GEN-LAST:event_tbl_hoKhauMouseClicked

    private void txt_tuKhoaNKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tuKhoaNKKeyReleased
        // TODO add your handling code here:
         String tuKhoa = txt_tuKhoaNK.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listNK);
        } else {
            ArrayList<NhanKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listNK.size(); i++) {
                if (listNK.get(i).getSoHoKhau().contains(tuKhoa)) {

                    listTimKiem.add(listNK.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_txt_tuKhoaNKKeyReleased

    private void txt_timKiem2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiem2KeyReleased
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem2.getText().trim();
        if (tuKhoa.equals("")) {
            getData2(listSHK);
        } else {
            ArrayList<SoHoKhau> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listSHK.size(); i++) {
                if (listSHK.get(i).getSoHoKhau().contains(tuKhoa) || listSHK.get(i).getDiaChi().contains(tuKhoa)) {

                    listTimKiem.add(listSHK.get(i));
                }
            }
            getData2(listTimKiem);
        }
    }//GEN-LAST:event_txt_timKiem2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_luu2;
    private javax.swing.JButton btn_tamTru;
    private javax.swing.JButton btn_tamVang;
    private javax.swing.JButton btn_thoat1;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_timKiem2;
    private com.toedter.calendar.JDateChooser date_ngaySinh;
    private javax.swing.JLabel doc;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbl_hoKhau;
    private javax.swing.JTable tbl_nhanKhau;
    private javax.swing.JTextField txt_diaChiTamTru;
    private javax.swing.JTextField txt_ghiChu;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_hoTen2;
    private javax.swing.JTextField txt_maNK;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_soHK;
    private javax.swing.JTextField txt_timKiem2;
    private javax.swing.JTextField txt_tuKhoaNK;
    // End of variables declaration//GEN-END:variables
}
