package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

public class CryptUtils {
	
	private static final String ENCRYPTION_ALGORITHM = "AES/ECB/PKCS5Padding";
	private static final String VIN_ENCRYPTION_KEY = "TestVINLocalEncryptKey";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Hello");
		 System.out.println(encrypt("WBAJC51080WB86441", "TestVINLocalEncryptKey"));
//		 System.out.println(decrypt("7gIlyuIHqH/hlqG69LSyx+WFP/E3VnnEeCFTuJzTV7g=", "TestVINLocalDecryptKey"));
		 

	}
	
	private static SecretKeySpec getSecretKey(final String myKey)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] key = myKey.getBytes("UTF-8");
        final MessageDigest sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        return new SecretKeySpec(key, "AES");
    }

    /**
     * Encrypt the given string with the given secret
     *
     * @param strToEncrypt string that is requested to be encrypted with the
     *            given secret
     * @param secret secret string for encryption
     * @return encrypted string
     * @throws IllegalArgumentException if the encryption was not possible
     */
    public static String encrypt(final String strToEncrypt, final String secret) {
        try {
            final Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(secret));
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (final Exception e) {
            throw new IllegalArgumentException("Error while encrypting: " + e.toString(), e);
        }
    }

    /**
     * Decrypt the given string with the given secret
     *
     * @param strToDecrypt string that is requested to be decrypted with the
     *            given secret
     * @param secret secret string for decryption
     * @return decrypted string
     * @throws IllegalArgumentException if the decryption was not possible
     */
    public static String decrypt(final String strToDecrypt, final String secret) {
        try {
            final Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(secret));
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (final Exception e) {
            throw new IllegalArgumentException("Error while decrypting: " + e.toString(), e);
        }
    }

}
