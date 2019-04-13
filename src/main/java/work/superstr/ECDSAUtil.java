package work.superstr;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
 
/**
 * ��Բ����ǩ���㷨
 * 
 * �ٶȿ� ǿ�ȸ� ǩ����
 * 
 * ʵ�ַ� JDK1.7/BC
 */
public class ECDSAUtil {
 
    private static String str = "hello";
 
    public static void main(String[] args) {
        jdkECDSA();
    }
 
    public static void jdkECDSA() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256);
 
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
            ECPrivateKey ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();
 
            // 2.ִ��ǩ��
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
 
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA1withECDSA");
            signature.initSign(privateKey);
 
            signature.update(str.getBytes());
            byte[] sign = signature.sign();
 
            // ��֤ǩ��
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
            keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            signature = Signature.getInstance("SHA1withECDSA");
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            boolean bool = signature.verify(sign);
            System.out.println(bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
