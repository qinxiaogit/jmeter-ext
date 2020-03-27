package myJmeter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.Cipher;

public class Rsa {
    /** 指定加密算法为RSA */
    private static String ALGORITHM = "RSA";

    /** 指定key的大小 */
    private static int KEYSIZE = 1024;

    /** 指定公钥存放文件 */
    private static String PUBLIC_KEY_FILE = "F:\\zhqt_org_api\\extend\\access\\cacert\\.private.pem";

    /** 指定私钥存放文件 */
    private static String PRIVATE_KEY_FILE =  "F:\\zhqt_org_api\\extend\\access\\cacert\\.public.pem";


    public static void main(String[] args) throws Exception {
        System.out.println("RSA加解密测试：");

        generateKeyPair();

        final String source = "{\"user\":\"qx@qq.com\",\"user_pwd\":\"123456\",\"key\":\"bZfD0HXinP\"}";// 要加密的字符串
        System.out.println("加密前:" + source);

        String cryptograph = encrypt(source);// 生成的密文
        System.out.println("Base64 format:" + cryptograph);

        String target = decrypt(cryptograph);// 解密密文
        System.out.println("解密后:" + target);

        RSAKeyUtils.setPublicKeyPath(PUBLIC_KEY_FILE);
        RSAKeyUtils.setPrivatePath(PRIVATE_KEY_FILE);

        RSAKeyUtils.init(PUBLIC_KEY_FILE, PRIVATE_KEY_FILE);

        String text = "{\"user\":\"qx@qq.com\",\"user_pwd\":\"123456\",\"key\":\"bZfD0HXinP\"}";
        System.out.println("原始数据:" + text);
        String enc = RSAKeyUtils.encByPrivateKey(text);
        System.out.println("加密数据:" + enc);
        System.out.println("解密数据:" + RSAKeyUtils.decByPublicKey(enc));
        String sign=RSAKeyUtils.doSignPrivateKey(text);
        sign = "tci06qzxHeOwnAcdjJuoR9fylOiV14ztMMi1C3RF4jzDy/+OyI3HamjKFtdAqUl5HqRlKxgWdV+ek/yDvBGp4sm7k6TEyheKKWIO47toeCFGrFbOCIwg2Q3L+RnrEsytZUU4YjG1gK7DRJQs4d2C9V225CxA37XZWgjuV7vhE62RahdXgX1VYZ/uhg5sRpdoLab0Xv9r0wiEtU2OjJwvVoJQQcDITvX37HlWGgIEASPjVvD2QWmOi7TcjbK0GiiGuEMlctaFET87GC711FcrtZDul11XlUYknusmBAw3nJAT43fv8+8bqFrikx4+xCUiF4/EUmn1JW1j8vdISNCxxQ==";
        System.out.println("签名:"+sign);
        System.out.println("验签结果:"+RSAKeyUtils.decByPrivateKey(sign));

    }

    /**
     * 生成密钥对
     */
    private static void generateKeyPair() throws Exception {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEYSIZE, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /** 得到公钥 */
        Key publicKey = kp.getPublic();
        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        /** 用对象流将生成的密钥写入文件 */
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
        oos1.writeObject(publicKey);
        oos2.writeObject(privateKey);
        /** 清空缓存，关闭文件输出流 */
        oos1.close();
        oos2.close();
    }

    /**
     * 加密方法 source： 源数据
     */
    public static String encrypt(String source) throws Exception {
        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        return Base64.encode(b1);
    }

    /**
     * 解密算法 cryptograph:密文
     */
    public static String decrypt(String cryptograph) throws Exception {
        /** 将文件中的私钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] b1 = Base64.decode(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

}
