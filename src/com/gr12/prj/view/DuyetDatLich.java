/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.view;

import com.gr12.prj.object.LichHoatDong;
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
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author APC
 */
public class DuyetDatLich extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    LichHoatDong lhd = new LichHoatDong();
    ArrayList<LichHoatDong> listLHD = new ArrayList<>();
    Validate_data validate = new Validate_data();
    public DuyetDatLich() {
        //this.setAlwaysOnTop(true); // this interface is always on top
        this.setResizable(false); // not resizeble now
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight() - 50;
        System.out.println(xsize + "va" + ysize);
        this.setSize(xsize, ysize);
        
        setTitle("Duyệt Đặt Lịch");
        loadFile();
        getData(listLHD);
        btn_dongY.setEnabled(false);
        btn_tuChoi.setEnabled(false);
        txt_maLich.setEnabled(false);
        txt_mail.setEnabled(false);
        txt_thoiGian.setEnabled(false);
        txt_congViec.setEnabled(false);
        txt_trangThai.setEnabled(false);
    }
    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listLHD.size(); i++) {
                String row = ""; //tạo hàng rỗng
                // row = ""
                row = row + listLHD.get(i).getMaLich() + "\t";
                row = row + listLHD.get(i).getCMND() + "\t";
                row = row + listLHD.get(i).getThoiGian() + "\t";
                row = row + listLHD.get(i).getCongViec() + "\t";
                row = row + listLHD.get(i).getTrangThai() + "\n";

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

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
           // listCS = new ArrayList<>(); //lưu ý
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
                    listLHD.add(hd);
                }
            } catch (IOException ex) {
                //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getData(ArrayList<LichHoatDong> listLHD) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã Lịch");
        defaultTableModel.addColumn("Email người đặt");
        defaultTableModel.addColumn("Thời gian");
        defaultTableModel.addColumn("Công việc");
        defaultTableModel.addColumn("Trạng thái");

        for (LichHoatDong obj : listLHD) {
            Vector vector = new Vector();
            vector.add(obj.getMaLich());
            vector.add(obj.getCMND());
            vector.add(obj.getThoiGian());
            vector.add(obj.getCongViec());
            vector.add(obj.getTrangThai());
            defaultTableModel.addRow(vector);
        }
        tbl_lichHoatDong.setModel(defaultTableModel);
    }
    
      public String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
      
      public void reset()
      {
        getData(listLHD);
        txt_maLich.setText("");
        txt_congViec.setText("");
        txt_mail.setText("");
        txt_thoiGian.setText("");
        txt_trangThai.setText("");
        btn_dongY.setEnabled(false);
        btn_tuChoi.setEnabled(false);
        txt_maLich.setEnabled(false);
        txt_mail.setEnabled(false);
        txt_thoiGian.setEnabled(false);
        txt_congViec.setEnabled(false);
        txt_trangThai.setEnabled(false);
      }
      
     public void sendmailDongY(String mail) {
        try {
            Email email = new SimpleEmail();

            // Cấu hình thông tin Email Server
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("duchuy01102001@gmail.com", "huyhuyhuy01102001")); //Nhớ nhập đúng với tài khoản thật nhé :))

            // Với gmail cái này là bắt buộc.
            email.setSSLOnConnect(true);

            // Người gửi
            email.setFrom("duchuy01102001@gmail.com", "Nhà văn hóa");

            // Tiêu đề
            email.setSubject("Việc đặt lịch nhà văn hóa"); //Tiêu đề khi gửi email

            // Nội dung email
            //String covert = String.valueOf(rand);
            email.setMsg("Cám ơn bạn đã đặt lịch nhà văn hóa. Bạn đã được phê duyệt sử dụng nhà văn hóa."); //Nội dung email bạn muốn gửi.
            // Người nhận
            email.addTo(mail); //Đia chỉ email người nhận
            email.send(); //Thực hiện gửi.
            System.err.println("Gửi email thành công ! Vui lòng kiểm tra email !");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Gửi không thành công !");
        }
    }
      
      public void sendmailTuChoi(String mail) {
        try {
            Email email = new SimpleEmail();

            // Cấu hình thông tin Email Server
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("duchuy01102001@gmail.com", "huyhuyhuy01102001")); //Nhớ nhập đúng với tài khoản thật nhé :))

            // Với gmail cái này là bắt buộc.
            email.setSSLOnConnect(true);

            // Người gửi
            email.setFrom("duchuy01102001@gmail.com", "Nhà văn hóa");

            // Tiêu đề
            email.setSubject("Việc đặt lịch nhà văn hóa"); //Tiêu đề khi gửi email

            // Nội dung email
            //String covert = String.valueOf(rand);
            email.setMsg("Cám ơn bạn đã đặt lịch nhà văn hóa. Rất xin lỗi bạn vì đơn đặt lịch sử dụng của bạn bị từ chối."); //Nội dung email bạn muốn gửi.
            // Người nhận
            email.addTo(mail); //Đia chỉ email người nhận
            email.send(); //Thực hiện gửi.
            System.err.println("Gửi email thành công ! Vui lòng kiểm tra email !");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Gửi không thành công !");
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
        txt_maLich = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_thoiGian = new javax.swing.JTextField();
        txt_congViec = new javax.swing.JTextField();
        txt_trangThai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_dongY = new javax.swing.JButton();
        btn_tuChoi = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_lichHoatDong = new javax.swing.JTable();
        btn_search1 = new javax.swing.JButton();
        date_tuKhoa = new com.toedter.calendar.JDateChooser();
        btn_them1 = new javax.swing.JButton();
        btn_sua1 = new javax.swing.JButton();
        btn_them2 = new javax.swing.JButton();
        btn_sua2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        doc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        txt_maLich.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_maLich.setForeground(new java.awt.Color(65, 50, 122));
        txt_maLich.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_maLich);
        txt_maLich.setBounds(230, 370, 390, 40);

        txt_mail.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(65, 50, 122));
        txt_mail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_mail);
        txt_mail.setBounds(230, 420, 390, 40);

        txt_thoiGian.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_thoiGian.setForeground(new java.awt.Color(65, 50, 122));
        txt_thoiGian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_thoiGian);
        txt_thoiGian.setBounds(230, 470, 390, 40);

        txt_congViec.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_congViec.setForeground(new java.awt.Color(65, 50, 122));
        txt_congViec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_congViec);
        txt_congViec.setBounds(230, 520, 390, 40);

        txt_trangThai.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        txt_trangThai.setForeground(new java.awt.Color(65, 50, 122));
        txt_trangThai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 123, 185)));
        jPanel1.add(txt_trangThai);
        txt_trangThai.setBounds(230, 570, 390, 40);

        jLabel9.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(140, 123, 185));
        jLabel9.setText("Mã lịch");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(70, 360, 110, 50);

        jLabel6.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(140, 123, 185));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 410, 110, 50);

        jLabel7.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(140, 123, 185));
        jLabel7.setText("Thời gian");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 460, 110, 50);

        jLabel8.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(140, 123, 185));
        jLabel8.setText("Công việc");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(70, 510, 110, 50);

        jLabel10.setFont(new java.awt.Font("UVN La Xanh", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(140, 123, 185));
        jLabel10.setText("Trạng thái");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(70, 570, 110, 50);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(65, 50, 122));
        jLabel15.setText("Danh sách đặt lịch");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(1150, 10, 340, 70);

        btn_dongY.setBackground(new java.awt.Color(65, 50, 122));
        btn_dongY.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_dongY.setForeground(new java.awt.Color(255, 255, 255));
        btn_dongY.setText("Đồng ý");
        btn_dongY.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_dongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dongYActionPerformed(evt);
            }
        });
        jPanel1.add(btn_dongY);
        btn_dongY.setBounds(180, 680, 100, 70);

        btn_tuChoi.setBackground(new java.awt.Color(65, 50, 122));
        btn_tuChoi.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_tuChoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_tuChoi.setText("Từ chối");
        btn_tuChoi.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_tuChoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tuChoiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tuChoi);
        btn_tuChoi.setBounds(310, 680, 100, 70);

        btn_thoat.setBackground(new java.awt.Color(65, 50, 122));
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

        btn_reset.setBackground(new java.awt.Color(65, 50, 122));
        btn_reset.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_settings_backup_restore_white_24dp.png"))); // NOI18N
        btn_reset.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset);
        btn_reset.setBounds(440, 680, 100, 70);

        tbl_lichHoatDong.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        tbl_lichHoatDong.setForeground(new java.awt.Color(65, 50, 122));
        tbl_lichHoatDong.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_lichHoatDong.setCellSelectionEnabled(true);
        tbl_lichHoatDong.setGridColor(new java.awt.Color(140, 123, 185));
        tbl_lichHoatDong.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tbl_lichHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_lichHoatDongMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_lichHoatDong);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(700, 170, 1190, 770);

        btn_search1.setBackground(new java.awt.Color(65, 50, 122));
        btn_search1.setFont(new java.awt.Font("UTM God's Word", 0, 13)); // NOI18N
        btn_search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/outline_search_white_18dp.png"))); // NOI18N
        btn_search1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search1);
        btn_search1.setBounds(1780, 120, 40, 40);

        date_tuKhoa.setBackground(new java.awt.Color(140, 123, 185));
        date_tuKhoa.setForeground(new java.awt.Color(65, 50, 122));
        date_tuKhoa.setFont(new java.awt.Font("UTM Times", 0, 18)); // NOI18N
        jPanel1.add(date_tuKhoa);
        date_tuKhoa.setBounds(1550, 120, 210, 40);

        btn_them1.setBackground(new java.awt.Color(65, 50, 122));
        btn_them1.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_them1.setForeground(new java.awt.Color(255, 255, 255));
        btn_them1.setText("Đồng ý");
        btn_them1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them1);
        btn_them1.setBounds(960, 120, 100, 40);

        btn_sua1.setBackground(new java.awt.Color(65, 50, 122));
        btn_sua1.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_sua1.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua1.setText("Từ chối");
        btn_sua1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua1);
        btn_sua1.setBounds(830, 120, 100, 40);

        btn_them2.setBackground(new java.awt.Color(65, 50, 122));
        btn_them2.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_them2.setForeground(new java.awt.Color(255, 255, 255));
        btn_them2.setText("Tất cả");
        btn_them2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_them2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them2);
        btn_them2.setBounds(700, 120, 100, 40);

        btn_sua2.setBackground(new java.awt.Color(65, 50, 122));
        btn_sua2.setFont(new java.awt.Font("UTM God's Word", 0, 18)); // NOI18N
        btn_sua2.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua2.setText("Đang chờ");
        btn_sua2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_sua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua2);
        btn_sua2.setBounds(1090, 120, 100, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(65, 50, 122));
        jLabel16.setText("Phê chuẩn các đặt lịch");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(240, 230, 370, 90);

        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gr12/prj/images/Artboard 1nen.png"))); // NOI18N
        doc.setText("jLabel1");
        jPanel1.add(doc);
        doc.setBounds(1, -4, 1920, 1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int index = -1;
    LichHoatDong lhdClicked = new LichHoatDong();

    private void btn_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search1ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = convertDateToString(date_tuKhoa.getDate());
        if (tuKhoa.equals("")) {
            getData(listLHD);
        } else {
            ArrayList<LichHoatDong> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listLHD.size(); i++) {
                if (listLHD.get(i).getThoiGian().contains(tuKhoa) ) {

                    listTimKiem.add(listLHD.get(i));
                }
            }
            getData(listTimKiem);
        }
    }//GEN-LAST:event_btn_search1ActionPerformed

    private void btn_dongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dongYActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đồng ý không?", "Có", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            lhd.setTrangThai("Đồng ý");
            listLHD.set(index, lhd);
        saveFile();
        getData(listLHD);
        JOptionPane.showMessageDialog(this, "Phê duyệt thành công");
        reset();
        sendmailDongY(listLHD.get(index).getCMND());
            
        }
    }//GEN-LAST:event_btn_dongYActionPerformed

    private void btn_tuChoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tuChoiActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn từ chối không?", "Có", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            lhd.setTrangThai("Từ chối");
            listLHD.set(index, lhd);
        saveFile();
        getData(listLHD);
        JOptionPane.showMessageDialog(this, "Phê duyệt thành công");
        reset();
        //sendmail
        sendmailTuChoi(listLHD.get(index).getCMND());
            
        }
    }//GEN-LAST:event_btn_tuChoiActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them2ActionPerformed
        // TODO add your handling code here:
        getData(listLHD);
    }//GEN-LAST:event_btn_them2ActionPerformed

    private void btn_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them1ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = "Đồng ý";
        
            ArrayList<LichHoatDong> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listLHD.size(); i++) {
                if (listLHD.get(i).getTrangThai().contains(tuKhoa) ) {

                    listTimKiem.add(listLHD.get(i));
                }
            }
            getData(listTimKiem);
    }//GEN-LAST:event_btn_them1ActionPerformed

    private void btn_sua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua1ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = "Từ chối";
        
            ArrayList<LichHoatDong> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listLHD.size(); i++) {
                if (listLHD.get(i).getTrangThai().contains(tuKhoa) ) {

                    listTimKiem.add(listLHD.get(i));
                }
            }
            getData(listTimKiem);
    }//GEN-LAST:event_btn_sua1ActionPerformed

    private void btn_sua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua2ActionPerformed
        // TODO add your handling code here:
        String tuKhoa = "Chờ";
        
            ArrayList<LichHoatDong> listTimKiem = new ArrayList<>();
            for (int i = 0; i < listLHD.size(); i++) {
                if (listLHD.get(i).getTrangThai().contains(tuKhoa) ) {

                    listTimKiem.add(listLHD.get(i));
                }
            }
            getData(listTimKiem);
    }//GEN-LAST:event_btn_sua2ActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void tbl_lichHoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_lichHoatDongMouseClicked
        // TODO add your handling code here:
        int row = tbl_lichHoatDong.getSelectedRow();
        String maLich = tbl_lichHoatDong.getValueAt(row, 0).toString();
        for (int i = 0; i < listLHD.size(); i++) {
            if (maLich.equalsIgnoreCase(listLHD.get(i).getMaLich())) {
                lhd = listLHD.get(i);
                index = i;
                break;
            }
        }
        btn_dongY.setEnabled(true);
        btn_tuChoi.setEnabled(true);
        txt_maLich.setText(lhd.getMaLich());
        txt_mail.setText(lhd.getCMND());
        txt_thoiGian.setText(lhd.getThoiGian());
        txt_congViec.setText(lhd.getCongViec());
        txt_trangThai.setText(lhd.getTrangThai());
    }//GEN-LAST:event_tbl_lichHoatDongMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dongY;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_search1;
    private javax.swing.JButton btn_sua1;
    private javax.swing.JButton btn_sua2;
    private javax.swing.JButton btn_them1;
    private javax.swing.JButton btn_them2;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_tuChoi;
    private com.toedter.calendar.JDateChooser date_tuKhoa;
    private javax.swing.JLabel doc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_lichHoatDong;
    private javax.swing.JTextField txt_congViec;
    private javax.swing.JTextField txt_maLich;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_thoiGian;
    private javax.swing.JTextField txt_trangThai;
    // End of variables declaration//GEN-END:variables
}
