package com.iemr.common.utils.rsa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.iemr.common.notification.exception.IEMRException;


public class RSAKeyPairGenerator {

    private PrivateKey privateKey;
    private PublicKey publicKey;

   private static final Logger logger = LoggerFactory.getLogger(RSAKeyPairGenerator.class);


    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public void writeToFile(String path, byte[] key) throws IOException {

    	  FileOutputStream fos=null;
    	try
    	{
        File f = new File(path);
        f.getParentFile().mkdirs();

        fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
       
    	}
    	catch(Exception e)
    	{
    		logger.error(e.getMessage());
    	}
    	finally
    	{
    		if(fos!=null)
    		    fos.close();

    	}
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
        keyPairGenerator.writeToFile("RSA/publicKey", keyPairGenerator.getPublicKey().getEncoded());
        keyPairGenerator.writeToFile("RSA/privateKey", keyPairGenerator.getPrivateKey().getEncoded());
       // System.out.println("Public key generated - "+Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
        //System.out.println("Private key generated - "+Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
    }
	
	
		public static PublicKey getPublicKey(String base64PublicKey) throws IEMRException{
        PublicKey publicKey = null;
        try{
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
        	logger.error(e.getMessage());
        } catch (InvalidKeySpecException e) {
        	logger.error(e.getMessage());
        }
        return publicKey;
    }
}


	