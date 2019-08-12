package com.abak.utility;

import java.io.UnsupportedEncodingException;
import javax.xml.bind.DatatypeConverter;

public class Password {
	
	public String encodePassword(String password) throws UnsupportedEncodingException{
		byte[] message = password.getBytes("UTF-8");
		String encoded = DatatypeConverter.printBase64Binary(message);
		return encoded;
	}
	
	public String decodePassword(String password) throws UnsupportedEncodingException{
		byte[] decoded = DatatypeConverter.parseBase64Binary(password);
		return new String(decoded, "UTF-8");
	}
	
	public static void main(String args[]) throws UnsupportedEncodingException{
		Password password= new Password();
		String passwordEncoded ="anil";
		String en= password.encodePassword(passwordEncoded);
		System.out.println(en);
		System.out.println("==================");
		String de = password.decodePassword(en);
		System.out.println(de);
	}
}
