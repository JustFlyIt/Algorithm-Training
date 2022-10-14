package encryption;

import util.FileAsStringReader;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;
import java.text.NumberFormat;

/**
 * Possible KEY_SIZE values are 128, 192 and 256
 * Possible T_LEN values are 128, 120, 112, 104 and 96
 */

public class AES {
	
	public enum solutionOptions { simpleText, textFile };
	
    private SecretKey key;
    private final int KEY_SIZE = 256;
    private final int T_LEN = 128;
    private Cipher encryptionCipher;
    //private static final String ALGORITHM = "AES";
    private static final String ALGORITHM = "AES/GCM/NoPadding";

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance(ALGORITHM);
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

	public static void workTheExample(String input, solutionOptions option) {
		
        String encryptedMessage;
        String decryptedMessage;
        double encryptedMessageLength = 0;
        double  decryptedMessageLength = 0;
        double percentageEncryptedOverhead = 0;
        AES aes;
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        
        try {
            aes = new AES();
            aes.init();
			switch(option) {
				case simpleText:
					System.out.println("Simple Text Encryption Example...");
					System.out.println("Test text: " + input);

					encryptedMessage = aes.encrypt(input);
		            decryptedMessage = aes.decrypt(encryptedMessage);
		            
		            encryptedMessageLength = encryptedMessage.length();
		            decryptedMessageLength = decryptedMessage.length();
		            percentageEncryptedOverhead = (float) ((encryptedMessageLength - decryptedMessageLength)/encryptedMessageLength);

		            System.out.println("Encrypted Message: " + encryptedMessage);
		            System.out.println("Encrypted Message - number of bytes: " + encryptedMessageLength);
		            System.out.println("Decrypted Message: " + decryptedMessage);
		            System.out.println("Decrypted Message - number of bytes: " + decryptedMessageLength);
		            
		    		defaultFormat.setMinimumFractionDigits(2);
		            System.out.println("Encryption Overhead Percentage: " + defaultFormat.format(percentageEncryptedOverhead));

					break;
				case textFile:
					System.out.println("Text File Encryption Example...");
					System.out.println("Test Input file: " + input);

					encryptedMessage = aes.encrypt(FileAsStringReader.readFileAsString(input));
		            decryptedMessage = aes.decrypt(encryptedMessage);
		            
		            encryptedMessageLength = encryptedMessage.length();
		            decryptedMessageLength = decryptedMessage.length();
		            percentageEncryptedOverhead = (float) ((encryptedMessageLength - decryptedMessageLength)/encryptedMessageLength);

		            System.out.println("Encrypted Message - number of bytes: " + encryptedMessage.length());
		            System.out.println("Decrypted Message - number of bytes: " + decryptedMessage.length());
		            
		    		defaultFormat.setMinimumFractionDigits(2);
		            System.out.println("Encryption Overhead Percentage: " + defaultFormat.format(percentageEncryptedOverhead));

					break;
				default:
					System.out.println("Valid Solution Not Specified");
					return;
			}
        } catch (Exception ignored) {
        }
	}

    public static void main(String[] args) {
    	workTheExample("Test StringTest StringTest StringTest StringTest String", solutionOptions.simpleText);
    	//workTheExample("C:\\Users\\dsnyder\\git\\JavaNotions\\src\\encryption\\sample-2mb-text-file.txt", solutionOptions.textFile);
    	//workTheExample("C:\\Users\\dsnyder\\git\\JavaNotions\\src\\encryption\\PU Device DT Chat Setup V1.mp4", solutionOptions.textFile);
    }
}
