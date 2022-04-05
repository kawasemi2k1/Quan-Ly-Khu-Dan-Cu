/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import com.gr12.prj.object.CoSoVatChat;
import com.gr12.prj.object.LichHoatDong;
import com.gr12.prj.object.NhanKhau;
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

/**
 *
 * @author APC
 */
public class NhaVanHoa extends javax.swing.JFrame {

    /**
     * Creates new form NhaVanHoa
     */
    private DefaultTableModel defaultTableModel;
    CoSoVatChat cs = new CoSoVatChat();
    ArrayList<CoSoVatChat> listCS = new ArrayList<>();
    LichHoatDong hd = new LichHoatDong();
    ArrayList<LichHoatDong> listHD = new ArrayList<>();
    Validate_data validate = new Validate_data();
    public NhaVanHoa() {
        //this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        setTitle("Nhà Văn Hóa");
        loadFile();
        loadFileLichHoatDong();
        getDataLichHD(listHD);
        getData(listCS);
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
        txt_congViec1.setEnabled(false);
        txt_congViec2.setEnabled(false);
        txt_congViec1.setEnabled(false);
        txt_CMND2.setEnabled(false);
        btn_datLich1.setEnabled(false);
        btn_datLich2.setEnabled(false);
    }
    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listCS.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listCS.get(i).getTen() + "\t";
                row = row + listCS.get(i).getTrangThai() + "\t";
                row = row + listCS.get(i).getSoLuong() + "\t";
                row = row + listCS.get(i).getGhiChu() + "\n";

                data += row;
            }
            fw = new FileWriter("cosovatchat.txt");
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
            listCS = new ArrayList<>(); //lưu ý
            fr = new FileReader("cosovatchat.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    CoSoVatChat cs = new CoSoVatChat();
                    cs.setTen(arr[0]);
                    cs.setTrangThai(arr[1]);
                    cs.setSoLuong(arr[2]);
                    cs.setGhiChu(arr[3]);
                    listCS.add(cs);
                }
            } catch (IOException ex) {
                //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getData(ArrayList<CoSoVatChat> listCS) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Tên");
        defaultTableModel.addColumn("Trạng thái");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Ghi chú");

        for (CoSoVatChat obj : listCS) {
            Vector vector = new Vector();
            vector.add(obj.getTen());
            vector.add(obj.getTrangThai());
            vector.add(obj.getSoLuong());
            vector.add(obj.getGhiChu());
            defaultTableModel.addRow(vector);
        }
        tbl_coSoVatChat.setModel(defaultTableModel);
    }

    public void saveFileLichHoatDong() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listHD.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listHD.get(i).getMaLich() + "\t";
                row = row + listHD.get(i).getCMND() + "\t";
                row = row + listHD.get(i).getThoiGian() + "\t";
                row = row + listHD.get(i).getCongViec() + "\t";
                row = row + listHD.get(i).getTrangThai() + "\n";

                data += row;
            }
            fw = new FileWriter("lichhoatdong.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadFileLichHoatDong() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            // listHD = new ArrayList<>(); //lưu ý
            fr = new FileReader("lichhoatdong.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    LichHoatDong hd = new LichHoatDong();
                    hd.setMaLich(arr[0]);
                    hd.setCMND(arr[1]);
                    hd.setThoiGian(arr[2]);
                    hd.setCongViec(arr[3]);
                    hd.setTrangThai(arr[4]);
                    listHD.add(hd);
                }
            } catch (IOException ex) {
                //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void getDataLichHD(ArrayList<LichHoatDong> listHD) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã Lịch");
        defaultTableModel.addColumn("Email người đặt");
        defaultTableModel.addColumn("Thời gian");
        defaultTableModel.addColumn("Công việc");
        defaultTableModel.addColumn("Trạng thái");

        for (LichHoatDong obj : listHD) {
            Vector vector = new Vector();
            vector.add(obj.getMaLich());
            vector.add(obj.getCMND());
            vector.add(obj.getThoiGian());
            vector.add(obj.getCongViec());
            vector.add(obj.getTrangThai());
            defaultTableModel.addRow(vector);
        }
        tbl_bangDatLich.setModel(defaultTableModel);
    }
    

