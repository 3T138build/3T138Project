package com.accp.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 功能描述：
 * 令牌生成器
 * @Author: xiaoke
 * @Date:2018/10/18 16:00
 * @Description:
 */
public class TokenProcessor {
    private TokenProcessor(){}
    private static TokenProcessor instance = new TokenProcessor();
    public static TokenProcessor getInstance(){
        return instance;
    }
    public String generateTokeCode(){
        String value = System.currentTimeMillis()+new Random().nextInt()+"";

        // System.getProperty 这个方法可以得到很多系统的属性。
       /* String osName = System.getProperty("os.name");
        String user = System.getProperty("user.name");
        System.out.println("当前操作系统是：" + osName);
        System.out.println("当前用户是：" + user);*/

        //获取数据指纹，指纹是唯一的
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] b = md.digest(value.getBytes());//产生数据的指纹
            //Base64编码
            BASE64Encoder be = new BASE64Encoder();
            be.encode(b);
            return be.encode(b);//制定一个编码
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}

