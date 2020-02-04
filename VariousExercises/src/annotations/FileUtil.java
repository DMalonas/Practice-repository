package annotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
	
	private int numOfQueriesFromFirstLine;

	
	

	public ArrayList<Rule> createAllRules() {
		//Get rules with Java 8
		Path myPath = Paths.get("AnnotationsPckgTestFile");
		ArrayList<Rule> rules = new ArrayList<Rule>();
        try {
        	 setNumOfQueriesFromFirstLine(Integer.parseInt(Files.lines(myPath).findFirst().get()));
        	 
        	 Stream<String>lines = Files.lines(myPath).skip(1);
        	 Spliterator<String> result = lines.collect(Collectors.toList()).spliterator();
        	 int current = 0;
        	 while (result.tryAdvance(line -> rules.add(new Rule(line.split(" "))))) {
        		 current++;
        	 }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rules;
	}



	public int getNumOfQueriesFromFirstLine() {
		return numOfQueriesFromFirstLine;
	}



	public void setNumOfQueriesFromFirstLine(int numOfQueriesFromFirstLine) {
		this.numOfQueriesFromFirstLine = numOfQueriesFromFirstLine;
	}	
}