//    public boolean kiemTraCMND(String cmnd)
//    {
//        frm_QuanLyNhanKhauReal frm= new frm_QuanLyNhanKhauReal();
//        ArrayList<NhanKhau> listNK = new ArrayList<>();
//        listNK=frm.listNK;
//         for (NhanKhau obj : listNK) {
//         
//         if(cmnd.equalsIgnoreCase(obj.getSoCMND()))
//             return true;
//         }
//        return false;
//    }
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

    public boolean kiemTraTen(String ten) {
        for (int i = 0; i < listCS.size(); i++) {
            if (listCS.get(i).getTen().equals(ten)) {
                return false;
            }
        }
        return true;
    }

    private boolean kiemTraHopLe() {
        String ten = txt_ten.getText().trim();
        String trangThai = txt_trangThai.getText().trim();
        String soLuong = txt_soLuong.getText().trim();
        String ghiChu = txt_ghiChu.getText().trim();

        if (ten.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được trống");
            return false;
        } else if (trangThai.equals("")) {
            JOptionPane.showMessageDialog(this, "Trạng thái không được trống");
            return false;
        } else if (soLuong.equals("")) {
            JOptionPane.showMessageDialog(this, "Số lượng không được trống");
            return false;
        } else if (ghiChu.equals("")) {
            JOptionPane.showMessageDialog(this, "Ghi chú không được trống");
            return false;
        }
        if (!validate.khongChuaChu(txt_soLuong.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Số lượng không được chứa chữ!");
            return false;
        }
        return true;
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
        txt_tuKhoa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_timKiem = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        txt_ten = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        txt_trangThai = new javax.swing.JTextField();
        txt_ghiChu = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btn_chon2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_CMND2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_congViec2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        date_ngay1 = new com.toedter.calendar.JDateChooser();
        date_ngay2 = new com.toedter.calendar.JDateChooser();
        btn_datLich2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btn_chon1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_congViec1 = new javax.swing.JTextField();
        txt_CMND1 = new javax.swing.JTextField();
        date_ngay = new com.toedter.calendar.JDateChooser();
        combo_ca = new javax.swing.JComboBox<>();
        btn_datLich1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bangDatLich = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_coSoVatChat = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        date_tuKhoa = new com.toedter.calendar.JDateChooser();
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

        txt_tuKhoa.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_tuKhoa.setForeground(new java.awt.Color(65, 50, 122));
        txt_tuKhoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        txt_tuKhoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tuKhoaKeyReleased(evt);
            }
        });
        jPanel1.add(txt_tuKhoa);
        txt_tuKhoa.setBounds(240, 450, 250, 40);

        jLabel15.setFont(new java.awt.Font("UTM American Sans", 0, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(65, 50, 122));
        jLabel15.setText("Thông tin cơ sở vật chất");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(300, 20, 540, 90);

        jLabel14.setFont(new java.awt.Font("UTM American Sans", 0, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(65, 50, 122));
        jLabel14.setText("Đặt lịch");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1450, 10, 160, 90);

        jLabel5.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(140, 123, 185));
        jLabel5.setText("Số lượng");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(240, 220, 110, 50);

        jLabel7.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(140, 123, 185));
        jLabel7.setText("Ghi chú");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(630, 220, 100, 50);

        jLabel6.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(140, 123, 185));
        jLabel6.setText("Tên cơ sở vật chất");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(240, 130, 210, 50);

        jLabel9.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(140, 123, 185));
        jLabel9.setText("Tìm kiếm");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(110, 440, 100, 50);

        jLabel8.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(140, 123, 185));
        jLabel8.setText("Trạng thái");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(630, 130, 110, 50);

        btn_them.setBackground(new java.awt.Color(65, 50, 122));
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
        btn_them.setBounds(320, 360, 80, 50);

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
        btn_sua.setBounds(450, 360, 80, 50);

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

        btn_reset.setBackground(new java.awt.Color(65, 50, 122));
        btn_reset.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_settings_backup_restore_white_24dp_1.png"))); // NOI18N
        btn_reset.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset);
        btn_reset.setBounds(710, 360, 80, 50);

        txt_ten.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_ten.setForeground(new java.awt.Color(65, 50, 122));
        txt_ten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_ten);
        txt_ten.setBounds(240, 180, 250, 40);

        txt_soLuong.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_soLuong.setForeground(new java.awt.Color(65, 50, 122));
        txt_soLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_soLuong);
        txt_soLuong.setBounds(240, 270, 250, 40);

        txt_trangThai.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_trangThai.setForeground(new java.awt.Color(65, 50, 122));
        txt_trangThai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        txt_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_trangThaiActionPerformed(evt);
            }
        });
        jPanel1.add(txt_trangThai);
        txt_trangThai.setBounds(630, 180, 250, 40);

        txt_ghiChu.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_ghiChu.setForeground(new java.awt.Color(65, 50, 122));
        txt_ghiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_ghiChu);
        txt_ghiChu.setBounds(630, 270, 250, 40);

        jPanel2.setBackground(new java.awt.Color(184, 173, 247));

        jLabel16.setFont(new java.awt.Font("UTM Flamenco", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(65, 50, 122));
        jLabel16.setText("Nhiều ngày");

        btn_chon2.setBackground(new java.awt.Color(65, 50, 122));
        btn_chon2.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_chon2.setForeground(new java.awt.Color(255, 255, 255));
        btn_chon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_done_white_24dp.png"))); // NOI18N
        btn_chon2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_chon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chon2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ngày");

        jLabel20.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Đến ngày");

        txt_CMND2.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_CMND2.setForeground(new java.awt.Color(65, 50, 122));
        txt_CMND2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        jLabel22.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Email");

        txt_congViec2.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_congViec2.setForeground(new java.awt.Color(65, 50, 122));
        txt_congViec2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        jLabel21.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Công việc");

        date_ngay1.setBackground(new java.awt.Color(140, 123, 185));
        date_ngay1.setForeground(new java.awt.Color(65, 50, 122));
        date_ngay1.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N

        date_ngay2.setBackground(new java.awt.Color(140, 123, 185));
        date_ngay2.setForeground(new java.awt.Color(65, 50, 122));
        date_ngay2.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N

        btn_datLich2.setBackground(new java.awt.Color(65, 50, 122));
        btn_datLich2.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_datLich2.setForeground(new java.awt.Color(255, 255, 255));
        btn_datLich2.setText("Đặt lịch");
        btn_datLich2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_datLich2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datLich2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_chon2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_ngay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_ngay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_congViec2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_CMND2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_datLich2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_chon2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_ngay2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_congViec2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_CMND2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_datLich2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(1550, 110, 320, 340);

        jPanel3.setBackground(new java.awt.Color(184, 173, 247));

        jLabel18.setFont(new java.awt.Font("UTM Flamenco", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(65, 50, 122));
        jLabel18.setText("Trong ngày");

        btn_chon1.setBackground(new java.awt.Color(65, 50, 122));
        btn_chon1.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_chon1.setForeground(new java.awt.Color(255, 255, 255));
        btn_chon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_done_white_24dp.png"))); // NOI18N
        btn_chon1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_chon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chon1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày");

        jLabel10.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email");

        jLabel11.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ca");

        jLabel12.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Công việc");

        txt_congViec1.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_congViec1.setForeground(new java.awt.Color(65, 50, 122));
        txt_congViec1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        txt_CMND1.setFont(new java.awt.Font("UTM Times", 0, 24)); // NOI18N
        txt_CMND1.setForeground(new java.awt.Color(65, 50, 122));
        txt_CMND1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));

        date_ngay.setBackground(new java.awt.Color(140, 123, 185));
        date_ngay.setForeground(new java.awt.Color(65, 50, 122));
        date_ngay.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N

        combo_ca.setFont(new java.awt.Font("UVN La Xanh", 0, 18)); // NOI18N
        combo_ca.setForeground(new java.awt.Color(65, 50, 122));
        combo_ca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng", "Chiều", "Tối", "Sáng và Chiều", "Chiều và Tối", "Tối" }));

        btn_datLich1.setBackground(new java.awt.Color(65, 50, 122));
        btn_datLich1.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_datLich1.setForeground(new java.awt.Color(255, 255, 255));
        btn_datLich1.setText("Đặt lịch");
        btn_datLich1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_datLich1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datLich1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_chon1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_ca, 0, 175, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_CMND1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_congViec1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_datLich1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_chon1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(combo_ca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_congViec1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_CMND1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_datLich1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(1210, 110, 310, 340);

        tbl_bangDatLich.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_bangDatLich.setForeground(new java.awt.Color(65, 50, 122));
        tbl_bangDatLich.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_bangDatLich.setCellSelectionEnabled(true);
        tbl_bangDatLich.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_bangDatLich.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane2.setViewportView(tbl_bangDatLich);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(1210, 510, 660, 440);

        tbl_coSoVatChat.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_coSoVatChat.setForeground(new java.awt.Color(65, 50, 122));
        tbl_coSoVatChat.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_coSoVatChat.setCellSelectionEnabled(true);
        tbl_coSoVatChat.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_coSoVatChat.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbl_coSoVatChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_coSoVatChatMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_coSoVatChat);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(70, 510, 930, 440);

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
        btn_xoa.setBounds(580, 360, 80, 50);

        jLabel17.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(140, 123, 185));
        jLabel17.setText("Tìm kiếm");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(1540, 460, 100, 50);

        jButton2.setBackground(new java.awt.Color(65, 50, 122));
        jButton2.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp_1.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1840, 470, 30, 30);

        date_tuKhoa.setBackground(new java.awt.Color(140, 123, 185));
        date_tuKhoa.setForeground(new java.awt.Color(65, 50, 122));
        date_tuKhoa.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(date_tuKhoa);
        date_tuKhoa.setBounds(1660, 470, 174, 30);

        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 1nen.png"))); // NOI18N
        doc.setText("jLabel1");
        jPanel1.add(doc);
        doc.setBounds(1, 0, 1920, 1000);

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
    public void reset() {
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
        btn_them.setEnabled(true);
        txt_ten.setText("");
        txt_trangThai.setText("");
        txt_soLuong.setText("");
        txt_ghiChu.setText("");
        txt_ten.setEnabled(true);
        getData(listCS);
    }

    public void resetLichHoatDong() {
        txt_congViec1.setEnabled(false);
        txt_congViec2.setEnabled(false);
        txt_CMND1.setEnabled(false);
        txt_CMND2.setEnabled(false);
        btn_datLich1.setEnabled(false);
        btn_datLich2.setEnabled(false);
//        txt_maLich1.setEnabled(false);
//        txt_maLich2.setEnabled(false);
        Date date = new Date();
        date_ngay.setDate(date);
        date_ngay1.setDate(date);
        date_ngay2.setDate(date);
        txt_CMND1.setText("");
        txt_CMND2.setText("");
        txt_congViec1.setText("");
        txt_congViec2.setText("");
//        txt_maLich1.setText("");
//        txt_maLich2.setText("");
    }
    int index = -1;
    CoSoVatChat csClicked = new CoSoVatChat();
    private void btn_thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoat1ActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_tuKhoa.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listCS);
        } else {
            ArrayList<CoSoVatChat> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listCS.size(); i++) {
                if (listCS.get(i).getTen().contains(tuKhoa)) {

                    listTimKiem.add(listCS.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void txt_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_trangThaiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String tuKhoa =convertDateToString(date_tuKhoa.getDate());
         if (tuKhoa.equals("")) {
            getDataLichHD(listHD);
        } else {
            ArrayList<LichHoatDong> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listHD.size(); i++) {
                if (listHD.get(i).getThoiGian().contains(tuKhoa)) {
                    listTimKiem.add(listHD.get(i));
                }
            }
            getDataLichHD(listTimKiem);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        String ten = txt_ten.getText().trim();
        String trangThai = txt_trangThai.getText().trim();
        String soLuong = txt_soLuong.getText().trim();
        String ghiChu = txt_ghiChu.getText().trim();
        if (!kiemTraHopLe()) {
            return;
        }
        if (!kiemTraTen(ten)) {
            return;
        }
        CoSoVatChat csThem = new CoSoVatChat();
        csThem.setTen(ten);
        csThem.setTrangThai(trangThai);
        csThem.setSoLuong(soLuong);
        csThem.setGhiChu(ghiChu);
        listCS.add(csThem);
        saveFile();
        getData(listCS);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        reset();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        String ten = txt_ten.getText().trim();
        String trangThai = txt_trangThai.getText().trim();
        String soLuong = txt_soLuong.getText().trim();
        String ghiChu = txt_ghiChu.getText().trim();
        if (!kiemTraHopLe()) {
            return;
        }
        CoSoVatChat csSua = new CoSoVatChat();
        csSua.setTen(ten);
        csSua.setTrangThai(trangThai);
        csSua.setSoLuong(soLuong);
        csSua.setGhiChu(ghiChu);
        listCS.set(index, csSua);
        saveFile();
        getData(listCS);
        JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công");
        reset();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Xóa", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            if (listCS.remove(cs)) {
                saveFile();
                getData(listCS);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
        reset();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tbl_coSoVatChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_coSoVatChatMouseClicked
        // TODO add your handling code here:
        int row = tbl_coSoVatChat.getSelectedRow();
        String ten = tbl_coSoVatChat.getValueAt(row, 0).toString();
        for (int i = 0; i < listCS.size(); i++) {
            if (ten.equalsIgnoreCase(listCS.get(i).getTen())) {
                cs = listCS.get(i);
                index = i;
                break;
            }
        }
        txt_ten.setText(cs.getTen());
        txt_ten.setEnabled(false);
        txt_trangThai.setText(cs.getTrangThai());
        txt_soLuong.setText(cs.getSoLuong());
        txt_ghiChu.setText(cs.getGhiChu());
        btn_them.setEnabled(false);
        btn_sua.setEnabled(true);
        btn_xoa.setEnabled(true);
    }//GEN-LAST:event_tbl_coSoVatChatMouseClicked

    private void btn_chon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chon1ActionPerformed
        // TODO add your handling code here:
        txt_congViec1.setEnabled(true);
        txt_congViec1.setEnabled(true);
        btn_datLich1.setEnabled(true);
    }//GEN-LAST:event_btn_chon1ActionPerformed

    private void btn_chon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chon2ActionPerformed
        // TODO add your handling code here:
        txt_congViec2.setEnabled(true);
        txt_CMND2.setEnabled(true);
        btn_datLich2.setEnabled(true);
    }//GEN-LAST:event_btn_chon2ActionPerformed

    private void btn_datLich1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datLich1ActionPerformed
        // TODO add your handling code here:
        
        LichHoatDong hdThem = new LichHoatDong();
        String CMND = txt_CMND1.getText().trim();
        String congViec = txt_congViec1.getText().trim();
        if (CMND.equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được trống");
            return;
        } else if (congViec.equals("")) {
            JOptionPane.showMessageDialog(this, "Công việc không được trống");
            return;
        }

        if (!validate.kiemTraEmail(CMND)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return;
        }

        Date date = new Date();
        if (date_ngay.getDate().before(date)) {
            JOptionPane.showMessageDialog(this, "Không được đặt lịch trong quá khứ");
            return;

        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String maHD = txt_CMND1.getText().trim() + "-" + sdf.format(date);
        hdThem.setCMND(CMND);
        hdThem.setMaLich(maHD);
        hdThem.setThoiGian(convertDateToString(date_ngay.getDate()) + "( " + combo_ca.getSelectedItem() + " )");
        hdThem.setCongViec(congViec);
        hdThem.setTrangThai("Chờ");
        listHD.add(hdThem);
        saveFileLichHoatDong();
        JOptionPane.showMessageDialog(this, "Đặt lịch thành công");
        resetLichHoatDong();
        getDataLichHD(listHD);
 
    }//GEN-LAST:event_btn_datLich1ActionPerformed

    private void btn_datLich2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datLich2ActionPerformed
        // TODO add your handling code here:
        LichHoatDong hdThem = new LichHoatDong();
        String CMND = txt_CMND2.getText().trim();
        String congViec = txt_congViec2.getText().trim();
        if (CMND.equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được trống");
            return;
        } else if (congViec.equals("")) {
            JOptionPane.showMessageDialog(this, "Công việc không được trống");
            return;
        }
        if (!validate.kiemTraEmail(CMND)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return;
        }
        if (date_ngay1.getDate().after(date_ngay2.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày đầu phải trước ngày cuối!");
            return;
        }

        Date date = new Date();
        if (date_ngay1.getDate().before(date)) {
            JOptionPane.showMessageDialog(this, "Không được đặt lịch trong quá khứ");
            return;

        }
        if (date_ngay2.getDate().before(date)) {
            JOptionPane.showMessageDialog(this, "Không được đặt lịch trong quá khứ");
            return;

        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String maHD = txt_CMND2.getText().trim() + "-" + sdf.format(date);
        hdThem.setCMND(CMND);
        hdThem.setMaLich(maHD);
        hdThem.setThoiGian("Từ ngày " + convertDateToString(date_ngay1.getDate()) + " đến ngày " + convertDateToString(date_ngay2.getDate()));
        hdThem.setCongViec(congViec);
        hdThem.setTrangThai("Chờ");
        listHD.add(hdThem);
        saveFileLichHoatDong();
        JOptionPane.showMessageDialog(this, "Đặt lịch thành công");
        resetLichHoatDong();
        getDataLichHD(listHD);
    }//GEN-LAST:event_btn_datLich2ActionPerformed

    private void txt_tuKhoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tuKhoaKeyReleased
        // TODO add your handling code here:
        String tuKhoa = txt_tuKhoa.getText().trim();
        if (tuKhoa.equals("")) {
            getData(listCS);
        } else {
            ArrayList<CoSoVatChat> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listCS.size(); i++) {
                if (listCS.get(i).getTen().contains(tuKhoa)) {

                    listTimKiem.add(listCS.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_txt_tuKhoaKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chon1;
    private javax.swing.JButton btn_chon2;
    private javax.swing.JButton btn_datLich1;
    private javax.swing.JButton btn_datLich2;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat1;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> combo_ca;
    private com.toedter.calendar.JDateChooser date_ngay;
    private com.toedter.calendar.JDateChooser date_ngay1;
    private com.toedter.calendar.JDateChooser date_ngay2;
    private com.toedter.calendar.JDateChooser date_tuKhoa;
    private javax.swing.JLabel doc;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_bangDatLich;
    private javax.swing.JTable tbl_coSoVatChat;
    private javax.swing.JTextField txt_CMND1;
    private javax.swing.JTextField txt_CMND2;
    private javax.swing.JTextField txt_congViec1;
    private javax.swing.JTextField txt_congViec2;
    private javax.swing.JTextField txt_ghiChu;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_trangThai;
    private javax.swing.JTextField txt_tuKhoa;
    // End of variables declaration//GEN-END:variables

}
