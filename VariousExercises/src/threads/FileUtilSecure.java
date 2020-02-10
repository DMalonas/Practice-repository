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
	private ApplicationFile apCallback;

	public FileUtilSecure(String filename, ApplicationFile apCallback) {
		this.filename = filename;
		this.apCallback = apCallback;
	}
	
	@Override
	public void run() {
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(new FileInputStream(filename), sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			apCallback.receiveDigest(digest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
