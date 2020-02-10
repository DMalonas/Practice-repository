package threads;

import javax.xml.bind.*;

public class ApplicationFile {

	public static void main(String[] args) {
		FileUtilSecure[] fus = new FileUtilSecure[args.length];
		
		for (int i = 0; i < args.length; i++) {
			//Calculate the digest
			fus[i] = new FileUtilSecure(args[i]);
			fus[i].start();
			
		}
		
		for (int i = 0; i < args.length; i++) {
			while(true) {
				byte[] digest = fus[i].getResult();
				System.out.println("out");
				if (digest != null) {
					System.out.println("in");
					StringBuffer result = new StringBuffer(args[i]);
					result.append(": ");	
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}
	}

}
