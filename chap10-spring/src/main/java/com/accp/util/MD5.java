package com.accp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 功能描述：
 * 加密类
 * @Author: xiaoke
 * @Date:2018/10/18 13:25
 * @Description:
 */
public class MD5 {
    public static String makeMD5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            //16位加密
            //return buf.toString().substring(8,24);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }


}
