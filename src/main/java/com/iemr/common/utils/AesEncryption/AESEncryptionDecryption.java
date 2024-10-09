package com.iemr.common.utils.AesEncryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.iemr.common.utils.AesEncryption.AESEncryptionDecryption;


@Component
public class AESEncryptionDecryption {

	private static  Logger logger = LoggerFactory.getLogger(AESEncryptionDecryption.class);
	private static SecretKeySpec secretKey;
	private static  byte[] key;
	static final String SECRET = "amrith$%2022@&*piramal@@swasthya!#";

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-512");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			 logger.error("context", e);
		}
	}


	public  String encrypt(String strToEncrypt) throws Exception {
		 String encryptedString=null;
		try {
			if (secretKey == null)
			     setKey(SECRET);
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			encryptedString= Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			logger.error("Error while encrypting: {}", e.toString());
			throw new Exception("Error while encrypting: "+e.toString());
		}
		return encryptedString;
	}


	public  String decrypt(String strToDecrypt) throws Exception {
		 String decryptedString=null;
		try {
			if (secretKey == null)
				setKey(SECRET);
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			decryptedString= new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			logger.error("Error while decrypting: {0}",e.toString());
			throw new Exception("Error while decrypting: "+e.toString());
		}
		return decryptedString;
	}
}
