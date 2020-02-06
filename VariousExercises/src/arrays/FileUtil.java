package arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileUtil{
	private Path myPath;
	
	public Object createAllRules(String testFile) {
		//String testFile1 = "MinimumSwapsInputTestFile";  //Enter name of test file here <<<------

		
		if (testFile.equals("DifferenceArrayInputTestFile")) {
			List<RuleArrDiffMtd> genRulesForDiffArrMtd();
		} else if (testFile.equals("MinimumSwapsInputTestFile")) {
			
			List<Rule> rules = genRulesForMinSwampsMtd();
			return  (List<Rule>) rules;

		} else {
			return null;
		}
		return null;
	}
	
	
	
	private List<Rule> genRulesForDiffArrMtd() {
		myPath = Paths.get("DifferenceArrayInputTestFile");
		try {
			Stream<String> lines = Files.lines(myPath);
			Spliterator<String> result = lines.collect(Collectors.toList()).spliterator();
			int current = 0;
       	 	while (result.tryAdvance(line -> rules
       	 			.add(new RuleArrDiffMtd(Arrays.stream(line.split(" "))
       	 					.map(Integer::parseInt)
       	 					.collect(Collectors.toList()))))) {
				current++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	private List<Rule> genRulesForMinSwampsMtd() {
		List<Rule> rules = new ArrayList<Rule>();
		myPath = Paths.get("MinimumSwapsInputTestFile");
        try {
        	/********************************************************************************************/
        	//Input file format is, first element is the expected result and the rest is the int[] input
        	 Stream<String>lines = Files.lines(myPath);//.skip(1);
        	 Spliterator<String> result = lines.collect(Collectors.toList()).spliterator();
        	 int current = 0;
        	 //https://stackoverflow.com/questions/11009818/how-to-get-list-of-integer-from-string
        	 while (result.tryAdvance(line -> rules.add(new Rule(Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList()))))) {
        		 current++;
        	 }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        return rules;
	}
}
