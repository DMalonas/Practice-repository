package arrays;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileUtil{
	private Path myPath;
	private int difArrMtdArrLen;
	
	public Object createAllRules(String testFile) {
		//String testFile1 = "MinimumSwapsInputTestFile";  //Enter name of test file here <<<------

		
		if (testFile.equals("DifferenceArrayInputTestFile")) {
			List<Integer> arrDiffRules =  genRulesForDiffArrMtd();
			return arrDiffRules;
		} else if (testFile.equals("MinimumSwapsInputTestFile")) {
			
			List<Rule> rules = genRulesForMinSwampsMtd();
			return  (List<Rule>) rules;

		} else {
			return null;
		}
	}
	
	
	public int getLenOfArr() {
		return this.difArrMtdArrLen;
	}
	
	private List<Integer> genRulesForDiffArrMtd() {
		String line = "";
		List<RuleArrDiffMtd> rules = new ArrayList<RuleArrDiffMtd>();
		List<Integer> queries = new ArrayList<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader("DifferenceArrayInputTestFile"))) {
			while((line = br.readLine()) != null) {
				if (line.equals("_")) {
					continue;
					
				}
				String[] tokenizedStr = line.split(" ");
				for (String element : tokenizedStr) {
					queries.add(Integer.parseInt(element));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println(queries.toString());
		return queries;
		
	}



	private List<Rule> genRulesForMinSwampsMtd() {
		List<Rule> rules = new ArrayList<Rule>();
		myPath = Paths.get("MinimumSwapsInputTestFile");
//        try {
        	/********************************************************************************************/
        	//Input file format is, first element is the expected result and the rest is the int[] input
    	 try (Stream<String>lines = Files.lines(myPath)) {//.skip(1);
        	 Spliterator<String> result = lines.collect(Collectors.toList()).spliterator();
        	 int current = 0;
        	 //https://stackoverflow.com/questions/11009818/how-to-get-list-of-integer-from-string
        	 while (result.tryAdvance(line -> rules
        			 .add(new Rule(Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList()))))) {
        		 current++;
        	 }
    	 } catch (IOException e1) {
    		 e1.printStackTrace();
    	 }
    	 return rules;
	}
}
