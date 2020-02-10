package threads;

import javax.xml.bind.*;

public class ApplicationFile {

	public static void receiveDigest(byte[] digest, String name) {
		StringBuilder result = new StringBuilder(name);
		result.append(": ");	
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(result);
	}
	public static void main(String[] args) {
		for (String filename : args) {
			FileUtilSecure fus = new FileUtilSecure(filename);
			Thread t =new Thread(fus);
			t.start();
		}
	}

}
