package tests;


import java.io.ByteArrayOutputStream;
import static org.junit.Assert.*;
import java.io.PrintStream;
import org.junit.Test;
import arrays.*;


public class ArrayHandlingTest {
	ArrayHandling ah = new ArrayHandling();

	  @Test
	  public void manipulateArrayTest() {
		  int queries[][] = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
		  int n = 5;
		  assertEquals(ah.manipulateArray(n, queries), 200);
		  //	    assertEquals(opts.getMaxHints(), 4);
  		  //	    assertEquals(opts.getWordSource(), "WordsFile.txt");
	  }
	  
	  
	  @Test
	  public void minimumSwapsTest() {
		  int[] testArr = {4, 3, 1, 2};
		  int ans = 3;
		  assertEquals(ah.minimumSwaps(testArr), 3);
	  }
}
