package threads;

public class ApplicationFile {

	public static void main(String[] args) {

		FileUtilSecure fus = new FileUtilSecure("AnnotationsPckgTestFile");
		fus.run();
		System.out.println(fus.getResult());
	}

}
