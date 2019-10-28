package nl.snakecoin.Snakecoin.Tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;

//source:
//https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/

public class Hashww {
	public static String SHA_512(String wachtwoord, String salt) {
        String generatedPassword = null;
        try {
           
            
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            //Add password bytes to digest and username
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            
            //Get the hash's bytes
            byte[] bytes = md.digest(wachtwoord.getBytes(StandardCharsets.UTF_8));
            
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}