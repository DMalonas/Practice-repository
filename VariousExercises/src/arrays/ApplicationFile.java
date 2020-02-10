package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationFile {

	public static void main(String[] args) {	

//		int[] alph = new int[26];
//		Arrays.fill(alph, 0);
//		String sl = "aabbcc";
//		for (int i = 0; i < alph.length; i++) {
//			System.out.println(alph[i]) ;
//			
//		}
//		for (int i = 0; i < sl.length(); i++) {
//			System.out.print(" " + (sl.charAt(i) - 97) + " ");
//		}
    	FileUtil fu = new FileUtil();
    	ArrayHandling ah = new ArrayHandling();

    	
    	ArrayList<Rule> rules;    	
    	rules = (ArrayList<Rule>) fu.createAllRules("MinimumSwapsInputTestFile");
    	if (null != rules) {
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
    	
    	
    	
    	ArrayList<Integer>  crudeInput = (ArrayList<Integer>) fu.createAllRules("DifferenceArrayInputTestFile");
    	
    	RuleArrDiffMtd rad = new RuleArrDiffMtd();
    	ArrayList<RuleArrDiffMtd> arrDiffRules = rad.getArrDiffRules(crudeInput);
    	for (RuleArrDiffMtd arrDiffRule : arrDiffRules) {
    		
    		if (arrDiffRule.getExpRes() == ah.manipulateArray(arrDiffRule.getArrLen(), arrDiffRule.getQueries())) {
    			System.out.println("Arr len: " + arrDiffRule.getArrLen() + " \nQueries:\n" + arrDiffRule.getQueriesNum() + " result " + arrDiffRule.getExpRes() + " is correct");
    			
    		} else {
    			System.out.println("Arr len: " + arrDiffRule.getArrLen() + " \nQueries:\n" + arrDiffRule.getQueriesNum() + " result " + ah.manipulateArray(arrDiffRule.getArrLen(), arrDiffRule.getQueries()) + " is wrong. Expected " +  arrDiffRule.getExpRes());;
    		}
    	}
	}

}
