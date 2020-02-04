package annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;


@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface PersonalBudget {
	    String userRole() default "GUEST";
		int budgetLimit() default 0;
	}

	class Person {

		
	    @PersonalBudget(userRole = "SENIOR", budgetLimit = 100)
	    public void seniorMember(int budget, int moneySpend) {
	        System.out.println("Senior Member");
	        System.out.println("Spend: " + moneySpend);
	        System.out.println("Budget Left: " + (budget - moneySpend));
	    }

	    @PersonalBudget(userRole = "JUNIOR", budgetLimit = 50)
	    public void juniorUser(int budget, int moneySpend) {
	        System.out.println("Junior Member");
	        System.out.println("Spend: " + moneySpend);
	        System.out.println("Budget Left: " + (budget - moneySpend));
	    }
	}

	public class ApplicationFile {
	    public static void main(String[] args) {
	    	
	    	FileUtil fu = new FileUtil();
	    	int testCases = fu.getNumOfQueriesFromFirstLine();
	    	List<Rule> rules = fu.createAllRules();
	    	for (Rule rule : rules) {
	    		String status = rule.getType();
	    		int expenses = rule.getCost();
	    		try {
	    			Class annotatedClass = Person.class;
	    			Method[] methods = annotatedClass.getMethods();
	    			for (Method method : methods) {
	    				if (method.isAnnotationPresent(PersonalBudget.class)) {
	    					PersonalBudget person = method.getAnnotation(PersonalBudget.class);
	    					String personType = person.userRole();
	    					int budgetLimit = person.budgetLimit();
	    					if (personType.equals(status)) {
	    						if (budgetLimit >= expenses) {
	    							method.invoke(Person.class.newInstance(), budgetLimit, expenses);
	    						} else {
	    							System.out.println("Expense is above budget threshold");
	    						}
	    					}
	    				}
	    			}
	    		} catch (Exception e) {
                e.printStackTrace();
	    		}		    	
	    	}
	    }
	}










