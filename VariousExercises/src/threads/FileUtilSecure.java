package threads;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.xml.bind.DatatypeConverter;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FileUtilSecure implements Runnable{
	private String filename;
//	private byte[] digest;
	
//	public byte[] getResult() {
//		return digest;
//	}

	public FileUtilSecure(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(new FileInputStream(filename), sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			ApplicationFile.receiveDigest(digest, filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
