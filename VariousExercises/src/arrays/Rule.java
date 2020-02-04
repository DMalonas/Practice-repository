package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rule {
	private List<Integer> nums;
	private int expectedResult;
	
	
	public Rule() {
		System.out.println("default constructor");
	}
	
	public Rule(List<Integer> currentRule) {
		System.out.println();
		if(currentRule.size() > 2 ) {
			this.expectedResult = currentRule.get(0);
			currentRule.remove(0);
			nums = new ArrayList<Integer>();
			nums = currentRule;//Arrays.copyOfRange(currentRule, 1, currentRule.length);
			System.out.println(this.toString());
		}
	}

	public List<Integer> getNums() {
		return nums;
	}

	public void setNums(List<Integer> nums) {
		this.nums = nums;
	}

	public int getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(int expectedResult) {
		this.expectedResult = expectedResult;
	}
	
	public String toString() {
		return "Test input is: \n" + nums + "\nexpected result is " + expectedResult;
	}

	
}
