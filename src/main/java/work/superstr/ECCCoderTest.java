package work.superstr;

import java.util.Map;  

/** 
 *  
 * @author ���� 
 * @version 1.0 
 * @since 1.0 
 */  
public class ECCCoderTest {  
	/**
	 * ��Կ���ܣ�˽Կ����
	 * @throws Exception
	 */
	public static void test1() throws Exception {
		String inputStr = "abc";  
        byte[] data = inputStr.getBytes();  
  
        Map<String, Object> keyMap = ECCCoder.initKey();  
  
        String publicKey = ECCCoder.getPublicKey(keyMap);  
        String privateKey = ECCCoder.getPrivateKey(keyMap);  
        System.err.println("��Կ: \n" + publicKey);  
        System.err.println("˽Կ�� \n" + privateKey);  
  
        byte[] encodedData = ECCCoder.encrypt(data, publicKey);  
        byte[] decodedData = ECCCoder.decrypt(encodedData, privateKey);  
        
       
        String outputStr = new String(decodedData);  
        System.err.println("����ǰ: " + inputStr + "\n\r" + "���ܺ�: " + outputStr);  
        System.out.println(inputStr.equals(outputStr));  
	}
	
	public static void test2() throws Exception {
		String inputStr = "abc";  
        byte[] data = inputStr.getBytes();  
  
        Map<String, Object> keyMap = ECCCoder.initKey();  
  
        String publicKey = ECCCoder.getPublicKey(keyMap);  
        String privateKey = ECCCoder.getPrivateKey(keyMap);  
        System.err.println("��Կ: \n" + publicKey);  
        System.err.println("˽Կ�� \n" + privateKey);  
  
        byte[] encodedData = ECCCoder.encrypt(data, privateKey);  
        byte[] decodedData = ECCCoder.decrypt(encodedData, publicKey);  
        
       
        String outputStr = new String(decodedData);  
        System.err.println("����ǰ: " + inputStr + "\n\r" + "���ܺ�: " + outputStr);  
        System.out.println(inputStr.equals(outputStr));  
	}
    public static void main(String[] args ) throws Exception  {  
        test2();
    }  
}  