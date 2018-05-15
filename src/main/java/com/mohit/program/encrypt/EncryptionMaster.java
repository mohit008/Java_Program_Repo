package com.mohit.program.encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class EncryptionMaster {

    static String string = "sha256:1000:Ke+qa7e+bDfJHdMVvoYlKNrD/6QsXRWJ:5YKfqQFQMkukPWhkwn4c1pTLjql3xwDG";
    static String password = "Addmin@12345";
    static String salt = "Ke+qa7e+bDfJHdMVvoYlKNrD/6QsXRWJ";

    public static void main(String[] args) {

        try {
            PasswordMaster.createHash(password, salt);
        } catch (NoSuchAlgorithmException e) {
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
