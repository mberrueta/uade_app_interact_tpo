package edu.uade.lib.security;

import org.apache.log4j.Logger;

public class Encriptor{
    private static final Logger log = Logger.getLogger("Encriptor");

    public static String encript(String md5) {
        if(md5 == null)
          return "";
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100), 1, 3);
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
            log.error("error encrypting", e);
        }
         return null;
     }
}