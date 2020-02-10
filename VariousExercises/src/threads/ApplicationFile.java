package threads;

import javax.xml.bind.*;

public class ApplicationFile {

	private String filename;
	private byte[] digest;
	
	public ApplicationFile(String filename) {
		this.filename = filename;
	}
	
	public void calculateDigest() {
		FileUtilSecure fus = new FileUtilSecure(filename, this);
		Thread t = new Thread(fus);
		t.start();
	}
	
	
	public void receiveDigest(byte[] digest) {
		this.digest = digest;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String result = filename + ": ";
		if (digest != null) {
			result += DatatypeConverter.printHexBinary(digest);
		} else {
			result += "digest not available";
		}
		return result;
	}
	
	public static void main(String[] args) {
		for (String filename : args) {
			ApplicationFile d = new ApplicationFile(filename);
			d.calculateDigest();
		}
	}

}
