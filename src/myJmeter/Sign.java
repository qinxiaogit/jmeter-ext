package myJmeter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sign {
    public static String getMD5(String source) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());//update处理
            byte [] encryContext = md.digest();//调用该方法完成计算

            int i;
            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            System.out.println("32result: " + buf.toString());// 32位的加密
            System.out.println("16result: " + buf.toString().substring(8, 24));// 16位的加密
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //需要32位
        return  buf.toString();
    }


    public static void main(String[] args) {
      System.out.println(getMD5("hello"));

    }
}
