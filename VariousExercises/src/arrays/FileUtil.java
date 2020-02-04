package arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileUtil {

	public ArrayList<Rule> createAllRules() {
		//Get rules with Java 8
		Path myPath = Paths.get("MinimumSwapsInputTestFile");
		ArrayList<Rule> rules = new ArrayList<Rule>();
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rules;
	}
}
