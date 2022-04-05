/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr12.prj.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MyPC
 */
public class Validate_data {

    public boolean kiemTraEmail(String email) {
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        return ktEmail;
    }

    

    public boolean khongChuaSo(String s) {
        for (int i = 0; i < 10; i++) {
            if (s.contains(i + "")) {
                return false;
            }
        }
        return true;
    }

    public boolean khongChuaChu(String s) {
        s = s.toLowerCase();
        for (int i = 97; i < 122; i++) {
            char j = (char) i;
            if (s.contains(j + "")) {
                return false;
            }
        }
        return true;
    }

    public String md5(String str) {
        // hÃ m bÄƒm máº­t kháº©u
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public String catNam(String date){
        String arr[] = date.split("-");
        return arr[2];
    }
    public String catThang(String date){
        String arr[] = date.split("-");
        return arr[1];
    }
    public String catNgay(String date){
        String arr[] = date.split("-");
        return arr[0];
    }
    
    private static Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");

    public static boolean kiemTraDate(String dateString) {
        Matcher dateMatcher = dateRegexPattern.matcher(dateString);

        if (dateMatcher.matches()) {

           dateMatcher.reset();

           if (dateMatcher.find()) {
               String day = dateMatcher.group(1);
               String month = dateMatcher.group(2);
               int year = Integer.parseInt(dateMatcher.group(3));

               if ("31".equals(day) && 
                  ("4".equals(month) || "6".equals(month) || "9".equals(month) ||
                   "11".equals(month) || "04".equals(month) || "06".equals(month) || 
                   "09".equals(month))) {
                   return false; // 1, 3, 5, 7, 8, 10, 12 has 31 days
               } else if ("2".equals(month) || "02".equals(month)) {
                    //leap year
                    if (year % 4 == 0) {
                        return !"30".equals(day) && !"31".equals(day);
                    } else {
                        return !"29".equals(day) && !"30".equals(day) && !"31".equals(day);
                    }
               } else {
                   return true;
               }
           } else {
               return false;
           }
        } else {
            return false;
        }
    }
}
