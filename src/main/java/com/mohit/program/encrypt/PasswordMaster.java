package com.mohit.program.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class PasswordMaster {

    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA256";

    public static final int SALT_BYTES = 24;
    public static final int HASH_BYTES = 24;
    public static final int PBKDF2_ITERATIONS = 1000;

    /**
     * create hash
     *
     * @param password
     * @param hash_salt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String createHash(String password, String hash_salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = hash_salt.getBytes();
//        byte[] hash = pbkdf2(password,salt);
        byte[] base = Base64.encodeBase64(pbkdf2(password, salt));
        String string = new String(base);
        return null;
    }

    /**
     * encrypt password
     *
     * @param password
     * @param salt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static byte[] pbkdf2(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, PBKDF2_ITERATIONS, SALT_BYTES * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        SecretKey key = skf.generateSecret(spec);
        byte[] res = key.getEncoded();
        return res;
    }
}
