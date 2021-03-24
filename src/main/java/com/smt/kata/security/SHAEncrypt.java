package com.smt.kata.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
// JDK 11.x
import java.security.NoSuchAlgorithmException;



/****************************************************************************
 * <b>Title:</b> SHAEncrypt.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Perform a one way SHA hash on the provided text.  This 
 * will provide a one way hash the the provided phrase.  One way hashes encrypt
 * data that cannot be decrypted and are often used to store user passwords.  Set the
 * default hash to SHA-256 for this class
 * 
 * You may NOT use any SMT libraries to do this or other completed code
 * (though you may use snippets).  You may use the Internet to research how to do it
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 24, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class SHAEncrypt {
	String  hashDigestType;
	/**
	 * Default constructor.  Assigns SHA-256
	 */
	public SHAEncrypt() {
		super();
		this.hashDigestType = "SHA-256";
	}
	
	/**
	 * Assigns the alogrithm applied
	 * @param hashDigestType
	 */
	public SHAEncrypt(String hashDigestType) {
		super();
		this.hashDigestType = hashDigestType;

		
	}

	/**
	 * 
	 * @param val
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidDataException
	 */
	public String encrypt(String val) throws NoSuchAlgorithmException {
		

		if (val.length() == 0) val = "";
	
		try {
			MessageDigest digest = MessageDigest.getInstance(hashDigestType);
			byte[] encodedhash = digest.digest(val.getBytes(StandardCharsets.UTF_8));
			return this.bytesToHex(encodedhash);
		} catch (Exception e) {
			throw new NoSuchAlgorithmException(e);
		}

	} 
	
	private String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	
}
