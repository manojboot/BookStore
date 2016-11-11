package com.mybook.dbutil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.mybook.dao.UpdatePasswordDAO;

public class PasswordDigestUtil 
	{
	static final Logger LOGGER = Logger.getLogger(PasswordDigestUtil.class);
    public static String generateMD5HashString(String message)
    {	
    	LOGGER.info("Inside the Hash Generating method");
        String generatedPassword = null;
        try 
        	{
		        // Create MessageDigest instance for MD5
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        //Add password bytes to digest
		        md.update(message.getBytes());
		        //Get the hash's bytes 
		        byte[] bytes = md.digest();
		        //This bytes[] has bytes in decimal format;
		        //Convert it to hexadecimal format
		        StringBuilder sb = new StringBuilder();
		        for(int i=0; i< bytes.length ;i++)
		        {
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        //Get complete hashed password in hex format
		        generatedPassword = sb.toString();
		        LOGGER.info(message);
        	} 
		    catch (NoSuchAlgorithmException e) 
		    {
		        e.printStackTrace();
		    }
	    System.out.println(generatedPassword);
		return generatedPassword;
     }
	}
