/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.controller;

import com.gr12.prj.even_obj.DanhMucBean;
import com.gr12.prj.view.LichSuJPanel;
import com.gr12.prj.view.QuanLiJPanel;
import com.gr12.prj.view.ThongKeJPanel;
import com.gr12.prj.view.TrangChuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author APC
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    
    private Color color1 = new Color(234, 153, 47);
    private Color color2 = new Color(239, 65, 101);
    private List<DanhMucBean> listItem = null;
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        
        jpnItem.setBackground(color1);
        jlbItem.setBackground(color1);
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
        
    }
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
           item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements  MouseListener{
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "QuanLi":
                    node = new QuanLiJPanel();
                    break;
                case "ThongKe":
                    node = new ThongKeJPanel();
                    break;
                case "LichSu":
                    node = new LichSuJPanel();
                    break;
                default:
                   break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(color1);
            jlbItem.setBackground(color1);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(color1);
            jlbItem.setBackground(color1);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(color2);
                jlbItem.setBackground(color2);
            }
        }
        
    }
    private void setChangeBackground(String kind){
        for(DanhMucBean item: listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(color1);
                item.getJlb().setBackground(color1);
            }else{
                item.getJpn().setBackground(color2);
                item.getJlb().setBackground(color2);    
            }
        }
    }
}
