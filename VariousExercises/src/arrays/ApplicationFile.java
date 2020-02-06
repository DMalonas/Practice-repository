package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationFile {

	public static void main(String[] args) {	
		
    	FileUtil fu = new FileUtil();
    	
    	
    	ArrayList<Rule> rules = (ArrayList<Rule>) fu.createAllRules("MinimumSwapsInputTestFile");
    	if (null == rules) {
    		return;
    	}
    	ArrayHandling ah = new ArrayHandling();
    	int result;
    	for (Rule rule : rules) {
    		//https://www.techiedelight.com/convert-list-integer-array-int/
    		if ((result = ah.minimumSwaps(rule.getNums().stream().mapToInt(Integer::intValue).toArray())) == rule.getExpectedResult()) {
    			System.out.println("Min swaps " + result);
    		} else {
    			System.out.println("Exp result was " + rule.getExpectedResult() + " but actual res is "  + result);
    		}
    	}
    	rules.clear();
    	
    	
    	
	}

}
